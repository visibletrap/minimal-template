(ns leiningen.new.minimal
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "minimal"))

(defn minimal
  [name & options]
  (let [data {:name name
              :sanitized (name-to-path name)
              :clojure-version "1.9.0-alpha10"}
        figwheel? (and (seq options) (= (first options) "+figwheel"))]
    (cond
      figwheel?
      (->files data
               ["project.clj" (render "clj-figwheel-project.clj" data)]
               [".gitignore" (render ".gitignore")]
               ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
               ["index.html" (render "index.html")])

      :else
      (->files data
               ["project.clj" (render "pure-clj-project.clj" data)]
               [".gitignore" (render ".gitignore")]
               ["src/{{sanitized}}/core.clj" (render "core.clj" data)]))))
