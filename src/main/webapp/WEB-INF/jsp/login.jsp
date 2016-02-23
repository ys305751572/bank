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
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"
	href="static/html/css/libs/CSSRESET.css">
<link rel="stylesheet" type="text/css" href="static/html/css/common.css">
<link rel="stylesheet" type="text/css" href="static/html/css/login.css">
</head>
<body>
	<div class="_container clear">
		<article class="wrapper">
			<div class="main">
				<form method="post" action="admin/login/check">
					<img src="img/icon_login.png" alt="" />
					<c:if test="${!empty error}">
						<h5>用户或密码错误！</h5>
					</c:if>
					<div>
						<label></label><input type="text" name="" placeholder="请输入工号" />
					</div>
					<div>
						<label></label><input type="password" name="" placeholder="请输入密码" />
					</div>
					<input type="submit" value="提交" class="btn_submit" />
				</form>
			</div>
		</article>
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
	</script>
</body>
</html>