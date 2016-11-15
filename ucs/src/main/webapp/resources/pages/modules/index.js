define(function(require, exports, module) {
	// 引入js和css区域
	require('metisMenu');
    require('slimscroll');
    require('layer');
    var maintabs = require('maintabs');
    var $ = require('jquery');
    var template = require('template');
    // 页面初始化部分
    $(function(){
        init();
    });
    function init(){
        getMenus();
        initConfig();
        initAction();
    }
    function initConfig(){
        // 菜单配置
        $('#side-menu').metisMenu();
    }
    function initAction(){
    	// 退出
    	$('.btnLogout').bind('click',function(e){
    		layer.confirm('您确定退出系统吗？',{title:'系统提示',btn:['确定','取消'],anim:1,icon:0},function(){
    			window.onbeforeunload = null;
                location.href= ctx+ '/logout';
    		})
    	})
    	// 菜单事件
    	$('.menu-item').bind('click',function(e){
    		var id = $(this).data('id');
    		var title = $(this).text();
    		var url = $(this).data('url');
    		maintabs.addTab(url,title,id);
    	})
    }
    // 业务逻辑区域
    /**
     * 获取菜单
     */
    function getMenus(){
    	$.ajax({
    		async:false,
    		type:'get',
    		url:ctx+"/ucsPermission/getMenus",
    		success: function(data){
    			var menus={data:data};
    			var html = template('menuScript',menus);
    	        $('#side-menu').append(html);
    		}
    	});
    }
});