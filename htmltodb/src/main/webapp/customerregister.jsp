<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
 <div align="center">
  <h1>Customer Register Form</h1>
  <form action="<%= request.getContextPath() %>/Customerservelt" method="post">
  

   <table style="with: 80%">
    <tr>
     <td>name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>phno</td>
     <td><input type="text" name="phno" /></td>
    </tr>
    <tr>
     <td>adress</td>
     <td><input type="text" name="adress" /></td>
    </tr>
    <tr>
     <td>date</td>
     <td><input type="date" name="date" /></td>
    </tr>
    <tr>
     <td>aadarnum</td>
     <td><input type="text" name="aadharnum" /></td>
    </tr>
   
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</body>
</html>