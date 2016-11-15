<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="container-fluid">
	<form id="main-form" action="${ctx }/ucsUser/${action}" class="form-horizontal margin-top">
		<div>
			<input type="hidden" name="id" value="${ucsUser.id }" />
		</div>
		<div class="form-group">
            <label class="col-xs-3 text-right control-label form-label">用户帐号:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control no-padding" name="username" value="${ucsUser.username }" required />
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 text-right control-label form-label">用户实名:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control no-padding" name="name" value="${ucsUser.name }" required />
            </div>
        </div>
        <c:if test="${action == 'add'}">
        <div class="form-group">
            <label class="col-xs-3 text-right control-label form-label">密码:</label>
            <div class="col-xs-9">
                <div class="input-group">
                	<span class="input-group-btn"><button type="button" class="btn btn-default" id="btnPassword"><i class="fa fa-eye-slash" id="iEye"></i></button></span>
                    <input type="password" class="form-control no-padding" id="password" name="password" value="${ucsUser.password }" autocomplete="off" required />
                </div>
            </div>
        </div>
        </c:if>
        <div class="form-group">
            <label class="col-xs-3 text-right control-label form-label">联系电话:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control no-padding" name="phone" value="${ucsUser.phone }" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 text-right control-label form-label">电子邮箱:</label>
            <div class="col-xs-9">
                <input type="email" class="form-control no-padding" name="email" value="${ucsUser.email }"  />
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 text-right control-label form-label">描述:</label>
            <div class="col-xs-9">
            	<textarea id="description" class="form-control no-padding" name="description" style="width:100%;height:100px;">${ucsUser.description}</textarea>
            </div>
        </div>
        <div class="">
            <div class="btn-group-sm text-center">
                <button class="btn btn-primary" type="button" id="btnSave">保存</button>
                <button class="btn btn-white" type="button" id="btnCancel">取消</button>
            </div>
        </div>
	</form>
</div>