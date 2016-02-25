<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="inc/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//    String basePath = request.getScheme()+"://"+"weixin.binf.me"+path+"/";
%>


<!doctype html>
<html ang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui" />
<title>太平健康季 让爱无缺口</title>
<link rel="stylesheet" type="text/css" href="../../static/html/css/libs/CSSRESET.css">
<link rel="stylesheet" type="text/css" href="../../static/html/css/common.css">
<link rel="stylesheet" type="text/css" href="../../static/html/css/upload_img.css">
<script src="../../static/html/js/libs/jquery-2.1.3.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>
<script src="../../static/html/js/uploadPreview.js" type="text/javascript"></script>
<script>
	$(function() {
		//点击上传图片，弹出文件选择对话框
		$(".upload").on("click", function() {
			$("input[type=file]").click();
		});

		$(function() {
			$("#file1").uploadPreview({
				Img : "ImgPr",
				Width : 252,
				Height : 161
			});
		});
		
		$formBtn = $("#doBtn");
		$formBtn.on("click",function() {
			var image = $("#file1").val();
			var wnumber = $("#wnumber").val();
			var custName = $("#custName").val();
			var custMobile = $("#custMobile").val();
			
			var $error = $("#error");
			 $error.empty();
			 if(image == null || image.trim() == '') {
					$error.append("请上传图片");
					return;
				}
			if(wnumber == null || wnumber.trim() == '') {
				$error.append("请输入见证人工号");
				return;
			}
			if(wnumber.length < 8 || wnumber.length > 11) {
				$error.append("工号为8-11位数字");
				return;
			}
			if(!/^[0-9]*$/.test(wnumber)) {
				$error.append("工号为8-11位数字");
				return;
			}
			
			if(custName == null || custName.trim() == '') {
				$error.append("请输入本人姓名");
				return;
			}
			if(custMobile == null || custMobile.trim() == '') {
				$error.append("请输入本人电话");
				return;
			}
			if(custMobile.length != 11) {
				$error.append("电话为11位数字");
				return;
			}
			if(!/^[0-9]*$/.test(wnumber)) {
				$error.append("电话为11位数字");
				return;
			}
			
			$("form").submit();
		})
	})
</script>
</head>
<body>
	<div class="_container clear">
		<article class="wrapper">
			<div class="_container clear">
				<article class="wrapper">
					<div class="main">
						<form method="post" action="<%= basePath %>admin/visit/record"
							enctype="multipart/form-data">
							<header class="header">
								<h1>太平健康季 让爱无缺口</h1>
							</header>
							<h4 class="upload">
								<img id="ImgPr" src="../../static/html/img/icon_upload.png"
									width="120" height="150" alt="" />
								<p>点击上传安心合集</p>
							</h4>
							<c:if test="${! empty error and error eq 'error1'}">
								<h5>已访问过该客户</h5>
							</c:if>
							<c:if test="${! empty error and error eq 'error2'}">
								<h5>客户不存在</h5>
							</c:if>
							<h5 id="error"></h5>
							<div>
								<label></label><input type="text" name="wnumber" id="wnumber"
									placeholder="请输入见证人工号" />
							</div>
							<div>
								<label></label><input type="text" name="custName" id="custName"
									placeholder="请输入本人姓名" />
							</div>
							<div>
								<label></label><input type="text" name="custMobile"
									id="custMobile" placeholder="请输入本人电话" />
							</div>
							<input type="file" id="file1" name="file1" /> 
							<input id="doBtn" type="button" value="点击提交" class="btn_submit" />
						</form>
					</div>
				</article>
			</div>
		</article>
	</div>
</body>
</html>