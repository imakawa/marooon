<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>大東购</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- 
<link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico"> -->
<link rel="icon" type="image/x-icon" href="images/title.ico">
    <!-- <link href="css/productlist.css" rel="stylesheet" type="text/css" media="all" /> -->
    <link href="css/stylebak.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/slider.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="all" >
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/modernizr.custom.28468.js"></script>
	<script type="text/javascript" src="js/jquery.cslider.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/owl.carousel.js"></script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
    <script src="js/blocksit.min.js"></script>
     <script type="text/javascript">
		jQuery(document).ready(function($) {
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

<!-- start slider -->
			<div id="da-slider" class="da-slider">
				<s:iterator value="#request.indexProducts" id="item">
				  <div class="da-slide">
					<h2><s:property value='product.name'/></h2>
					<p><s:property value="product.descripe1.chInfo"/></p>
					<a href="details.action?productId=<s:property value='product.id' />" class="da-link">详细</a>
					<div class="da-img"><img src="productImages/<s:property value='product.imageView'/>" alt="image01" /></div>
				  </div>				
				</s:iterator>
				<nav class="da-arrows">
					<span class="da-arrows-prev"></span>
					<span class="da-arrows-next"></span>
				</nav>
			</div>
<div class="main_bg1">
<div class="wrap">	
	<div class="main1">
		<h2>人气商品↓</h2>
	</div>
</div>
</div>
<!-- start main -->
<div class="main_bg">
<div class="wrap">	
	<div id="container" class="main">
         <s:iterator value="#request.hotProducts" status="product">
          <%-- <s:if test="#product.index%3==0"><div class="grids_of_3"></s:if> --%>
           <div class="grid1_of_3">
				<a href="details.action?productId=<s:property value='product.id' />">
					<img  src="productImages/<s:property value='product.imageView'/>" alt=""/>
					<h3><s:property value='product.name'/></h3>
					<s:if test="#session.loginuser!=null && #session.loginuser.groupeCode=='1001'">
					<div class="price">
						<h4>
					         ¥<s:property value="product.price.price1"/>
						</h4>
					</div>
					</s:if>
					<span class="b_btm"></span>
				</a>
			</div>
			<%-- <s:if test="#product.index%3==2 || #product.isLast()"><div class="clear"></div>
					</s:if> --%>
         </s:iterator>
		</div>
	</div>
</div>
</div>	

<jsp:include page="template/footer.jsp"></jsp:include>

</body>
</html>