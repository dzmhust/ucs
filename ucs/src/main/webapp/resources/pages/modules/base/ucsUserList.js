define(function(require, exports, module) {
	// 引入js和css区域
	require('layer');
	require('validate_zh');
	require('bootstrap_table_zh');
	require('jdirk');
	require('md5');
	var $ = require('jquery');
	var toastr = require('toastr');
	var Ladda = require('ladda');
	var constant = require('constant');
	var util = require('util');
	// 变量区域
	var searchForm;
	var mainForm;
	var mainGrid;
	var mainEvents;// 主列表操作列
	// 页面初始化部分
	$(function(){
        init();
    });
    /**
     * 系统初始化
     */
    function init(){
        initConfig();
        initAction();
    }
    /**
     * 初始化配置
     */
    function initConfig(){
    	// 初始化当前页面上使用到的dom
    	searchForm = $("#searchForm");
    	// 初始表格事件绑定
    	initMainGridEvents();
    	// 初始化表格
    	initMainGrid();
    }
    /**
     * 初始化主表格的事件绑定
     */
    function initMainGridEvents(){
    	mainEvents = {
    		'click .edit':function(e,value,row,index){
            	edit(row);
        	},
        	'click .remove':function(e,value,row,index){
        		remove(row);
        	}
    	};
    }
    /**
     * 初始化动作绑定
     */
    function initAction(){
    	$('#searchFrom_find').bind('click',function(){find();});
		$('#searchFrom_reset').bind('click',function(){reset();});
		$('#btnAdd').bind('click',function(){add();});
		$('#btnRemoveBatch').bind('click',function(){removeBatch();});
    }
    /**
     * 初始化form配置
     */
    function initFormConfig(layero){
		initMainForm(layero);
		initMainFormAction(layero);
    }
    /**
     * 初始化form
     */
    function initMainForm(layero){
    	mainForm = $('#main-form');
    	mainForm.bootstrapValidator({
			message : '非法值',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields:{
				username:{validators:{notEmpty:{message:'用户名不能为空'},stringLength:{min:2,max:20,message:'用户名长度应在2-20位'}}},
				name:{validators:{notEmpty:{message:'用户实名不能为空'},stringLength:{min:1,max:20,message:'用户实名长度应在1-20位'}}},
				password:{validators:{notEmpty:{message:'密码不能为空'},stringLength:{min:6,max:20,message:'密码长度应在6-20位'}}}
			}
		}).on('success.form.bv',function(e){
			e.preventDefault();
			var $form = $(e.target);
			save($form,layero);
		});
    }
    /**
     * 绑定form中的事件
     */
    function initMainFormAction(layero){
    	// 取消
		$('#btnCancel').bind('click',function(){
			layer.close(layero);
		});   
		// 保存
		$('#btnSave').bind('click',function(){
			$('#main-form').bootstrapValidator('validate');
		})
		// 密码框
		$('#btnPassword').bind('click',function(){
			if ($('#password').attr('type')=='password'){
				$('#password').attr('type','text');
				$('#iEye').removeClass('fa-eye-slash').addClass('fa-eye');
			} else{
				$('#password').attr('type','password');
				$('#iEye').removeClass('fa-eye').addClass('fa-eye-slash');
			}
		})
    }
    // 业务逻辑区域
    /**
     * 查询
     */
    function find(){
		mainGrid.bootstrapTable('refresh',{url:ctx+'/ucsUser/find'});    	
    }
    /**
     * 仅刷新当前页面
     */
    function refresh(){
    	mainGrid.bootstrapTable('refresh');   
    }
    /**
     * 重置
     */
    function reset(){
    	searchForm[0].reset();
    	find();
    }
    /**
     * 新增
     */
    function add(){
    	$.ajax({
    		url:ctx+'/ucsUser/add?t='+Math.random(),
    		type:'get',
    		async:false,
    		success:function(htmlContent){
    			var layero = layer.open({type:1,title:'新增',shadeClose:false,shade:0.8,area:['500px','450px'],content:htmlContent});
    			initFormConfig(layero);
    		}
    	});
    }
    /**
     * 批量删除
     */
    function removeBatch(){
    	var rows = mainGrid.bootstrapTable('getSelections');
    	if ($.array.isNullOrEmpty(rows)){
    		layer.msg('请选择需要删除的数据',{title:'系统提示',icon:0 ,time:1000});
    		return false;
    	}
		var ids = '';
		var isAdmin = false;
		$.each(rows,function(index,row){
			if (row.id == constant.admin){
				isAdmin = true;
				return false;
			} else{
				if (index == 0){
					ids += row.id;	
				} else{
					ids += ',' + row.id;
				}
			}
		})
    	if (isAdmin){
    		layer.alert('超级用户不允许删除，请核对后重新选择',{title:'系统提示',icon:0});
    	} else{
    		layer.confirm('您确定删除这些数据吗？',{title:'系统提示',btn:['确定','取消'],anim:1,icon:3},function(){
				$.ajax({
					type:'post',
					url:ctx+"/ucsUser/removeBatch",
					data:{ids:ids},
					success: function(data){
						if (data.success){
							layer.msg(data.msg, {title:'系统提示',icon: 1,time:1000},function(){
								refresh();
							})
						} else{
							layer.alert(data.msg,{title:'系统提示',icon:2,time:1000});
						}
					}
				});
			})
    	}
    }
    /**
     * 编辑
     */
    function edit(row){
    	$.ajax({
    		url:ctx+'/ucsUser/edit/'+ row.id + '?t=' +Math.random(),
    		type:'get',
    		async:false,
    		success:function(htmlContent){
    			var layero = layer.open({type:1,title:'编辑',shadeClose:false,shade:0.1,area:['500px','400px'],content:htmlContent});
    			initFormConfig(layero);
    		}
    	});
    }
    /**
     * 删除
     */
    function remove(row){
    	if (row.id == constant.admin){
    		layer.alert('超级用户不允许删除',{title:'系统提示',icon:0});
    	} else{
    		layer.confirm('您确定删除该数据吗？',{title:'系统提示',btn:['确定','取消'],anim:1,icon:3},function(){
				$.ajax({
					type:'get',
					url:ctx+"/ucsUser/remove/"+row.id,
					success: function(data){
						if (data.success){
							layer.msg(data.msg, {title:'系统提示',icon: 1,time:1000},function(){
								refresh();
							})
						} else{
							layer.alert(data.msg,{title:'系统提示',icon:2,time:1000});
						}
					}
				});
			})
    	}
    }
    /**
     * 初始化列表
     */
    function initMainGrid(){
    	mainGrid = $('#main-grid').bootstrapTable({
    		sidePagination:'server',cache:false,method:'post',url:ctx+'/ucsUser/find',queryParams:queryParams,contentType: 'application/x-www-form-urlencoded',
    		uniqueId:'id',sortName:'username',height:getMainGridHeight(),
    		pagination:true,pageNumber:1,pageSize:20,pageList:[20,30,50],search:false,
    		toolbar:'#main-grid-tb',singleSelect:false,striped:true,clickToSelect:true,
    		columns:[
    			{checkbox:true},
		        {field:'username',title:'用户帐号',sortable:true,width:100,align: 'center',valign: 'middle'},    
		        {field:'name',title:'用户实名',sortable:true,width:100,align: 'center',valign: 'middle',hide:true},
		        {field:'email',title:'email',sortable:true,width:100,align: 'center',valign: 'middle'},
		        {field:'phone',title:'联系电话',sortable:true,width:100,align: 'center',valign: 'middle',formatter:fmtPhone},
		        {field:'userType',title:'用户类型',sortable:true,width:100,align: 'center',valign: 'middle'},
		        {field:'events',title:'操作',sortable:false,width:100,align: 'center',valign: 'middle',formatter:fmtEvents,events:mainEvents}
    		]
    	});
    	$(window).resize(function () {
            mainGrid.bootstrapTable('resetView', {
                height: getMainGridHeight()
            });
        });
    }
    function fmtPhone(val){
    	return util.fmtMobile(val);
    }
    /**
     * 获取高度
     */
    function getMainGridHeight() {
        return $(window).height() - $('#searchForm').outerHeight(true)-10;
    }
    /**
     * 查询条件
     */
    function queryParams(params){
    	var solidParams = {
	    	page:params.pageNumber,
	    	rows:params.limit,
	    	sort:params.sort,
	    	order:params.order
    	};
    	solidParams = $.extend(solidParams,searchForm.serializeObject());
    	return solidParams;
    }
    /**
     * 格式化列表中的事件
     */
    function fmtEvents(){
    	return mainGridPermissions.join('');
    }
    /**
     * 保存
     */
    function save(form,layero){
		//
    	var process= Ladda.create($('#btnSave')[0]);
		process.start();
		if (!$.isEmptyObject($('password').val())){
			// 密码加密处理
			var md5Pass = hex_md5(hex_md5($("#password").val()));
			$("#password").val(md5Pass);			
		}
		//
		$.ajax({
			url:mainForm.attr('action'),
			type:'post',
			data:form.serializeObject(),
			success:function(resp){
				if (resp.success){
					// 关闭form
					layer.close(layero);
					// 重新查询
					refresh(); 
				} else{
					toastr.error(resp.msg);
				}
			}
		}).always(function(){process.stop();});
    }
    // 输出区域
});
