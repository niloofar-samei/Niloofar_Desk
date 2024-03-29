(defproject niloofar-desk "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [stasis "2023.11.21"]
                 [ring "1.11.0"]
                 [hiccup "2.0.0-RC2"]
                 [me.raynes/cegdown "0.1.1"]]
  :ring {:handler niloofar_desk.web/app}
  :profiles {:dev {:plugins [[lein-ring "0.12.6"]]}}
  :repl-options {:init-ns niloofar-desk.core})
