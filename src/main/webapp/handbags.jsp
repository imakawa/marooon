<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>大東购</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico"/>
 <link href="css/stylebak.css" rel="stylesheet" type="text/css" media="all" /> 
<!--<link href="css/productlist.css" rel="stylesheet" type="text/css" media="all" />-->
<script src="js/jquery.min.js"></script> 
<!-- start top_js_button -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script src="js/blocksit.min.js"></script>
   <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
			
			$(window).load( function() {
				var winWidth = $(window).width();
				var conWidth;
				if(winWidth < 600) {
					conWidth = 300;
					col = 1
				} else if(winWidth < 900) {
					conWidth = 600;
					col = 2
				} else if(winWidth < 1200) {
					conWidth = 900;
					col = 3;
				} else {
					conWidth = 1200;
					col = 4;
				}
				
				$('#container').width(conWidth);
				$('#container').BlocksIt({
					numOfCol: col,
					offsetX: 10,
					offsetY: 10
				});
			});
			
			$(window).resize(function() {
				var winWidth = $(window).width();
				var conWidth;
				if(winWidth < 600) {
					conWidth = 300;
					col = 1
				} else if(winWidth < 900) {
					conWidth = 600;
					col = 2
				} else if(winWidth < 1200) {
					conWidth = 900;
					col = 3;
				} else {
					conWidth = 1200;
					col = 4;
				}
				
				$('#container').width(conWidth);
				$('#container').BlocksIt({
					numOfCol: col,
					offsetX: 10,
					offsetY: 10
				});
			});
			
		});
	</script>
</head>
<body>
<jsp:include page="template/header.jsp"></jsp:include>

<!-- start main -->
<div class="main_bg">
<div class="wrap">	
	<div id="container" class="main">
		<!-- <h2 class="style top">featured handbags</h2> -->
		<!-- <!-- start grids_of_3 -->

				<s:iterator value="#request.products" status="product">
				  <%-- <s:if test="#product.index%3==0"><div class="grids_of_3"></s:if> --%>
						<div class="grid1_of_3">
							<a href="details.action?productId=<s:property value='id' />">
							<img  src="productImages/<s:property value='imageView'/>" alt="" />
								<h3>
									<s:property escape="false" value="name" />
								</h3>
								<s:if test="#session.loginuser!=null && #session.loginuser.groupeCode=='1001'">
								<div class="price">
									<h4>
									    ¥<s:property value="price.price1" />
										<%-- <span>詳細</span> --%>
									</h4>
								</div>
								</s:if>
<%-- 								<h1>
								标示码：<s:property value="code" />
								</h1> --%>
								 <span class="b_btm"></span>
							</a>
						</div>
						<%-- <s:if test="#product.index%3==2 || #product.isLast()"><div class="clear"></div>
					</s:if> --%>
				</s:iterator>
				<!-- 
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/w_pic2.jpg" alt=""/>
					<h3>明治ーほほえみ</h3>
					<div class="price">
						<h4>$299 <span>詳細</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/w_pic3.jpg" alt=""/>
					<h3>ーほほえみ</h3>
					<div class="price">
						<h4>$299<span>詳細</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="clear"></div>
		</div>
		<div class="grids_of_3">
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/w_pic4.jpg" alt=""/>
					<h3>branded handbags</h3>
					<div class="price">
						<h4>$299<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/w_pic5.jpg" alt=""/>
					<h3>branded handbags</h3>
					<div class="price">
						<h4>$299<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/w_pic6.jpg" alt=""/>
					<h3>branded handbags</h3>
					<div class="price">
						<h4>$299<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div> -->
			<!-- <div class="clear"></div>
		</div> -->
		<!-- end grids_of_3 -->
	</div>
</div>
</div>	

<jsp:include page="template/footer.jsp"></jsp:include>

</body>
</html>