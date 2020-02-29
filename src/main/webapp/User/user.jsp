<%@ page isELIgnored="false" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
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

    <script>
        $(function () {
            $("#bnTable").jqGrid(
                {
                    url: "${path}/User/page",
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
                    colNames: ['Id', '图片', '手机号', '密码', '盐', '状态', '姓名', '法名', '性别', '地址', '签名', '注册时间'],
                    colModel: [
                        {name: 'id', index: 'id', width: 55},
                        {
                            name: 'img', editable: true, index: 'invdate', width: 90, align: "center", edittype: "file",
                            formatter: function (cellvalue, options, rowObject) {

                                return "<img src='${path}/upload/img/" + cellvalue + "' style='width:180px;height:80px' />";
                            }
                        },
                        {name: 'phone', editable: true, index: 'name asc, invdate', width: 100},
                        {name: 'password', editable: true, index: 'name asc, invdate', width: 100, align: "center"},
                        {name: 'salt', editable: true, index: 'name asc, invdate', width: 100},
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
                        {name: 'name', index: 'note', width: 150, sortable: false,},
                        {name: 'legal_name', editable: true, index: 'name asc, invdate', width: 100},
                        {name: 'sex', index: 'note', width: 150, sortable: false,},
                        {name: 'city', index: 'note', width: 150, sortable: false,},
                        {name: 'sign', index: 'note', width: 150, sortable: false,},
                        {name: 'time', index: 'note', width: 150, sortable: false,}

                    ]

                });

            //增删改查操作
            $("#bnTable").jqGrid('navGrid', '#bnPage', {
                    edit: true,
                    add: true,
                    del: true,
                    addtext: "添加",
                    edittext: "编辑",
                    deltext: "删除"
                },

                {

                    closeAfterEdit: true, //关闭添加框
                    beforeShowForm: function (obj) {
                        obj.find("#src").attr("disabled", true);
                    }
                },//修改之后的额外操作
                {
                    closeAfterAdd: true, //关闭添加框
                    afterSubmit: function (data) { //提交之后执行的方法
                        $.ajaxFileUpload({
                            url: "${path}/Banner/upload",
                            type: "post",
                            datatype: "json",
                            data: {id: data.responseText},
                            //过去id
                            fileElementId: "src",
                            //需要上传的文件域的ID，即<input type="file">的ID
                            success: function () {
                                //刷新表单
                                $("#bnTable").trigger("reloadGrid");
                            }

                        });
                        return "hehe";

                    }
                },//添加之后的额外操作
                {
                    closeAfterDel: true, //关闭添加框
                }//删除之后的额外操作
            );

            //导出数据
            $("#btn1").click(function () {
                $.post("${path}/User/export",function (data) {
                    alert(data.message);

                })
            })


        });

        //修改图片状态
        function updateStatus(id, status) {

            $(status == "0")
            $.ajax({
                url: "${path}/User/update",
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
                url: "${path}/User/update",
                type: "post",
                datatype: "json",
                data: {"id": id, "status": "1", "oper": "edit"},
                success: function () {
                    //刷新表单
                    $("#bnTable").trigger("reloadGrid");
                }
            });
        }



    </script>

</head>
<body>

<div class="panel">
    <div class="panel-heading">
        <h1>用户信息</h1>
    </div>
    <hr>

    <%--标签页--%>
    <ul class="nav nav-tabs">
        <li class="active"><a>用户管理</a></li>
    </ul>

    <br>
    <div align="">
        <button id="btn1" class="btn btn-info">导出数据</button>&emsp;
    </div>
    <br>

    <%--初始化表单--%>
    <table id="bnTable"/>

    <%--分页工具栏--%>
    <div id="bnPage"/>

</body>
</html>