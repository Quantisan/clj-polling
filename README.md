# clj-polling

A Clojure library for running a function periodically.

## Example

You should see "Hello" printed twice in this example.

```clj
(defn say-hello [] (println "Hello"))

; runs say-hello immediately and then every 200 ms using one thread
(periodically say-hello 0 200 :threads 1)

; wait for some time to see output
(Thread/sleep 500)  ;; wait 500 ms
(shutdown)          ;; shutdown
```
