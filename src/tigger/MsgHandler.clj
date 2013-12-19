
(ns tigger.MsgHandler
  (:import (org.subethamail.smtp MessageContext))
  (:require [clojure.core.async :refer [put!]])
  (:gen-class
    :implements [org.subethamail.smtp.MessageHandler]
    :init init
    :constructors {[Object org.subethamail.smtp.MessageContext] []}
    :state state))

(defn- set-in [this k v]
  (dosync
    (alter (.state this) assoc k v)))

;; Impl
;; ----

(defn -init [ch ^MessageContext ctx]
  [[] (ref {:ch ch :ctx ctx})])

(defn -from [this from]
  (set-in this :from from))

(defn -recipient [this recipient]
  (set-in this :recipient recipient))

(defn -data [this in]
  (set-in this :data (slurp in)))

(defn -done [this]
  (let [{:keys [ch from recipient data]} @(.state this)
        msg {:from from
             :recipient recipient
             :data data}]
    (put! ch msg)))

