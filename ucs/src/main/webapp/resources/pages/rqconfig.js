requirejs.config({
	baseUrl:ctxResources+'/pages/modules',
	urlArgs: "v=" +  (new Date()).getTime(),//禁止缓存，生产环境去除
//	urlArgs:'v=2016111102',
    paths:{
      jquery:["../../plugins/jquery/jquery"],
      bootstrap:["../../plugins/bootstrap/dist/js/bootstrap.min"],
	  validate:["../../plugins/bootstrapvalidator/js/bootstrapValidator"],
	  toastr:["../../plugins/toastr/toastr.min"],
	  md5:["../../plugins/udf/md5"],
	  layer:["../../plugins/layer/layer"],
	  spin:["../../plugins/ladda-bootstrap/dist/spin.min"],
      ladda:["../../plugins/ladda-bootstrap/dist/ladda"],
      template:["../../plugins/artTemplate/template"]
    },
    shim:{
    	bootstrap: {deps: ["jquery"],exports: 'bootstrap'},
        validate: {deps: ["jquery"],exports: 'validate'},
        toastr: {deps: ["jquery","css!../../plugins/toastr/toastr.min.css"],exports: "toastr"},
        md5: {exports: 'md5'},
        layer:{deps:["jquery"],exports:'layer'},
        ladda:{deps:["spin","css!../../plugins/ladda-bootstrap/dist/ladda-themeless.min.css"],exports:"ladda"},
        template:{exports:"template"}
    },
    map:{
        '*':{
            css:'../../plugins/requirejs/css'
        }
    }
});
require(['jquery','bootstrap']);