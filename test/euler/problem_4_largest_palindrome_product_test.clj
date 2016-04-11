(ns euler.problem-4-largest-palindrome-product-test
  (:use [midje.sweet] 
        [euler.problem-4-largest-palindrome-product :refer [largest-palindromic-number-that-is-product-of-two-three-digit-numbers is-palindromic-number?]]))
(fact "timing info"
      (println (time (largest-palindromic-number-that-is-product-of-two-three-digit-numbers))))

(fact "known answer"
      (largest-palindromic-number-that-is-product-of-two-three-digit-numbers)
      => [993 913 906609])
;;(defn three-digit-number? [x]
;;(defn decompose-into-two-3-digit-factors [^long x]
;;(println (time (largest-palindromic-number-that-is-product-of-two-three-digit-numbers)))
;; [993 913 906609]
;;(defn largest-palindromic-number-that-is-product-of-two-three-digit-numbers
