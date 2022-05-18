(ns sicp.ch1.conditional-test
  (:use clojure.test)
  (:require [sicp.ch1.conditional :refer :all]))

(deftest test-abs
  (is (= 1 (my-abs 1))))

(deftest test-abs-zero
  (is (= 0 (my-abs 0))))

(deftest test-abs-negative
  (is (= 1 (my-abs -1))))
