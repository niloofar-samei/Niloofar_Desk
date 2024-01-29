(ns niloofar_desk.web
  (:require [stasis.core :as stasis]
            [hiccup.page :refer [html5]]
            [clojure.java.io :as io]))

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

(defn partial-pages [pages]
  (zipmap (keys pages)
          (map layout-page (vals pages))))

(defn get-pages[]
  (stasis/merge-page-sources
    {:public (stasis/slurp-directory "resources/public" #".*\.(html|css|js)$")
     :partials (partial-pages (stasis/slurp-directory "resources/partials" #".*\.html$"))}))

(def app (stasis/serve-pages get-pages))

;(defn about-page [request]
;  (layout-page (slurp (io/resource "partials/about.html"))))


