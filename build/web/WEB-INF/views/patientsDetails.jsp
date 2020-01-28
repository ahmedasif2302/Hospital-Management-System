<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Hospital+ | Patients details</title>
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
						class="fa fa-angle-right"></i>Patients <i
						class="fa fa-angle-right"></i> Patients Details</li>
				</ol>
				<!--grid-->
				<div class="validation-system">

					<div class="validation-form">

						<h3>
							<center>
								<u>&nbsp;&nbsp;&nbsp;Details of ${patients.name}.
									&nbsp;&nbsp;&nbsp;</u>
							</center>
						</h3>
						<p class="form-message">${errorString}</p>
						<form action="${pageContext.request.contextPath}/patientsUpdate"
							method="post">

							<div class="vali-form">
								<div class="col-md-6 form-group1">
									<label class="control-label">Name</label> <input type="text"
										name="name" value="${patients.name}" required="">
								</div>

								<div class="col-md-6 form-group1 form-last">
									<label class="control-label">Father Name</label> <input
										type="text" name="father_name" value="${patients.fatherName}"
										required="">
								</div>

								<div class="clearfix"></div>
							</div>

							<div class="clearfix"></div>
							<div class="col-md-12 form-group1 ">
								<label class="control-label">Your Address</label>
								<textarea name="address" required="">${patients.address}</textarea>
							</div>

							<div class="clearfix"></div>
							<div class="vali-form">

								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group2">
										<label class="control-label">Gender</label> <select
											name="gender">
											<option value="${patients.gender}">${patients.gender}</option>
											<option value="Male">Male</option>
											<option value="Female">Female</option>
											<option value="Other">Other</option>
										</select>
									</div>

									<div class="col-md-6 form-group1 form-last">
										<label class="control-label">Patients Age</label> <input
											type="text" name="age" value="${patients.age}" required="">
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>
								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group2">
										<label class="control-label">Blood Group</label> <select
											name="blood_group">
											<option value="${patients.bloodGroup}">${patients.bloodGroup}</option>
											<option value="A+">A+</option>
											<option value="B+">B+</option>
											<option value="AB+">AB+</option>
											<option value="O+">O+</option>
											<option value="A-">A-</option>
											<option value="B-">B-</option>
											<option value="AB-">AB-</option>
											<option value="O-">O-</option>
										</select>
									</div>

									<div class="col-md-6 form-group1 form-last">
										<label class="control-label">National ID</label> <input
											type="text" name="national_id" value="${patients.nationalID}"
											required="">
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>
								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group1">
										<label class="control-label">Disease</label> <input
											type="text" name="disease" value="${patients.disease}"
											required="">
									</div>

									<div class="col-md-6 form-group1 form-last">
										<label class="control-label">Date</label> <input type="text"
											name="date" value="${patients.entryDate}" required="">
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>
								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group2">
										<label class="control-label">Room Type</label> <select
											name="room_type">
											<option value="${patients.roomType}">${patients.roomType}</option>
											<option value="Normal">Normal</option>
											<option value="Medium">Medium</option>
											<option value="VIP">VIP</option>
										</select>
									</div>

									<div class="col-md-6 form-group2 form-last">
										<label class="control-label">Status</label> <select
											name="status">
											<option value="${patients.status}">${patients.status}</option>
											<option value="Admitted">Admitted</option>
											<option value="Relesed">Released</option>
										</select>
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>
								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group1">
										<label class="control-label">Phone No.</label> <input
											type="text" name="phone_no" value="${patients.phoneNo}"
											required="">
									</div>

									<div class="col-md-6 form-group1 form-last">
										<label class="control-label">Email</label> <input type="text"
											name="email" value="${patients.emailNo}" required="">
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>

								<div class="col-md-12 form-group">
									<input type="hidden" name="pid" value="${patients.pid}">
									<button type="submit" name="action" value="update"
										class="btn btn-success">Update</button>
									<a class="btn btn-blue"
										href="${pageContext.request.contextPath }/${path}">&nbsp;&nbsp;Back&nbsp;&nbsp;&nbsp;</a>
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