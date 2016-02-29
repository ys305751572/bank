<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="inc/taglibs.jsp"%>
<!doctype html>
<html lang="zh-cn">
<head>
<%@ include file="inc/meta.jsp"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui" />   
<title>太平健康季 让爱无缺口</title>
<link rel="stylesheet" type="text/css" href="static/html/css/libs/CSSRESET.css">
<link rel="stylesheet" type="text/css" href="static/html/css/common.css">
<link rel="stylesheet" type="text/css" href="static/html/css/health_walk.css">
</head>
<body>
	<div class="_container clear">
    	<header class="header">
			<h1>太平健康季 让爱无缺口</h1>
		</header>
		<!-- header End -->
        
		<article class="wrapper">
			<div class="main">	
            	<div class="div_location"></div>
				<ul class="ul_list">
                	<li><span></span><p>至今共为<em>${vo.allCustomCount}</em>位客户</p></li>
                    <li><span></span><p>送去了<em>${vo.allMoney }</em>万的保险保障</br>为他们生活增添了祥和与安宁</p></li>
                    <li><span></span><p>全省累计回访<em>${vo.proviceCustomCount }</em>位客户</p></li>
                    <li><span></span><p>今日回访<em>${vo.todayCount }</em>位客户</p></li>
                </ul>
			</div>
		</article>
		<!-- wrapper End -->
		
		<footer class="footer">
			<ul class="ul_menu">
				<li class="active"><a href="javascript:void(0)" onclick="toUnfinishedPage();">件数榜</a></li>
				<li><a href="javascript:void(0)" onclick="toUnfinishedPage();">保额榜</a></li>
                <li><a href="javascript:void(0)" onclick="toCustomPage();">个人明细</a></li>
			</ul>
		</footer>
		<!-- footer End -->
	</div>
	<script type="text/javascript">
		function toUnfinishedPage() {
			window.location.href = "visit/toUnfinishedPage";
		}
		
		function toCustomPage() {
			window.location.href = "visit/customerDetail";
		}
	</script>
</body>
</html>