<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital+ | employee details</title>
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
						class="fa fa-angle-right"></i>Employee <i
						class="fa fa-angle-right"></i> Employee Details</li>
				</ol>
				<!--grid-->
				<div class="validation-system">

					<div class="validation-form">					
					
						<h3>
							<center>
								<u>&nbsp;&nbsp;&nbsp; Details of ${employee.name} &nbsp;&nbsp;&nbsp;</u>
							</center>
						</h3>
						<p class="form-message">${errorString}</p>

						<form action="${pageContext.request.contextPath}/employeeUpdate" method="post">

							<div class="vali-form">
								<div class="col-md-6 form-group1">
									<label class="control-label">Name</label> <input type="text"
										name="name" value="${employee.name}" required="">
								</div>

								<div class="col-md-6 form-group1 form-last">
									<label class="control-label">Father Name</label> <input
										type="text" name="father_name" value="${employee.fatherName}"
										required="">
								</div>

								<div class="clearfix"></div>
							</div>

							<div class="clearfix"></div>
							<div class="col-md-12 form-group1 ">
								<label class="control-label">Your Address</label>
								<textarea name="address"
									required="">${employee.address}</textarea>
							</div>

							<div class="clearfix"></div>
							<div class="vali-form">

								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group2">
										<label class="control-label">Gender</label> 
										
										<select name="gender">
											<option value="${employee.gender}">${employee.gender}</option>
											<option value="Male">Male</option>
											<option value="Female">Female</option>
											<option value="Other">Other</option>
										</select>
									</div>

									<div class="col-md-6 form-group1 form-last">
										<label class="control-label">Employee Age</label> <input
											type="text" name="age" value="${employee.age}"
											required="">
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>
								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group1">
										<label class="control-label">Qualification</label> <input
											type="text" name="qualification"
											value="${employee.qualification}" required="">
									</div>

									<div class="col-md-6 form-group2">
										<label class="control-label">Designation</label> <select
											name="designation">
											<option value="${employee.designation}">${employee.designation}</option>
											<option value="Nurse">Nurse</option>
											<option value="Receptionist">Receptionist</option>
											<option value="Manager">Manager</option>
										</select>
									</div>

									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>
								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group2">
										<label class="control-label">Blood Group</label> <select
											name="blood_group">
											<option value="${employee.bloodGroup}">${employee.bloodGroup}</option>
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
											type="text" name="national_id"
											value="${employee.nationalID}" required="">
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>
								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group1">
										<label class="control-label">Joining Date</label> <input
											type="text" name="joining_date"
											value="${employee.joiningDate}" required="">
									</div>

									<div class="col-md-6 form-group1 form-last">
										<label class="control-label">Salary</label> <input type="text"
											name="salary" value="${employee.salary}" required="">
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>
								<div class="vali-form vali-form1">
									<div class="col-md-6 form-group1">
										<label class="control-label">Phone No.</label> <input
											type="text" name="phone_no" value="${employee.mobileNo}"
											required="">
									</div>

									<div class="col-md-6 form-group1 form-last">
										<label class="control-label">Email</label> <input type="email"
											name="email" value="${employee.email}" required="">
									</div>
									<div class="clearfix"></div>
								</div>

								<div class="clearfix"></div>

								<div class="col-md-12 form-group">
							    	<input type="hidden" name="eid" value="${employee.eid}">
									<button type="submit" name="action" value="update" class="btn btn-green">&nbsp;Update&nbsp;</button>
									<button type="reset" class="btn btn-reset">&nbsp; Reset &nbsp;</button>
									<a class="btn btn-blue" href="${pageContext.request.contextPath}/employeeList">&nbsp;&nbsp;&nbsp;Back &nbsp;&nbsp;</a>
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