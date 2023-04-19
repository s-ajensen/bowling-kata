(ns bowling-kata.core)

(defn roll [rolls pins]
  (conj rolls pins))

(defn get-next-frame [rolls]
  (if (= 10 (first rolls))
    (next rolls)
    (next (next rolls))))

(defn is-spare [rolls]
  (= 10 (+ (first rolls) (nth rolls 1))))

(defn score-spare [rolls]
  (+ (first rolls) (nth rolls 1)))

(defn score-frame [rolls]
  (if (= 10 (first rolls))
    (+ 10 (nth rolls 1 ) (nth rolls 2))
    (if (is-spare rolls)
      (+ 10 (nth rolls 2))
      (score-spare rolls))))

(defn score-game [rolls]
  (loop [rolls rolls
         score 0]
    (if (nil? (next rolls))
      score
      (recur (get-next-frame rolls) (+ score (score-frame rolls))))))