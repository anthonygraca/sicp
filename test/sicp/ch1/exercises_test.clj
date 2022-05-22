(ns sicp.ch1.exercises-test
  (:require [sicp.ch1.exercises :refer :all]
            [clojure.test :refer :all]))

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
