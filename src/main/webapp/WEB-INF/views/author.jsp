<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Author Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Author
</h1>

<c:url var="addAction" value="/author/add" ></c:url>

<form:form action="${addAction}" commandName="author">
<table>
	<c:if test="${!empty author.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="biography">
				<spring:message text="Biography"/>
			</form:label>
		</td>
		<td>
			<form:input path="biography" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="miniBio">
				<spring:message text="MiniBio"/>
			</form:label>
		</td>
		<td>
			<form:input path="miniBio" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="imgSrc">
				<spring:message text="ImgSrc"/>
			</form:label>
		</td>
		<td>
			<form:input path="imgSrc" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="language">
				<spring:message text="Language"/>
			</form:label>
		</td>
		<td>
			<form:input path="language" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="joinedOn">
				<spring:message text="JoinedOn"/>
			</form:label>
		</td>
		<td>
			<form:input path="joinedOn" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty author.name}">
				<input type="submit"
					value="<spring:message text="Edit Author"/>" />
			</c:if>
			<c:if test="${empty author.name}">
				<input type="submit"
					value="<spring:message text="Add Author"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Authors List</h3>
<c:if test="${!empty listAuthors}">
	<table class="tg">
	<tr>
		<th width="80">Author ID</th>
		<th width="120">Author Name</th>
		<th width="120">Author Biography</th>
		<th width="120">Author MiniBio</th>
		<th width="120">Author ImgSrc</th>
		<th width="120">Author Language</th>
		<th width="120">Author JoinedOn</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listAuthors}" var="author">
		<tr>
			<td>${author.id}</td>
			<td>${author.name}</td>
			<td>${author.biography}</td>
			<td>${author.miniBio}</td>
			<td>${author.imgSrc}</td>
			<td>${author.language}</td>
			<td>${author.joinedOn}</td>
			<td><a href="<c:url value='/edit/${author.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${author.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
