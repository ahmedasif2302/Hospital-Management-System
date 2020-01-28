<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Hospital+ Appointment Form</title>
	<!-- custom-theme -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Health Appointment Form " />
	
	<script type="application/x-javascript">
		 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
			function hideURLbar(){ window.scrollTo(0,1); } 
	</script>
	
	
	<!-- css files -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css" />
	<link href="${pageContext.request.contextPath}/css/appointment-style.css" type="text/css" rel="stylesheet" media="all">
	<link href="//fonts.googleapis.com/css?family=Poppins:300,400,500,600,700&amp;subset=devanagari,latin-ext" rel="stylesheet">
	<!-- //css files -->

</head>


<body>
	<!-- section -->
	<section class="register">
	<div class="register-full">
		<div class="register-right">
			<div class="register-in">
				<h1>Make an Appointment</h1>
				
				<div class="registerimg">
					<img src="images/doctor.png" alt="" />
				</div>
				
				<div class="register-form">
				
				<p class="text-center" style="color: red;">${errorString}</p>
				
					<form action="${pageContext.request.contextPath}/getAppointment" method="post">
						<div class="fields-grid">
						
							<div class="styled-input">
								<input type="text" name="name" required=""> <label>Patients
									Name*</label> <span></span>
							</div>
							
							<div class="styled-input">
								<input type="email" name="email" required=""> <label>Email*</label>
								<span></span>
							</div>
							
							<div class="styled-input">
								<input type="tel" name="phone"  required=""> <label>Mobile (01xxxxxxxxx)</label> <span></span>
							</div>
							
							<div class="styled-input">
								<h2>Sex :</h2>
								<input type="radio" name="gender" value="male" checked>
								Male <input type="radio" name="gender" value="female">
								Female
							</div>

							<div class="styled-input">
								<input type="text" name="age" required=""> <label>Patients
									Age</label> <span></span>
							</div>

							<div class="styled-input">
								<select name="specialization" id="category1" required="">
									<option value="null">Specialization*</option>
									<option value="Cardiology">Cardiology</option>
									<option value="Heart Surgery">Heart Surgery</option>
									<option value="Skin Care">Skin Care</option>
									<option value="Body Check-up">Body Check-up</option>
									<option value="Numerology">Numerology</option>
									<option value="Diagnosis">Diagnosis</option>
									<option value="Others">Others</option>
								</select> <span></span>
							</div>

							<div class="styled-input">
								<input class="date" id="datepicker" name="date" type="text"
									value="MM/DD/YYYY" onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = 'MM/DD/YYYY';}"
									required="">
							</div>

							<input type="submit" name="action" value="Book Appointment">
							<input class="btn-reset" type="reset" name="reset" value="Reset">
							<a class="btn" href="${pageContext.request.contextPath}/home">Back</a>
							
							<div class="clear"></div>
						</div>
						
					</form>
					
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<!-- copyright -->
	<p class="agile-copyright">
		© 2016 HelthCare+. All Rights Reserved | Design by <a href="#">M AHMED ASIF</a>
	</p>
	<!-- //copyright --> </section>
	<!-- //section -->

	<!-- Default-JavaScript -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

	<!-- Calendar -->
	<script src="js/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker,#datepicker1").datepicker();
		});
	</script>
	<!-- //Calendar -->

</body>
<!-- //body ends -->
</html>