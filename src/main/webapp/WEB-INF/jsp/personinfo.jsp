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
					<li class="righttitle check2"><a href="<%=path %>/myinfo/detail">个人信息</a></li>
					<li class="righttitle"><a href="<%=path %>/myinfo/revise">信息管理</a></li>
				</ul>
			</div>
			<div class="rightc">
				<div class="r_photo"><img src="" alt=""></div>
				<div class="r_info">
					<ul class="r_myinfo">
						<li class="r_myinfo1">
							qq：<span>${user.qq }</span>
						</li>
						<li class="r_myinfo1">
							wchart：<span>${user.weixin }</span>
						</li>
						<li class="r_myinfo1">
							phone：<span>1176033349</span>
						</li>
						<li class="r_myinfo1">
							info：<span>${user.info }</span>
						</li>
						<li class="r_myinfo1">
							progress：<span>${user.progress }</span>
						</li>
						<li class="r_myinfo1">
							dream：<span>${user.dream }</span>
						</li>
					</ul>
				</div>
				<div class="r_xiugai"><a href="revise">修改跟人信息</a></div>
			</div>
		</div>
	</div>

</body>
</html>