<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="inc/taglibs.jsp"%>
<!doctype html>
<html lang="zh-cn">
<head>
<%@ include file="inc/meta.jsp"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="static/html/css/libs/CSSRESET.css">
<link rel="stylesheet" type="text/css" href="static/html/css/common.css">
<link rel="stylesheet" type="text/css" href="static/html/css/login.css">
</head>
<body>
	<div class="_container clear">
		<article class="wrapper">
			<div class="main">
				<form method="post" action="admin/login/check">
					<img src="static/html/img/icon_login.png" alt="" />
					<c:if test="${ ! empty error }">
						<h5>用户名密码错误</h5>
					</c:if>
					<h5 id="error1"></h5>
					<div>
						<label></label><input type="text" id="username" name="username" placeholder="请输入工号" />
					</div>
					<div>
						<label></label><input type="password" id="password" name="password" placeholder="请输入密码" />
					</div>
					<input type="button" id="formBtn" value="提交" class="btn_submit" />
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
	
		var $formBtn = $("#formBtn");
		$formBtn.on("click", function() {
			var $username = $("#username").val();
			var $password = $("#password").val();
			
			var $error = $("#error1");
			$error.empty();
			if($username == null || $username.trim() == '') {
				$error.append("请输入工号");
				return;
			}
			if($password == null || $password.trim() == '') {
				$error.append("请输入密码");
				return;
			}
			$("form").submit();
		});
	</script>
</body>
</html>