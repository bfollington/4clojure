(ns my-4clojure.problem-54
  (:require [clojure.test :refer [deftest is run-tests]]))

(defn p-54 [n xs]
  (let [xs (into [] xs)
        length (count xs)
        chunks (/ length n)]
    (->> (map (fn [x]
                (let [start (* x n)
                      end (+ start n)
                      in-bounds (<= end length)]
                  (if in-bounds
                    (into '() (reverse (subvec xs (* x n) (+ (* x n) n))))
                    nil)))
              (range chunks))
         (filter some?))))

(defn p-54-2 [n xs]
  (let [head (take n xs)
        tail (drop n xs)]
    (when (<= n (count xs))
      (concat (list head) (p-54-2 n tail)))))

(concat [1 2 3] [1 2 3])


(p-54-2 2 [1 2 3 4 5 6 7 8 9 10 11])
(p-54 2 [1 2 3 4 6])


(take 2 [1 2 3])

(deftest p-54-tests
  (is (= (p-54-2 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
  (is (= (p-54-2 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
  (is (= (p-54-2 3 (range 8)) '((0 1 2) (3 4 5)))))

(run-tests)