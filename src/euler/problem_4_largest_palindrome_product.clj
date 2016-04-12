(ns euler.problem-4-largest-palindrome-product)

(defn three-digit-number? [x]
  (and (> x 100)
       (< x 1000)))

(defn is-palindromic-number? [x]
  (= (vec (str x)) (reverse (vec (str x)))))

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
  "Algorithm:
     start with x and y set to the largest 3 digit number and work downwards.
   Test in this order [999 999] [999 998] etc
   Then [998 998] [998 997] 
   But once the product is less than the largest, go on to next x.
   Also be sure to stop testing x and y when they are no longer 3 digits.
   If we are going on to next x, if the new product < largest, then we are done
  "
  []
  (loop [largest 0 
         x 999 
         y 999]
    (let [my-product (* x y)]
      (cond 
        (< x 100)
        largest
        (and (is-palindromic-number? my-product)
             (> my-product largest))   ;; found a new largest palindromic product
        (recur my-product ;; new largest
               (dec x) ;; onto next x
               (dec x))  ;;999) 
        (and (< my-product largest)  ;; onto next x
             (< (* (dec x) 999) largest)) ;; but next x's will never be larger
        largest
        (or (< my-product largest)  ;; onto next x
            (< y 100))
        (recur largest 
               (dec x)
               (dec x)) ;; 999
        true
        (recur largest 
               x
               (dec y))))))

(defn v1-largest-palindromic-number-that-is-product-of-two-three-digit-numbers
  "OLD VERSION-about 5 times slower than the version above. Largest palindrome product
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
