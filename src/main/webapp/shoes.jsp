<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>全球购 | 奢侈品 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- <link href="css/style.css" rel="stylesheet" type="text/css" media="all" /> -->
<link href="css/productlist.css" rel="stylesheet" type="text/css" media="all" />
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
		<h2 class="style top">featured shoes</h2>
		<!-- start grids_of_3 -->
		<div class="grids_of_3">
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/shoe_pic1.jpg" alt=""/>
					<h3>branded shoes</h3>
					<div class="price">
						<h4>$499<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/shoe_pic2.jpg" alt=""/>
					<h3>branded shoes</h3>
					<div class="price">
						<h4>$499<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/shoe_pic3.jpg" alt=""/>
					<h3>branded shoes</h3>
					<div class="price">
						<h4>$499<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="clear"></div>
		</div>
		<div class="grids_of_3">
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/shoe_pic4.jpg" alt=""/>
					<h3>branded shoes</h3>
					<div class="price">
						<h4>$499<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/shoe_pic5.jpg" alt=""/>
					<h3>branded shoes</h3>
					<div class="price">
						<h4>$499<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="grid1_of_3">
				<a href="details.jsp">
					<img src="images/shoe_pic6.jpg" alt=""/>
					<h3>branded shoes</h3>
					<div class="price">
						<h4>$499<span>indulge</span></h4>
					</div>
					<span class="b_btm"></span>
				</a>
			</div>
			<div class="clear"></div>
		</div>	
		<!-- end grids_of_3 -->
	</div>
</div>
</div>		

<jsp:include page="template/footer.jsp"></jsp:include>

</body>
</html>