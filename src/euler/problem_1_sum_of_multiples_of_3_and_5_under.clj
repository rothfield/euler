(ns euler.problem-1-sum-of-multiples-of-3-and-5-under
  (:require [clojure.set]))

(defn sum-of-multiples-of-3-and-5-under
  "Multiples of 3 and 5
    Problem 1
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000."
  [n]
  (apply + (clojure.set/union 
            (set (range 3 n 3))
            (set (range 5 n 5)))))
