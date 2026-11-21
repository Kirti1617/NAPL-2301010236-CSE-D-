
;; Lab 11 - Experiment 23
;; Exception Handling and Error Management in Clojure

(println "Exception Handling in Clojure")

;; 1. ArithmeticException Handling

(println "\n1. Arithmetic Exception")

(try
  (println "Result:" (/ 10 0))
  (catch ArithmeticException e
    (println "Caught Exception:" (.getMessage e)))
  (finally
    (println "Arithmetic block completed")))


;; 2. NullPointerException Handling

(println "\n2. Null Pointer Exception")

(try
  (let [x nil]
    (.length x))
  (catch NullPointerException e
    (println "Caught Exception:" (.getMessage e)))
  (finally
    (println "Null pointer block completed")))


;; 3. Custom Exception using ex-info

(println "\n3. Custom Exception")

(defn check-age [age]
  (if (< age 18)
    (throw (ex-info "Age must be 18 or above"
                    {:age age :type :invalid-age}))
    (println "Eligible to vote")))

(try
  (check-age 15)
  (catch clojure.lang.ExceptionInfo e
    (println "Error Message:" (.getMessage e))
    (println "Error Data:" (ex-data e)))
  (finally
    (println "Custom exception block completed")))


;; 4. Graceful Recovery using ex-message and ex-data

(println "\n4. Graceful Recovery")

(try
  (throw (ex-info "Invalid marks entered"
                  {:marks -10 :type :invalid-input}))
  (catch clojure.lang.ExceptionInfo e
    (println "Exception Message:" (ex-message e))
    (println "Exception Data:" (ex-data e))
    (println "Recovery: Please enter valid marks between 0 and 100.")))

(println "\nProgram Completed Successfully!")
