(ns clj-polling.core-test
  (:use clojure.test
        clj-polling.core))

(def test-atom (atom 0))

(defn inc-atom [x]
  (swap! x inc))

(deftest periodic-inc-test
  (testing "Periodically inc test-atom, shutdown after 3 periods"
    (is (= 3
           (dosync
             (periodically (partial inc-atom test-atom) 100 200)
             (Thread/sleep 600)
             (shutdown)
             @test-atom)))))
