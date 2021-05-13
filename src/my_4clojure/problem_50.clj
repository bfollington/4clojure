(ns my-4clojure.problem-50
  (:require [clojure.test :refer [deftest is run-tests]]))

(defn sln [xs]
  (vals (group-by type xs)))

(deftest tests
  (is (= (set (sln [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
  (is (= (set (sln [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
  (is (= (set (sln [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})))

(run-tests)