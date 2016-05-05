(ns euler.problem-9-pythagorean-triplet-totalling)

(comment
  (use 'clojure.stacktrace)     
  (print-stack-trace *e));;


(defn is-pythagorean-triplet? [[a b c]]
  (and (< a b c)
       (= (* c c) 
          (+ (* a a) (* b b)))))

;; (is-pythagorean-triplet? [3 4 5])
;; (is-pythagorean-triplet? [1 2 9])
;; (println (time (pythagorean-triplet-totalling 1000)))   => [200 375 425]
;; (apply * [200 375 425])


(defn pythagorean-triplet-totalling
  "
 Special Pythagorean triplet
 Problem 9
 A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
  "
  [totalling]
  (let [debug false]
    (loop [a 1
           b (inc a) 
           c (- totalling a b)]
 ;;   (assert (= totalling (+ a b c)))
      (when debug
        (println [a b c])) 
   ;;  (println "a=" a)
      (cond 
        (= a (- totalling 2))
        nil
        (<= c b) ;; crossed. c is <= b. on to next a
        (recur (inc a)
               (+ 2 a)
               (- totalling (inc a) (+ 2 a)))
        (is-pythagorean-triplet? [a b c])
        [(apply * [a b c]) [a b c]]
        true
        (recur a  
               (inc b) 
               (dec c))))))

(defn pythagorean-triplet-totalling-brute-force
  "
 Special Pythagorean triplet
 Problem 9
 A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
  "
  [totalling]
  (->> (for [a (range 1 totalling)
             b (range 1 totalling)
             c (range 1 totalling)]
         [a b c])
       (filter is-pythagorean-triplet?) 
       (some #(if (= totalling (apply + %))
                %))))
