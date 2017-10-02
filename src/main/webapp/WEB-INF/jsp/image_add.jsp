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
				<form action="<%=path %>/image/add.do" method="POST" enctype="multipart/form-data" class="biaodan">
					<c:if test="${error_msg != null}">
						<h3>${error_msg }</h3>
					</c:if>
					<c:if test="${msg != null}">
						<h3>${msg }</h3>
					</c:if>
					<ul>
						<li class="replace">
							<p class="replacename">图片名称：</p>
							<input type="text" name="name" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">图片类别：</p>
							<select class="replacecontent" name="type_id">
								<option value="1">电商</option>
								<option value="2">移动端</option>
							</select>
						</li>
						<li class="replace">
							<p class="replacename">项目名称：</p>
							<input type="text" name="project_name" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">项目地址：</p>
							<input type="text" name="project_url" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">图片简介：</p>
							<input type="text" name="summary" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">完成时间：</p>
							<input type="date" name="complete_time" class="replacecontent">
						</li>
						<li class="replace" style="overflow: visible;">
							<p class="replacename">图片上传：</p>
							<input type="file" name="file" class="replacecontent2" style="text-indent: 0">
							<c:if test="${pic_url != null}">
								<img src="${pic_url }" alt="" />
							</c:if>
						</li>
					</ul>
					<input type="submit" value="上传图片" class="addprogress btn">
				</form>
			</div>
		</div>
	</div>

</body>
</html>