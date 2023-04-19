(ns bowling-kata.core)

(defn roll [rolls pins]
  (conj rolls pins))

(defn get-next-frame [rolls]
  (next (next rolls)))

(defn score-frame [rolls]
  (if (= 10 (+ (first rolls) (nth rolls 1)))
    (+ 10 (nth rolls 2))
    (+ (first rolls) (nth rolls 1))))

(defn score-game [rolls]
  (loop [rolls rolls
         score 0]
    (if (nil? (next rolls))
      score
      (recur (get-next-frame rolls) (+ score (score-frame rolls))))))