<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar-default navbar-static-side" role="navigation">
    <ul class="nav" id="side-menu">
        <!-- 导航栏头像开始 -->
        <li class="nav-header">
            <!-- 导航栏头像开始 -->
            <!-- 头像栏开始 -->
            <div class="dropdown ">
                <span><img alt="image" class="img-circle" src="${ctxResources }/images/profile_small.jpg" /></span>
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <div class="clear">
                        <span class="text-muted block margin-top"><strong>超级管理员</strong><b class="caret"></b></span>
                    </div>
                </a>
                <ul class="dropdown-menu animated fadeInRight">
                    <li><a href="#">修改密码</a></li>
                    <li><a href="#" class="btnLogout">安全退出</a></li>
                </ul>
            </div>
            <!-- 头像栏开始 -->
            <!-- 缩小后图标开始 -->
            <!-- <div class="logo-element">
                UCS
            </div> -->
            <!-- 缩小后图标结束 -->
        </li>
        <!-- 导航栏头像结束 -->
    </ul>
</nav>