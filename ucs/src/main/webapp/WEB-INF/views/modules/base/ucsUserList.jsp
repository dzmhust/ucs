<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<%@ include file="/WEB-INF/views/include/meta.jsp"%>
	<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
	<%@ include file="/WEB-INF/views/include/common-css.jsp"%>
</head>
<body class="animated fadeInUp">
	<form id="searchForm" role="form">
		<div class="row">
			<div class="form-group col col-sm-3 col-xs-3 padding no-margin-bottom">
				<label class="col col-sm-4 col-xs-6 text-right form-label no-padding-left">用户帐号:</label>
				<div class="col col-sm-8 col-xs-6 no-padding-left">
                    <input type="text" class="form-control no-padding" name="filter_likes_username" />
                </div>
			</div>
			<div class="form-group col col-sm-3 col-xs-3 padding no-margin-bottom">
				<label class="col col-sm-4 col-xs-6 text-right form-label no-padding-left">用户实名:</label>
				<div class="col col-sm-8 col-xs-6 no-padding-left">
                    <input type="text" class="form-control no-padding" name="filter_likes_name" />
                </div>
			</div>
			<shiro:hasPermission name="ucsUser:find">
			<div class="col col-sm-offset-10 col-xs-offset-8 padding">
                <label><a href="#" id="searchFrom_find" class="btn btn-primary"><i class="fa fa-search"></i> 搜索</a></label>
                <label><a href="#" id="searchFrom_reset" class="btn btn-primary"><i class="fa fa-refresh"></i> 重置</a></label>
            </div>
            </shiro:hasPermission>
		</div>
	</form>
	<div id="main-grid-tb">
		<shiro:hasPermission name="ucsUser:add">
		<button type="button" class="btn btn-primary margin-left" id="btnAdd">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        </shiro:hasPermission>
		<shiro:hasPermission name="ucsUser:remove">
		<button type="button" class="btn btn-default margin-left" id="btnRemoveBatch">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
        </shiro:hasPermission>
	</div>
	<table id="main-grid" data-toggle="main-grid">
	</table>
	<%@ include file="/WEB-INF/views/include/common-js.jsp"%>
	<script>
	require(['base/ucsUserList']);
	// 列表权限
	window.mainGridPermissions = [
		'<shiro:hasPermission name="ucsUser:edit"><a class="edit btn btn-primary" href="javascript:void(0)" title="编辑"><i class="glyphicon glyphicon-edit"></i>编辑</a></shiro:hasPermission>',
		'<shiro:hasPermission name="ucsUser:remove"><a class="remove btn btn-danger" href="javascript:void(0)" title="删除"><i class="glyphicon glyphicon-remove"></i>删除</a></shiro:hasPermission>'
	]
	</script>
</body>
</html>