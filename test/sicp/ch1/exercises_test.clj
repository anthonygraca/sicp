(ns sicp.ch1.exercises-test
  (:use sicp.ch1.exercises sicp.ch1.newtons-method)
  (:require [clojure.test :refer [deftest is]])
  (:refer-clojure :exclude (test)))

;; Exercise 1.1
(deftest test-expression-result-1
  (is (= 10 10)))

(deftest test-expression-result-2
  (is (= 12 (+ 5 3 4))))

(deftest test-expression-result-3
  (is (= 8 (- 9 1))))

(deftest test-expression-result-4
  (is (= 3 (/ 6 2))))

(deftest test-expression-result-5
  (is (= 6 (+ (* 2 4) (- 4 6)))))

(deftest test-define-a
  (is (= 3 a)))

(deftest test-define-b
  (is (= 4 b)))

(deftest test-expression-result-6
  (is (= 19 (+ a b (* a b)))))

(deftest test-bool-expression
  (is (= false (= a b))))

(deftest test-if-statement
  (is (= b
         (if (and (> b a) (< b (* a b)))
           b
           a))))

(deftest test-cond-statement
  (is (= 16
         (cond (= a 4) 6
               (= b 4) (+ 6 7 a)
               :else 25))))

(deftest test-if-expression
  (is (= 6
         (+ 2 (if (> b a) b a)))))

(deftest test-cond-expression
  (is (= 16
         (* (cond (> a b) a
                  (< a b) b
                  :else -1)
            (+ a 1)))))

;; Exercise 1.2
(deftest test-infix-to-prefix
  (is (= (/ 37 -150) infix-to-prefix)))

;; Exercise 1.3
(deftest test-sum-of-squares-of-two-larger-numbers
  (is (= (+ 16 25)
         (sum-of-squares-of-two-larger-numbers 3 4 5))))


;; Exercise 1.4
(deftest test-a-plus-abs-b
  (is (= (+ 1 2) (a-plus-abs-b 1 2))))

(deftest test-a-plus-abs-b-negative
  (is (= (+ 1 2) (a-plus-abs-b 1 -2))))

;; Exercise 1.5 - no test

;; Exercise 1.6 - no test

;; Exercise 1.7
(deftest good-enough-bottoms-out-for-small-numbers-1
  (is (good-enough? 0.03125 0.000001)))

(deftest good-enough-bottoms-out-for-small-numbers-2
  (is (good-enough? 0.03125 0.00001)))

(deftest good-enough-bottoms-out-for-small-numbers-3
  (is (good-enough? 0.03125 0.000000009)))

(deftest good-enough-fails-for-big-values-that-are-good
  (is (not (good-enough? 46340.95 Integer/MAX_VALUE))))

(deftest new-good-enough-does-not-bottom-out-for-small-numbers-1
  (is (not (new-good-enough? 0.03125 0.000001))))

(deftest new-good-enough-does-not-bottomn-out-for-small-numbers-2
  (is (not (new-good-enough? 0.03125 0.00001))))

(deftest new-good-enough-des-not-bottom-out-for-small-numbers-3
  (is (not (new-good-enough? 0.03125 0.00000009))))

(deftest new-good-enough-is-sensitive-for-small-numbers
  (is (good-enough? 0.0003 0.00000009)))

(deftest new-good-enough-passes-for-big-values-that-are-good
  (is (new-good-enough? 46340 Integer/MAX_VALUE)))

;; Exercise 1.8
(deftest test-cubed-root
  (is (cubed-good-enough? (cubed-root 27) 27)))

;; Exercise 1.9 - no test

;; Exercise 1.10
;; (A 1 10) => 1024
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 1) => 2^10 => 1024
(deftest test-ackermann-function-1
  (is (= 1024 (A 1 10))))

;; (A 2 4) => 65536
;; (A 1 (A 1 (A 1 (A 2 1)))) => (A 1 (A 1 (A 1 2))) => 2^2^2^2 => 2^16
(deftest test-ackermann-function-2
  (is (= 65536 (A 2 4))))

;; (A 3 3)
;; (A 2 (A 2 (A 3 1))) => (A 2 (A 2 2)) => (A 2 (A 1 (A 2 1)))
;; => (A 2 (A 1 2) => (A 2 4) => 2^16 => 65536
(deftest test-ackermann-function-3
  (is (= 65536 (A 3 3))))

;; 2n
(deftest test-f-ackermann-1
  (is (= (* 2 2) (f-ackermann 2))))

(deftest test-f-ackermann-2
  (is (= (* 2 3) (f-ackermann 3))))

(deftest test-f-ackermann-3
  (is (= (* 2 4) (f-ackermann 4))))

;; 2^n
(deftest test-g-1
  (is (= 4 (g-ackermann 2))))

(deftest test-g-2
  (is (= 8 (g-ackermann 3))))

(deftest test-g-3
  (is (= 16 (g-ackermann 4))))

;; power of powers, raise 2^2 n times.
(deftest test-h-1
  (is (= 4 (h-ackermann 2))))

(deftest test-h-2
  (is (= 16 (h-ackermann 3))))

(deftest test-h-3
  (is (= 65536 (h-ackermann 4))))

;; Exercise 1.11
(deftest f-recursive-1
  (is (= 2 (f-recursive 2))))

(deftest f-recursive-2
  (is (= 4 (f-recursive 3))))

(deftest f-recursive-3
  (is (= 11 (f-recursive 4))))

(deftest f-recursive-4
  (is (= 25 (f-recursive 5))))

(deftest f-recursive-5
  (is (= 59 (f-recursive 6))))

(deftest f-iterative-1
  (is (= 2 (f-iterative 2))))

(deftest f-iterative-2
  (is (= 4 (f-iterative 3))))

(deftest f-iterative-3
  (is (= 11 (f-iterative 4))))

(deftest f-iterative-4
  (is (= 25 (f-iterative 5))))

(deftest f-iterative-5
  (is (= 59 (f-iterative 6))))

;; Exercise 1.12
(deftest test-pascals-triangle-base-case
  (is (= 1 (pascals-triangle 1 1))))

(deftest test-pascals-triangle-recursive-case
  (is (= 2 (pascals-triangle 3 2))))

;; Exercise 1.13 - proof

 
