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
					<li class="righttitle check2"><a href="<%=path %>/image/add">图片作品管理</a></li>
					<li class="righttitle"><a href="<%=path %>/image/type">图片类别</a></li>
				</ul>
			</div>
			<div class="rightc">
				<form action="" class="biaodan">
					<ul>
						<li class="replace">
							<p class="replacename">图片名称：</p>
							<input type="text" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">图片类别：</p>
							<select class="replacecontent">
								<option value="">电商</option>
								<option value="">移动端</option>
							</select>
						</li>
						<li class="replace" style="overflow: visible;">
							<p class="replacename">图片上传：</p>
							<input type="file" class="replacecontent2" style="text-indent: 0">
						</li>
					</ul>
					<input type="submit" value="上传图片" class="addprogress btn">
				</form>
			</div>
		</div>
	</div>

</body>
</html>