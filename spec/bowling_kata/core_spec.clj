(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(describe "Bowling game tests"
  (it "should add gutter roll to a given game"
    (should= [0] (roll '() 0)))

  (it "should add successful roll to a given game"
    (should= [1] (roll '() 1))))
