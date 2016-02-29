<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="inc/taglibs.jsp"%>
<!doctype html>
<html lang="zh-cn">
<head>
<%@ include file="inc/meta.jsp"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui" />   
<title>保单明细</title>
<link rel="stylesheet" type="text/css" href="static/html/css/libs/CSSRESET.css">
<link rel="stylesheet" type="text/css" href="static/html/css/common.css">
<link rel="stylesheet" type="text/css" href="static/html/css/policy_detail.css">
</head>
<body>
	<div class="_container clear">
    	<header class="header">
			<h1>保单明细</h1>
		</header>
		<!-- header End -->
        
		<article class="wrapper">
			<div class="main">	
				<div class="profile">
     				<div>1</div>
                	<img src="static/html/img/icon_profile.png" alt="" />
                    <p>${map.custName }</p>
                    <c:if test="${map.isJoin}">
						<span> 已参加 </span>
					</c:if>
                </div>
                <ul class="ul_policy">
                	<c:forEach items="${list }" var="cust">
                		<li>
	                    	<div></div>
	                        <div>
	                        	<p><span>被保人：<em>${cust.beInsuranceName }</em></span><span>缴费年限：<em>${cust.limit }年</em></span></p>
	                            <p><span>保 &nbsp; 额：<em>${cust.be }</em></span><span>购买年份：<em>${cust.year }</em></span></p>
	                        </div>
	                    </li>
                	</c:forEach>
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