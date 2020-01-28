<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital+ | add room</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="patients registration" />

<jsp:include page="_styles.jsp"></jsp:include>

</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="mother-grid-inner">

				<!--header start here-->
				<jsp:include page="_header.jsp"></jsp:include>
				<!--heder end here-->

				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.jsp">Home</a><i
						class="fa fa-angle-right"></i>Room & Building <i
						class="fa fa-angle-right"></i> Add Room & Building</li>
				</ol>
				<!--grid-->
				<div class="validation-system">

					<div class="validation-form">
						<h3>
							<center>
								<u>&nbsp;&nbsp;&nbsp;Add Room.&nbsp;&nbsp;&nbsp;</u>
							</center>
						</h3>
						<p class="form-message">${errorString}</p>
						
						<form action="${pageContext.request.contextPath}/addRoom" method="post">

							<div class="vali-form">
								<div class="col-md-6 form-group1">
									<label class="control-label">Room Number*</label>
									<input type="text" name="room_no" placeholder="Room Number" required="">
								</div>

								<div class="col-md-6 form-group2 form-last">
									<label class="control-label">Room Type*</label>
									 <select name="room_type">
										<option value="null">Select Room Type</option>
										<option value="Normal">Normal</option>
										<option value="Medium">Medium</option>
										<option value="VIP">VIP</option>
									</select>
								</div>

								<div class="clearfix"></div>
							</div>

							<div class="clearfix"></div>
							<div class="vali-form vali-form1">
								<div class="col-md-6 form-group2">
									<label class="control-label">Building</label>
									<select name="building">
										<option value="null">Select building</option>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
									</select>
								</div>

								<div class="col-md-6 form-group1 form-last">
									<label class="control-label">Room Price*</label>
									<input type="text" name="price" placeholder="Enter Room Price" required="">
								</div>
								<div class="clearfix"></div>
							</div>

							<div class="vali-form1">
								<div class="col-md-6 form-group1">
									<label class="control-label">Number Of Bed*</label>
									<input type="text" name="bed_no" placeholder="Number of Bed" required="">
								</div>

								<div class="col-md-6 form-group2 form-last">
									<label class="control-label">Room Status*</label>
									<select name="room_status">
										<option value="null">Select Room Status</option>
										<option value="Busy">Busy</option>
										<option value="Free">Free</option>
									</select>
								</div>

								<div class="clearfix"></div>
							</div>

							<div class="clearfix"></div>

							<div class="col-md-12 form-group">
								<button type="submit" name="action" value="submit" class="btn btn-green">&nbsp;Submit&nbsp;</button>
								<button type="reset" class="btn btn-reset">&nbsp; Reset &nbsp;</button>
								<a class="btn btn-blue" href="${pageContext.request.contextPath}/roomList">View All</a>
							</div>
							<div class="clearfix"></div>
						</form>

						<!---->
					</div>

				</div>
				<!--//grid-->

				<!-- script-for sticky-nav -->
				<script>
						$(document).ready(function() {
							var navoffeset = $(".header-main").offset().top;
							$(window).scroll(function() {
								var scrollpos = $(window).scrollTop();
								if (scrollpos >= navoffeset) {
									$(".header-main").addClass("fixed");
								} else {
									$(".header-main").removeClass("fixed");
								}
							});
	
						});
					</script>
				<!-- /script-for sticky-nav -->
				<!--inner block start here-->
				<div class="inner-block"></div>
				<!--inner block end here-->
				<!--copy rights start here-->
				<div class="copyrights">
					<p>
						© 2016 HelthCare+. All Rights Reserved | Design by <a href="#">M AHMED ASIF</a>
					</p>
				</div>
				<!--COPY rights end here-->
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<jsp:include page="_sidebar.jsp"></jsp:include>
		<!-- sidebar menu end -->


		<div class="clearfix"></div>
	</div>
	<script>
			var toggle = true;
	
			$(".sidebar-icon").click(
					function() {
						if (toggle) {
							$(".page-container").addClass("sidebar-collapsed")
									.removeClass("sidebar-collapsed-back");
							$("#menu span").css({
								"position" : "absolute"
							});
						} else {
							$(".page-container").removeClass("sidebar-collapsed")
									.addClass("sidebar-collapsed-back");
							setTimeout(function() {
								$("#menu span").css({
									"position" : "relative"
								});
							}, 400);
						}
	
						toggle = !toggle;
					});
		</script>
	<!--js -->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<!-- /Bootstrap Core JavaScript -->

</body>
</html>