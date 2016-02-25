<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="inc/taglibs.jsp"%>
<!doctype html>
<html lang="zh-cn">
<head>
<%@ include file="inc/meta.jsp"%>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui" />
<title>客户明细</title>
<link rel="stylesheet" type="text/css"
	href="static/html/css/libs/CSSRESET.css">
<link rel="stylesheet" type="text/css" href="static/html/css/common.css">
<link rel="stylesheet" type="text/css"
	href="static/html/css/customer_detail.css">
</head>
<body>
	<div class="_container clear">
		<header class="header">
			<h1>客户明细</h1>
			<a href="javascript:void(0)" onclick="goBack();">返回</a>
		</header>
		<!-- header End -->

		<article class="wrapper">
			<div class="main">
				<div class="sort clear">
					<a href="javascript:void(0)" onclick="sort1();" sort="${map.sortBe }" id="sortBe">保额排序</a>
					<a href="javascript:void(0)" onclick="sort2();" sort="${map.sortName }" id="sortName">姓氏排序</a>
				</div>

				<ul class="ul_detail">
					<c:forEach items="${list}" var="cust" varStatus="status">
						<li onclick="doDetail('${cust.customerId}','${cust.customerName }','${cust.isJoin}')"><i>${status.index + 1}</i>
							<h5>${cust.customerName }</h5>
							<p>
								保额：<strong>${cust.allBf }</strong>
							</p> <c:if test="${cust.isJoin}">
								<span> 已参加 </span>
							</c:if>
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
	<!-- jQuery Version 1.11.0 -->
	<script src="static/js/jquery-1.11.0.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="static/js/bootstrap.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="static/js/plugins/metisMenu/metisMenu.min.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="static/js/sb-admin-2.js"></script>
	<script type="text/javascript">
		function sort1() {
			var sort = $("#sortBe").attr("sort");
			window.location.href = "visit/customerDetail?property=be&sort=" + sort;
		}

		function sort2() {
			var sort = $("#sortName").attr("sort");
			window.location.href = "visit/customerDetail?property=name&sort=" + sort;
		}
		
		function doDetail(custId,custName,isJoin) {
			window.location.href = "visit/bddetail?custId=" + custId + "&custName=" + custName + "&isJoin=" + isJoin;
		}
		
		function toUnfinishedPage() {
			window.location.href = "visit/toUnfinishedPage";
		}
		
		function toCustomPage() {
			window.location.href = "visit/customerDetail";
		}
		
		function goBack() {
			window.location.href = "admin/dashboard";
		}
	</script>

</body>
</html>