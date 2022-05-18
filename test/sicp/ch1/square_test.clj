(ns sicp.ch1.square-test
  (:use clojure.test)
  (:require [sicp.ch1.square :refer :all]))

(deftest test-square
  (is (= 441 (square 21))))

(deftest test-square-2
  (is (= 49 (square (+ 2 5)))))

(deftest test-square-square
  (is (= 81 (square (square 3)))))

(deftest test-sum-of-squares
  (is (= 25 (sum-of-squares 3 4))))

(deftest test-f
  (is (= 136 (f 5))))

