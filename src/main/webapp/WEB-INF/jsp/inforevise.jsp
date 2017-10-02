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
					<li class="righttitle">个人信息</li>
					<li class="righttitle check2">信息管理</li>
				</ul>
			</div>
			<div class="rightc">
				<form action="" class="biaodan">
					<ul>
						<li class="replace">
							<p class="replacename">电话：</p>
							<input type="text" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">qq：</p>
							<input type="text" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">微信：</p>
							<input type="num" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">居住地址：</p>
							<input type="text" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">个人简历：</p>
							<textarea class="replacecontent1"></textarea>
						</li>
						<li class="replace">
							<p class="replacename">历程：</p>
							<textarea class="replacecontent1"></textarea>
						</li>
						<li class="replace">
							<p class="replacename">期望与发展：</p>
							<textarea class="replacecontent1"></textarea>
						</li>
					</ul>
					<input type="submit" value="修改" class="btn addprogress">
				</form>
			</div>
		</div>
	</div>

</body>
</html>