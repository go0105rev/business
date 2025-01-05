<!doctype html>
<html lang="en">

<head>
    <!-- (1) -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/app/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
    
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
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="${pageContext.request.contextPath}/resources/app/css/demo.css" rel="stylesheet" />
    <script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
    <!--TODO demo.js修正が必要-->
    <script src="${pageContext.request.contextPath}/resources/app/js/demo.js"></script>
    
<script>
    var header_height;
    var fixed_section;
    var floating = false;

    $(document).ready(function() {
        suggestions_distance = $("#suggestions").offset();
        pay_height = $('.fixed-section').outerHeight();

    });
</script>
<style>
	.mainBody {
	    width: 300px;
	    margin: 0 auto;
	}
	.mainBody form {
	  width: 100%;
	}
input {
    background: none repeat scroll 0 0 rgba(0, 0, 0, 0.3);
    border: 1px solid rgba(0, 0, 0, 0.3);
    border-radius: 4px 4px 4px 4px;
    box-shadow: 0 -5px 45px rgba(100, 100, 100, 0.2) inset, 0 1px 1px rgba(255, 255, 255, 0.2);
    color: #FFFFFF;
    font-size: 13px;
    margin-bottom: 10px;
    outline: medium none;
    padding: 10px;
    text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.3);
    width: 100%;
}
button {
    background: linear-gradient(to bottom, #009EFF 0px, #0075BC 100%) repeat scroll 0 0 transparent;
    border: 1px solid rgba(0, 0, 0, 0.3);
    border-bottom: 1px solid rgba(0, 0, 0, 0.55);
    border-radius: 6px 6px 6px 6px;
    box-shadow: 0 1px 0 #E6F5FF inset;
    color: #FFFFFF;
    cursor: pointer;
    display: block;
    margin: 0 auto;
    padding: 10px 25px;
    text-shadow: 0 1px rgba(0, 0, 0, 0.3);
    width: 100%;
}
</style>
</head>

<body class="documentation">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg  navbar-transparent " color-on-scroll="500">
        <div class="  container-fluid ">
            <a class="navbar-brand" href="#" target="_blank">
                Code Learning
            </a>
            <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-bar burger-lines"></span>
                <span class="navbar-toggler-bar burger-lines"></span>
                <span class="navbar-toggler-bar burger-lines"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navigation">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="http://demos.creative-tim.com/bs3/light-bootstrap-dashboard/documentation/tutorial-components.html">ボタンA（TODO）</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- End Navbar -->
    <div class="wrapper">
        <div class="page-header clear-filter" filter-color="purple">
            <div class="page-header-image" data-parallax="true" style="background-image: url('${pageContext.request.contextPath}/resources/app/img/full-screen-image-3.jpg')">
                <div class="filter"></div>
                <div class="title-container text-center">
                    <h1>Regist Complete</h1>
                    <br/>
                    <div class="mainBody">
                        <button onclick="location.href='${pageContext.request.contextPath}/login/loginForm'">complete</button>
                    </div>
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
</body>

</html>