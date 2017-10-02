<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="headtop"><p>任志量的后台管理系统</p><img src="" alt=""></div>
		<!--左侧菜单-->
		<div class="left">
			<div class="lefttop">资料管理</div>
			<ul>
				
					<li class="left1"><a href="<%=path %>/project/list">项目管理</a></li>
				
				
					<li class="left1"><a href="<%=path %>/image/list">图片管理</a></li>
				
				
					<li class="left1"><a href="<%=path %>/article/list">文章管理</a></li>
				
				
					<li class="left1"><a href="<%=path %>/myinfo/personinfo">信息管理</a></li>
				
			</ul>
		</div>
	<script>
		var href=location.href;
		var left = $('.left1');
		if(href.indexOf('project') !== -1) {
			left.eq(0).addClass('check1')
		}
		if(href.indexOf('image') !== -1) {
			left.eq(1).addClass('check1')
		}
		if(href.indexOf('article') !== -1) {
			left.eq(2).addClass('check1')
		}
		if(href.indexOf('myinfo') !== -1) {
			left.eq(3).addClass('check1')
		}
	</script>