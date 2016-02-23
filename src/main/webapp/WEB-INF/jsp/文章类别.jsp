<%--
  Created by IntelliJ IDEA.
  User: wangbin
  Date: 2015/8/20
  Time: 10:42
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
    <title>文章类型</title>
    <%@ include file="inc/css.jsp" %>

</head>

<body>

<div id="posts" class="wrapper">

    <%@ include file="inc/nav.jsp" %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">文章类型</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a href="javascript:void(0)" id="addPostType" class="btn btn-outline btn-primary btn-lg"
                           role="button">添加文章类型</a>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover" id="dataTables">
                                <colgroup>
                                    <col class="gradeA even" style="text-align: center; width: 6%"/>
                                    <col class="gradeA odd"/>
                                    <col class="gradeA even"/>
                                    <col class="gradeA odd"/>
                                    <col class="gradeA even"/>
                                </colgroup>
                                <thead>
                                <tr>
                                    <th><input type="checkbox" onclick="$bluemobi.checkAll(this)" class="checkall"/></th>
                                    <th>名称</th>
                                    <th>创建时间</th>
                                    <th>修改时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.panel-body -->

                </div>
                <!-- /.panel -->
            </div>
        </div>


    </div>
    <!-- /#page-wrapper -->


    <!-- Modal -->
    <div class="modal fade" id="addPostTypeModal" tabindex="-1" role="dialog" aria-labelledby="memberModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="addPostTypeModalLabel">操作</h4>
                </div>
                <div class="modal-body ">
                    <form id="addPostTypeForm" method="post" action="admin/post/type/save" class="form-horizontal" role="form">
                        <input type="hidden" name="id" value="">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">类型名称:</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="name" name="name" maxlength="20"
                                       data-rule="required" placeholder="请输入类型名称">
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="savePostType" class="btn btn-primary">保存</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- Modal end -->


</div>

<%@ include file="inc/footer.jsp" %>
</body>

<script type="text/javascript">

    var postType = {
        v: {
            id: "postType",
            list :[],
            dTable: null
        },
        fn: {
            init: function () {
                postType.fn.dataTableInit();

                $("#addPostType").click(function(){
                    postType.fn.showModal("addPostTypeModal","添加文章地址");
                })

                $("#savePostType").click(function(){
                    postType.fn.save();
                })

            },
            dataTableInit: function () {
                postType.v.dTable = $bluemobi.dataTable($('#dataTables'), {
                    "processing": true,
                    "serverSide": true,
                    "searching":false,
                    "ordering": false,
                    "ajax": {
                        "url": "admin/post/type/list",
                        "type": "POST"
                    },
                    "columns": [
                        {"data": "id"},
                        {"data": "name"},
                        {"data": "createDate"},
                        {"data": "updateDate"},
                        {
                            "data": null,
                            "defaultContent":
                            "<button type='button'  title='修改' class='btn btn-primary btn-circle edit'>" +
                            "<i class='fa fa-edit'></i>" +
                            "</button>" +
                            "&nbsp;&nbsp;" +
                            "<button type='button'  title='删除' class='btn btn-danger btn-circle delete'>" +
                            "<i class='fa fa-bitbucket'></i>" +
                            "</button>",
                            "targets": -1
                        }
                    ],
                    "createdRow": function (row, data, index) {
                        postType.v.list.push(data);
                        $('td', row).eq(0).html("<input type='checkbox' value=" + data.id + ">");
                    },
                    rowCallback: function (row, data) {
                        var items = postType.v.list;

                        $('td', row).last().find(".edit").click(function () {
                            postType.fn.edit(data.id);
                        })

                        $('td', row).last().find(".delete").click(function () {
                            postType.fn.deleteRow([data.id]);
                        });


                    },
                    "fnServerParams": function (aoData) {

                    },
                    "fnDrawCallback": function (row) {
                        $bluemobi.uiform();
                    }
                });
            },
            deleteRow: function (ids) {
                if (ids.length > 0) {
                    $bluemobi.optNotify(function () {
                        $bluemobi.ajax("admin/post/type/delete", {ids: JSON.stringify(ids)}, function (result) {
                            if (result.status == "0") {
                                $bluemobi.notify(result.msg, "success");
                                postType.v.dTable.ajax.reload();

                            } else {
                                $bluemobi.notify(result.msg, "error");
                            }
                        })
                    });
                }
            },
            edit: function (id) {
                postType.fn.showModal("addPostTypeModal","修改文章地址");
                var items = postType.v.list;
                $.each(items, function (index, item) {
                    if (item.id == id) {
                        for (var key in item) {
                            var element = $("#addPostTypeForm :input[name=" + key + "]")
                            if (element.length > 0) {
                                element.val(item[key]);
                            }
                        }
                    }
                })
            },
            save: function () {
                $("#addPostTypeForm").ajaxSubmit({
                    dataType: "json",
                    success: function (result) {

                        if(result.status=="0"){
                            alert(result.msg)
                        }else{
                            alert("保存失败，请刷新页面")
                        }

                        console.log(result.status)
                    }
                })
            },
            responseComplete: function (result,action) {
                if (result.status == "0") {
                    if(action){
                        postType.v.dTable.ajax.reload(null, false);
                    }else{
                        postType.v.dTable.ajax.reload();
                    }

                    $bluemobi.notify(result.msg, "success");
                } else {
                    $bluemobi.notify(result.msg, "error");
                }
            },
            showModal: function (modalId,title) {
                $("#"+modalId).modal("show");
                $bluemobi.clearForm($("#"+modalId));
                if (title) {
                    $("#"+modalId+" .modal-title").text(title);
                }
            }

        }
    }

    $(document).ready(function () {
        postType.fn.init();
    });




</script>


</html>