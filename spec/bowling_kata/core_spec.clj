(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(describe "Bowling scoring tests"
  (it "should score a game of gutter balls as 0"
    (should= 0 (score-game (loop [n     0
                                  rolls ()]
                             (if (>= n 20)
                               rolls
                               (recur (inc n) (roll rolls 0)))))))
  (it "should score a game of 1's as 20"
    (should= 20 (score-game (loop [n      0
                                   rolls  ()]
                              (if (>= n 20)
                                rolls
                                (recur (inc n) (roll rolls 1))))))))
