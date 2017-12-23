<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<c:set var="webRoot" value="<%=basePath%>" />

<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>博客管理系统</title>
<link rel="stylesheet" type="text/css"
	href="${webRoot}/resources/css/bootstrap.min.css">
<link href="${webRoot}/resources/css/bootstrap-treeview.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${webRoot}/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${webRoot}/resources/css/login.css">
<link rel="apple-touch-icon-precomposed"
	href="${webRoot}/resources/images/icon/icon.png">
<link rel="shortcut icon"
	href="${webRoot}/resources/images/icon/favicon.ico">
<link href="https://cdn.bootcss.com/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<link href="https://cdn.bootcss.com/layer/3.1.0/mobile/need/layer.css"
	rel="stylesheet">
</head>