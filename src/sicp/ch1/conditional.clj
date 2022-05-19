(ns sicp.ch1.conditional
  (:refer-clojure :exclude (abs)))

(defn abs [x]
  (cond
    (> x 0) x
    (= x 0) 0
    :else (* x -1)))

