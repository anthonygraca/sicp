(ns sicp.ch1.exercises
  (:require [sicp.ch1.square :refer :all]))

;; Exercise 1.1
(def a 3)

(def b (+ a 1))

;; Exercise 1.2
;; Translate to prefix: (5 + 4 + (2 - (3 - (6 + 4/5)))) / 3(6 - 2)(2 - 7)
(def infix-to-prefix
  (/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
     (* 3 (- 6 2) (- 2 7))))

;; Exercise 1.3
;; Define a procedure that takes three numbers as arguments and
;; returns the sum of of the squares of the two larger numbers
(defn sum-of-squares-of-two-larger-numbers [a b c]
  (cond (and (< a b) (< a c)) (sum-of-squares b c)
        (and (< b c) (< b a)) (sum-of-squares a c)
        :else (sum-of-squares a b)))

;; Exercise 1.4
;; Observe that our model of evaluation allows for combinations whose
;; operators are compound expressions. Use this observation to
;; describe the behavior of the following procedure
;;
;; Answer: From page 14, "to apply a compound procedure to arguments,
;;         evaluate the body of the procedure with each formal
;;         parameter replaced by the corresponding argument. [...]
;;         Evaluating this combination involves three subproblems. We
;;         must evaluate the operator to get the procedure to be
;;         applied, and we must evaluate the operands to get the
;;         arguments"
;;
;;         Thus the following process:
;;         (a-plus-abs-b 1 2) => (if (> 2 0 ) + -) 1 2) =>
;;                               (+ 1 2) => 3
;;         (a-plus-abs-b 1 -2) => (if (> -2 0) + -) 1 2) =>
;;                                (- 1 -2) => 3
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))
