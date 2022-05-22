(ns sicp.ch1.newtons-method
  (:use sicp.ch1.square))

(declare good-enough?)
(declare improve)
(declare average)

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn average [x y]
  (/ (+ x y) 2))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt [x]
  (sqrt-iter 1.0 x))
