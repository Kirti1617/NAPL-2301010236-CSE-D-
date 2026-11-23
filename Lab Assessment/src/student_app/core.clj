(ns student-app.core
  (:require [clojure.java.jdbc :as jdbc]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.params :refer [wrap-params]]))
(def db
  {:connection-uri "jdbc:sqlite:students.db"})
(defn create-table []
  (try
    (jdbc/execute!
      ["CREATE TABLE IF NOT EXISTS students
        (id INTEGER PRIMARY KEY AUTOINCREMENT,
         name TEXT,
         marks INTEGER)"])
    (println "Database table created successfully")
    (catch Exception e
      (println "Database Error:" (.getMessage e)))))
(def students
  [{:name "Aman" :marks 85}
   {:name "Riya" :marks 35}
   {:name "Rahul" :marks 75}
   {:name "Neha" :marks 90}])
(defn process-data []
  (let [passed (filter
                 #(>= (:marks %) 40)
                 students)
        processed (map
                    #(assoc % :status "Pass")
                    passed)
        total (reduce
                +
                0
                (map :marks processed))
        average (if (seq processed)
                  (/ total (count processed))
                  0)]
    {:students (vec processed)
     :total total
     :average average}))
(defn add-student [name marks]
  (try
    (jdbc/insert!
      db
      :students
      {:name name
       :marks marks})
    {:status 200
     :body "Student added successfully"}
    (catch Exception e
      {:status 500
       :body (str "Insert Error: " (.getMessage e))})))

(defn get-students []
  (try
    (jdbc/query
      db
      ["SELECT * FROM students"])
    (catch Exception e
      (println "Read Error:" (.getMessage e))
      [])))

(defn app [request]
  (let [uri (:uri request)]
    (cond
      (= uri "/")
      {:status 200
       :body "Welcome to Clojure Student Management System"}
      (= uri "/results")
      {:status 200
       :headers {"Content-Type" "text/plain"}
       :body (pr-str (process-data))}
      (= uri "/students")
      {:status 200
       :headers {"Content-Type" "text/plain"}
       :body (pr-str (get-students))}
      (= uri "/add")
      (try
        (let [name (get-in request [:params "name"])
              marks (Integer/parseInt
                      (get-in request [:params "marks"]))]
          (if (and (seq name) (<= 0 marks 100))
            (add-student name marks)
            {:status 400 :body "Invalid student details"}))
        (catch Exception e
          {:status 400
           :body (str "Invalid Input: " (.getMessage e))}))
      :else
      {:status 404
       :body "Page Not Found"})))
(defn -main [& args]
  (create-table)
  (println "Server running at http://localhost:3000")
  (run-jetty
    (wrap-params app)
    {:port 3000
     :join? true}))

 
