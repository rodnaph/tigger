
(ns tigger.core
  (:require [clojure.core.async :refer [chan <!!]])
  (:import (org.subethamail.smtp.server SMTPServer)))

;; Public
;; ------

(defn listen
  ([port] (listen port (chan)))
  ([port ch]
   (let [factory (tigger.MsgFactory. ch)
         server (doto (SMTPServer. factory)
                  (.setPort port))]
     (future
       (.start server)))
   ch))

