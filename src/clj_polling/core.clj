(ns clj-polling.core
  "
  Reference:
  http://pragprog.com/magazines/2011-07/create-unix-services-with-clojure
  "
  (:import (java.util.concurrent ScheduledThreadPoolExecutor TimeUnit)))

(def ^:private pool (atom nil))

(defn- thread-pool [threads]
  (swap! pool (fn [p] (or p (ScheduledThreadPoolExecutor. threads)))))

(defn periodically
  "Schedules function f to run every 'delay' milliseconds after a
  delay of 'initial-delay'."
  [f initial-delay delay & {:keys [threads] :or {threads 1}}]
  (.scheduleWithFixedDelay (thread-pool threads)
                           f
                           initial-delay delay TimeUnit/MILLISECONDS))

(defn shutdown
  "Terminates all periodic tasks."
  []
  (swap! pool (fn [p] (when p (.shutdown p)))))
