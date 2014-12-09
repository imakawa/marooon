<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>大東微购｜<s:property value="#request.keyword"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico"/>

 <link href="css/stylebak.css" rel="stylesheet" type="text/css" media="all" />
<!-- start details -->
<link rel="stylesheet" type="text/css" href="css/productviewgallery.css" media="all" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/cloud-zoom.1.0.3.min.js"></script>
<script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>
<script type="text/javascript" src="js/jquery.fancybox-buttons.js"></script>
<script type="text/javascript" src="js/jquery.fancybox-thumbs.js"></script>
<script type="text/javascript" src="js/productviewgallery.js"></script>
<!-- start top_js_button -->
<script type="text/javascript" src="js/jquery.min.js"></script>
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

<jsp:include page="../template/header.jsp"></jsp:include>

<!-- start main -->
<div class="main_bg">
<div class="wrap">	
     <div style="margin-top:15px">
	  <h2>・关键字：<s:property value="#request.keyword" /></h2>
	  <s:if test="#request.products.size==0">
	  <br/>
	  <h1>・没有检索到相关内容</h1>
	  <h1>&nbsp;&nbsp;&nbsp;→关键字不能为空</h1>
	  <h1>&nbsp;&nbsp;&nbsp;→商品名称为模糊检索</h1>
	  <h1>&nbsp;&nbsp;&nbsp;→标示码为精准检索</h1>
	  </s:if>
	 </div> 
	<div id="container" class="main">	  
	　<s:iterator value="#request.products" status="product">
				<%--   <s:if test="#product.index%3==0"><div class="grids_of_3"></s:if> --%>
						<div class="grid1_of_3">
							<a href="details.action?productId=<s:property value='id' />">
							<img src="productImages/<s:property value='imageView'/>" alt="" />
								<h3>
									<s:property value="name" />
								</h3>
								<div class="price">
									<h4>
										<s:if test="#session.loginuser!=null && #session.loginuser.groupeCode=='1001'">
										   ¥<s:property value="price.price1" />
										</s:if>
										<span>詳細</span>
									</h4>
								</div>
								<h1>
								标示码：<s:property value="code" />
								</h1>
								 <span class="b_btm"></span>
							</a>
						</div>
						<%-- <s:if test="#product.index%3==2 || #product.isLast()"><div class="clear"></div>
					</s:if> --%>
		</s:iterator>
	</div>
</div>
</div><!-- end main -->	
<jsp:include page="../template/footer.jsp"></jsp:include>

</body>
</html>