<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <script charset="utf-8" src="${path}/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="${path}/kindeditor/lang/zh-CN.js"></script>
    <script>
        KindEditor.create('#editor_id', {
            uploadJson: "${path}/editor/uploadPhoto",  //指定文件上传的路径
            filePostName: "img",  //指定上传文件的名  默认imgFile
            allowFileManager: true,//显示浏览远程图片的按钮
            fileManagerJson: "${path}/upload/photo",  //指定浏览远程图片的路径
            afterBlur: function () {  //失去焦点之后执行的方法
                this.sync();   //将kindeditor中的内容同步到表单中
            }
        });
    </script>

    <script>
        $(function () {
            $("#bnTable").jqGrid(
                {
                    url: "${path}/Article/page",
                    editurl: "",
                    datatype: "json",
                    height: "auto",
                    pager: '#bnPage',
                    page: 1,//初始化页号
                    rowNum: 3,//决定每页显示3条
                    rowList: [3, 6, 9, 12], //修改每页展示的条数
                    viewrecords: true,//显示总记录数
                    autowidth: true,
                    styleUI: "Bootstrap",
                    colNames: ['Id', '标题', '时间', '上师名', '内容', '状态'],
                    colModel: [
                        {name: 'id', index: 'id', width: 55},
                        {name: 'title', editable: true, index: 'name asc, invdate', width: 100},
                        {name: 'time', editable: true, index: 'name asc, invdate', width: 100},
                        {name: 'gurn_name', editable: true, index: 'name asc, invdate', width: 100},
                        {name: 'content', index: 'note', width: 150, sortable: false,},
                        {
                            name: 'status', index: 'amount', width: 80, align: "right", align: "center",
                            formatter: function (cellvalue, options, rowObject) {

                                if (cellvalue == 1) {
                                    return "<button class='btn btn-success' onclick='updateStatus(\"" + rowObject.id + "\",\"" + cellvalue + "\")' >不展示</button>";
                                } else {
                                    return "<button class='btn btn-danger' onclick='updateStatu(\"" + rowObject.id + "\",\"" + cellvalue + "\")' >展示</button>";
                                }
                            }
                        },

                    ]

                });


        });

        //修改图片状态
        function updateStatus(id, status) {

            $(status == "0")
            $.ajax({
                url: "${path}/Article/update",
                type: "post",
                datatype: "json",
                data: {"id": id, "status": "0", "oper": "edit"},
                success: function () {
                    //刷新表单
                    $("#bnTable").trigger("reloadGrid");
                }
            });
        }

        function updateStatu(id, status) {

            $(status == "1")
            $.ajax({
                url: "${path}/Article/update",
                type: "post",
                datatype: "json",
                data: {"id": id, "status": "1", "oper": "edit"},
                success: function () {
                    //刷新表单
                    $("#bnTable").trigger("reloadGrid");
                }
            });
        }


        //点击文章显示按钮
        $("#btn1").click(function () {
            //先选中一行
            var rowId = $("#bnTable").jqGrid("getGridParam", "selrow");
            //判断选中行的id
            if (rowId != null) {

                //根据行id返回指定行的数据
                var row = $("#bnTable").jqGrid("getRowData", rowId);

                //给标题的input设置内容
                $("#titles").val(row.title);
                //给作者的input设置内容
                $("#gurn_name").val(row.gurn_name);
                //给kindeditor设置值
                KindEditor.html("#editor_id", row.content);

                //给模态框设置两个按钮
                $("#modalFooter").html("<button onclick='updateArticle(\"" + rowId + "\")' class='btn btn-default'>保存</button >" +
                    "<button class='btn btn-primary' data-dismiss='modal'>关闭</button>"
                );

                //展示模态框
                $("#articleModal").modal("show");

            } else {
                alert("请选中一行");
            }
        })

        //点击添加文章按钮
        $("#btn2").click(function () {
            //重置表单
            $("#articleForm")[0].reset();

            //给kindeditor设置值
            KindEditor.html("#editor_id", "");

            //展示模态框
            $("#articleModal").modal("show");

            //给模态框设置两个按钮
            $("#modalFooter").html("<button onclick='addArticle()' class='btn btn-default'>保存</button >" +
                "<button class='btn btn-primary' data-dismiss='modal'>关闭</button>"
            );

        });

        //点击删除按钮
        $("#btn3").click(function () {


            $("#delete").modal("show");

            //给模态框设置两个按钮
            $("#modalFooter1").html("<button onclick='deleteArticle()' class='btn btn-primary'>确定</button >" +
                "<button class='btn btn-primary' data-dismiss='modal'>关闭</button>"
            );

        })

        //点击添加文章按钮
        function addArticle() {
            $.ajax({
                url: "${path}/Article/add",
                type: "post",
                dataType: "text",
                data: $("#articleForm").serialize(),
                success: function () {
                    //关闭模态框
                    $("#articleModal").modal("hide");
                    //刷新表单
                    $("#bnTable").trigger("reloadGrid");
                }
            });

        }

        //点击修改文章按钮
        function updateArticle(id) {
            $.ajax({
                url: "${path}/Article/update1?id=" + id,
                type: "post",
                datatype: "json",
                data: $("#articleForm").serialize(),
                success: function () {
                    //关闭模态框
                    $("#articleModal").modal("hide");
                    //刷新表单
                    $("#bnTable").trigger("reloadGrid");
                }
            });

        }

        //点击修改文章按钮
        function deleteArticle() {
            //先选中一行
            var id = $("#bnTable").jqGrid("getGridParam", "selrow");
            $.ajax({
                url: "${path}/Article/delete?id=" + id,
                type: "post",
                datatype: "json",
                data: $("#articleForm").serialize(),
                success: function () {
                    //关闭模态框
                    $("#delete").modal("hide");
                    //刷新表单
                    $("#bnTable").trigger("reloadGrid");
                }
            });

        }


    </script>


