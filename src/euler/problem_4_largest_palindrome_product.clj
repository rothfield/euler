(ns euler.problem-4-largest-palindrome-product)

(defn three-digit-number? [x]
  (and (> x 100)
       (< x 1000)))

(defn is-palindromic-number? [x]
  (let [s (str x)
        mid (int (/ (count s) 2))]
    (every? true? (map = (take mid s) (take mid (reverse s))))))

(defn decompose-into-two-3-digit-factors [^long x]
  (let [x (int x)]
    (loop [a (int 999)]
      (cond 
        (= 99 a)
        nil 
        (and (zero? (mod x a))
             (three-digit-number? (/ x a)))
        [a (/ x a)]
        true
        (recur (dec a))))))

(defn largest-palindromic-number-that-is-product-of-two-three-digit-numbers
  "Largest palindrome product
Problem 4
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.

 Find largest palindrome that is the product of two 3 digit numbers. 
 Returns a list of the 2 factors and the palindrome number
 Approach is to start with the largest product of two 3 digit numbers and
work downwards. If the number is a palindrome, try and factor the number into
2 3-digit numbers.  
 "
  []
  (let [largest-product-of-3-digits (int (* 999 999))
        [three-digit-factor1 three-digit-factor2]
        (->> (range largest-product-of-3-digits (int (/ largest-product-of-3-digits 2)) -1)
             (filter is-palindromic-number?)
             (some decompose-into-two-3-digit-factors))]
    [three-digit-factor1 three-digit-factor2 (* three-digit-factor1 three-digit-factor2)]))
