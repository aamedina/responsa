(defproject responsa "0.1.0-SNAPSHOT"
  :license {:name "GNU Public License v3.0"
            :url "https://www.gnu.org/copyleft/gpl.html"}
  :repositories
  {"sonatype"
   "http://oss.sonatype.org/content/repositories/snapshots"
   "gclosure"
   "https://oss.sonatype.org/content/repositories/orgclojure-1208/"
   "gclosure-third-party"
   "https://oss.sonatype.org/content/repositories/orgclojure-1209/"}
  :dependencies [[org.clojure/clojure "1.6.0-RC1"]
                 [org.clojure/clojurescript "0.0-2191"
                  :exclusions [org.clojure/google-closure-library
                               org.clojure/google-closure-library-third-party]]
                 [org.clojure/google-closure-library "0.0-20140226-71326067"]
                 [org.clojure/core.async "0.1.278.0-76b25b-alpha"]
                 [om "0.5.2"]
                 [sablono "0.2.10"]
                 [ankha "0.1.1"]
                 [riddley "0.1.6"]
                 [prismatic/dommy "0.1.2"]
                 [weasel "0.1.0"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [ring "1.2.1"]
                                  [compojure "1.1.6"]
                                  [enlive "1.1.4"]]
                   :plugins [[com.cemerick/austin "0.1.4"]]
                   :source-paths ["dev"]}}
  :plugins [[lein-cljsbuild "1.0.2"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds
              [{:source-paths ["src"]
                :compiler {:output-to "resources/public/js/main.js"
                           :output-dir "resources/public/js/out"
                           :source-map true
                           :optimizations :none}}]})
