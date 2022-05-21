(ns sicp.ch1.exercises
  (:require [sicp.ch1.square :refer :all]))

;; Exercise 1.1
(def a 3)

(def b (+ a 1))

;; Exercise 1.2
(def infix-to-prefix
  (/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
     (* 3 (- 6 2) (- 2 7))))

;; Exercise 1.3
(defn sum-of-squares-of-two-larger-numbers [a b c]
  (cond (and (< a b) (< a c)) (sum-of-squares b c)
        (and (< b c) (< b a)) (sum-of-squares a c)
        :else (sum-of-squares a b)))
