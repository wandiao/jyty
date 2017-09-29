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
	<h1>登录</h1>
	<form>
		<div>
			<input id="username" type="text" name="username" />
		</div>
		<div>
			<input id="password" type="text" name="password" />
		</div>
		<div>
			<button onclick="login()" type="button">登录</button>
		</div>
	</form>
	<script>
		function check() {
			var username = $('#username').val();
			var password = $('#password').val();
			if(!username) {
				alert('用户名不能为空');
				return false;
			}
			if(!password) {
				alert('密码不能为空');
				return false;
			}
			return true;
		}
		function login() {
			var username = $('#username').val();
			var password = $('#password').val();
			if(!check()) {
				return false;
			}
			$.ajax({
				type:'post',
				url:"<%=path%>/toLogin",
				data: {
					username:username,
					password:password
				},
				dataType:'json',
				success:function(res) {
					if(res.succeed) {
						location.href = '<%=path%>/project/list';
					}else {
						alert(res.message);
					}
				}
			})
		}
	</script>
</body>
</html>