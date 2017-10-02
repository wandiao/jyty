<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="<%=path %>/static/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/static/css/pagination.css">
<script src="<%=path %>/static/js/jquery.min.js"></script>
<script src="<%=path %>/static/js/jquery.pagination.js"></script>
<script src="<%=path %>/static/js/ueditor.config.js"></script>
<script src="<%=path %>/static/js/ueditor.all.min.js"></script>