(ns bowling-kata.core)

(defn roll [rolls pins]
  (conj rolls pins))

(defn is-spare [rolls]
  (= 10 (+ (first rolls) (nth rolls 1))))

(defn is-strike [rolls]
  (= 10 (first rolls)))

(defn get-next-frame [rolls]
  (if (is-strike rolls)
    (next rolls)
    (next (next rolls))))

(defn score-spare [rolls]
  (+ 10 (nth rolls 2)))

(defn score-strike [rolls]
  (let [next-frame-empty (nil? (nth rolls 2 nil))]
    (if next-frame-empty
      0
      (+ 10 (nth rolls 1 ) (nth rolls 2)))))

(defn score-frame [rolls]
  (if (is-strike rolls)
    (score-strike rolls)
    (if (is-spare rolls)
      (score-spare rolls)
      (+ (first rolls) (nth rolls 1)))))

(defn score-game [rolls]
  (loop [rolls rolls
         score 0]
    (print score " - " rolls "\n")
    (if (nil? (next rolls))
      score
      (recur (get-next-frame rolls) (+ score (score-frame rolls))))))