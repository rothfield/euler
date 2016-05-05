(ns euler.problem-6-sum-square-difference-test
  (:use [midje.sweet] 
        [euler.problem-6-sum-square-difference :refer [sum-square-difference]]))

(fact "known sum for 10"
      (sum-square-difference 10) => 2640)
(fact "known sum"
      (sum-square-difference 100) => 25164150)

(comment
  (use 'clojure.stacktrace)     
  (print-stack-trace *e));; first 20 numbers prime factored
