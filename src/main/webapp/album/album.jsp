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
            $("#abTable").jqGrid({
                url: "${path}/Album/page",
                editurl: "${path}/Album/edit",
                datatype: "json",
                rowNum: 2,
                rowList: [2, 4, 6, 8],
                pager: '#abPage',
                viewrecords: true,
                styleUI: "Bootstrap",
                height: "auto",
                autowidth: true,
                multiselect: false,
                colNames: ['Id', '名称', "封面", '评分', '作者', '播音员', '集数', '内容', '时间'],
                colModel: [
                    {name: 'id', index: 'id', width: 55},
                    {name: 'title', editable: true, index: 'invdate', width: 90},
                    {
                        name: "src", editable: true, index: "item", width: 130, align: "center", edittype: "file",
                        formatter: function (cellvalue, options, rowObject) {
                            return "<img src='${path}/upload/img/" + cellvalue + "' style='width:180px;height:80px' />";
                        }
                    },
                    {name: 'score', editable: true, index: 'name', width: 100},
                    {name: 'author', editable: true, index: 'name', width: 100},
                    {name: 'broadcost', editable: true, index: 'name', width: 100},
                    {name: 'count', editable: true, index: 'amount', width: 80, align: "right"},
                    {name: 'content', editable: true, index: 'tax', width: 80, align: "right"},
                    {name: 'time', index: 'note', width: 150, sortable: false}
                ],
                subGrid: true,  //是否开启子表格
                //1.subgrid_id 点击一行会在父表各种创建一个div来容纳子表格  subgrid_id就是这个div的id
                //2.row_id  点击行的id
                subGridRowExpanded: function (subgrid_id, row_id) {
                    addSubGrid(subgrid_id, row_id);
                }
            });

            //父表格 工具栏
            $("#abTable").jqGrid('navGrid', '#abPage', {add: true, edit: true, del: true},
                {
                    closeAfterEdit: true, //关闭添加框
                    beforeShowForm: function (obj) {
                        obj.find("#src").attr("disabled", true);
                    }
                },   //修改之后的额外操作
                {
                    closeAfterAdd: true, //关闭添加框
                    afterSubmit: function (data) {  //提交之后执行的方法
                        //文件的上传
                        $.ajaxFileUpload({
                            url: "${path}/Album/upload",
                            type: "post",
                            datatype: "json",
                            data: {id: data.responseText},  //获取id
                            fileElementId: "src",  //需要上传的文件域的ID，即<input type="file">的ID
                            success: function () {
                                //刷新表单
                                $("#abTable").trigger("reloadGrid");
                            }
                        });
                        return "hehe";
                    }
                },   //添加之后的额外操作
                {
                    closeAfterDel: true,
                }    //删除之后的额外操作
            );
        });

        //子表格
        function addSubGrid(subgridId, rowId) {

            var subgridTableId = subgridId + "Table";
            var pagerId = subgridId + "Page";

            $("#" + subgridId).html("<table id='" + subgridTableId + "' />" +
                "<div id='" + pagerId + "'/>"
            );


            //子表格
            $("#" + subgridTableId).jqGrid({
                url: "${path}/Chapter/page?id=" + rowId,
                editurl: "${path}/Chapter/edit?album_id=" + rowId,
                datatype: "json",
                rowNum: 2,
                rowList: [2, 5, 10, 20, 30],
                //pager : '#abPage',
                pager: "#" + pagerId,
                sortname: 'num',
                sortorder: "asc",
                styleUI: "Bootstrap",
                height: "auto",
                viewrecords: true,
                autowidth: true,
                colNames: ['Id', '名字', '音频', '时长', '大小', '日期', "专辑id", "操作"],
                colModel: [
                    {name: "id", index: "num", width: 80, key: true},
                    {name: "title", editable: true, index: "item", width: 60},
                    {name: "img", editable: true, index: "qty", width: 170, align: "right", edittype: "file",},
                    {name: "duration", index: "unit", width: 70, align: "right"},
                    {name: "size",index: "qty", width: 70, align: "right"},
                    {name: "upload_time", index: "total", width: 70, align: "right", sortable: false},
                    {name: "album_id", index: "total", width: 70, align: "right", sortable: false},
                    {
                        name: "img", align: "center",
                        formatter: function (cellvalue) {
                            return "<a href='#' onclick='Download(\""+cellvalue+"\")' ><span class='glyphicon glyphicon-download' /></a>&nbsp;&emsp;&emsp;" +
                                "<a href='#' onclick='play(\""+cellvalue+"\")' ><span class='glyphicon glyphicon-play-circle' /></a>";
                        }
                    }
                ]
            });

            //子表格的正删改查操作
            $("#" + subgridTableId).jqGrid('navGrid', "#" + pagerId, {edit: true, add: true, del: true},
                {
                    closeAfterEdit: true, //关闭添加框
                    beforeShowForm: function (obj) {
                        obj.find("#img").attr("disabled", true);
                    }
                },   //修改之后的额外操作
                {
                    closeAfterAdd: true, //关闭添加框
                    afterSubmit: function (data) {  //提交之后执行的方法
                        //文件的上传
                        $.ajaxFileUpload({
                            url: "${path}/Chapter/upload",
                            type: "post",
                            datatype: "json",
                            data: {id: data.responseText},  //获取id
                            fileElementId: "img",  //需要上传的文件域的ID，即<input type="file">的ID
                            success: function () {
                                //刷新表单
                                $("#abTable").trigger("reloadGrid");
                            }
                        });
                        return "hehe";
                    }
                },   //添加之后的额外操作
                {
                    closeAfterDel: true,
                }    //删除之后的额外操作
            );
        };


        //文件下载
        function Download(img1) {

            location.href="${path}/Chapter/download?img1="+img1;

        };

        //文件在线播放
        function play(img1) {
            alert(img1)
            //展示模态框
            $("#AudioModal").modal("show");

            //给音频标签设置值
            $("#myAudio").attr("src","${path}/upload/text/"+img1);
        }


    </script>
</head>
<body>

<!--初始化面板-->
<div class="panel panel-warning">

    <!--面板-->
    <div class="panel panel-heading">
        <h3>专辑信息</h3>
    </div>

    <!--标签页-->
    <ul class="nav nav-tabs">
        <li class="active"><a>专辑管理</a></li>
    </ul>

    <!--初始化表单-->
    <table id="abTable"/>

    <!--分页工具栏-->
    <div id="abPage"/>

    <%--播放的模态框--%>
    <div id="AudioModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <audio id="myAudio" src="" controls/>
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</div>


</body>
</html>