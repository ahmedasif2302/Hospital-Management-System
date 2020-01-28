<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title>Hospital+ | admin login</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css">
	</head>
	
	<body>
		
		<div class="login-page">
			<div class="form">
				<form method="POST" action="${pageContext.request.contextPath}/AdminLogin" class="login-form">
				
					<input type="text" name="userName" placeholder="Enter username" />
					
					<input type="password" name="password" placeholder="Enter password" />
					
					<select name="log_in_as">
						<option value="null">Login as</option>
						<option value="administrator">Admin</option>
						<option value="Receptionist">Receptionist</option>
					
					</select>
					
					remember me ? <input type="checkbox" name="remember" value= "Y"/>
					
					
					<button name="submit">login</button>
					
					<p class="message"> ${errorString}</p>
				</form>
			</div>
		</div>
		
		<script type="text/javascript">
			$('.message a').click(function() {
				$('form').animate({
					height : "toggle",
					opacity : "toggle"
				}, "slow");
			});
		</script>
	
	</body>
</html>
