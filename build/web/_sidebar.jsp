<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--sidebar-menu start-->

<div class="sidebar-menu">
	<header class="logo1">
		<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
		</a>
	</header>
	<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
	<div class="menu">
		<ul id="menu">
		
			<li>
			   <a href="${pageContext.request.contextPath}/AdminPanel">
				   <i class="fa fa-tachometer"></i> <span>Dashboard</span>
				   <div class="clearfix"></div>
			   </a>
			</li>
			

			<li id="menu-academico"><a href="#"><i
					class="fa fa-user-md fa-2x" aria-hidden="true"></i> <span>
						Doctors</span> <span class="fa fa-angle-right" style="float: right"></span>
					<div class="clearfix"></div></a>
				<ul id="menu-academico-sub">
					<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/addDoctor">Add
							Doctor</a></li>
					<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/doctorList">Doctor
							List</a></li>
				</ul></li>

			<li id="menu-academico"><a href="#"><i
					class="glyphicon glyphicon-user" aria-hidden="true"></i> <span>
						Patients</span> <span class="fa fa-angle-right" style="float: right"></span>
					<div class="clearfix"></div></a>
				<ul id="menu-academico-sub">
					<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/addPatients">Add
							Patients.</a></li>
					<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/patientsList">View
							Current Patients</a></li>
					<li id="menu-academico-avaliacoes"><a
						href="${pageContext.request.contextPath}/formerPatients">View Former Patients</a></li>
				</ul></li>

			<li id="menu-academico"><a href="#"><i class="fa fa-users"
					aria-hidden="true"></i> <span> Employee</span> <span
					class="fa fa-angle-right" style="float: right"></span>
					<div class="clearfix"></div></a>
				<ul id="menu-academico-sub">
					<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/addEmployee">Add
							Employee.</a></li>
					<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/employeeList">View
							All Employee</a></li>
				</ul></li>

			<li id="menu-academico"><a href="${pageContext.request.contextPath}/roomList"><i
					class="fa fa-building-o" aria-hidden="true"></i> <span>Room
						& Building</span>
					<div class="clearfix"></div></a></li>

			<li id="menu-academico"><a href="${pageContext.request.contextPath}/appointmentList"><i
					class="fa fa-bar-chart"></i><span>Appointment</span>
					<div class="clearfix"></div></a></li>

			<li><a href="tabels.html"><i class="fa fa-table"></i> <span>Financial</span>
					<div class="clearfix"></div></a></li>

			<li id="menu-academico"><a href="${pageContext.request.contextPath}/messageList"><i
					class="fa fa-envelope nav_icon"></i><span>Inbox</span>
					<div class="clearfix"></div></a></li>

			<li><a href="#"><i class="fa fa-picture-o"
					aria-hidden="true"></i><span>Gallery</span>
					<div class="clearfix"></div></a></li>

		</ul>
	</div>
</div>