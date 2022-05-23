(ns sicp.ch1.black-box-test
  (:use sicp.ch1.black-box)
  (:require [clojure.test :refer [deftest is]]))

(deftest test-good-enough
  (is (== (sqrt 1) 1)))

(deftest test-sqrt
  (is (< (abs (- (sqrt 9) 3)) 0.001)))

(deftest test-good-enough-lexical-scope
  (is (== (sqrt-lexical-scope 1) 1)))

(deftest test-sqrt-lexical-scope
  (is (< (abs (- (sqrt-lexical-scope 9) 3)) 0.001)))

