(ns sicp.ch1.ex1-test
  (:use clojure.test)
  (:require [sicp.ch1.ex1 :refer :all]))

(deftest must-pass (is true))

(deftest test-literal
  (is (= 10 10)))

(deftest test_addition
  (is (= 12 (+ 5 3 4))))

(deftest test-subtraction
  (is (= 8 (- 9 1))))

(deftest test-division
  (is (= 3 (/ 6 2))))

(deftest test-multiple-opterations
  (is (= 6 (+ (* 2 4) (- 4 6)))))

(deftest test-naming-computational-objects
  (is (= 3 a)))
  
(deftest test-naming-result-of-compound-operations
  (is (= 4 b)))

(deftest test-computational-objects-of-increasing-complexity
  (is (= 19 (+ a b (* a b)))))

(deftest test-comparison
  (is (= false (= a b))))

(deftest test-conditional-expression
  (is (= 16 (cond (= a 4) 6
                  (= b 4) (+ 6 7 a)
                  :else 25))))

(deftest test-compound-operation-with-predicate
  (is (= 6 (+ 2 (if (> b a) b a)))))

(deftest test-compound-operation-with-conditional
  (is (= 16 (* (cond (> a b) a
                     (< a b) b
                     :else -1)
               (+ a 1)))))
