(ns bowling-kata.core)

(defn roll [rolls pins]
  (conj rolls pins))

(defn is-spare [rolls]
  (= 10 (+ (first rolls) (nth rolls 1))))

(defn is-strike [rolls]
  (= 10 (first rolls)))

(defn score-strike [rolls]
  (if (nil? (nth rolls 2 nil))
    0
    (+ 10 (nth rolls 1) (nth rolls 2))))

(defn progress-frame [rolls]
  (if (is-strike rolls)
    (next rolls)
    (next (next rolls))))

(defn score-frame [rolls]
  (if (is-strike rolls)
    (score-strike rolls)
    (if (is-spare rolls)
      (+ 10 (nth rolls 2))
      (+ (first rolls) (nth rolls 1)))))

(defn score-game [rolls]
  (loop [rolls rolls
         score 0]
    (if (nil? (next rolls))
      score
      (recur (progress-frame rolls) (+ score (score-frame rolls))))))