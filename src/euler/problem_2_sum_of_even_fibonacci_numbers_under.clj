(ns euler.problem-2-sum-of-even-fibonacci-numbers-under)

(defn fibs-not-to-exceed
  "return list of fibonacci numbers not exceeding the given number"
  [not-to-exceed]
  (loop [a 0
         b 1
         accum []]
    (let [next-fib (+ a b)]
      (if (>= next-fib not-to-exceed)
        accum
        (recur b next-fib (conj accum next-fib))))))

(defn sum-of-even-fibonacci-numbers-under
  "Even Fibonacci numbers
Problem 2
Each new term in the Fibonacci sequence is generated by adding the previous two terms.
By starting with 1 and 2, the first 10 terms will be:
1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms." 
  [z]
  (->> z fibs-not-to-exceed (filter even?) (apply +)))
(fibs-not-to-exceed 10)
(assert (= 4613732 (sum-of-even-fibonacci-numbers-under 4000000)))
(assert (= 44 (sum-of-even-fibonacci-numbers-under 35)))
(assert (= 10 (sum-of-even-fibonacci-numbers-under 10)))