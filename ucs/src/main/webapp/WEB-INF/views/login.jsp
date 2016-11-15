<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<%@ include file="/WEB-INF/views/include/meta.jsp"%>
	<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
	<%@ include file="/WEB-INF/views/include/common-css.jsp"%>
</head>
<body class="bg-login">
	<div class="container login-header">
		<div class="login-logo">
			<div class="login-logo-zh">XX系统</div>
			<div class="login-logo-en"> XI TONG</div>
		</div>
	</div>
    <div class="middle-box loginscreen bg-white" >
        <div class="login-top"></div>
        <div class="login-title text-center">
        	<h1>用户登录</h1>
        </div>
        <form role="form" class="padding-horizontal " id="loginForm">
            <div class="form-group has-feedback">
                <input type="text" class="form-control text-center" required id="username" name="username" placeholder="请输入用户名"/>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control text-center" required autocomplete="off" id="password" name="password" placeholder="请输入密   码"/>
            </div>
            <div class="form-group has-feedback row ">
                <div class="col-sm-6">
                    <input type="text" class="form-control text-center" id="captcha" name="captcha" placeholder="验证码" autocomplete="off">
                </div>
                <div class="col-sm-6">
                    <img alt="验证码" class="img-responsive" src="${ctx}/resources/images/kaptcha.jpg" title="点击更换" id="img_captcha" style="height:34px;" />
                </div>
            </div>
            <div class="padding-bottom">
                <button type="button" class="btn btn-primary full-width ladda-button" data-style="expand-left" data-size="1" id="btnSubmit"><span class="ladda-label">登录</span></button>
            </div>
        </form>
    </div>
    <%@ include file="/WEB-INF/views/include/common-js.jsp"%>
	<!-- 加载js文件 -->
	<script>
	require(['login']);
	</script>
</body>
</html>
