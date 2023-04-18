(ns bowling-kata.core)

(defn roll [rolls pins]
  (conj rolls pins))

(defn is-spare [rolls n]
  (= 10 (+ (nth rolls n) (nth rolls (+ n 1)))))

(defn score-spare [rolls n]
  (+ 10 (nth rolls (+ 2 n))))

(defn score-frame [rolls n]
  (if (is-spare rolls n)
    (score-spare rolls n)
    (+ (nth rolls n) (nth rolls (+ n 1)))))

(defn score-game [rolls]
  (loop [n      0
         score  0]
    (if (>= n 20)
      score
      (recur (+ n 2) (+ score (score-frame rolls n))))))
