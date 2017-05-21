(ns leiningen.new.minimal
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "minimal"))

(defn minimal
  [name & options]
  (let [data {:name name
              :sanitized (name-to-path name)
              :clojure-version "1.9.0-alpha16"} ]
    (->files data
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render ".gitignore")]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)])))
