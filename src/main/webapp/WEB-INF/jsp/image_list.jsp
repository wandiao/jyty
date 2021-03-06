<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<li class="righttitle check2"><a href="<%=path %>/image/list">图片作品列表</a></li>
					<li class="righttitle"><a href="<%=path %>/image/add">图片作品管理</a></li>
					<li class="righttitle"><a href="<%=path %>/image/type">图片类别</a></li>
				</ul>
			</div>
	<!--右侧内容-->
		<div class="rightc">
				<form action="" class="biaodan">
					<ul>
						<li class="replace_listtop">
							<div class="replace_listtop1">图片作品名称</div>
							<div class="replace_listtop1">图片作品类别</div>
							<div class="replace_listtop1">图片作品简介</div>
							<div class="replace_listtop1">图片作品项目</div>
							<div class="replace_listtop1">图片作品时间</div>
							<div class="replace_listtop1">操作</div>
						</li>
						<c:forEach items="${images }" var="image">
							<li class="replace_listcontent">
								<div class="replace_listcontent1">${image.name }</div>
								<div class="replace_listcontent1">${image.type_name }</div>
								<div class="replace_listcontent1">${image.summary }</div>
								<div class="replace_listcontent1">${image.project_name }</div>
								<div class="replace_listcontent1"><fmt:formatDate value="${image.complete_time }" pattern="yyyy-MM-dd"/></div>
								<div class="replace_listcontent1"><a href="update/${image.id }">修改</a>/<a href="javascript:;" class="del-btn" data-id="${image.id }">删除</a></div>
							</li>
						</c:forEach>
					</ul>
				</form>
				<!--分页器-->
				
			</div>
			</div>
		</div>
	</div>
	<script>
	var delBtn = $(".del-btn");
	delBtn.click(function() {
		var id = $(this).attr("data-id");
		$.ajax({
			type:'post',
			url:'delete/'+ id + '.do',
			success:function(res) {
				console.log(res)
				alert("删除成功");
				window.location.reload();
			}
		})
	})
	</script>

</body>
</html>