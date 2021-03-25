<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <sf:form action="search" method="post" name="form" modelAttribute="country">
		
	<input type="text" name="name">
		<input type="submit" name="submit" value="Search"/>
	</sf:form>
	
	<br/><br/>
	<h3>Displaying Countries in Random Order</h3>
	<p>
	${countryName}</p>
	<br/>
	<h3>Displaying Countries in Ascending Order</h3>
	<p>${countryNameAsc }</p></br>
	
	
	<br/><br/>
	<sf:form action="searchWith" method="post" name="forms" modelAttribute="country">
	
		<sf:input path="name" type="submit" name="submit" value="A"/>
		<sf:input path="name" type="submit" name="submit" value="B"/>
		<sf:input path="name" type="submit" name="submit" value="C"/>
		<sf:input path="name" type="submit" name="submit" value="D"/>
		<sf:input path="name" type="submit" name="submit" value="E"/>
		<sf:input path="name" type="submit" name="submit" value="F"/>
		<sf:input path="name" type="submit" name="submit" value="G"/>
		<sf:input path="name" type="submit" name="submit" value="H"/>
		<sf:input path="name" type="submit" name="submit" value="I"/>
		<sf:input path="name" type="submit" name="submit" value="J"/>
		<sf:input path="name" type="submit" name="submit" value="K"/>
		<sf:input path="name" type="submit" name="submit" value="L"/>
		<sf:input path="name" type="submit" name="submit" value="M"/>
		<sf:input path="name" type="submit" name="submit" value="N"/>
		<sf:input path="name" type="submit" name="submit" value="O"/>
		<sf:input path="name" type="submit" name="submit" value="P"/>
		<sf:input path="name" type="submit" name="submit" value="Q"/>
		<sf:input path="name" type="submit" name="submit" value="R"/>
		<sf:input path="name" type="submit" name="submit" value="S"/>
		<sf:input path="name" type="submit" name="submit" value="T"/>
		<sf:input path="name" type="submit" name="submit" value="U"/>
		<sf:input path="name" type="submit" name="submit" value="V"/>
		<sf:input path="name" type="submit" name="submit" value="W"/>
		<sf:input path="name" type="submit" name="submit" value="X"/>
		<sf:input path="name" type="submit" name="submit" value="Y"/>
		<sf:input path="name" type="submit" name="submit" value="Z"/>
		
		<br/><br/>
		${countryNameStart}</br>
	</sf:form>
	
</body>
</html>