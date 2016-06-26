(defproject {{name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "{{clojure-version}}"]
                 [org.clojure/clojurescript "1.9.89"]]

  :plugins [[lein-figwheel "0.5.4-4"]
            [lein-cljsbuild "1.1.3"]]

  :cljsbuild
  {:builds
   [{:id "dev"
     :source-paths ["src"]
     :figwheel {:on-jsload "{{name}}.core/on-js-reload"}
     :compiler {:main {{name}}.core
                :output-to "target/js/main.js"
                :output-dir "target/js"
                :source-map-timestamp true}}]})
