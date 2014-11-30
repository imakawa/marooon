<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/tmp_header.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div class="header_top">
		<div class="wrap">
			<div class="logo">
				<a href="index.action"><img src="images/logo.png" alt="" /> </a>
			</div>
<!-- 			<div class="h_icon">
				<ul class="icon1 sub-icon1">
					<li><a class="active-icon c1" href="#"><i>$300</i></a>
						<ul class="sub-icon1 list">
							<li><h3>shopping cart empty</h3> <a href=""></a></li>
							<li><p>
									if items in your wishlit are missing, <a href="contact.jsp">contact
										us</a> to view them
								</p>
							</li>
						</ul>
					</li>
				</ul>
			</div> -->
				
				<div class="h_icon">
				　<s:if test="#session.loginuser!=null">
				    [<a href="/marooon/userinfo.action"><s:property value="%{#session.loginuser.username}"/></a>]
				　</s:if>
				</div>
				
				<div class="h_search">
					<form>
						<input type="text" value="检索：商品名称或标示码" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '检索：商品名称或标示码';}"> <input type="submit" value="">
					</form>
				</div>
				
				<div class="clear"></div>
		</div><!-- end of [wrap] -->
	</div><!-- end of [header_top] -->
	
	<div class="header_nav">
		<div class="wrap">
				<div class="h_menu">
					<ul>
						<s:iterator value="#request.chanels" id="item">
						<li><a href="<s:property value='action'/>.action?chanelId=<s:property value='id' />"><s:property value="name" /></a></li>
						</s:iterator>
					</ul>
				</div>
				
				<div class="top-nav">
					<nav class="nav"> <a href="#" id="w3-menu-trigger"> </a>
					<ul class="nav-list" style="">
						<s:iterator value="#request.chanels" id="item">
						<li><a href="<s:property value='action'/>.action?chanelId=<s:property value='id' />"><s:property value="name" /></a></li>
						</s:iterator>
					</ul>
					</nav>
					
					<div class="search_box">
						<form>
							<input type="text" value="检索：商品名称或标示码" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '检索：商品名称或标示码';}"><input
								type="submit" value="">
						</form>
					</div>
					<div class="clear"></div>
					<script src="js/responsive.menu.js"></script>
				</div><!-- end of [top-nav] -->
				
				<div class="clear"></div>
		</div><!-- end of [wrap] -->
	</div><!-- end of [header_nav] -->
</body>
</html>