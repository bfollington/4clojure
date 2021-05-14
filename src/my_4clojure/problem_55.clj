(ns my-4clojure.problem-55
  (:require [clojure.test :refer [deftest is run-tests]]))

(defn p-55 [xs]
  (into {} (map (fn [[k v]] [k (count v)]) (group-by identity xs))))


(deftest tests
  (is (= (p-55 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
  (is (= (p-55 [:b :a :b :a :b]) {:a 2, :b 3}))
  (is (= (p-55 '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))

(run-tests)