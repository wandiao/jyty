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
					<li class="righttitle"><a href="<%=path %>/myinfo/detail">个人信息</a></li>
					<li class="righttitle check2"><a href="<%=path %>/myinfo/revise">信息管理</a></li>
				</ul>
			</div>
			<div class="rightc">
				<form action="revise.do" class="biaodan" method="post">
					<c:if test="${msg != null}">
						<h3>${msg}</h3>
					</c:if>
					<ul>
						<li class="replace">
							<p class="replacename">qq：</p>
							<input value="${user.qq }" type="text" name="qq"  class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">微信：</p>
							<input value="${user.weixin }" type="text" name="weixin" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">居住地址：</p>
							<input value="${user.address }" type="text" name="address" class="replacecontent">
						</li>
						<li class="replace">
							<p class="replacename">个人简历：</p>
							<textarea name="info" class="replacecontent1">${user.info }</textarea>
						</li>
						<li class="replace">
							<p class="replacename">历程：</p>
							<textarea name="progress" class="replacecontent1">${user.progress }</textarea>
						</li>
						<li class="replace">
							<p class="replacename">期望与发展：</p>
							<textarea name="dream" class="replacecontent1">${user.dream }</textarea>
						</li>
					</ul>
					<input type="submit" value="修改" class="btn addprogress">
				</form>
			</div>
		</div>
	</div>

</body>
</html>