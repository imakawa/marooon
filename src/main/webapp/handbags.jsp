<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>大東微购</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico"/>
 <link href="css/stylebak.css" rel="stylesheet" type="text/css" media="all" /> 
<!--<link href="css/productlist.css" rel="stylesheet" type="text/css" media="all" />-->
<script src="js/jquery.min.js"></script> 
<!-- start top_js_button -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
   <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
</head>
<body>
<jsp:include page="template/header.jsp"></jsp:include>

<!-- start main -->
<div class="main_bg">
<div class="wrap">	
	<div class="main">
		<!-- <h2 class="style top">featured handbags</h2> -->
		<!-- <!-- start grids_of_3 -->

				<s:iterator value="#request.products" status="product">
				  <s:if test="#product.index%3==0"><div class="grids_of_3"></s:if>
						<div class="grid1_of_3">
							<a href="details.action?productId=<s:property value='id' />">
							<img width="200px" height="180px" src="productImages/<s:property value='imageView'/>" alt="" />
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
								</div> <span class="b_btm"></span>
							</a>
						</div>
						<s:if test="#product.index%3==2 || #product.isLast()"><div class="clear"></div>
					</div></s:if>
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