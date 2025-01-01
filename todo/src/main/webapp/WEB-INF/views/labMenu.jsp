<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/app/img/apple-icon.png">
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/app/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Light Bootstrap Dashboard - Free Bootstrap 4 Admin Dashboard by Creative Tim</title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
<!--     Fonts and icons     -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<!-- CSS Files -->
<link href="${pageContext.request.contextPath}/resources/app/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/app/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="${pageContext.request.contextPath}/resources/app/css/demo.css" rel="stylesheet" />
<style>
.area{
    display: inline-block;
    width: 100%;
    padding: 10px;
    border: 1px solid #999;
    box-sizing: border-box;
    background: #f2f2f2;
    margin: 0.5em 0;
    line-height: 1.5;
    height: 6em;
}
.alert-error {
    background-color: #c60f13;
    border-color: #970b0e;
    color: white;
}
</style>
</head>

<body>
    <div class="wrapper">
        <div class="sidebar" data-image="${pageContext.request.contextPath}/resources/app/img/sidebar-5.jpg">
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="${pageContext.request.contextPath}/codeLearn/menu" class="simple-text">
                        Code eLearning
                    </a>
                </div>
                <ul class="nav">
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/menu">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            ダッシュボード
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/lab/">
                            <i class="nc-icon nc-atom"></i>
                            開発LAB
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/lesson/">
                            <i class="nc-icon nc-notes"></i>
                            修業BOX
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/record/">
                            <i class="nc-icon nc-circle-09"></i>
                            開発記録
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/contact/">
                            <i class="nc-icon nc-paper-2"></i>
                            お問い合わせ
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/news/">
                            <i class="nc-icon nc-bell-55"></i>
                            お知らせ
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#pablo"> 開発LAB </a>
                    <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="#pablo">
                                    <span class="no-icon">アカウント</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#pablo">
                                    <span class="no-icon">Log out</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="content">
                <div class="container-fluid">
                    <h4>問題集</h4>
                    <ul>
                        <c:choose>
                            <c:when test="${scope}">
                                <c:forEach items="${output}" var="lab">
                                    <li><a href="${pageContext.request.contextPath}/codeLearn/lab/scope?scope=${f:h(lab.scope)}">${f:h(lab.scopeName)}</a></li>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${output}" var="lab">
                                    <li>${f:h(lab.quesNum)}:<a href="${pageContext.request.contextPath}/codeLearn/lab/scope/ques?quesNum=${f:h(lab.quesNum)}">${f:h(lab.quesName)}</a></li>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                        
                    </ul>
                </div>
            </div>
            <footer class="footer">
                <div class="container-fluid">
                    <nav>
                        <p class="copyright text-center">
                            ©
                            <script>
                                document.write(new Date().getFullYear())
                            </script>
                            <a href="https://www.revale.co.jp/">Revale</a>, made with love for a better web
                        </p>
                    </nav>
                </div>
            </footer>
        </div>
    </div>
</body>

</html>
