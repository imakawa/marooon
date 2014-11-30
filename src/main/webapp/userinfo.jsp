<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>大東微购</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico"/>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

 <link href="css/stylebak.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js"></script>
<!-- start top_js_button -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1200);
		});
	});
</script>

<style type="text/css">
.userinfo {padding-top:100px; padding-bottom:150px;}
</style>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>

	<div class="main_bg">
		<div class="wrap">
			<div class="main">
			
			<h2>・注册功能暂不开放，用户注册请<a href="connect.action">联系我们</a>。</h2>
			<div class="userinfo">
				<form name="form1" method="post" action="userLogin.action">
					<div class="container">
					
						<form class="form-signin" role="form">
							<h2 class="form-signin-heading"></h2>
							<input name="username" id="username" type="text"
								class="form-control" placeholder="请输入用户名" required>

							<input name="password" id="password" type="password"
								class="form-control" placeholder="请输入密码" required>

							<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
						</form>
					</div>
				</form>
				</div>
				
			</div>
		</div>
	</div>

	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>