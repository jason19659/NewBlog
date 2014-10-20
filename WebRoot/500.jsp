<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="" lang="zh-cn">
<head>
		<title>(1<<9)-12</title>
		<link rel="stylesheet" href="reset.css" type="text/css"/>
		<link rel="stylesheet" href="error.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
	<div class="wrapper">
		<div class="top-nav"> 
			<ul>
				<li><a href="http://192.168.102.42/www/index"><span>42首页<span></a></li>
				<li><a href="http://192.168.102.42/www/publish/ListNews.index.x">新闻社区</a></li>
				<li><a href="http://192.168.102.42/mediacenter/">媒体中心</a></li>
				<li><a href="http://192.168.102.42/www/dengdeng/">瞪 瞪</a></li>
				<li><a href="http://192.168.102.41/42movie/user/userIndex_UserIndex.do">乐 乐</a></li>
				<li><a href="http://192.168.102.41/software/index.42">软件站</a></li>
			</ul>
		</div> 
		
		<div class="content">
			<img class="errorimg" src="500.png"/>
			<div class="errorintro">
			<span>500</span><br/>
			${errMsg}
			<br /><a href="<%=basePath %>">返回</a>
			</div>
				
		</div>
		<div class="footerpush"></div>
	</div>
	<div class="footer">
		<div class="copyright">
			<p>Copyright © 2003 - 2013 42Team. All Rights Reserved</p>
			<p>因为42（是爱）&nbsp;所以精彩 - 42网络技术小组</p>
		</div>
	</div>
</div>
</body>
</html>