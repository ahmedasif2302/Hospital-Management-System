<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!--header start here-->
<div class="header-main">
	<div class="logo-w3-agile">
		<h1>
			<a href="${pageContext.request.contextPath}/AdminPanel"><b>HOSPITAL+</b></a>
		</h1>
	</div>
	<div class="w3layouts-left">

		<!--search-box-->
		<div class="w3-search-box">
			<form action="#" method="post">
				<input type="text" placeholder="Search..." required=""> <input
					type="submit" value="">
			</form>
		</div>
		<!--//end-search-box-->
		<div class="clearfix"></div>
	</div>
	<div class="w3layouts-right">
		<div class="profile_details_left">
			<!--notifications of menu start -->
			<ul class="nofitications-dropdown">
				<li class="dropdown head-dpdn"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"><i class="fa fa-envelope"></i><span
						class="badge">${currentlist[0]}</span></a>
					<ul class="dropdown-menu">
						<li>
							<div class="notification_header">
								<h3>You have 0 new messages</h3>
							</div>
						</li>

						<li>
							<div class="notification_bottom">
								<a href="#">See all messages</a>
							</div>
						</li>
					</ul></li>
				<li class="dropdown head-dpdn"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"><i class="fa fa-bell"></i><span
						class="badge blue">0</span></a>
					<ul class="dropdown-menu">
						<li>
							<div class="notification_header">
								<h3>You have 0 new notification</h3>
							</div>
						</li> 0
						<li>
							<div class="notification_bottom">
								<a href="#">See all notifications</a>
							</div>
						</li>
					</ul></li>
				<li class="dropdown head-dpdn"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"><i class="fa fa-tasks"></i><span
						class="badge blue1">0</span></a>
					<ul class="dropdown-menu">
						<li>
							<div class="notification_header">
								<h3>You have 0 pending task</h3>
							</div>
						</li>

						<li>
							<div class="notification_bottom">
								<a href="#">See all pending tasks</a>
							</div>
						</li>
					</ul></li>
				<div class="clearfix"></div>
			</ul>
			<div class="clearfix"></div>
		</div>
		<!--notification menu end -->

		<div class="clearfix"></div>
	</div>
	<div class="profile_details w3l">
		<ul>
			<li class="dropdown profile_details_drop"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
					<div class="profile_img">
						<span class="prfil-img"><img src="images/in4.jpg" alt="">
						</span>
						<div class="user-name">
							<p>${loginedUser.userName}</p>
							<span>Administrator</span>
						</div>
						<i class="fa fa-angle-down"></i> <i class="fa fa-angle-up"></i>
						<div class="clearfix"></div>
					</div>
			</a>
				<ul class="dropdown-menu drp-mnu">
					<li><a href="${pageContext.request.contextPath}/AdminLogout"><i class="fa fa-sign-out"></i> Logout</a></li>
				</ul></li>
		</ul>
	</div>

	<div class="clearfix"></div>
</div>
<!--heder end here-->