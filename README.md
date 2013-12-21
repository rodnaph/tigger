
# Tigger, SMTP to core.async Channel Receiver

Tigger provides an [SMTP server](https://code.google.com/p/subethasmtp/) that
routes messages to a [core.async](https://github.com/clojure/core.async) channel
as Clojure data structures.

## Usage

To start a server you use the _listen_ function, which will return a channel
that you can read from.  This is an example which prints all messages that
are received.

```clojure
(ns my.project
  (:require [tigger.core :refer [listen]]
            [clojure.core.async :refer [<!!]]))

(defn -main []
  (let [ch (listen 25)]
    (while true
      (println (pr-str (<!! ch))))))
```

