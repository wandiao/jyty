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
		<div class="right">
			<div class="righttop">
				<ul>
					<li class="righttitle"><a href="<%=path %>/image/list">图片作品列表</a></li>
					<li class="righttitle"><a href="<%=path %>/image/add">图片作品管理</a></li>
					<li class="righttitle check2"><a href="<%=path %>/image/type">图片类别</a></li>
				</ul>
			</div>
			<div class="rightc">
			<form action="" class="biaodan">
				<div class="r_type">
					<div class="r_type_top">
							<p>新增分类</p>
						<input type="text" value="新增类别">
						<input type="button" value="确定">
						<select>
						<option value="app">app</option>
						<option value="电商">电商</option>
					</select>
					</div>

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
	</div>

</body>
</html>