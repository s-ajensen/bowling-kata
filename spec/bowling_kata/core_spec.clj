(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(def new-game
  '())

(defn roll-many [n pins]
  (nth (iterate #(roll % pins) new-game) n))

(describe "Bowling game tests"
  (it "should add gutter roll to a given game"
    (should= [0] (roll '() 0)))

  (it "should add successful roll to a given game"
    (should= [1] (roll '() 1)))

  (it "should score gutter game as 0"
    (should= 0 (score (roll-many 20 0))))

  (it "should score game of 1's as 20"
    (should= 20 (score (roll-many 20 1)))))
