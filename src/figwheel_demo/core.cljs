(ns ^:figwheel-hooks figwheel-demo.core
    (:require [reagent.core :as r]))

(enable-console-print!)

(println "This text is printed from src/figwheel-demo.core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello, world!"}))

(defn my-component []
  [:div.panel.panel-default
   (:text @app-state)])

(defn my-root []
  [:div.container
   [my-component]])

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  (swap! app-state update-in [:__figwheel_counter] inc)
  (console.log "Reload")
  (r/render [my-root]
            (.getElementById js/document "app")))
