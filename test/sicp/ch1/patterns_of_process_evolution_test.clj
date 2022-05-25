(ns sicp.ch1.patterns-of-process-evolution-test
  (:use sicp.ch1.patterns-of-process-evolution)
  (:require [clojure.test :refer [deftest is]]))

(deftest test-linear-iterative-factorial
  (is (= 720 (linear-iterative-factorial 6))))

(deftest test-counter-factorial
  (is (= 720 (counter-factorial 6))))

(deftest test-bad-fibonacci-1
  (is (= 0 (bad-fibonacci 0))))

(deftest test-bad-fibonacci-2
  (is (= 1 (bad-fibonacci 1))))

(deftest test-bad-fibonacci-3
  (is (= 1 (bad-fibonacci 2))))

(deftest test-good-fib-1
  (is (= 0 (fib 0))))

(deftest test-good-fib-2
  (is (= 1 (fib 1))))

(deftest test-good-fib-3
  (is (= 1 (fib 2))))

(deftest test-good-fib-4
  (is (= 6765 (fib 20))))

(deftest test-good-fib-5
  (is (= 832040 (fib 30))))
