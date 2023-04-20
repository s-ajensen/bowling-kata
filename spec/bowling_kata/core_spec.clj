(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(def new-game
  [])

(defn roll-many [rolls pins num-rolls]
  (nth (iterate #(roll % pins) rolls) num-rolls))

(describe "Bowling game tests"
  (it "should roll a single gutter ball as 0"
    (should= [0] (roll new-game 0)))

  (it "should roll a single pin roll as 1"
    (should= [1] (roll new-game 1)))

  (it "should return [1 1] after rolling two single pins"
    (should= [1 1] (roll-many new-game 1 2)))

  (it "should score a game of gutter balls as 0"
    (should= 0 (score-game (roll-many new-game 0 20))))

  (it "should score a game of single pin rolls as 20"
    (should= 20 (score-game (roll-many new-game 1 20))))

  (it "should give bonus for spare"
    (should= 16 (score-game (-> new-game
                                (roll-many 5 2)
                                (roll 3)
                                (roll-many 0 17)))))

  (it "should score game of spares as 150"
    (should= 150 (score-game (roll-many new-game 5 21))))

  (it "should give bonus for strike"
    (should= 20 (score-game (-> new-game
                                (roll 10)
                                (roll 2)
                                (roll 3)
                                (roll-many 0 17)))))

  (it "should score perfect game as 300"
    (should= 300 (score-game (roll-many new-game 10 12)))))

