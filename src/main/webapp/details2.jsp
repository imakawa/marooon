<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>大東购｜<s:property value="#request.product.name"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico"/>
 <link href="css/stylebak.css" rel="stylesheet" type="text/css" media="all" />
 
 <link rel="stylesheet" type="text/css" href="css/jquery.ad-gallery.css">
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.ad-gallery.js"></script>
  <script type="text/javascript">
  $(function() {
    var galleries = $('.ad-gallery').adGallery();
  });
  </script>
  
</head>
<body>

<jsp:include page="template/header.jsp"></jsp:include>

<!-- start main -->
<div class="main_bg">
<div class="wrap">	
	<div class="main">
	
    <div id="gallery" class="ad-gallery">
      <div class="ad-image-wrapper">
      </div>
      <div class="ad-controls">
      </div>
      <div class="ad-nav">
        <div class="ad-thumbs">
          <ul class="ad-thumb-list">
           <s:iterator value="#request.product.images" status="image" id="imagePath">
            <li>
               <a href="productImages/<s:property value="imagePath" />" style="width:64px;height:85px;">
                 <img src="productImages/<s:property value="imagePath" />" class="image0">
               </a>
             </li>
           </s:iterator>
          </ul>
        </div>
      </div>
    </div>
    
			<div class="span1_of_1_des">
				  <div class="desc1">
					<h3><s:property value="#request.product.name"/></h3>
					<p><s:property value="#request.product.descripe1.chInfo"/></p>
					<%-- <s:if test="#session.loginuser!=null && #session.loginuser.groupeCode=='1001'"> --%>
					    <h5>¥&nbsp<s:property value="#request.product.price.price1"/></h5>
					<%-- </s:if> --%>
                    <div>
						<span>标示码：</span>
						<span><s:property value="#request.product.code"/></span>
					</div>
			   	 </div>
			   	</div>
			   	<div class="clear"></div>
		
		        
		<hr/>	
		     <div style="margin:15px;">
			
			      <s:if test="#request.product.descripe2.chInfo!=''">
		            <span style="font-weight:bold;">・商品介绍（日本语）</span>
		              <hr/>
				        <div>
							<s:property escape="false" value="#request.product.descripe2.chInfo"/>
							<div class="clear"></div>
						</div>
				  </s:if>
					
					<s:if test="#request.product.descripe3.chInfo!=''">	
					<hr/>
		            <span style="font-weight:bold;">・商品介绍（中国语）</span>
		              <hr/>
				        <div>
							<s:property escape="false" value="#request.product.descripe3.chInfo"/>
						</div>
				    </s:if>
				    
				    <s:if test="#request.product.descripe4.chInfo!=''">    
				    <hr/>
		            <span style="font-weight:bold;">・商品介绍（其他）</span>
		              <hr/>
				        <div>
							<s:property escape="false" value="#request.product.descripe4.chInfo"/>
							<div class="clear"></div>
						</div>
					</s:if>
			        </div>
		
		
		
  </div>
	</div>
</div>
<jsp:include page="template/footer.jsp"></jsp:include>

</body>
</html>