<%--
  Created by IntelliJ IDEA.
  User: wangbin
  Date: 2015/8/17
  Time: 15:37
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
    <title>文章列表</title>
    <%@ include file="inc/css.jsp" %>
</head>

<body>
<div id="posts" class="wrapper">
    <%@ include file="inc/nav.jsp" %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">文章列表</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a href="admin/post/add" target="_blank" class="btn btn-outline btn-primary btn-lg"
                           role="button">添加文章</a>

                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label>文章编码：</label>
                                <input type="text" class="form-control" value="" id="postCode" name="postCode"
                                       maxlength="20"
                                       placeholder="请输入文章编码">
                            </div>
                            <div class="form-group">
                                <label>类型：</label>
                                <select id="typeList" name="typeList" style="width: 120px;"
                                        class="form-control"></select>
                            </div>
                            <div class="form-group">
                                <label>地址：</label>
                                <select id="areaList" name="areaList" style="width: 120px;"
                                        class="form-control"></select>
                            </div>
                            <button type="button" id="c_search" class="btn btn-default btn-sm">查询</button>
                        </form>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">

                        <div class="table-responsive">

                            <table class="table table-striped table-bordered table-hover" id="dataTables">
                                <colgroup>
                                    <col class="gradeA even"/>
                                    <col class="gradeA odd"/>
                                    <col class="gradeA even"/>
                                    <col class="gradeA odd"/>
                                    <col class="gradeA even"/>
                                    <col class="gradeA odd"/>
                                    <col class="gradeA even"/>
                                    <col class="gradeA odd"/>
                                </colgroup>
                                <thead>
                                <tr>
                                    <th><input type="checkbox" onclick="$bluemobi.checkAll(this)" class="checkall"/>
                                    </th>
                                    <th>文章名称</th>
                                    <th>文章编码</th>
                                    <th>字数</th>
                                    <th>类型</th>
                                    <th>地址</th>
                                    <th>创建时间</th>
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


</div>
<!-- /#wrapper -->

<%@ include file="inc/footer.jsp" %>
</body>

