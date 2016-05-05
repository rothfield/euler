(ns euler.problem-12-highly-divisible-triangular-number)
;;; 500 divisors
;;; 500= 
;; 500 = 22 × 53
;; (println (*' (exp 2 167)  (exp 3 3)))
;;  282655456723167445807792128N

;; (integer? (Math/sqrt (+ 1 (* 8 28))))
; (def z  (Math/sqrt 100))

;; (problem-11)
(defn multiples-up-to [x up-to]
  "Returns list of multiples of x. Doesn't include x."
  (take-while (partial > up-to) (iterate (partial + x) (+ x x))))

(defn sieve
  " (sieve (Math/floor (Math/sqrt 600851475143))) Find all prime numbers < z"
  [z]
  (let [odds
        (remove even? (range 3 z))
        my-floor (int (Math/floor (Math/sqrt (inc z))))]
    (sort (into [] (reduce (fn [accum-set item]
                             (clojure.set/difference accum-set 
                                                     (into #{} (multiples-up-to item z))))
                           (into #{} odds)
                           (remove even? (range 3 my-floor)))))))

(def prime-numbers-under-million
  (sieve (* 1000 1000)))

(def prime-factorization
  ""
  [x prime-list])
;; (println (take 100 prime-numbers-under-million))
(defn is-triangular?
  "So a number T is triangular if and only if 8T + 1 is an odd perfect 
square." 
  [x]
  (let [z (Math/sqrt (+ 1 (* 8 x)))]
    (not (> z (Math/floor z)))))
;; (is-triangular? 28)
;; (= (int 15.0) 15)
(comment
  (use 'clojure.stacktrace)     
  (print-stack-trace *e))
;; (def x 100000000)
(defn exp
  "Raise x to the power n"
  [x n]
  (reduce *' (repeat n x)))
;; (println (count-of-divisors-of-a-number 1000000))
;; (println (is-triangular? 76576500))
;; (println (count (divisors-of-a-number 76576500)))
;; (println (sort (divisors-of-a-number 76576500))))
;; (println (time (count (divisors-of-a-number 100000000))))

(defn divisors-of-a-number [x]
  (reduce (fn [accum item]
           ;; (println "item=" item " accum=" accum)
            (if (zero? (mod x item))
              (conj (conj accum item) (/ x item))
              accum))
          #{1} (range 2 (Math/floor (inc (Math/sqrt x))))))

;;; Show that n is a triangular number if and only if 8n+1 is a perfect square. ?
;; (divisors-of-a-number (exp 10N 20))
;; 
;; (println (range 1 7))
;; (count (divisors-of-a-number 48))
;; (/ 24 4)
;; (conj #{1} 4)
;; (mod 24 4)
;; (println (problem-11))
;; (println (is-triangular? 282655456723167445807792128N))
;; 
;; (println (is-triangular? 5050949658615600485311934781867474115930902868525056N))
;;[5050949658615600485311934781867474115930902868525056N 0 []]
" Jud McCranie, T.W.A. Baumann & Enoch Haga sent basically the same procedure to find N(d) for a given d:

Factorize d as a product of his prime divisors: d = p1a1 * p2a2 *p3a3 *...
d = 501*1 * 3*167 = b1 * b2 * b3 etc where b1 b2 b3 are decreasing


d is number of divisors. 501 for euler

501 = 3^1  * 167^1 =  167 * 3
      p1 a1  p2 a2    b1    b2

N(501) is the result of computing
2^(b1-1) * 3^(b2-1) etc. 
(*
(exp 2 166)
(exp 167 2))

d=   501 
    p1 a1   p2 a2

 
convert this factorization in another arithmetically equivalent factorization, composed of non-powered monotonically decreasing and not necesarilly prime factors... (uf!...) d = p1a1 * p2a2 *p3a3 *... = b1 * b2 * b3... such that b1 ≥ b2 ≥ b3...

b1

  501 * 167 * 3
  b1  * b2 * b3

(2*501 - 1)
*
(3*167 -1)
= (println (*   
(dec (* 2 501))
(dec (* 3 167))))
=500500

;; (println (count-of-divisors-of-a-number 120)) 
You must realize that for every given d, there are several arithmetically equivalent factorizations that can be done: by example:
if d = 16 = 24 then there are 5 equivalent factorizations: d = 2*2*2*2 = 4*2*2 = 4*4 = 8*2 = 16
N is the minimal number resulting of computing 2b1-1 * 3b2-1 * 5b3-1 * ... for all the equivalent factorizations of d. Working the same example:
N(16) = the minimal of these {2 * 3 * 5 * 7, 23 * 3 * 5, 23 * 33, 27 * 3, 215} = 23 * 3 * 5 = 120"

;; (println (time (problem-11)))
;;Elapsed time: 25259.75221 msecs"
;;76576500
;; (println (minimal-number-with-x-factors 501))
;;
;; (map minimal-number-with-x-factors (range 5 20))
(defn minimal-number-with-x-factors [x]
  (let [debug true]
    (some #(if (>= (count (divisors-of-a-number %))
                   x)
             (if debug
               [% (count (divisors-of-a-number %))
                (sort (divisors-of-a-number %))]
               %))
          (range))))
;; (time (println (time (problem-11 501)))

;; "Elapsed time: 10440.050169 msecs"
;; 76576500

(defn problem-11
  "1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ..."
  [x]
  (loop [ctr 1
         my-triangular-number 1]
    (cond  (>= (count (divisors-of-a-number my-triangular-number)) 
               x)
           my-triangular-number
           true
           (recur (inc ctr) (+ (inc ctr) my-triangular-number)))))

(defn problem-11-brute-force []
  (some #(if (and (is-triangular? %)
                  (> (count (divisors-of-a-number %)) 
                     500))
           [% (divisors-of-a-number %)])
        (range)))

(defn highly-divisible-triangular-number
  "Highly divisible triangular number
  Problem 12
  The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

  1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

  Let us list the factors of the first seven triangle numbers:

   1: 1
   3: 1,3
   6: 1,2,3,6
  10: 1,2,5,10
  15: 1,3,5,15
  21: 1,3,7,21
  28: 1,2,4,7,14,28
  We can see that 28 is the first triangle number to have over five divisors.

  What is the value of the first triangle number to have over five hundred divisors?"
  [number-of-divisors])
