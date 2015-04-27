// Compiled by ClojureScript 0.0-3196 {}
goog.provide('hello_world.core');
goog.require('cljs.core');
goog.require('clojure.browser.repl');
if(typeof hello_world.core.conn !== 'undefined'){
} else {
hello_world.core.conn = clojure.browser.repl.connect.call(null,"http://localhost:9000/repl");
}
hello_world.core.say_hello = (function hello_world$core$say_hello(){
return cljs.core.println.call(null,"hello world");
});
hello_world.core.my_name = "Amir Rajan";
hello_world.core.my_dictionary = new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"name","name",1843675177),"Amir"], null);
hello_world.core.jane_doe = new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"f-name","f-name",1829376078),"Jane",new cljs.core.Keyword(null,"l-name","l-name",-1347905953),"Doe"], null)], null);
hello_world.core.john_doe = new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"f-name","f-name",1829376078),"John",new cljs.core.Keyword(null,"l-name","l-name",-1347905953),"Doe"], null)], null);
hello_world.core.jane_doe_twin = new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"f-name","f-name",1829376078),"Jane",new cljs.core.Keyword(null,"l-name","l-name",-1347905953),"Doe"], null)], null);
hello_world.core.all_people = new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [hello_world.core.jane_doe,hello_world.core.john_doe,hello_world.core.jane_doe_twin], null);
hello_world.core.say_hello = (function hello_world$core$say_hello(person){
return cljs.core.println.call(null,[cljs.core.str(new cljs.core.Keyword(null,"f-name","f-name",1829376078).cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(person))),cljs.core.str(" says hello")].join(''));
});
hello_world.core.say_hello_pretty = (function hello_world$core$say_hello_pretty(person){
return cljs.core.println.call(null,[cljs.core.str(" says hello"),cljs.core.str(new cljs.core.Keyword(null,"f-name","f-name",1829376078).cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(person)))].join(''));
});
hello_world.core.say_hello_fixed = (function hello_world$core$say_hello_fixed(person){
return cljs.core.println.call(null,(function (p){
return [cljs.core.str(p),cljs.core.str(" says hello")].join('');
}).call(null,new cljs.core.Keyword(null,"f-name","f-name",1829376078).cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(person))));
});
hello_world.core.say_hello_anon = (function hello_world$core$say_hello_anon(person){
return cljs.core.println.call(null,(function (p1__128_SHARP_){
return [cljs.core.str(p1__128_SHARP_),cljs.core.str(" says hello")].join('');
}).call(null,new cljs.core.Keyword(null,"f-name","f-name",1829376078).cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(person))));
});

//# sourceMappingURL=core.js.map