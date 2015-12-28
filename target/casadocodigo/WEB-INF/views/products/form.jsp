<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro de Productos</title>
</head>
<body>

<form action="/casadocodigo/produtos" method="post">

<div>
<label for="title">Titulo</label>
<input type="text" name="title" id="title">
</div>

<div>
<label for="description">Descripción</label>
<textarea rows="10" cols="20" name="description" id="description">
</textarea>
</div>

<div>
<label for="pages">Número de Páginas</label>

<input type="text" name="pages" id="pages">

</div>

<div>
<input type="submit" value="Enviar">

</div>



</form>




<c:forEach items="${types}" var="bookType" varStatus="status">
<div>
<label for="price_${bookType}">${bookType}</label>
<input type="text" name="prices[${status.index}].value"
id="price_${bookType}"/>
<input type="hidden"
name="prices[${status.index}].bookType"
value="${bookType}"/>
</div>
</c:forEach>






</body>
</html>