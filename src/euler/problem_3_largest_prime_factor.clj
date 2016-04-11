(ns euler.problem-3-largest-prime-factor)

;;;;;  Below is the O(sqrt(n)) version, as suggested in the comment. Here is the code, once more.
;; http://stackoverflow.com/questions/23287/largest-prime-factor-of-a-number
;;;;    def prime_factors(n):
;;;;        """Returns all the prime factors of a positive integer"""
;;;;        factors = []
;;;;        d = 2
;;;;        while n > 1:
;;;;            while n % d == 0:
;;;;                factors.append(d)
;;;;                n /= d
;;;;            d = d + 1
;;;;            if d*d > n:
;;;;                if n > 1: factors.append(n)
;;;;                break
;;;;        return factors 
;;;;    

(defn factor-out-divisor
  " Factor out divisor and return list of divisors and the new n. ie 
  (factor-out-divisor 12 2) -> {:factors [2 2], :n 3}
  "
  [n divisor]
  (loop [n n
         factors []]
    (cond (= n 1)
          {:factors factors :n n}
          (zero? (mod n divisor))
          (recur (/ n divisor)
                 (conj factors divisor))
          true
          {:factors factors :n n})))

(defn prime-factors [x]
  (loop [factors []
         d 2 
         n x]
    (cond (= 1 n)
          factors 
          (> (* d d) n)  ;; n must be prime!
          (conj factors n)
          true
          (let [{new-n :n new-factors :factors} (factor-out-divisor n d)]
            (recur (vec (concat factors new-factors))
                   (if (> d 2) (+ 2 d) (inc d))
                   new-n)))))

(defn prime-factors-v1
  "first version. without factor-out-divisors"
  [x]
  (loop [factors []
         d 2 
         n x]
    (cond (= 1 n)
          factors 
          (> (* d d) n)
          (conj factors n)
          (zero? (mod n d))
          (recur (conj factors d) 
                 d
                 (/ n d))
          (> (* (inc d) (inc d)) n)
          (conj factors n)
          true
          (recur  factors
                  (if (= 2 d)
                    (inc d)
                    (+ 2 d))
                  n))))

(defn largest-prime-factor [x]
  (last (prime-factors x)))
