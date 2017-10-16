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
					<li class="righttitle  check2"><a href="<%=path %>/project/list">项目列表</a></li>
					<li class="righttitle"><a href="<%=path %>/project/add">添加项目</a></li>
					<li class="righttitle"><a href="<%=path %>/project/type">项目分类</a></li>
				</ul>
			</div>
			<div class="rightc">
				<form action="" class="biaodan">
					<ul>
						<li class="replace_listtop">
							<div class="replace_listtop1">项目名称</div>
							<div class="replace_listtop1">项目类别</div>
							<div class="replace_listtop1">项目简介</div>
							<div class="replace_listtop1">项目负责</div>
							<div class="replace_listtop1">项目时间</div>
							<div class="replace_listtop1">操作</div>
						</li>
						<c:forEach items="${projects }" var="item">
							<li class="replace_listcontent">
								<div class="replace_listcontent1">${item.title }</div>
								<div class="replace_listcontent1">${item.type_name }</div>
								<div class="replace_listcontent1">${item.summary }</div>
								<div class="replace_listcontent1">${item.position }</div>
								<div class="replace_listcontent1"><fmt:formatDate value="${item.project_start_time }" pattern="yyyy-MM-dd"/></div>
								<div class="replace_listcontent1"><a href="update/${item.id }">修改</a>/<a class="del-btn" href="javascript:;" data-id="${item.id }">删除</a></div>
							</li>
						</c:forEach>
					</ul>
				</form>
				<!--<div class="now"></div>-->
				<div class="M-box"></div>
				<script>
				$('.M-box').pagination({
					pageCount:"${total}",
					current:"${current}",
					showData:"${pageSize}"
				});
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
				
			</div>
		</div>
	</div>

</body>
</html>