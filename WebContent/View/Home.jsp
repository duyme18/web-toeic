<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

<link href="Template/Front-End/css/bootstrap.css" rel="stylesheet">
<link href="Template/Front-End/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="Template/Front-End/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="Template/Front-End/font/font-awesome.min.css" />

<script src="Template/Front-End/js/jquery1.js"></script>
<script src="Template/Front-End/js/bootstrap.min.js"></script>
</head>
<body>
	<!--HEADER ROW-->
	<jsp:include page="Header.jsp"/>
	
	<!-- /HEADER ROW -->


	<div class="container">

		<!--Carousel
  ==================================================-->

		<div id="myCarousel" class="carousel slide">
			<div class="carousel-inner">

				<div class="active item">
					<div class="container">
						<div class="row">

							<div class="span6">

								<div class="carousel-caption">
									<h1>Hướng dẫn phần nghe, đọc Toeic</h1>
									<p class="lead">Nghe Đọc Toeic</p>
									<a class="btn btn-large btn-primary" href="#">Tham gia ngay</a>
								</div>

							</div>

							<div class="span6">
								<img src="Template/Front-End/img/slide/slide12.jpg">
							</div>

						</div>
					</div>
				</div>
				<c:forEach items="${listslidebanner}" var="list">
					<div class="item">
						<div class="container">
							<div class="row">
								<div class="span6">
									<div class="carousel-caption">
										<h1>${list.slidename}</h1>
										<p class="lead">${list.slidecontent}</p>
										<a class="btn btn-large btn-primary" href="#">Tham gia
											ngay</a>
									</div>
								</div>
								<div class="span6">
									<img src="Template/Front-End/img/slide/${list.slideimage}">
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
			<!-- Carousel nav -->
			<a class="carousel-control left " href="#myCarousel"
				data-slide="prev"><i class="icon-chevron-left"></i></a> <a
				class="carousel-control right" href="#myCarousel" data-slide="next"><i
				class="icon-chevron-right"></i></a>
			<!-- /.Carousel nav -->
		</div>
		<!-- /Carousel -->

		<!-- Feature 
  ==============================================-->


		<div class="row feature-box">
			<div class="span12 cnt-title">
				<h1>At vero eos et accusamus et iusto odio dignissimos</h1>
				<span>Contrary to popular belief, Lorem Ipsum is not simply
					random text.</span>
			</div>

			<div class="span4">
				<img src="Template/Front-End/img/icon3.png">
				<h2>Feature A</h2>
				<p>Pellentesque habitant morbi tristique senectus et netus et
					malesuada fames ac turpis egestas.</p>

				<a href="#">Read More &rarr;</a>

			</div>

			<div class="span4">
				<img src="Template/Front-End/img/icon2.png">
				<h2>Feature B</h2>
				<p>Consectetur adipisicing elit, sed do eiusmod tempor
					incididunt ut labore et dolore magna aliqua.</p>
				<a href="#">Read More &rarr;</a>
			</div>

			<div class="span4">
				<img src="Template/Front-End/img/icon1.png">
				<h2>Feature C</h2>
				<p>Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor
					sit amet, ante.</p>
				<a href="#">Read More &rarr;</a>
			</div>
		</div>


		<!-- /.Feature -->

		<div class="hr-divider"></div>

		<!-- Row View -->


		<div class="row">
			<div class="span6">
				<img src="Template/Front-End/img/responsive.png">
			</div>

			<div class="span6">
				<img class="hidden-phone" src="Template/Front-End/img/icon4.png"
					alt="">
				<h1>Fully Responsive</h1>
				<p>Pellentesque habitant morbi tristique senectus et netus et
					malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat
					vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit
					amet quam egestas semper. Aenean ultricies mi vitae est. Mauris
					placerat eleifend leo.</p>
				<a href="#">Read More &rarr;</a>
			</div>
		</div>


	</div>


	<!-- /.Row View -->



	<!--Footer-->
	<jsp:include page="Footer.jsp"/>
	<!--/.Footer-->
</body>
</html>