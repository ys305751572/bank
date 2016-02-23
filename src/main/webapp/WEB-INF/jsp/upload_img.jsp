<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="inc/taglibs.jsp"%>
<!doctype html>
<html ang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"
	href="static/html/css/libs/CSSRESET.css">
<link rel="stylesheet" type="text/css" href="static/html/css/common.css">
<link rel="stylesheet" type="text/css"
	href="static/html/css/upload_img.css">
<script src="static/html/js/libs/jquery-2.1.3.min.js"></script>
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
	})
</script>
</head>
<body>
	<div class="_container clear">
		<article class="wrapper">
			<div class="_container clear">
				<article class="wrapper">
					<div class="main">
						<form method="post" action="api/visit/record" enctype="multipart/form-data">
							<h4 class="upload">
								<img id="ImgPr" src="static/html/img/icon_upload.png" width="120" height="150" alt="" />
								<p>点击上传安心合集</p>
							</h4>
							<h5>请输入工号！</h5>
							<div>
								<label></label><input type="text" name="" placeholder="请输入见证人工号" />
							</div>
							<div>
								<label></label><input type="text" name="" placeholder="请输入本人姓名" />
							</div>
							<div>
								<label></label><input type="text" name="" placeholder="请输入本人电话" />
							</div>
							<input type="file" id="file1" name="" /> 
							<input type="submit" value="点击提交" class="btn_submit" />
						</form>
					</div>
				</article>
			</div>
		</article>
	</div>
</body>
</html>