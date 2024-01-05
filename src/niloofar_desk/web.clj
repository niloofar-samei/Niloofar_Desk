(ns niloofar_desk.web
  (:require [stasis.core :as stasis]
            [hiccup.page :refer [html5]]))

(defn get-pages []
  (stasis/slurp-directory "resources/public" #".*\.(html|css|js)$"))

(def app (stasis/serve-pages get-pages))

(defn layout-page [page]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:title "Tech blog"]
    [:link {:rel "stylesheet" :href "/styles/styles.css"}]]
   [:body
    [:div.logo "cjohansen.no"]
    [:div.body page]]))
