<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="uploadfile" enctype="multipart/form-data">
<table>
        <tr>
        <td>Select a file to upload</td>
        <td><input type="file" name="file" /></td>
        <td><input type="text" name="id" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
            
        </tr>
    </table>
</form>
</body>
</html>