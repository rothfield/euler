(ns euler.problem-1-sum-of-multiples-of-3-and-5-under-test
  (:use [midje.sweet] 
        [euler.problem-1-sum-of-multiples-of-3-and-5-under :refer [sum-of-multiples-of-3-and-5-under]]))

(fact "known sum for 10"
      (sum-of-multiples-of-3-and-5-under 10) => 23)
(fact "known sum"
      (sum-of-multiples-of-3-and-5-under 1000) => 233168)
