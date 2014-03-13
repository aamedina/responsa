(ns responsa.core
  (:require [weasel.repl :as repl]
            [cljs.core.async :as a :refer [<! >! put! take! chan]]
            [om.core :as om :include-macros true]
            [sablono.core :as html :refer [html] :include-macros true]
            [dommy.core :as dom])
  (:require-macros [cljs.core.async.macros :as a :refer [go go-loop]]
                   [dommy.macros :refer [sel sel1 node deftemplate]]))

(repl/connect "ws://localhost:9001" :verbose true)

(enable-console-print!)

(defn widget
  [data owner]
  (reify om/IRender
    (render [this]
      (html [:h1 (:text data)]))))

(defn ^:export -main []
  (om/root widget
    {:text "Hello, world!"} {:target (sel1 :#content)}))
