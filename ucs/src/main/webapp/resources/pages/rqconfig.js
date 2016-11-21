requirejs.config({
	baseUrl:ctxResources+'/pages/modules',
//	urlArgs: "v=" +  (new Date()).getTime(),//禁止缓存，生产环境去除
	urlArgs:'v=2016112101',
    paths:{
      jquery:["../../plugins/jquery/jquery"],
      jdirk:["../../plugins/jquery/jquery.jdirk.min"],
      bootstrap:["../../plugins/bootstrap/dist/js/bootstrap.min"],
	  validate:["../../plugins/bootstrapvalidator/js/bootstrapValidator"],
	  validate_zh:['../../plugins/bootstrapvalidator/js/language/zh_CN'],
	  toastr:["../../plugins/toastr/toastr.min"],
	  md5:["../../plugins/udf/md5"],
	  layer:["../../plugins/layer/layer"],
	  spin:["../../plugins/ladda-bootstrap/dist/spin.min"],
      ladda:["../../plugins/ladda-bootstrap/dist/ladda"],
      template:["../../plugins/artTemplate/template"],
      metisMenu:["../../plugins/metisMenu/jquery.metisMenu"],
      slimscroll:["../../plugins/slimscroll/jquery.slimscroll.min"],
      bootstrap_table:["../../plugins/bootstrap-table/dist/bootstrap-table"],
      bootstrap_table_zh:["../../plugins/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min"],
      constant:["../../plugins/udf/constant"],
      touchspin:["../../plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.min"],
      util:["../../plugins/udf/util"],
      chosen:["../../plugins/chosen/chosen.jquery.min"]
    },
    shim:{
    	jdirk:{deps: ["jquery"],exports: 'jdirk'},
    	bootstrap: {deps: ["jquery"],exports: 'bootstrap'},
        validate: {deps: ["jquery"],exports: 'validate'},
        validate_zh:{deps: ["jquery","validate"],exports: 'validate_zh'},
        toastr: {deps: ["jquery","css!../../plugins/toastr/toastr.min.css"],exports: "toastr"},
        md5: {exports: 'md5'},
        layer:{deps:["jquery","css!./../../plugins/layer/skin/layer.css"],exports:'layer'},
        ladda:{deps:["spin","css!../../plugins/ladda-bootstrap/dist/ladda-themeless.min.css"],exports:"ladda"},
        template:{exports:"template"},
        metisMenu:{deps:["jquery"],exports:'metisMenu'},
        slimscroll:{deps:["jquery"],exports:"slimscroll"},
        bootstrap_table:{deps:["jquery"],exports:"bootstrap_table"},
        bootstrap_table_zh:{deps:["jquery","bootstrap_table","css!../../plugins/bootstrap-table/dist/bootstrap-table.min.css"],exports:"bootstrap_table_zh"},
        touchspin:{deps:["jquery","css!./../../plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.min.css"]},
        chosen:{deps:["jquery","css!./../../plugins/chosen/chosen.min.css"]}
    },
    map:{
        '*':{
            css:'../../plugins/requirejs/css'
        }
    }
});
require(['jquery','bootstrap']);