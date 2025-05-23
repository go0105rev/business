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
.area{
    outline:none;
    width: 100%;
    line-height: normal;
    height: 400px;
    margin: 1em 0; /* ブロック前後の余白 */
    padding: 1em; /* ブロック内の余白 */
    border-radius: 5px; /* 角丸 */
    background: #25292f;
    color: #fff;
    white-space: pre-wrap; /* はみ出たときに折り返す */
    overflow-x: auto; /* 横スクロール有効化 */
    webkit-overflow-scrolling: touch; /* モバイルで滑る可能 */
}
.alert-error {
    background-color: #c60f13;
    border-color: #970b0e;
    color: white;
}

.subtexts{
    padding-left: 20px;
}

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
                    <a class="navbar-brand" href="#pablo"> 開発LAB </a>
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
                            <form:form name="logout" action="${pageContext.request.contextPath}/logout" method="post"><input type="hidden"></form:form>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="content">
                <div class="container-fluid">
                    <h3>${labSession.quesNum}：${labSession.quesName}</h3>
                    <h4>問題</h4>
                        <div class="subtexts">${content.detail}</div>
                    <h4>制約（ルール）</h4>
                        <c:forEach items="${rule}" var="r"><ul><li>${r}</li></ul></c:forEach>
                    <h4>入力</h4>
                        <div class="subtexts">${content.input}</div>
                    <h4>出力</h4>
                        <div class="subtexts">${content.output}</div>
                    <h4>入力例</h4>
                        <div class="subtexts">${content.input1}</div>
                    <h4>出力例</h4>
                        <div class="subtexts">${content.output1}</div>
                    <div class="UnitTest">
                        <t:messagesPanel/>
                        <form:form
                            action="${pageContext.request.contextPath}/codeLearn/lab/commit"
                            method="post" modelAttribute="labMapper">
                            <form:errors class="alert-error" path="context" />
                            <form:textarea class="area" spellcheck="false" path="context"/>
                            <form:button>commit</form:button>
                        </form:form>
                    </div>
                    <hr/>
                    <div class="unitList">
                    <h4>ソース</h4>
                        <table border="1">
                            試験結果（0:評価中。1:クリア。2:一部クリア。9:エラー（コンパイルエラー含め）。）
                            <tr><th>ID</th><th>スコア</th><th>サイズ</th><th>実行時間</th><th>試験結果</th><th>更新日付</th></tr>
                            <c:if test="${cnt > 0}">
                                <c:forEach items="${output}" var="units">
                                    <tr>
                                        <td><a href="${pageContext.request.contextPath}/codeLearn/lab/detail?sourceId=${f:h(units.sourceId)}">${f:h(units.sourceId)}</a></td>
                                        <td>${f:h(units.score)} 点</td>
                                        <td>${f:h(units.size)} byte</td>
                                        <td>${f:h(units.duration)} ms</td>
                                        <td>${f:h(units.status)}</td>
                                        <td>${f:h(units.strSaveTime)}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                        </table>
                    </div>
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
    <!--   -->
    <!-- <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown">
            <i class="fa fa-cog fa-2x"> </i>
        </a>

        <ul class="dropdown-menu">
			<li class="header-title"> Sidebar Style</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Background Image</p>
                    <label class="switch">
                        <input type="checkbox" data-toggle="switch" checked="" data-on-color="primary" data-off-color="primary"><span class="toggle"></span>
                    </label>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger background-color">
                    <p>Filters</p>
                    <div class="pull-right">
                        <span class="badge filter badge-black" data-color="black"></span>
                        <span class="badge filter badge-azure" data-color="azure"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-purple active" data-color="purple"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Sidebar Images</li>

            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="../assets/img/sidebar-1.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="../assets/img/sidebar-3.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="..//assets/img/sidebar-4.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="../assets/img/sidebar-5.jpg" alt="" />
                </a>
            </li>

            <li class="button-container">
                <div class="">
                    <a href="http://www.creative-tim.com/product/light-bootstrap-dashboard" target="_blank" class="btn btn-info btn-block btn-fill">Download, it's free!</a>
                </div>
            </li>

            <li class="header-title pro-title text-center">Want more components?</li>

            <li class="button-container">
                <div class="">
                    <a href="http://www.creative-tim.com/product/light-bootstrap-dashboard-pro" target="_blank" class="btn btn-warning btn-block btn-fill">Get The PRO Version!</a>
                </div>
            </li>

            <li class="header-title" id="sharrreTitle">Thank you for sharing!</li>

            <li class="button-container">
				<button id="twitter" class="btn btn-social btn-outline btn-twitter btn-round sharrre"><i class="fa fa-twitter"></i> · 256</button>
                <button id="facebook" class="btn btn-social btn-outline btn-facebook btn-round sharrre"><i class="fa fa-facebook-square"></i> · 426</button>
            </li>
        </ul>
    </div>
</div>
 -->
</body>

</html>
