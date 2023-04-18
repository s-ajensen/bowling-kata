(ns bowling-kata.core)

(defn roll [rolls pins]
  (conj rolls pins))

(defn is-strike [rolls n]
  (= 10 (nth rolls n)))

(defn is-spare [rolls n]
  (= 10 (+ (nth rolls n) (nth rolls (+ n 1)))))

(defn score-strike [rolls n]
  (+ 10 (nth rolls (+ 1 n)) (nth rolls (+ 2 n))))

(defn score-spare [rolls n]
  (+ 10 (nth rolls (+ 2 n))))

(defn score-frame [rolls n]
  (if (is-strike rolls n)
    (score-strike rolls n)
    (if (is-spare rolls n)
      (score-spare rolls n)
      (+ (nth rolls n) (nth rolls (+ n 1))))))

(defn progress-frames [rolls n]
  (if (is-strike rolls n) (inc n) (+ n 2)))

(defn score-game [rolls]
  (loop [frame        0
         frame-index  0
         score        0]
    (if (>= frame-index 10)
      score
      (recur (progress-frames rolls frame) (inc frame-index) (+ score (score-frame rolls frame))))))
