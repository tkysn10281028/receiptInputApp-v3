(function(){"use strict";var e={3046:function(e,o,t){var n=t(6369),r=function(){var e=this,o=e._self._c;return o("div",{attrs:{id:"app"}},[o("router-view")],1)},i=[],a=t(1001),s={},u=(0,a.Z)(s,r,i,!1,null,"77f01abf",null),c=u.exports,l=t(2631),d=function(){var e=this,o=e._self._c;return o("div",{attrs:{id:"main-view"}},[o("h2",[e._v("Hello, This is Test Page")]),o("p",[e._v("emailaddress:"),o("input",{directives:[{name:"model",rawName:"v-model",value:e.emailaddress,expression:"emailaddress"}],attrs:{type:"text"},domProps:{value:e.emailaddress},on:{input:function(o){o.target.composing||(e.emailaddress=o.target.value)}}})]),o("p",[e._v("password:"),o("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],attrs:{type:"password"},domProps:{value:e.password},on:{input:function(o){o.target.composing||(e.password=o.target.value)}}})]),o("button",{on:{click:e.login}},[e._v("Login!")]),o("br"),o("button",{on:{click:e.logout}},[e._v("Logout")]),o("br"),o("input",{directives:[{name:"model",rawName:"v-model",value:e.searchWord,expression:"searchWord"}],attrs:{type:"text"},domProps:{value:e.searchWord},on:{input:function(o){o.target.composing||(e.searchWord=o.target.value)}}}),o("button",{on:{click:e.search}},[e._v("Search")])])},p=[],h={data(){return{emailaddress:"",password:"",searchWord:""}},methods:{login:function(){const e=location.origin+"/",o=new URLSearchParams;o.append("emailaddress",this.emailaddress),o.append("password",this.password),this.axios.post(e,o,{headers:{Authorization:"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2NzcxOTczOCwiZXhwIjoxNjY4MzI0NTM4fQ.ISCX9j6isOda5LgTD6hAkMgpo1ijYCZ0_zRez1xNlvg"}},this.serverPass+"login").then((e=>{console.log(e)})).catch((e=>{console.log(e)}))},logout:function(){const e=location.origin+"/api/v1/logout";this.axios.get(e).then((e=>console.log(e)))},search:function(){const e=location.origin+"/api/v1/getResultBySearchWord",o=new URLSearchParams;o.append("searchWord",this.searchWord),this.axios.post(e,o,{headers:{Authorization:"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2NzcxOTczOCwiZXhwIjoxNjY4MzI0NTM4fQ.ISCX9j6isOda5LgTD6hAkMgpo1ijYCZ0_zRez1xNlvg"}},this.serverPass+"login").then((e=>{console.log(e)})).catch((e=>{console.log(e)}))}}},f=h,v=(0,a.Z)(f,d,p,!1,null,null,null),m=v.exports;n.ZP.use(l.ZP);const g=[{path:"/",name:"home",component:m}],w=new l.ZP({routes:g});var b=w,x=t(70),j=t(6423);n.ZP.use(j.Z,x.Z),n.ZP.config.productionTip=!1,new n.ZP({router:b,render:e=>e(c)}).$mount("#app")}},o={};function t(n){var r=o[n];if(void 0!==r)return r.exports;var i=o[n]={id:n,loaded:!1,exports:{}};return e[n](i,i.exports,t),i.loaded=!0,i.exports}t.m=e,function(){t.amdO={}}(),function(){var e=[];t.O=function(o,n,r,i){if(!n){var a=1/0;for(l=0;l<e.length;l++){n=e[l][0],r=e[l][1],i=e[l][2];for(var s=!0,u=0;u<n.length;u++)(!1&i||a>=i)&&Object.keys(t.O).every((function(e){return t.O[e](n[u])}))?n.splice(u--,1):(s=!1,i<a&&(a=i));if(s){e.splice(l--,1);var c=r();void 0!==c&&(o=c)}}return o}i=i||0;for(var l=e.length;l>0&&e[l-1][2]>i;l--)e[l]=e[l-1];e[l]=[n,r,i]}}(),function(){t.n=function(e){var o=e&&e.__esModule?function(){return e["default"]}:function(){return e};return t.d(o,{a:o}),o}}(),function(){t.d=function(e,o){for(var n in o)t.o(o,n)&&!t.o(e,n)&&Object.defineProperty(e,n,{enumerable:!0,get:o[n]})}}(),function(){t.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){t.hmd=function(e){return e=Object.create(e),e.children||(e.children=[]),Object.defineProperty(e,"exports",{enumerable:!0,set:function(){throw new Error("ES Modules may not assign module.exports or exports.*, Use ESM export syntax, instead: "+e.id)}}),e}}(),function(){t.o=function(e,o){return Object.prototype.hasOwnProperty.call(e,o)}}(),function(){var e={143:0};t.O.j=function(o){return 0===e[o]};var o=function(o,n){var r,i,a=n[0],s=n[1],u=n[2],c=0;if(a.some((function(o){return 0!==e[o]}))){for(r in s)t.o(s,r)&&(t.m[r]=s[r]);if(u)var l=u(t)}for(o&&o(n);c<a.length;c++)i=a[c],t.o(e,i)&&e[i]&&e[i][0](),e[i]=0;return t.O(l)},n=self["webpackChunkreceiptinputappfront"]=self["webpackChunkreceiptinputappfront"]||[];n.forEach(o.bind(null,0)),n.push=o.bind(null,n.push.bind(n))}();var n=t.O(void 0,[998],(function(){return t(3046)}));n=t.O(n)})();
//# sourceMappingURL=app.581e5db6.js.map