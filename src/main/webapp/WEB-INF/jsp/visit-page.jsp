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
    <title>回访客户列表</title>
    <%@ include file="inc/css.jsp" %>
</head>

<body>
<div id="posts" class="wrapper">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">回访客户列表</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label>工号：</label>
                                <input type="text" class="form-control" value="" id="wnumber" name="prodwnumbeructCode"
                                       maxlength="20"
                                       placeholder="请输入工号">
                            </div>
                            <div class="form-group">
                                <label>员工姓名：</label>
                                <input type="text" class="form-control" value="" id="wname" name="wname"
                                       maxlength="20"
                                       placeholder="请输入员工姓名">
                            </div>
                             <div class="form-group">
                                <label>客户姓名：</label>
                                <input type="text" class="form-control" value="" id="custname" name="custname"
                                       maxlength="20" 
                                       placeholder="请输入客户姓名">
                            </div>
                            <button type="button" id="c_search" class="btn btn-default btn-sm">查询</button>
                        </form>
                        <div class="clearfix"></div>
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
                                    <th>工号</th>
                                    <th>员工姓名</th> 
                                    <th>客户姓名</th>
                                    <th>客户手机</th>
                                    <th>创建时间</th>
                                    <th>查看图片</th>
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

    var productList = {
        v: {
            id: "productList",
            list: [],
            dTable: null
        },
        fn: {
            init: function () {
                // 页面加载时，自动加载分类信息
                productList.fn.getTagList();

                productList.fn.dataTableInit();
                // 查询
                $("#c_search").click(function () {
                    productList.v.dTable.ajax.reload();
                })

                $("#delete").click(function () {
                    var checkBox = $("#dataTables tbody tr").find('input[type=checkbox]:checked');
                    var ids = checkBox.getInputId();
                    productList.fn.deleteRow(checkBox, ids)
                })

                $("#c_search").click(function () {
                    productList.v.dTable.ajax.reload();
                })
            },
            dataTableInit: function () {
                productList.v.dTable = $bluemobi.dataTable($('#dataTables'), {
                    "processing": true,
                    "serverSide": true,
                    "searching": false,
                    "ordering": false,
                    "ajax": {
                        "url": "admin/visitpage/list",
                        "type": "POST"
                    },
                    "columns": [
                        {"data": "id"},
                        {"data": "wnumber"},
                        {"data": "wname"},
                        {"data": "custName"},
                        {"data": "custMobile"},
                        {"data": "createDate"},
                        {"data": ""}
                    ],
                    "columnDefs": [
                        {
                            "data": null,
                            "defaultContent":
                            "<a  title='编辑' target='_blank' class='btn btn-primary btn-circle edit'>" +
                            "<i class='fa fa-edit'></i>" +
                            "</a>" +
                            "&nbsp;&nbsp;" ,
                            "targets": -1
                        }
                    ],
                    "createdRow": function (row, data, index) {
                        productList.v.list.push(data);
                        $('td', row).eq(0).html("<input type='checkbox' value=" + data.id + ">");
                        if (data.isAdded) {
                            $(row).addClass("success")
                            $('td', row).eq(1).prepend("<span style='color: red'>【上架】</span>");
                            $('td', row).last().find(".settingAdded").addClass("btn-default");
                            $('td', row).last().find(".settingAdded").attr("title", "下架商品")
                        } else {
                            $('td', row).last().find(".settingAdded").addClass("btn-info");
                            $('td', row).last().find(".settingAdded").attr("title", "上架商品")
                        }
                    },
                    rowCallback: function (row, data) {
                        var items = productList.v.list;
                        $('td', row).last().find(".settingAdded").click(function () {
                            productList.fn.settingAdded(data);
                        })

                        $('td', row).last().find(".edit").on("click",function(){
                        	window.open(data.image);
                        })
                    },
                    "fnServerParams": function (aoData) {
                        aoData.wnumber = $("#wnumber").val();
                        aoData.wname = $("#wname").val();
                        aoData.custname = $("#custname").val();
                    },
                    "fnDrawCallback": function (row) {
                        $bluemobi.uiform();
                    }
                });
            },
            settingAdded: function (data) {
                $bluemobi.ajax("admin/product/setting/isAdded", {
                    id: data.id,
                    isAdded: data.isAdded
                }, function (result) {
                    productList.fn.responseComplete(result, true);
                })
            },
            deleteRow: function (checkBox, ids) {
                if (ids.length > 0) {
                    $bluemobi.optNotify(function () {
                        $bluemobi.ajax("admin/product/delete", {ids: JSON.stringify(ids)}, function (result) {
                            if (result.status == "0") {
                                $bluemobi.notify(result.msg, "success");
                                productList.v.dTable.ajax.reload();

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
                        productList.v.dTable.ajax.reload(null, false);
                    } else {
                        productList.v.dTable.ajax.reload();
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
        productList.fn.init();
    });


</script>


</html>