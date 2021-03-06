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
					<li class="righttitle"><a href="<%=path %>/project/list">项目列表</a></li>
					<li class="righttitle  check2"><a href="<%=path %>/project/add">添加项目</a></li>
					<li class="righttitle"><a href="<%=path %>/project/type">项目分类</a></li>
				</ul>
			</div>
			<div class="rightc">
				<form action="<%=path %>/project/add.do" method="post" class="biaodan">
					<c:if test="${error_msg != null}">
						<h3>${error_msg }</h3>
					</c:if>
					<c:if test="${msg != null}">
						<h3>${msg }</h3>
					</c:if>
					<ul>
						<li class="replace">
							<p class="replacename">项目名称：</p>
							<input type="text" class="replacecontent" name="title">
						</li>
						<li class="replace">
							<p class="replacename">分类：</p>
							<select style="margin-left:50px;" name="type_id">
								<c:forEach items="${types }" var="type">
									<option value="${type.type_id }">${type.type_name}</option>
								</c:forEach>
							</select>
						</li>
						<li class="replace">
							<p class="replacename">链接地址：</p>
							<input type="text" class="replacecontent" name="url">
						</li>
						<li class="replace">
							<p class="replacename">公司：</p>
							<input type="text" class="replacecontent" name="company">
						</li>
						<li class="replace">
							<p class="replacename">担任职位：</p>
							<input type="text" class="replacecontent" name="position">
						</li>
						<li class="replace">
							<p class="replacename">项目开始时间：</p>
							<input type="date" class="replacecontent" name="project_start_time">
						</li>
						<li class="replace">
							<p class="replacename">项目结束时间：</p>
							<input type="date" class="replacecontent" name="project_end_time">
						</li>
						<li class="replace">
							<p class="replacename">项目简介：</p>
							<textarea class="replacecontent1" name="summary"></textarea>
						</li>
					</ul>
					<input type="submit" value="上传" class="btn addprogress">
				</form>
			</div>
		</div>
	</div>

</body>
</html>