(ns sicp.ch1.black-box
  (:use sicp.ch1.square))

(defn average [x y]
  (/ (+ x y) 2))

(defn sqrt [x]
  (letfn [(good-enough? [guess x]
            (< (abs (- (square guess) x)) 0.001))]
    (letfn [(improve [guess x]
              (average guess (/ x guess)))]
      (letfn [(sqrt-iter [guess x]
                (if (good-enough? guess x)
                  guess
                  (sqrt-iter (improve guess x) x)))]
        (sqrt-iter 1.0 x)))))

(defn sqrt-lexical-scope [x]
  (letfn [(good-enough? [guess]
            (< (abs (- (square guess) x)) 0.001))]
    (letfn [(improve [guess]
              (average guess (/ x guess)))]
      (letfn [(sqrt-iter [guess]
                (if (good-enough? guess)
                  guess
                  (sqrt-iter (improve guess))))]
        (sqrt-iter 1.0)))))
