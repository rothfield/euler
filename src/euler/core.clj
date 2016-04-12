(ns euler.core
  (use
   [euler.problem-1-sum-of-multiples-of-3-and-5-under :refer [sum-of-multiples-of-3-and-5-under]]
   [euler.problem-2-sum-of-even-fibonacci-numbers-under :refer
    [sum-of-even-fibonacci-numbers-under]]
   [euler.problem-3-largest-prime-factor :refer [largest-prime-factor]]
   [euler.problem-4-largest-palindrome-product :refer [largest-palindromic-number-that-is-product-of-two-three-digit-numbers is-palindromic-number?]]
   [euler.problem-5-smallest-multiple :refer [smallest-multiple]])
  (:gen-class))

(defn -main
  [& args]
  (println "problem 1")
  (println "euler problem 1 answer is " (time (sum-of-multiples-of-3-and-5-under 1000)))
  (println "problem 2")
  (println "euler problem 2 answer is"  (time (sum-of-even-fibonacci-numbers-under 4000000)))
  (println "problem 3")
  (println "euler problem 3 answer is"  (time (largest-prime-factor 600851475143)))
  (println "problem 4")
  (println "euler problem 4 answer is" (time (largest-palindromic-number-that-is-product-of-two-three-digit-numbers)))
  (println "problem 5")
  (println "euler problem 5 answer is" (time (smallest-multiple 20))))

;; (-main)
