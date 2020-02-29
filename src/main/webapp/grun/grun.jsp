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

    <script>
        $(function () {
            $("#bnTable").jqGrid(
                {
                    url: "${path}/Grun/page",
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
                    colNames: ['Id', '名字', '图片', '用户名', '密码', '盐', '时间'],
                    colModel: [
                        {name: 'id', index: 'id', width: 55},
                        {name: 'name', editable: true, index: 'name asc, invdate', width: 100},
                        {
                            name: 'src', editable: true, index: 'invdate', width: 90, align: "center", edittype: "file",
                            formatter: function (cellvalue, options, rowObject) {

                                return "<img src='${path}/upload/img/" + cellvalue + "' style='width:180px;height:80px' />";
                            }
                        },
                        {name: 'username', editable: true, index: 'name asc, invdate', width: 100},
                        {name: 'password', editable: true, index: 'name asc, invdate', width: 100},
                        {name: 'salt', editable: true, index: 'name asc, invdate', width: 100},
                        {name: 'time', editable: true, index: 'name asc, invdate', width: 100},

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


        });


    </script>


</head>
<body>

<div class="panel-danger">
    <div class="panel-heading">
        <h1>上师管理</h1>
    </div>

    <%--标签页--%>
    <ul class="nav nav-tabs">
        <li class="active"><a>上师信息</a></li>
    </ul>

    <%--初始化表单--%>
    <table id="bnTable"/>

    <%--分页工具栏--%>
    <div id="bnPage"/>
</div>

</body>
</html>