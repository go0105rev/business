<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/app/img/apple-icon.png">
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/app/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Rev : coding Elearning</title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
<!--     Fonts and icons     -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<!-- CSS Files -->
<link href="${pageContext.request.contextPath}/resources/app/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/app/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="${pageContext.request.contextPath}/resources/app/css/demo.css" rel="stylesheet" />
<!--   Core JS Files   -->
<script src="${pageContext.request.contextPath}/resources/app/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/core/popper.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="${pageContext.request.contextPath}/resources/app/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="${pageContext.request.contextPath}/resources/app/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="${pageContext.request.contextPath}/resources/app/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="${pageContext.request.contextPath}/resources/app/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<style>
</style>
</head>
<sec:authentication property="principal.userInf" var="account" />
<body>
    <div class="wrapper">
        <div class="sidebar" data-image="${pageContext.request.contextPath}/resources/app/img/sidebar-5.jpg">
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="${pageContext.request.contextPath}/codeLearn/menu/dashBoard?userId=${account.userId}" class="simple-text">
                        Code eLearning
                    </a>
                </div>
                <ul class="nav">
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/menu/dashBoard?userId=${account.userId}">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            ダッシュボード
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/lab/?userId=${account.userId}">
                            <i class="nc-icon nc-atom"></i>
                            開発LAB
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/lesson/?userId=${account.userId}">
                            <i class="nc-icon nc-notes"></i>
                            修業BOX
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/record/?userId=${account.userId}">
                            <i class="nc-icon nc-circle-09"></i>
                            開発記録
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/contact/?userId=${account.userId}">
                            <i class="nc-icon nc-paper-2"></i>
                            お問い合わせ
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/codeLearn/news/?userId=${account.userId}">
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
                    <a class="navbar-brand" href="#pablo"> 開発記録 </a>
                    <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item dropdown">
                                <a href="" class="dropdown-toggle nav-link" data-toggle="dropdown">
                                    <span class="no-icon">アカウント</span>
                                </a>
                                <div class="dropdown-menu">
                                    <div class="dropdown-item">チーム名：${account.teamId}</div>
                                    <div class="dropdown-item">ユーザ名：${account.userName}</div>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/login/userInf">情報詳細..</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="javascript:logout.submit()">
                                    <span class="no-icon">Log out</span>
                                </a>
                            </li>
                        </ul>
                        <form:form name="logout" action="${pageContext.request.contextPath}/logout" method="post"><input type="hidden"></form:form>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="content">
                <div class="container-fluid">
                    <h4>軌跡</h4>
                        <br>
                        <c:forEach items="${recordSession.labInf}" var="lab">
                            <li><a href="${pageContext.request.contextPath}/codeLearn/record/scope?scope=${f:h(lab.scope)}">${f:h(lab.scopeName)}</a></li>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${scope}">
                                <h3>LABを選び、各チームの状況を確認しましょう～</h3>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${output}" var="records">
                                        <h3>${f:h(records.teamId)}：${f:h(records.teamName)}</h3>
                                    <div class="container-fluid">
                                        <div class="subtexts">スコア　　：${f:h(records.teamScore)} 点</div>
                                        <div class="subtextBlue">評価中　　：${f:h(records.wait)} 件</div>
                                        <div class="subtextGreen">クリア　　：${f:h(records.clear)} 件</div>
                                        <div class="subtextBrond">部分クリア：${f:h(records.warn)} 件</div>
                                        <div class="subtextRed">エラー　　：${f:h(records.error)} 件</div>
                                    </div>
                                    <div class="container-fluid">
                                        <table align="center" border="5">
                                            <tr><th>お題</th><th>プレイヤー</th><th>試験結果</th><th>スコア</th><th>サイズ</th><th>実行時間</th></tr>
                                            <c:if test="${size > 0}">
                                            <c:forEach items="${records.unitTest}" var="r">
                                                <tr>
                                                <td>${f:h(r.quesName)}</td>
                                                <td>${f:h(r.userName)}</td>
                                                <td>${f:h(r.status)}</td>
                                                <td>${f:h(r.score)} 点</td>
                                                <td>${f:h(r.size)} byte</td>
                                                <td>${f:h(r.duration)} ms</td>
                                                </tr>
                                            </c:forEach>
                                            </c:if>
                                        </table>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
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
