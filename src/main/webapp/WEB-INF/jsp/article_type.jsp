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
					<li class="righttitle">文章管理</li>
					<li class="righttitle">文章列表</li>
					<li class="righttitle check2">文章分类</li>
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
						<option value="app">个人</option>
						<option value="电商">关于</option>
					</select>
					</div>

					<ul>
						<li class="replace_listtop">
							<div class="replace_listtop1">图片作品名称</div>
							<div class="replace_listtop1">图片作品类别</div>
							<div class="replace_listtop1">图片作品简介</div>
							<div class="replace_listtop1">图片作品项目</div>
							<div class="replace_listtop1">图片作品时间</div>
							<div class="replace_listtop1">操作</div>
						</li>

						<li class="replace_listcontent">
							<div class="replace_listcontent1">app</div>
							<div class="replace_listcontent1">app</div>
							<div class="replace_listcontent1">图片作品简介</div>
							<div class="replace_listcontent1">图片作品项目</div>
							<div class="replace_listcontent1">图片作品时间</div>
							<div class="replace_listcontent1"><a href="">修改</a></div>
						</li>
						<li class="replace_listcontent">
							<div class="replace_listcontent1">app</div>
							<div class="replace_listcontent1">app</div>
							<div class="replace_listcontent1">图片作品简介</div>
							<div class="replace_listcontent1">图片作品项目</div>
							<div class="replace_listcontent1">图片作品时间</div>
							<div class="replace_listcontent1"><a href="">修改</a></div>
						</li>
					</ul>
				</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>