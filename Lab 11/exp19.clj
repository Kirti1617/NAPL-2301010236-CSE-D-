
;; Lab 11 - Java Interoperability in Clojure
;; Experiment 20

(println "Java Interoperability in Clojure")

;; 1. Calling Java Static Methods

(println "\n1. Java Static Methods")

(println "Absolute value:" (Math/abs -25))

(println "Current Time in Milliseconds:" 
         (System/currentTimeMillis))


;; 2. Creating Java Objects

(println "\n2. Creating Java Objects")

(def javaList (new java.util.ArrayList))

(def javaMap (new java.util.HashMap))


;; 3. Invoking Instance Methods

(println "\n3. Invoking Instance Methods")

(.add javaList "Apple")
(.add javaList "Banana")
(.add javaList "Mango")

(println "Java ArrayList:" javaList)

(println "List Size:" (.size javaList))

(.put javaMap "Name" "Kirti")
(.put javaMap "Course" "Clojure")
(.put javaMap "Marks" 95)

(println "Java HashMap:" javaMap)

(println "Student Name:" (.get javaMap "Name"))


;; 4. Converting Between Clojure and Java Collections

(println "\n4. Collection Conversion")

;; Java Collection to Clojure Collection

(def clojureVector (into [] javaList))

(println "Java List to Clojure Vector:" clojureVector)

(def clojureMap (into {} javaMap))

(println "Java Map to Clojure Map:" clojureMap)


;; Clojure Collection to Java Collection

(def newJavaList (java.util.ArrayList. clojureVector))

(def newJavaMap (java.util.HashMap. clojureMap))

(println "Clojure Vector to Java ArrayList:" newJavaList)

(println "Clojure Map to Java HashMap:" newJavaMap)

(println "\nProgram Completed Successfully!")
