(ns sicp.ch1.newtons-method-test
  (:use sicp.ch1.newtons-method sicp.ch1.square)
  (:require [clojure.test :refer [deftest is]]))

(deftest test-good-enough-true-value
  (is (= true
         (good-enough? 3 9))))

(deftest test-good-enough-approx-value
  (is (= true
         (good-enough? 3.00009154 9))))

(deftest test-good-enough-false-value
  (is (= false
         (good-enough? 3.001 9))))

(defn approx? [x y]
  (< (abs (- x y)) 0.001))

(deftest test-sqrt
  (is (good-enough? (sqrt 9) 9)))

(deftest test-sqrt
  (is (approx? (sqrt 9) 3)))

(deftest test-sqrt-2
  (is (approx? (sqrt (+ 100 37)) 11.704699)))

(deftest test-sqrt-3
  (is (good-enough? (sqrt (+ (sqrt 2) (sqrt 3))) 3.14626)))

(deftest test-sqrt-4
  (is (approx? (square (sqrt 1000)) 1000)))
