(ns euler.problem-5-smallest-multiple
  (:use [euler.problem-3-largest-prime-factor :refer [prime-factors]]))

(comment
  (use 'clojure.stacktrace)     
  (print-stack-trace *e));; first 20 numbers prime factored
(def zprime-factors
  [[2]
   [3]
   [2 2]
   [5]
   [3 2]
   [7]
   [2 2 2]
   [3 3]
   [2 5]
   [11]
   [3 2 2]
   [13]
   [7 2]
   [3 5]
   [2 2 2 2]
   [17]
   [2 3 3]
   [19]
   [2 2 5]])

(defn exp
  "Raise x to the power n"
  [x n]
  (reduce * (repeat n x)))
;;(exp 10 15)
;;(println (reduce (fn [accum item] (+ accum item)) 0 (range 1 (exp 10 15))))
(defn smallest-multiple
  "520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
  
  Algorithm: Go through the list of factored numbers. Keep a hashmap of prime factors -> count. Update the hashmap so that
  the count is the max that occurs in the factored numbers. Then multiply everything together to get the answer. 
    
  "
  [n]
  (let [prime-factors (map prime-factors (range 2 (inc n)))
        x1
        (reduce (fn outer-reducer [accum item]
                  (reduce (fn inner-reducer [accum2 item2] 
                            (update-in accum2 [(first item2)] (fnil max 0) (last item2))) 
                          accum (frequencies item)))
                {}  ;;; this will look like: { 2 4, 3 2, 5 1, 7 , 11 1, 13 1, 17 1, 19 1 }
          ;;; meaning 2^4 3^2 etc
                prime-factors)]
    (->> x1
         (map (fn [x] (apply exp x)))  ;;; raise to power
         (apply *))  ;; multiply all together
    ))
