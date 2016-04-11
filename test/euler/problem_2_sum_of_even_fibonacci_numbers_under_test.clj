(ns euler.problem-2-sum-of-even-fibonacci-numbers-under-test
  (:use [midje.sweet] 
        [euler.problem-2-sum-of-even-fibonacci-numbers-under :refer
         [fibs-not-to-exceed sum-of-even-fibonacci-numbers-under]]))

(fibs-not-to-exceed 10)
(fact (sum-of-even-fibonacci-numbers-under 4000000) => 4613732)
(fact (sum-of-even-fibonacci-numbers-under 35) => 44)
(fact (sum-of-even-fibonacci-numbers-under 10) => 10)
