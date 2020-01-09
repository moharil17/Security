<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

	<form action="signup" method="post" modelAttribute="Users">
	
		<div class="form-group">
      		<label for="name">Name:</label>
			<input type="text" name="userName" placeholder="name">
		</div>
			<div class="form-group">
      		<label for="name">Email:</label>
			<input type="text" name="userEmail" placeholder="email">
		</div>	
		

		
		
		<button type="submit" class="btn btn-success">Submit</button>
	</form>
</div>
</body>
</html>