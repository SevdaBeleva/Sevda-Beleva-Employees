<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<style>
		table {border: 1px solid;
			border-collapse: collapse;}
		table td, table th {border: 1px solid;}
	</style>
</head>
<body>
	<h2>Employee pairs</h2>
	<table>
		<thead>
			<tr>
				<th>Employee ID #1</th>
				<th>Employee ID #2</th>
				<th>Project ID</th>
				<th>Days worked</th>
			</tr>
		</thead>
		<tbody>
		   <c:forEach var="pair" items="${pairs}">
		       <tr>
			       <td>${pair.firstEmployee.id}</td>
			       <td>${pair.secondEmployee.id}</td>
			       <td>${pair.projectId}</td>
			       <td>${pair.daysWorkedTogether}</td>
		       </tr>
		   </c:forEach>
	   </tbody>
	   </table>
</body>
</html>
