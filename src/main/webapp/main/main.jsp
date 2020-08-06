<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>持明法州后台管理系统</title>
    <link rel="icon" href="${path}/bootstrap/img/arrow-up.png" type="image/x-icon">
    <link rel="stylesheet" href="${path}/bootstrap/css/bootstrap.css">

    <%--引入jqgrid中主题css--%>
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/css/css/hot-sneaks/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/boot/css/trirand/ui.jqgrid-bootstrap.css">
    <%--引入js文件--%>
    <script src="${path}/bootstrap/js/jquery.min.js"></script>
    <script src="${path}/bootstrap/js/bootstrap.js"></script>
    <script src="${path}/bootstrap/jqgrid/js/i18n/grid.locale-cn.js"></script>
    <script src="${path}/bootstrap/jqgrid/boot/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="${path}/bootstrap/js/ajaxfileupload.js"></script>

</head>
<body>

<!--顶部导航-->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">持名法州管理系统</a>
        </div>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">欢迎:${sessionScope.name}</a></li>
            <li><a href="${path}/admin/tuichu">退出登陆<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a>
            </li>
        </ul>
    </div>
</nav>

<!--栅格系统-->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">

            <!--左边手风琴部分-->
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-info">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                               aria-expanded="true" aria-controls="collapseOne">
                                <center>用户管理</center>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body">
                            <center>
                                <button type="button" class="btn btn-warning">
                                    <a href="javascript:$('#mainId').load('${path}/User/user.jsp')">用户信息</a>
                                </button>
                            </center>
                            <br>
                            <center>
                                <button type="button" class="btn btn-warning">
                                    <a href="javascript:$('#mainId').load('${path}/User/echarst.jsp')">用户统计</a>
                                </button>
                            </center>
                            <br>
                            <center>
                                <button type="button" class="btn btn-warning">
                                    <a href="javascript:$('#mainId').load('${path}/User/map.jsp')">用户分布</a>
                                </button>
                            </center>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="panel panel-success">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                <center>轮播图管理</center>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li>
                                    <center>
                                        <button class="btn btn-warning">
                                            <a href="javascript:$('#mainId').load('${path}/banner/banner.jsp')">轮播图展示</a>
                                        </button>
                                    </center>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="panel panel-warning">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                <center>专辑管理</center>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThree">
                        <div class="panel-body">
                            <center>
                                <button type="button" class="btn btn-warning">
                                    <a href="javascript:$('#mainId').load('${path}/album/album.jsp')">专辑信息</a>
                                </button>
                            </center>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="panel panel-danger">
                    <div class="panel-heading" role="tab" id="headingThrees">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseThrees" aria-expanded="false" aria-controls="collapseThree">
                                <center>文章管理</center>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThrees" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThrees">
                        <div class="panel-body">
                            <center>
                                <button type="button" class="btn btn-warning"><a
                                        href="javascript:$('#mainId').load('${path}/article/article.jsp')">文章信息</a>
                                </button>
                            </center>
                            <br>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="panel panel-primary">
                    <div class="panel-heading" role="tab" id="headingThrees1">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseThrees1" aria-expanded="false" aria-controls="collapseThree">
                                <center>上师管理</center>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThrees1" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThrees1">
                        <div class="panel-body">
                            <center>
                                <button type="button" class="btn btn-warning">
                                    <a href="javascript:$('#mainId').load('${path}/grun/grun.jsp')">上师信息</a>
                                </button>
                            </center>
                            <br>
                            <center>
                                <button type="button" class="btn btn-warning">上师统计</button>
                            </center>
                            <br>
                            <center>
                                <button type="button" class="btn btn-warning">上师分布</button>
                            </center>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="panel panel-info">
                    <div class="panel-heading" role="tab" id="headingThrees2">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseThrees2" aria-expanded="false" aria-controls="collapseThree">
                                <center>管理员管理</center>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThrees2" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThrees2">
                        <div class="panel-body">
                            <center>
                                <button type="button" class="btn btn-warning">管理员信息</button>
                            </center>
                            <br>
                            <center>
                                <button type="button" class="btn btn-warning">管理员统计</button>
                            </center>
                            <br>
                            <center>
                                <button type="button" class="btn btn-warning">管理员分布</button>
                            </center>
                        </div>
                    </div>
                </div>
            </div>


        </div>

        <div class="col-md-10" id="mainId">

            <!--巨幕开始-->
            <div class="jumbotron">
                <h3>欢迎来到持明法州后台管理系统</h3>
            </div>
            <!--右边轮播图部分-->
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${path}/bootstrap/img/1.png" alt="...">
                    </div>
                    <div class="item">
                        <img src="${path}/bootstrap/img/2.png" alt="...">
                    </div>
                    <div class="item">
                        <img src="${path}/bootstrap/img/3.png" alt="...">
                    </div>
                    <div class="item">
                        <img src="${path}/bootstrap/img/4.png" alt="...">
                    </div>
                    <div class="item">
                        <img src="${path}/bootstrap/img/shouye.jpg" alt="...">
                    </div>

                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>


            <!--页脚-->
            <center>
                <div class="panel-footer">@百知教育 @zparkhr.com</div>
            </center>
        </div>
        <!--栅格系统-->
    </div>
</div>

</body>
</html>
