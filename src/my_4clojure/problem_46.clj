(ns my-4clojure.problem-46
  (:require [clojure.test :refer [deftest is run-tests]]))

(defn sln [f]
  (fn [& args]
    (apply f (reverse args))))

(deftest tests
  (is (= 3 ((sln nth) 2 [1 2 3 4 5])))
  (is (= true ((sln >) 7 8)))
  (is (= 4 ((sln quot) 2 8)))
  (is (= [1 2 3] ((sln take) [1 2 3 4 5] 3))))

(run-tests)