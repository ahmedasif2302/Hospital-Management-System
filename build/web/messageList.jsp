<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital+ | message list</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="patients list" />

<jsp:include page="_styles.jsp"></jsp:include>
<jsp:include page="_stylestable.jsp"></jsp:include>

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
						class="fa fa-angle-right"></i>Inbox <i class="fa fa-angle-right"></i>
						Message List</li>
				</ol>
				<div class="agile-grids">
					<!-- tables -->

					<div class="agile-tables">
						<div class="w3l-table-info">

							<center>INBOX</center>
							<p class="form-message">${errorString}</p>
							<table id="table">
								<thead>
									<tr>
										<th width="5%">ID</th>
										<th width="20%">Name</th>
										<th width="20%">Email</th>
										<th width="50%">Message</th>
										<th width="5%"><center>Remove</center></th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${allMessage}" var="messages">
										<tr>
											<td>${messages.mid}</td>
											<td>${messages.name}</td>
											<td>${messages.email}</td>
											<td>${messages.message}</td>


											<td>
											    <center>
													<form method="POST"
														action="${pageContext.request.contextPath}/messageDelete">
														<input type="hidden" name="mid" value="${messages.mid}">
														<button type="submit" name="action"
															class="btn btn-red btn-sm" value="delete">
															<span class="glyphicon glyphicon-remove"></span>
														</button>
													</form>
												</center>
											</td>
										</tr>

									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
					<!-- //tables -->
				</div>
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
						© 2016 HelthCare+. All Rights Reserved | Design by <a
							href="http://w3layouts.com/">M AHMED ASIF</a>
					</p>
				</div>
				<!--COPY rights end here-->

			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<jsp:include page="_sidebar.jsp"></jsp:include>
		<!--/sidebar-menu-->

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