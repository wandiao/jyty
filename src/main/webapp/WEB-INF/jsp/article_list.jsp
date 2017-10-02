<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人后台文章管理</title>
	<%@ include file="include/head.jsp"%>
</head>
<body>
	<div id="article">
		<%@ include file="include/sidebar.jsp"%>
		<!--右侧修改内容-->
		<div class="right">
			<div class="righttop">
				<ul>
					<li class="righttitle check2"><a href="<%=path %>/article/list">文章列表</a></li>
					<li class="righttitle"><a href="<%=path %>/article/add">添加文章</a></li>
					<li class="righttitle"><a href="<%=path %>/article/type">文章类别</a></li>
				</ul>
			</div>
			<div class="rightc">
				<form action="" class="biaodan">
					<ul>
						<li class="replace_listtop">
							<div class="replace_listtop2">文章名称</div>
							<div class="replace_listtop2">文章类别</div>
							<div class="replace_listtop2">文章简介</div>
							<div class="replace_listtop2">文章时间</div>
							<div class="replace_listtop2">操作</div>
						</li>

						<li class="replace_listcontent">
							<div class="replace_listcontent2">关于css3伪类</div>
							<div class="replace_listcontent2">app</div>
							<div class="replace_listcontent2">文章简介</div>
							<div class="replace_listcontent2">文章时间</div>
							<div class="replace_listcontent2">修改</div>
						</li>
					</ul>
					
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>