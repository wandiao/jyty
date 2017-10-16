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
					<li class="righttitle"><a href="<%=path %>/project/list">项目列表</a></li>
					<li class="righttitle"><a href="<%=path %>/project/add">添加项目</a></li>
					<li class="righttitle check2"><a href="<%=path %>/project/type">项目分类</a></li>
				</ul>
			</div>
			<div class="rightc">
			<form action="type/add.do" method="post" class="biaodan">
				<div class="r_type">
					<div class="r_type_top">
							<p>新增分类</p>
						<input type="text" name="type_name" placeholder="新增类别">
						<input type="submit" value="确定">
					</div>

					<ul>
						<li class="replace_listtop">
							<div class="replace_listtop1">分类名称</div>
							<div class="replace_listtop1">操作</div>
						</li>
						<c:forEach items="${types }" var="type">
							<li class="replace_listcontent">
								<div class="replace_listcontent1">${type.type_name }</div>
								<div class="replace_listcontent1"><a>修改</a>/<a href="javascript:;" class="del-btn" data-id="${type.type_id }">删除</a></div>
							</li>
						</c:forEach>
					</ul>
				</form>
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
			url:'type/delete/'+ id + '.do',
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