<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Pdf</title>
</head>
<body>
<h3>Create a Pdf</h3>
<p>
<form action="createPDF" method="GET">
<table width="300px" align="center" style="border:0px;background-color:#eeeeee;">
<tr><td>Enter pdf filename :</td> <td><input type="text" name="pdfName" style="background-color: graytext;"/></td></tr>
<tr><td>Enter pdf Content : </td> <td><textarea rows="10" name="pdfContent" ="30" style="background-color: graytext;"></textarea>
</p>
</table>
<center><input name="CreatePdf" value="Create"
					onclick="/CompletePdfTool/src/com/santhyreddy/createPDF/CreatePDF.java"
					type="button"></center>
</form>
</body>
</html>