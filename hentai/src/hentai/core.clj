(ns hentai.core
  (:use compojure.core compojure.response fleet
        [ring.util.response :only (response content-type)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]))

(fleet-ns templates "templates" [:fleet :bypass])

(extend-protocol Renderable fleet.util.CljString 
    (render [this _] (-> (response (.toString this))
                       (content-type "text-html; charset=UTF-8"))))

(def hentai-link ["http://fs.plaync.jp/UF/image/6344/01/23/13/842/seigetsu_32446/854674_photo0.jpg" "http://yipev.com/data/img2/20110408084405/thumb_e1r73nh7fv301cd1uweinzjw.jpg" "http://fs.plaync.jp/UF/image/6344/01/23/13/842/seigetsu_32446/854662_photo0.jpg"])
(defn get-img []  (rand-nth hentai-link))

(defroutes main-routes
  (GET "/" _ (templates/index))
  (POST "/hentai" {params :params} (templates/hentai {:link (get-img) :user-name (params :user)}))
  (GET "/ikemen" _ "You are ikemen")
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (handler/site main-routes))