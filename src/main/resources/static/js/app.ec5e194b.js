(function(){"use strict";var e={5296:function(e,n,o){var t=o(6369),r=function(){var e=this,n=e._self._c;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},i=[],a=o(1001),s={},u=(0,a.Z)(s,r,i,!1,null,"77f01abf",null),c=u.exports,l=o(2631),d=function(){var e=this,n=e._self._c;return n("div",{attrs:{id:"main-view"}},[n("h2",[e._v("Hello, This is Test Page")]),n("p",[e._v("emailaddress:"),n("input",{directives:[{name:"model",rawName:"v-model",value:e.emailaddress,expression:"emailaddress"}],attrs:{type:"text"},domProps:{value:e.emailaddress},on:{input:function(n){n.target.composing||(e.emailaddress=n.target.value)}}})]),n("p",[e._v("password:"),n("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],attrs:{type:"password"},domProps:{value:e.password},on:{input:function(n){n.target.composing||(e.password=n.target.value)}}})]),n("button",{on:{click:e.login}},[e._v("Login!")]),n("br"),n("button",{on:{click:e.logout}},[e._v("Logout")]),n("br"),n("button",{on:{click:e.search}},[e._v("Search")])])},p=[],f={data(){return{emailaddress:"",password:""}},methods:{login:function(){const e=location.origin+"/",n=new URLSearchParams;n.append("emailaddress",this.emailaddress),n.append("password",this.password),this.axios.post(e,n,{headers:{Authorization:"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2NzcxOTczOCwiZXhwIjoxNjY4MzI0NTM4fQ.ISCX9j6isOda5LgTD6hAkMgpo1ijYCZ0_zRez1xNlvg"}},this.serverPass+"login").then((e=>{console.log(e)})).catch((e=>{console.log(e)}))},logout:function(){const e=location.origin+"/api/v1/logout";this.axios.get(e).then((e=>console.log(e)))},search:function(){const e=location.origin+"/api/v1/getResultBySearchWord",n=new URLSearchParams;n.append("searchWord","search"),this.axios.post(e,n,{headers:{Authorization:"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2NzcxOTczOCwiZXhwIjoxNjY4MzI0NTM4fQ.ISCX9j6isOda5LgTD6hAkMgpo1ijYCZ0_zRez1xNlvg"}},this.serverPass+"login").then((e=>{console.log(e)})).catch((e=>{console.log(e)}))}}},h=f,v=(0,a.Z)(h,d,p,!1,null,null,null),g=v.exports;t.ZP.use(l.ZP);const m=[{path:"/",name:"home",component:g}],w=new l.ZP({routes:m});var b=w,j=o(70),O=o(6423);t.ZP.use(O.Z,j.Z),t.ZP.config.productionTip=!1,new t.ZP({router:b,render:e=>e(c)}).$mount("#app")}},n={};function o(t){var r=n[t];if(void 0!==r)return r.exports;var i=n[t]={id:t,loaded:!1,exports:{}};return e[t](i,i.exports,o),i.loaded=!0,i.exports}o.m=e,function(){o.amdO={}}(),function(){var e=[];o.O=function(n,t,r,i){if(!t){var a=1/0;for(l=0;l<e.length;l++){t=e[l][0],r=e[l][1],i=e[l][2];for(var s=!0,u=0;u<t.length;u++)(!1&i||a>=i)&&Object.keys(o.O).every((function(e){return o.O[e](t[u])}))?t.splice(u--,1):(s=!1,i<a&&(a=i));if(s){e.splice(l--,1);var c=r();void 0!==c&&(n=c)}}return n}i=i||0;for(var l=e.length;l>0&&e[l-1][2]>i;l--)e[l]=e[l-1];e[l]=[t,r,i]}}(),function(){o.n=function(e){var n=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(n,{a:n}),n}}(),function(){o.d=function(e,n){for(var t in n)o.o(n,t)&&!o.o(e,t)&&Object.defineProperty(e,t,{enumerable:!0,get:n[t]})}}(),function(){o.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){o.hmd=function(e){return e=Object.create(e),e.children||(e.children=[]),Object.defineProperty(e,"exports",{enumerable:!0,set:function(){throw new Error("ES Modules may not assign module.exports or exports.*, Use ESM export syntax, instead: "+e.id)}}),e}}(),function(){o.o=function(e,n){return Object.prototype.hasOwnProperty.call(e,n)}}(),function(){var e={143:0};o.O.j=function(n){return 0===e[n]};var n=function(n,t){var r,i,a=t[0],s=t[1],u=t[2],c=0;if(a.some((function(n){return 0!==e[n]}))){for(r in s)o.o(s,r)&&(o.m[r]=s[r]);if(u)var l=u(o)}for(n&&n(t);c<a.length;c++)i=a[c],o.o(e,i)&&e[i]&&e[i][0](),e[i]=0;return o.O(l)},t=self["webpackChunkreceiptinputappfront"]=self["webpackChunkreceiptinputappfront"]||[];t.forEach(n.bind(null,0)),t.push=n.bind(null,t.push.bind(t))}();var t=o.O(void 0,[998],(function(){return o(5296)}));t=o.O(t)})();
//# sourceMappingURL=app.ec5e194b.js.map