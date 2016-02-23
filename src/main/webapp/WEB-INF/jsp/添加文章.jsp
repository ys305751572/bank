<%--
  Created by IntelliJ IDEA.
  User: wangbin
  Date: 2015/8/17
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%@ include file="inc/meta.jsp" %>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>添加文章</title>
    <%@ include file="inc/css.jsp" %>
    <link href="static/js/plugins/bootstrap-fileinput/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
    <script src="static/js/plugins/bootstrap-fileinput/js/fileinput.js" type="text/javascript"></script>
    <script src="static/js/plugins/bootstrap-fileinput/js/fileinput_locale_zh.js" type="text/javascript"></script>
    <link href="static/js/plugins/dropper/jquery.fs.dropper.css" rel="stylesheet">
    <script src="static/js/plugins/dropper/jquery.fs.dropper.js"></script>

</head>
<style>
    .kv-file-upload{display: none;}
    .fileinput-upload-button {display: none;}
</style>
<body>

<div id="posts" class="wrapper">

    <%@ include file="inc/nav.jsp" %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">添加文章</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form id="postForm" method="post" enctype="multipart/form-data" action="admin/post/save" class="form-horizontal" role="form">
                            <input type="hidden" id="id" name="id" value="${post.id}">

                            <div class="form-group">
                                <label  class="col-sm-2 control-label">文章名称:</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="name" name="name" maxlength="20"
                                           data-rule="required" value="${post.name}" placeholder="请输入文章名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">文章编码:</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="code" name="code" maxlength="20"
                                           data-rule="required" value="${post.code}" placeholder="请输入文章编码">
                                </div>
                            </div>
                            <div class="form-group img_tooltip" >
                                <label for="imageId" class="col-sm-2 control-label">缩略图:</label>

                                <div class="col-sm-3">
                                    <input type="hidden" id="imageId" name="imageId" value="${post.image.id}">


                                    <div class="image_show"  <c:if test="${post.image==null}"> style="display: none"  </c:if>>
                                        <img src="${post.image.path}" class='img-responsive' >
                                    </div>
                                    <div class="image_handle"  <c:if test="${post.image!=null}">  style="display: none"  </c:if>data-toggle="tooltip" data-placement="top" title="" data-original-title="建议上传宽480px高320px的图片">
                                        <div class="dropped"></div>
                                    </div>
                                </div>
                                <div class="col-sm-5">
                                    <a href="javascript:void(0)" id="removeImg" class="btn btn-info" role="button" >删除图片</a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name" class="col-sm-2 control-label">文章地址:</label>
                                <div class="col-sm-3">
                                    <select class="form-control" name="postArea.id" data-rule="required">
                                        <c:forEach items="${postAreaList}" var="postArea">
                                            <option value="${postArea.id}" <c:if test="${post.postArea.id == postArea.id}">selected</c:if> >${postArea.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name" class="col-sm-2 control-label">文章类型:</label>
                                <div class="col-sm-3">
                                    <select class="form-control" name="postType.id" data-rule="required">
                                        <c:forEach items="${postTypeList}" var="postType">
                                            <option value="${postType.id}">${postType.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">品牌:</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="brand" name="brand" maxlength="20"
                                           data-rule="required" value="${post.brand}" placeholder="请输入文章名称">
                                </div>
                            </div>

                            <div class="form-group  has-feedback">
                                <label  class="col-sm-2 control-label">字数:</label>
                                <div class="col-sm-3">
                                    <input type="text" value="${post.marketPrice}" class="form-control" id="marketPrice" name="marketPrice" maxlength="20"
                                           data-rule="required;price"  data-rule-price="[/^\d{0,8}\.{0,1}(\d{1,2})?$/, '请输入正确的字数']" placeholder="请输入文章估计字数">
                                    <span class="glyphicon  form-control-feedback" >字</span>
                                </div>
                            </div>

                            <div class="form-group  has-feedback">
                                <label  class="col-sm-2 control-label">准备字数:</label>
                                <div class="col-sm-3">
                                    <input type="text" value="${post.price}" class="form-control" id="price" name="price" maxlength="20"
                                           data-rule="required;price"  data-rule-price="[/^\d{0,8}\.{0,1}(\d{1,2})?$/, '请输入正确的字数']" placeholder="请输入文章准备字数">
                                    <span class="glyphicon  form-control-feedback" >字</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">简介:</label>
                                <div class="col-sm-6">
                                    <script id="container" name="content" type="text/plain">${post.content}</script>
                                </div>
                            </div>

                            <div class="form-group">
                                <input type="hidden" id="imageIds" name="imageIds" value="">
                                <label  class="col-sm-2 control-label">图片:</label>
                                <div class="col-sm-10">
                                    <input id="the_file" name="files" type="file" multiple=true class="file-loading">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" id="submitPost" class="btn btn-primary">提交</button>
                                </div>
                            </div>
                        </form>

                    </div>
                    <!-- /.panel-body -->

                </div>
                <!-- /.panel -->
            </div>
        </div>


    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="inc/footer.jsp" %>
<!-- 配置文件 -->
<script type="text/javascript" src="ueditor1_4_3/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="ueditor1_4_3/ueditor.all.js"></script>
</body>

<script type="text/javascript">

    var post = {
        v: {
            id: "post",
            list: [],
            dTable: null
        },
        fn: {
            init: function () {

                if($("#id").val()!=""){
                    $(".page-header").text("编辑文章")
                }
                $("#submitPost").click(function(){
                    post.fn.save();
                })
                post.fn.imageInit();
                post.fn.dropperInit();
                $("#removeImg").click(function(){
                    post.fn.clearImageView();
                })
                UE.getEditor('container');

            },
            clearImageView: function(){
                $("#imageId").val("");
                $(".image_show").html("");
                $(".image_handle").show();
                $(".dropper-input").val("");
            },
            viewImage: function (image) {
                if (image) {
                    $(".dropper-input").val("");
                    $(".image_handle").hide();
                    $(".image_show").show();
                    $("#imageId").val(image.id);
                    $(".image_show").html("<img src='" + image.path + "' class='img-responsive' >");
                }
            },
            dropperInit: function () {
                $(".dropped").dropper({
                    postKey: "file",
                    action: "common/file/save/image",
                    postData: {thumbSizes: '480x800'},
                    label: "把图片拖拽到此处",
                    maxSize: 204857
                }).on("fileComplete.dropper", post.fn.onFileComplete)
                        .on("fileError.dropper", post.fn.onFileError);
            },
            onFileComplete: function (e, file, response) {
                if (response.status == '0') {
                    post.fn.viewImage(response.data);
                } else {
                    $bluemobi.notify(response.msg, "error");
                }
            },
            onFileError: function (e, file, error) {
                $bluemobi.notify(error, "error");
            },
            initialPreview:function(){
                var imgPreViews = [];
                <c:forEach var="_image" items="${post.images}" >
                var img =  "<img src='${_image.path}' style ='height:160px'>"
                imgPreViews.push(img);
                </c:forEach>
                return imgPreViews;
            },
            initialPreviewConfig:function(){
                var imgPreViewsConf = [];
                <c:forEach var="_image" items="${post.images}" >
                var conf = {
                    caption: "",
                    width: "120px",
                    url: "admin/post/delPic?postId=${post.id}&imageId=${_image.id}",
                    key: ${_image.id}
                }
                imgPreViewsConf.push(conf);
                </c:forEach>
                return imgPreViewsConf;

            },
            imageInit:function(){
                var $input = $("#the_file");
                $input.fileinput({
                    uploadUrl: "common/file/save/images", // server upload action
                    uploadAsync: false,
                    showUpload: true, // hide upload button
                    showRemove: false, // hide remove button
                    overwriteInitial: false,
                    minFileCount: 1,
                    maxFileCount: 3,
                    initialPreview: post.fn.initialPreview(),
                    initialPreviewConfig: post.fn.initialPreviewConfig(),
                    msgFilesTooMany:"只能上传三张图片",
                    allowedFileTypes:['image'],
                    uploadExtraData: function() {  // callback example
                        var out = {}, key, i = 0;
                        $('.kv-input:visible').each(function() {
                            $el = $(this);
                            key = $el.hasClass('kv-new') ? 'new_' + i : 'init_' + i;
                            out[key] = $el.val();
                            i++;
                        });
                        return out;
                    }
                }).on('filebatchuploadsuccess', function(event, data, previewId, index) {
                    var response = data.response;
                    if(response.status==0){
                        var imageIds = "";
                        $.each(response.data,function(index,data){
                            imageIds+=data.id+",";
                        })
                        if(imageIds.length>0){
                            imageIds =  imageIds.substr(0,imageIds.length-1);
                        }
                        $("#imageIds").val(imageIds);

                        $("#postForm").ajaxSubmit({
                            dataType: "json",
                            success: function (result) {
                                $("#imageIds").val("");
                                post.fn.responseComplete(result);
                            }
                        })
                    }
                });
            },
            save: function () {
                if(!$('#postForm').isValid()) {
                    return false;
                };

                if($("#imageId")==""||$("#imageId")==null){
                    $bluemobi.notify("缩略图不能为空!", "error");
                    return false;
                }

                if($(".glyphicon-hand-down").length==0){ // 没有图片的情况
                    $("#postForm").ajaxSubmit({
                        dataType: "json",
                        success: function (result) {
                            post.fn.responseComplete(result,true);
                        }
                    });
                }else{ // 有图片的情况
                    $(".fileinput-upload-button").trigger("click");
                }

            },
            responseComplete: function (result) {
                if (result.status == "0") {
                    $bluemobi.notify(result.msg, "success");
                } else {
                    $bluemobi.notify(result.msg, "error");
                }
            }
        }
    }

    $(document).ready(function () {
        post.fn.init();


    });

</script>

</html>