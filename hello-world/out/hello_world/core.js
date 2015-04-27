// Compiled by ClojureScript 0.0-3196 {}
goog.provide('hello_world.core');
goog.require('cljs.core');
goog.require('goog.string.format');
goog.require('clojure.browser.repl');
if(typeof hello_world.core.conn !== 'undefined'){
} else {
hello_world.core.conn = clojure.browser.repl.connect.call(null,"http://localhost:9000/repl");
}

//# sourceMappingURL=core.js.map