(ns sicp.ch1.conditional-test
  (:require [sicp.ch1.conditional :as sicp]
            [clojure.test :refer :all]))

(deftest test-abs
  (is (= 1 (sicp/abs 1))))

(deftest test-abs-zero
  (is (= 0 (sicp/abs 0))))

(deftest test-abs-negative
  (is (= 1 (sicp/abs -1))))
