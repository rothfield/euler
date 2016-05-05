(ns euler.problem-6-sum-square-difference)

(comment
  (use 'clojure.stacktrace)     
  (print-stack-trace *e));; first 20 numbers prime factored


(defn sum-square-difference
  "Sum square difference
Problem 6
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
"
  [x]
  (let [y (->> (range 1 (inc x)) (map #(* % %)) (apply +))
        z (->> (range 1 (inc x)) (apply +)) 
        z2 (* z z)]
    (- z2 y)))
