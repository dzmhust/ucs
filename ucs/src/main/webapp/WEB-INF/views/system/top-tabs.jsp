<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row content-tabs">
	<button class="roll-nav roll-left tab-left"><i class="fa fa-backward"></i></button>
	<nav class="page-tabs menu-tabs">
		<div class="page-tabs-content">
        </div>
	</nav>
	<button class="roll-nav roll-right tab-right"><i class="fa fa-forward"></i></button>	
	<div class="btn-group roll-nav roll-right">
		<button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span></button>
           <ul role="menu" class="dropdown-menu dropdown-menu-right">
               <li class="closeAllTabs"><a>关闭全部选项卡</a></li>
               <li class="closeOtherTabs"><a>关闭其他选项卡</a></li>
           </ul>
	</div>
	<a href="login.html" class="roll-nav roll-right tab-exit btnLogout"><i class="fa fa-sign-out"></i> 退出</a>
</div>