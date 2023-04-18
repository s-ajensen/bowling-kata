(ns bowling-kata.core)

(defn roll [rolls pins]
  (conj rolls pins))

(defn score-frame [rolls n]
  (if (= 10 (+ (nth rolls n) (nth rolls (+ n 1))))
    (+ 10 (nth rolls (+ 2 n)))
    (+ (nth rolls n) (nth rolls (+ n 1)))))

(defn score-game [rolls]
  (loop [n      0
         score  0]
    (if (>= n 20)
      score
      (recur (+ n 2) (+ score (score-frame rolls n))))))
