
(defproject rodnaph/tigger "0.3.0"
  :description "SMTP to core.async Channel Receiver"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/core.async "0.1.242.0-44b1e3-alpha"]
                 [org.subethamail/subethasmtp "3.1.7"]]
  :aot [tigger.MsgHandler tigger.MsgFactory])

