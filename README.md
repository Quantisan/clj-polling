# clj-polling

A Clojure library for polling resources.

## Example

You should see "Hello" printed twice in this example.

```clj
(defn say-hello [] (println "Hello"))

(periodically say-hello 0 200)

(Thread/sleep 500)  ;; wait 500 ms
(shutdown)          ;; shutdown
```
