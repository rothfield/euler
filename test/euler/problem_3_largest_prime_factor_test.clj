(ns euler.problem-3-largest-prime-factor-test
  (:use 
   [clojure.java.io :as io]
   [clojure.edn :as edn]
   [midje.sweet] 
   [euler.problem-3-largest-prime-factor :refer [largest-prime-factor factor-out-divisor prime-factors]]))

(def first-10000-primes
  (->> "first_10000_primes.edn"
       io/resource
       slurp
       edn/read-string))
;; (count first-10000-primes)
(facts "factor-out-divisor"
       (fact  (factor-out-divisor 32 2) =>  {:factors [2 2 2 2 2], :n 1})
       (fact  (factor-out-divisor 7 3) => {:factors [], :n 7})
       (fact  (factor-out-divisor 14 3) => {:factors [], :n 14})
       (fact  (factor-out-divisor 21 3) => {:factors [3], :n 7}) 
       (fact  (factor-out-divisor 120 2) => {:factors [2 2 2], :n 15}))

(fact "known answer (6857) for largest prime factor of 600851475143"
      (largest-prime-factor 600851475143) => 6857)

(dorun (for [x (range (- (last (sort first-10000-primes)) 100) (last (sort first-1000-primes)))
             :let [factors (prime-factors x)]]
         (do
           (fact "prime-factors returns a sorted list" (sort factors) => factors)
           (fact "checking that all items are prime with a list of known primes" (every? first-1000-primes factors) true)
           (fact "checking that the prime factors multiplied are equal to original number" (apply * factors) => x))))
(facts "running tests on 10 large numbers near 600851475140"
       (dorun (for [x (range 600851475140 600851475150)
                    :let [factors (prime-factors x)]]
                (fact "multiplied factors  equal original number" (apply * factors) x))))
