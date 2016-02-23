<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"
	href="../static/html/css/libs/CSSRESET.css">
<link rel="stylesheet" type="text/css"
	href="../static/html/css/common.css">
<link rel="stylesheet" type="text/css"
	href="../static/html/css/upload_img.css">
<script src="../static/html/js/libs/jquery-2.1.3.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>
<script src="../static/html/js/uploadPreview.js" type="text/javascript"></script>
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
			if(custName == null || custName.trim() == '') {
				$error.append("请输入本人姓名");
				return;
			}
			if(custMobile == null || custMobile.trim() == '') {
				$error.append("请输入本人电话");
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
						<form method="post" action="<%= basePath %>api/visit/record"
							enctype="multipart/form-data">
							<h4 class="upload">
								<img id="ImgPr" src="../static/html/img/icon_upload.png"
									width="120" height="150" alt="" />
								<p>点击上传安心合集</p>
							</h4>
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