</head>
<body>

<div class="panel-success">
    <div class="panel-heading">
        <h1>文章管理</h1>
    </div>

    <%--标签页--%>
    <ul class="nav nav-tabs">
        <li class="active"><a>文章信息</a></li>
    </ul>


    <!--按钮组-->
    <div class="panel panel-body">
        <button id="btn1" class="btn btn-info">查看文章</button>&emsp;
        <button id="btn2" class="btn btn-success">添加文章</button>&emsp;
        <button id="btn3" class="btn btn-warning">删除文章</button>
    </div>

    <%--初始化表单--%>
    <table id="bnTable"/>

    <%--分页工具栏--%>
    <div id="bnPage"/>
</div>


<%--模态框--%>
<div id="articleModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="width:730px">

            <%--模态框标题--%>
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="gridSystemModalLabel">文章信息展示</h4>
            </div>

            <%--模态框的内容--%>
            <div class="modal-body">
                <%--放一个表单--%>
                <form class="form-horizontal" id="articleForm">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">标题</span>
                        <input id="titles" name="title" type="text" class="form-control"
                               aria-describedby="basic-addon1"/>
                    </div>
                    <br>


                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon3">作者</span>
                        <input id="gurn_name" name="gurn_name" type="text" class="form-control"
                               aria-describedby="basic-addon1"/>
                    </div>
                    <br>

                    <div class="input-group">
                        <%--引入输入框--%>
                        <textarea id="editor_id" name="content" style="width:700px;height:300px;"/>
                    </div>

                </form>
            </div>

            <%--模态框按钮--%>
            <div class="modal-footer" id="modalFooter">
                <%--<button type="button" class="btn btn-default">保存</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>--%>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!--删除模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="delete">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">你确定要删除此条数据吗</h4>
            </div>
            <div class="modal-footer" id="modalFooter1">
                <%--<button type="button" class="btn btn-danger" data-dismiss="modal">确定</button>
                <button type="button" class="btn btn-danger">取消</button>--%>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


</body>
</html>