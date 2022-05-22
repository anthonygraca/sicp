(ns sicp.ch1.exercises
  (:use sicp.ch1.square sicp.ch1.newtons-method)
  (:refer-clojure :exclude (test)))

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

;; Exercise 1.5
;; Answer: In Applicative Order, the test will expand so that the
;;         arguments evaluate first
;; (test 0 (p)) => infinite-loop in evaluating p forever
;; In Normal Order, the test will expand everything first before
;; evaluating so that
;; (test 0 (p)) => (if (= 0 0) 0 (p)) => 0
(defn p [] (p))

(defn test [x y]
  (if (= x 0)
    0
    y))
;; (test 0 (p))

;; Exercise 1.6
;; Answer: Trying to use new-sqrt-iter to compute square roots will
;; lead to a stack overflow error due to how the new-sqrt-iter will
;; be called without end. This is caused by applicative-order since
;; all the arguments are evaluated first for the new-if function.
;; In contrast, (if) is a special form that evaluates the predicate
;; first then calls the appropriate clause, meaning that there is a
;; stopping point where (if) would prevent new-sqrt-iter from being
;; called
(defn new-if [predicate then-clause else-clause]
  (cond (predicate) then-clause
        :else else-clause))

(defn new-sqrt-iter [guess x]
  (new-if (good-enough? guess x) guess
          (new-sqrt-iter (improve guess x) x)))

;; Exercise 1.7
;; Answer good-enough? fails with small numbers because it bottoms out
;; at 0.0315. The procedutre also fails with large numbers because
;; the test is too sensitive and provides false negatives for actual
;; good values.
;; A new version of good-enough? would stop guessing if the change is
;; a small fraction of guess.
(defn new-good-enough? [guess x]
  (> 0.01
     (abs (- 1.0 (/ (square guess) x)))))

;; Exercise 1.8 - cubed roots newtons method
(declare cubed-root-iter)
(declare cubed-good-enough?)
(declare cubed-improve)
(declare cube)

(defn cubed-root [x]
  (cubed-root-iter 1.0 x))

(defn cubed-root-iter [guess x]
  (if (cubed-good-enough? guess x)
    guess
    (cubed-root-iter (cubed-improve guess x) x)))

(defn cubed-good-enough? [guess x]
  (> 0.01
     (abs (- 1.0 (/ (cube guess) x)))))

(defn cube [x] (* x x x))

(defn cubed-improve [y x]
  (/ (+ (/ x (* y y)) (* 2 y)) 3))
