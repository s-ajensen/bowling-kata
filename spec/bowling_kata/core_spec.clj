(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(def new-game [])

(defn roll-many [rolls pins num-rolls]
  (nth (iterate #(roll % pins) rolls) num-rolls))

(describe "bowling kata tests"
  (it "should add rolls to the game"
    (should= [0] (roll new-game 0))
    (should= [0 0] (roll-many new-game 0 2))
    (should= [1 1 1] (roll-many new-game 1 3)))

  (it "should score game of gutter balls as 0"
    (should= 0 (score-game (roll-many new-game 0 20))))

  (it "should score game of 1 pin rolls as 20"
    (should= 20 (score-game (roll-many new-game 1 20))))

  (it "should give bonus for rolling a spare"
    (should= 16 (score-game (-> new-game
                              (roll-many 5 2)
                              (roll 3)
                              (roll-many 0 17)))))

  (it "should score game of spares as 150"
    (should= 150 (score-game (roll-many new-game 5 21))))

  (it "should give bonus for rolling a strike"
    (should= 20 (score-game (-> new-game
                              (roll 10)
                              (roll 2)
                              (roll 3)
                              (roll-many 0 17)))))

  (it "should score perfect game as 300"
    (should= 300 (score-game (roll-many new-game 10 12)))))
