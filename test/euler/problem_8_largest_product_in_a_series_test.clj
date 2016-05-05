(ns euler.problem-8-largest-product-in-a-series-test
  (:use [midje.sweet] 
        [euler.problem-8-largest-product-in-a-series :refer [largest-product-in-a-series thousand-digits]]))

(facts
 (fact (largest-product-in-a-series "9315" 2) => [27 [9 3]])
 (fact (largest-product-in-a-series "9369" 2) => [54 [6 9]]) 
 (fact (largest-product-in-a-series "936000010999995" 3) => [729 [9 9 9]]))
(fact "small set"
      (largest-product-in-a-series "41203" 2) => [4 [4 1]])
(fact "known answer for 4"
      (largest-product-in-a-series thousand-digits 4) => 
      [5832 [9 9 8 9]]) 
(println (time (fact "project euler answer for 13"
      (largest-product-in-a-series thousand-digits 13) => 
      [23514624000 [5 5 7 6 6 8 9 6 6 4 8 9 5]])))
