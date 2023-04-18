(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(defn roll-many [num-rolls pins]
  (loop [n     0
         rolls []]
    (if (>= n num-rolls)
      rolls
      (recur (inc n) (roll rolls pins)))))

(describe "Bowling scoring tests"
  (it "should score a game of gutter balls as 0"
    (should= 0 (score-game (roll-many 20 0))))
  (it "should score a game of 1's as 20"
    (should= 20 (score-game (roll-many 20 1))))
  (it "should give the bonus for scoring a spare"
    (should= 16 (score-game (-> []
                                (roll 5)
                                (roll 5)
                                (roll 3)
                                (concat (roll-many 17 0)))))))
