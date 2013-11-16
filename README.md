# sorcery-data

A Clojure library that scrapes data-sorcery.org/book-recommendations 
to an Incanter dataset, minus images and links. Uses Enlive and
Incanter. 


## Usage

(save-xls (load-data book-url) "resources/recommendations.xls")

For more manipulations, see the Incanter docs.

## License

Copyright © 2013 Brian Muhia

Distributed under the Eclipse Public License, the same as Clojure.
