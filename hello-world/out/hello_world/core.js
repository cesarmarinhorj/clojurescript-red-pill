// Compiled by ClojureScript 0.0-3196 {}
goog.provide('hello_world.core');
goog.require('cljs.core');
goog.require('goog.string.format');
goog.require('clojure.browser.repl');
if(typeof hello_world.core.conn !== 'undefined'){
} else {
hello_world.core.conn = clojure.browser.repl.connect.call(null,"http://localhost:9000/repl");
}
hello_world.core.format = goog.string.format;
hello_world.core.say_hello_fn = (function hello_world$core$say_hello_fn(sayer){
return cljs.core.println.call(null,hello_world.core.format.call(null,"Hello from %s",new cljs.core.Keyword(null,"f-name","f-name",1829376078).cljs$core$IFn$_invoke$arity$1(sayer)));
});
hello_world.core.say_stuff_fn = (function hello_world$core$say_stuff_fn(sayer,stuff){
return cljs.core.println.call(null,hello_world.core.format.call(null,"%s says %s",new cljs.core.Keyword(null,"f-name","f-name",1829376078).cljs$core$IFn$_invoke$arity$1(sayer),stuff));
});

hello_world.core.ISayStuff = (function (){var obj96 = {};
return obj96;
})();

hello_world.core.say_hello = (function hello_world$core$say_hello(sayer){
if((function (){var and__3239__auto__ = sayer;
if(and__3239__auto__){
return sayer.hello_world$core$ISayStuff$say_hello$arity$1;
} else {
return and__3239__auto__;
}
})()){
return sayer.hello_world$core$ISayStuff$say_hello$arity$1(sayer);
} else {
var x__3511__auto__ = (((sayer == null))?null:sayer);
return (function (){var or__3247__auto__ = (hello_world.core.say_hello[goog.typeOf(x__3511__auto__)]);
if(or__3247__auto__){
return or__3247__auto__;
} else {
var or__3247__auto____$1 = (hello_world.core.say_hello["_"]);
if(or__3247__auto____$1){
return or__3247__auto____$1;
} else {
throw cljs.core.missing_protocol.call(null,"ISayStuff.say-hello",sayer);
}
}
})().call(null,sayer);
}
});

hello_world.core.say_stuff = (function hello_world$core$say_stuff(sayer,stuff){
if((function (){var and__3239__auto__ = sayer;
if(and__3239__auto__){
return sayer.hello_world$core$ISayStuff$say_stuff$arity$2;
} else {
return and__3239__auto__;
}
})()){
return sayer.hello_world$core$ISayStuff$say_stuff$arity$2(sayer,stuff);
} else {
var x__3511__auto__ = (((sayer == null))?null:sayer);
return (function (){var or__3247__auto__ = (hello_world.core.say_stuff[goog.typeOf(x__3511__auto__)]);
if(or__3247__auto__){
return or__3247__auto__;
} else {
var or__3247__auto____$1 = (hello_world.core.say_stuff["_"]);
if(or__3247__auto____$1){
return or__3247__auto____$1;
} else {
throw cljs.core.missing_protocol.call(null,"ISayStuff.say-stuff",sayer);
}
}
})().call(null,sayer,stuff);
}
});

hello_world.core.reify_sayer = (function hello_world$core$reify_sayer(f_name,stuff){
if(typeof hello_world.core.t100 !== 'undefined'){
} else {

/**
* @constructor
*/
hello_world.core.t100 = (function (reify_sayer,f_name,stuff,meta101){
this.reify_sayer = reify_sayer;
this.f_name = f_name;
this.stuff = stuff;
this.meta101 = meta101;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
hello_world.core.t100.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (_102,meta101__$1){
var self__ = this;
var _102__$1 = this;
return (new hello_world.core.t100(self__.reify_sayer,self__.f_name,self__.stuff,meta101__$1));
});

hello_world.core.t100.prototype.cljs$core$IMeta$_meta$arity$1 = (function (_102){
var self__ = this;
var _102__$1 = this;
return self__.meta101;
});

hello_world.core.t100.prototype.hello_world$core$ISayStuff$ = true;

hello_world.core.t100.prototype.hello_world$core$ISayStuff$say_hello$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return window.alert(self__.f_name);
});

hello_world.core.t100.prototype.hello_world$core$ISayStuff$say_stuff$arity$2 = (function (_,___$1){
var self__ = this;
var ___$2 = this;
return window.alert(hello_world.core.format.call(null,"%s says %s",self__.f_name,self__.stuff));
});

hello_world.core.t100.cljs$lang$type = true;

hello_world.core.t100.cljs$lang$ctorStr = "hello-world.core/t100";

hello_world.core.t100.cljs$lang$ctorPrWriter = (function (this__3462__auto__,writer__3463__auto__,opt__3464__auto__){
return cljs.core._write.call(null,writer__3463__auto__,"hello-world.core/t100");
});

hello_world.core.__GT_t100 = (function hello_world$core$reify_sayer_$___GT_t100(reify_sayer__$1,f_name__$1,stuff__$1,meta101){
return (new hello_world.core.t100(reify_sayer__$1,f_name__$1,stuff__$1,meta101));
});

}

return (new hello_world.core.t100(hello_world$core$reify_sayer,f_name,stuff,cljs.core.PersistentArrayMap.EMPTY));
});

//# sourceMappingURL=core.js.map