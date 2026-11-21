
(ns sequence-transformations.core)

;; Function to perform operations
(defn process-collection [numbers]

  (println "\nOriginal Collection:" numbers)

  ;; 1. MAP - Square each element
  (println "MAP - Squares:"
           (map #(* % %) numbers))

  ;; 2. FILTER - Select even numbers
  (println "FILTER - Even Numbers:"
           (filter even? numbers))

  ;; 3. REDUCE - Calculate sum
  (println "REDUCE - Sum:"
           (reduce + numbers))

  ;; 4. TAKE - Get first 3 elements
  (println "TAKE - First 3:"
           (take 3 numbers))

  ;; 5. DROP - Remove first 2 elements
  (println "DROP - After removing first 2:"
           (drop 2 numbers))

  ;; 6. THREADING MACRO - Chain operations
  (println "THREADING - Square, filter even, take 3:"
           (->> numbers
                (map #(* % %))
                (filter even?)
                (take 3)))
)

;; Main function
(defn -main [& args]

  (println "===== COLLECTION 1 =====")
  (process-collection [1 2 3 4 5 6])

  (println "\n===== COLLECTION 2 =====")
  (process-collection [10 15 20 25 30 35])
)