<script type="text/javascript">

    var postLists = {
        v: {
            id: "postLists",
            list: [],
            dTable: null
        },
        fn: {
            init: function () {
                // 页面加载时，自动加载分类信息
                postLists.fn.getTagList();

                postLists.fn.dataTableInit();
                // 查询
                $("#c_search").click(function () {
                    postLists.v.dTable.ajax.reload();
                })

                $("#delete").click(function () {
                    var checkBox = $("#dataTables tbody tr").find('input[type=checkbox]:checked');
                    var ids = checkBox.getInputId();
                    postLists.fn.deleteRow(checkBox, ids)
                })

                $("#c_search").click(function () {
                    postLists.v.dTable.ajax.reload();
                })
            },
            dataTableInit: function () {
                postLists.v.dTable = $bluemobi.dataTable($('#dataTables'), {
                    "processing": true,
                    "serverSide": true,
                    "searching": false,
                    "ordering": false,
                    "ajax": {
                        "url": "admin/post/list",
                        "type": "POST"
                    },
                    "columns": [
                        {"data": "id"},
                        {"data": "name"},
                        {"data": "code"},
                        {"data": "price"},
                        {
                            "data": "postType.name",
                            "defaultContent":""
                        },
                        {"data": "postArea.name"},
                        {"data": "createDate"},
                        {"data": ""}
                    ],
                    "columnDefs": [
                        {
                            "data": null,
                            "defaultContent": "<button type='button'  title='发表文章' class='btn btn-circle settingAdded'>" +
                            "<i class='fa fa-recycle'></i>" +
                            "</button>" +
                            "&nbsp;&nbsp;" +
                            "<a  title='编辑' target='_blank' class='btn btn-primary btn-circle edit'>" +
                            "<i class='fa fa-edit'></i>" +
                            "</a>" +
                            "&nbsp;&nbsp;" +
                            "<button type='button'  title='删除' class='btn btn-danger btn-circle delete'>" +
                            "<i class='fa fa-bitbucket'></i>" +
                            "</button>",
                            "targets": -1
                        }
                    ],
                    "createdRow": function (row, data, index) {
                        postLists.v.list.push(data);
                        $('td', row).eq(0).html("<input type='checkbox' value=" + data.id + ">");
                        if (data.isAdded) {
                            $(row).addClass("success")
                            $('td', row).eq(1).prepend("<span style='color: red'>【推荐】</span>");
                            $('td', row).last().find(".settingAdded").addClass("btn-default");
                            $('td', row).last().find(".settingAdded").attr("title", "下架文章")
                        } else {
                            $('td', row).last().find(".settingAdded").addClass("btn-info");
                            $('td', row).last().find(".settingAdded").attr("title", "发表文章")
                        }
                    },
                    rowCallback: function (row, data) {
                        var items = postLists.v.list;
                        $('td', row).last().find(".settingAdded").click(function () {
                            postLists.fn.settingAdded(data);
                        })

                        $('td', row).last().find(".edit").attr("href", 'admin/post/add?id=' + data.id)

                        $('td', row).last().find(".delete").click(function () {
                            var checkbox = $('td', row).first().find("input[type='checkbox']");
                            postLists.fn.deleteRow(checkbox, [data.id]);
                        })
                    },
                    "fnServerParams": function (aoData) {
                        aoData.typeId = $("#typeId").val();
                        aoData.isAdded = $("#isAdded").val();
                        aoData.postCode = $("#postCode").val();
                        aoData.typeId = $("#typeList").val();
                        aoData.areaId = $("#areaList").val();
                    },
                    "fnDrawCallback": function (row) {
                        $bluemobi.uiform();
                    }
                });
            },
            settingAdded: function (data) {
                $bluemobi.ajax("admin/post/setting/isAdded", {
                    id: data.id,
                    isAdded: data.isAdded
                }, function (result) {
                    postLists.fn.responseComplete(result, true);
                })
            },
            deleteRow: function (checkBox, ids) {
                if (ids.length > 0) {
                    $bluemobi.optNotify(function () {
                        $bluemobi.ajax("admin/post/delete", {ids: JSON.stringify(ids)}, function (result) {
                            if (result.status == "0") {
                                $bluemobi.notify(result.msg, "success");
                                postLists.v.dTable.ajax.reload();

                            } else {
                                $bluemobi.notify(result.msg, "error");
                            }
                        })
                    });
                }
            },
            responseComplete: function (result, action) {
                if (result.status == "0") {
                    if (action) {
                        postLists.v.dTable.ajax.reload(null, false);
                    } else {
                        postLists.v.dTable.ajax.reload();
                    }
                    $bluemobi.notify(result.msg, "success");
                } else {
                    $bluemobi.notify(result.msg, "error");
                }
            },
            getTagList: function () {
                $bluemobi.ajax("admin/utils/type/list", null, function (result) {
                    if (null != result) {
                        // 获取返回的分类列表信息，并循环绑定到label中
                        var content = "<option value=''>全部</option>";
                        jQuery.each(result, function (i, item) {
                            content += "<option value='" + item.id + "'>" + item.name + "</option>";
                        });
                        $('#typeList').append(content);
                    } else {
                        $bluemobi.notify("获取分类信息失败", "error");
                    }
                });
                $bluemobi.ajax("admin/utils/area/list", null, function (result) {
                    if (null != result) {
                        // 获取返回的分类列表信息，并循环绑定到label中
                        var content = "<option value=''>全部</option>";
                        jQuery.each(result, function (i, item) {
                            content += "<option value='" + item.id + "'>" + item.name + "</option>";
                        });
                        $('#areaList').append(content);
                    } else {
                        $bluemobi.notify("获取分类信息失败", "error");
                    }
                });
            }
        }
    }

    $(document).ready(function () {
        postLists.fn.init();
    });


</script>


</html>