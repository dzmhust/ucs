define(function(require, exports, module) {
	require('validate');
	require('md5');
	//
	var $ = require('jquery');
	var toastr = require('toastr');
	var Ladda = require('ladda');
	$(function(){
		init();
	});
	function init(){
		initConfig();
		initAction();
	}
	function initConfig(){
//		Ladda.bind( 'button', { timeout: 2000 } );
		$('#loginForm').bootstrapValidator({
			message : '非法值',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields:{
				username:{validators:{notEmpty:{message:'用户名不能为空'},stringLength:{min:5,max:20,message:'用户名长度应在5-20位'}}},
				password:{validators:{notEmpty:{message:'密码不能为空'},stringLength:{min:6,max:20,message:'密码长度应在6-20位'}}},
				captcha:{validators:{notEmpty:{message:'验证码不能为空'},stringLength:{min:4,max:4,message:'验证码长度不正确'}}}
			}
		}).on('success.form.bv',function(e){
			e.preventDefault();
			var $form = $(e.target);
			doLogin($form);
		});
	}
	function initAction(){
		$('#btnSubmit').on('click',function(e){
			$('#loginForm').bootstrapValidator('validate');
		})
		$('#img_captcha').on('click',function(e){
			document.getElementById("img_captcha").src=ctxResources + "/images/kaptcha.jpg?t=" + Math.random();  
		})
		$("#loginForm input").each(function(){
			$(this).bind('keypress',function(event){
		        if(event.keyCode == "13") {
		        	$('#loginForm').bootstrapValidator('validate');
		        	return false;
		        }
		    });
		});
	}
	function doLogin(form){
		var md5Pass = hex_md5(hex_md5($("#password").val()));
		$("#password").val(md5Pass);
		var process= Ladda.create($('#btnSubmit')[0]);
		process.start();
		$.ajax({
			url:ctx+'/login',
			type:'post',
			data:form.serialize(),
			success:function(resp){
				if (!resp.success){
					toastr.error(resp.msg);
					// 
					form.data('bootstrapValidator').resetForm(true);
					$('#img_captcha')[0].click();
				} else{
					window.location.href = ctx+'/index';
				}
			}
		}).always(function(){process.stop();});
	}
});