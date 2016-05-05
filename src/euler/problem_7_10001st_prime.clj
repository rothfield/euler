(ns euler.problem-7-10001st-prime
  (:require [clojure.set]))

(defn multiples-up-to [x up-to]
  "Returns list of multiples of x. Doesn't include x."
  (take-while (partial > up-to) (iterate (partial + x) (+ x x))))

;; (nth [1 2 3] 2)
;; (sieve 200)
;; (nth (vec (sieve (* 1000 1000))) 9999)
;; (nth (sieve (* 1000 1000)) 9999)

;; (nth (sieve (* 1000 1000)) 10001)
;; (nth (sieve (* 1000 1000)) 10001)
;; (nth (sieve (* 1000 1000)) 5)
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

;; (problem-7) -> 104743
(defn problem-7 []
  (nth (sieve (* 1000 1000)) 9999))
