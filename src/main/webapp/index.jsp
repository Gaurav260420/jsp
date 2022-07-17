<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="send" method="post" enctype="multipart/form-data">
<input type="text" placeholder="Enter your name" name="name"> <br>
<input type="email" placeholder="Enter your email" name="email"> <br>
<input type="password" placeholder="Enter your password" name="pass"> <br>
<input type="file" value="Browse" name="file">
<input type="submit">

</form>

</body>
</html>