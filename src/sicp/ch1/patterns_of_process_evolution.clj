(ns sicp.ch1.patterns-of-process-evolution)

;; Linear Recursion
(defn linear-iterative-factorial [n]
  (if (= n 1)
    1
    (* n (linear-iterative-factorial (- n 1)))))

;; Linear Iteration
;; product <= counter * product
;; counter <= counter + 1
;; n! when counter > n
(defn counter-factorial [n]
  (letfn [(iter [product counter]
            (if (> counter n)
              product
              (iter (* counter product) (+ counter 1))))]
    (iter 1 1)))

;; Tree Recursion
(defn bad-fibonacci [n]
  (cond (= n 0) 0
        (= n 1) 1
        :else (+ (bad-fibonacci (- n 1))
                 (bad-fibonacci (- n 2)))))

(defn fib [n]
  (letfn [(fib-iter [a b count]
            (if (= count 0)
              b
              (fib-iter (+ a b) a (- count 1))))]
    (fib-iter 1 0 n)))
