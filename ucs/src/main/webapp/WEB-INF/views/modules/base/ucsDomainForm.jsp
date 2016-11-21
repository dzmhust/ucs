<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="container-fluid">
	<form id="main-form" action="${ctx}/ucsDomain/${action}"
		class="form-horizontal margin-top">
		<div class="form-group">
			<label class="col-xs-3 text-right control-label">系统编号:</label>
			<div class="col-xs-9">
				<input type="text" class="form-control no-padding" id="id" placeholder="保存后不可编辑"
					name="id" value="${ucsDomain.id}" required <c:if test="${action == 'edit'}">readonly="readonly"</c:if>/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 text-right control-label">系统名称:</label>
			<div class="col-xs-9">
				<input type="text" class="form-control no-padding" id="name"
					name="name" value="${ucsDomain.name}" required />
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 text-right control-label">状态:</label>
			<div class="col-xs-9">
				<select class="form-control no-padding" name="status" id="status" data-value="${ucsDomain.status}">
				</select>
			</div>
		</div>
		<div class="form-group spinner">
			<label class="col-xs-3 text-right control-label">排序:</label>
			<div class="col-xs-9 ">
				<input type="number" class="form-control no-padding" id="sort"
					name="sort" value="${ucsDomain.sort}" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 text-right control-label">描述:</label>
			<div class="col-xs-9">
				<textarea id="description" class="form-control no-padding"
					id="description" name="description"
					style="width: 100%; height: 100px;">${ucsDomain.description}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 text-right control-label">AppId:</label>
			<div class="col-xs-9">
				<input type="text" class="form-control no-padding" id="appId"
					name="appId" value="${ucsDomain.appId}" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 text-right control-label">AppKey:</label>
			<div class="col-xs-9">
				<input type="text" class="form-control no-padding" id="appKey"
					name="appKey" value="${ucsDomain.appKey}" />
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