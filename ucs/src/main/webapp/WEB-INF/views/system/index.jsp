<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<%@ include file="/WEB-INF/views/include/meta.jsp"%>
	<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
	<%@ include file="/WEB-INF/views/include/common-css.jsp"%>
</head>
<body class="bg-gray full-height-layout fixed-sidebar animated fadeInUp" style="overflow: hidden">
	<div id="wrapper">
        <!-- 左侧导航栏开始 -->
        <%@ include file="/WEB-INF/views/system/left-nav.jsp"%>
        <!-- 左侧导航栏结束 -->
        <!-- 右侧区域开始 -->
        <div id="page-wrapper" class="bg-gray">
            <!-- 右侧顶部导航开始 -->
            <!-- 右侧顶部导航结束 -->
            <!-- 页签栏开始 -->
            <%@ include file="/WEB-INF/views/system/top-tabs.jsp"%>
            <!-- 页签栏结束 -->
            <!-- 右侧内容开始 -->
            <div class="row main-content" id="content-main">
            </div>
            <!-- 右侧内容结束 -->
            <!-- footer开始 -->
            <footer>
            	<div class="pull-right">&copy; 2016-2017 <a href="#" target="_blank">dzm</a></div>
            </footer>
            <!-- footer结束 -->
        </div>
        <!-- 右侧区域结束 -->
    </div>
    <%@ include file="/WEB-INF/views/include/common-js.jsp"%>
    <script id="menuScript" type="text/html">
    {{each data as p_permission}}
    {{if (p_permission.pid === '')}}
    <li>
        <a href="#">
            <i class="fa {{p_permission.icon}}"></i>
            <span class="nav-label">{{p_permission.name}}</span>
            <span class="fa arrow"></span>
        </a>
        <ul class="nav nav-second-level">
            {{each data as c_permission}}
            {{if (c_permission.pid==p_permission.id)}}
            <li>
                <a class="menu-item" data-url="{{c_permission.url}}" data-id="{{c_permission.id}}">{{c_permission.name}}</a>
            </li>
            {{/if}}
            {{/each}}
        </ul>
    </li>
    {{/if}}
    {{/each}}
	</script>
	<!-- 加载js文件 -->
	<script>
	require(['index']);
	</script>
</body>


</html>