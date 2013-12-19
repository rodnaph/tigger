
(ns tigger.MsgFactory
  (:import (org.subethamail.smtp MessageContext))
  (:gen-class
    :implements [org.subethamail.smtp.MessageHandlerFactory]
    :init init
    :constructors {[Object] []}
    :state state))

(defn -init [ch]
  [[] (ref {:ch ch})])

(defn -create [this ^MessageContext ctx]
  (tigger.MsgHandler. (:ch @(.state this)) ctx))

