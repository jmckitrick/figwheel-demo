(ns ^:figwheel-hooks figwheel-demo.core
    (:require [reagent.core :as r]))

(enable-console-print!)

(println "This text is printed from src/figwheel-demo.core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(defn my-component []
  [:div
   Hello, world!])

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  (r/render [my-component]
            (.getElementById js/document "app"))
)
