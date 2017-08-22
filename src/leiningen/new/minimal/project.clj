(defproject {{name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "{{clojure-version}}"]
                 [org.clojure/spec.alpha "0.1.123"]
                 [org.clojure/core.specs.alpha "0.1.24"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]]}})
