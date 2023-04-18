(ns bowling-kata.core)

(defn roll [rolls pins]
  (let [rolls (conj rolls pins)]
    (if (= pins 10)
      (conj rolls 0)
      rolls)))

(defn is-spare [rolls n]
  (= 10 (+ (nth rolls n) (nth rolls (+ n 1)))))

(defn score-spare [rolls n]
  (+ 10 (nth rolls (+ 2 n))))

(defn score-frame [rolls n]
  (if (= 10 (nth rolls n))
    (+ 10 (nth rolls (+ 2 n)) (nth rolls (+ 3 n)))
    (if (is-spare rolls n)
      (score-spare rolls n)
      (+ (nth rolls n) (nth rolls (+ n 1))))))

(defn score-game [rolls]
  (print rolls "\n")
  (loop [n      0
         score  0]
    (print n " - " score "\n")
    (if (>= n 20)
      score
      (recur (+ n 2) (+ score (score-frame rolls n))))))
