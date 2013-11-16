(ns sorcery-data.core
  (:require '[clojure.string :as string]
            '[net.cgrand.enlive-html :as html])
  (:use 'incanter.core)
  (:import [java.net URL]))

(def book-url "http://data-sorcery.org/book-recommendations/")

(defn to-keyword
  "Takes a string and returns a normalized keyword."
  [input]
  (-> input
      string/lower-case
      (string/replace \space \-)
      keyword))


;;(def ^:dynamic row-selector
;;[[:div.entry-content
;;  (html/but [:td :strong])]])


(defn load-data
  "This loads the data from a table at a URL."
  [url]
  (let [html (html/html-resource (URL. url))
        
        div (html/select html [:div.entry-content])

        colnames ["Group" "Books"]
        
        headers (->>
                 (html/select div [:td :strong])
                 (map html/text)
                 (map to-keyword)
                 vec)

        rows (->> (html/select div [:tr])
                  (map #/select % [:td])
                  (map #(map html/text %))
                  (filter seq))

        ;;links (->> (first (html/select div '[[:a (attr? :href)]]))
        ;; (map #(map html/text %))
        ;; vec)
        ]
    
    (dataset colnames rows)))
