(ns bowling-kata.core)

(defn roll [rolls pins]
  (conj rolls pins))

(defn score-game [rolls]
  (reduce + rolls))
