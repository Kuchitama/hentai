(defproject hentai "1.0.0-SNAPSHOT"
  :description "For heintai advent calendar"
  :dependencies [[org.clojure/clojure "1.2.1"]
        [org.clojure/clojure-contrib "1.2.0"]
        [compojure "0.6.4"]
        [fleet "0.9.5"]]
  :dev-dependencies [[lein-eclipse "1.0.0"]
                     [lein-ring "0.4.5"]]
  :ring {:handler hentai.core/app})
