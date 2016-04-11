(ns euler.core
  (use
   [euler.problem-1-sum-of-multiples-of-3-and-5-under :refer [sum-of-multiples-of-3-and-5-under]]
   [euler.problem-2-sum-of-even-fibonacci-numbers-under :refer
    [sum-of-even-fibonacci-numbers-under]]
   [euler.problem-3-largest-prime-factor :refer [largest-prime-factor]]
   [euler.problem-4-largest-palindrome-product :refer [largest-palindromic-number-that-is-product-of-two-three-digit-numbers is-palindromic-number?]])
  (:gen-class))

(defn -main
  [& args]
  (println "euler problem 1 answer is " (sum-of-multiples-of-3-and-5-under 1000))
  (println "euler problem 2 answer is"  (sum-of-even-fibonacci-numbers-under 40000000))
  (println "euler problem 3 answer is"  (largest-prime-factor 600851475143))
  (println "euler problem 4 answer is" (time (largest-palindromic-number-that-is-product-of-two-three-digit-numbers))))
;; (-main)
