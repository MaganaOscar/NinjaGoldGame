<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gold Game</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app.js"></script>
	</head>
	<body>
		<div>
			<div>
				<p>Your Gold: <span><c:out value="${gold}"/></span></p>
				<form action="/place" method="POST">
					<input type="hidden" name="location" value="reset"/>
					<button type="submit">Reset</button>
				</form>
			</div>
			<div style="display: flex; justify-content: space-around">
				<div>
					<h1>Farm</h1>
					<p>(earns 10-20 gold)</p>
					<form action="/place" method="POST">
						<input type="hidden" name="location" value="farm"/>
						<button type="submit">Find Gold!</button>
					</form>
				</div>
				<div>
					<h1>Cave</h1>
					<p>(earns 5-10 gold)</p>
					<form action="/place" method="POST">
						<input type="hidden" name="location" value="cave"/>
						<button type="submit">Find Gold!</button>
					</form>
				</div>
				<div>
					<h1>House</h1>
					<p>(earns 2-5 gold)</p>
					<form action="/place" method="POST">
						<input type="hidden" name="location" value="house"/>
						<button type="submit">Find Gold!</button>
					</form>
				</div>
				<div>
					<h1>Casino!</h1>
					<p>(earns/takes 0-50 gold)</p>
					<form action="/place" method="POST">
						<input type="hidden" name="location" value="casino"/>
						<button type="submit">Find Gold!</button>
					</form>
				</div>
				<div>
					<h1>Spa</h1>
					<p>(loses 5-20 gold)</p>
					<form action="/place" method="POST">
						<input type="hidden" name="location" value="spa"/>
						<button type="submit">Find Gold!</button>
					</form>
				</div>
			</div>
			<div>
				<h2>Activities: </h2>
				<div>
					<c:forEach var="activity" items="${activities}">
						<c:choose>
							<c:when test="${activity.getGold() > 0}">
							<p style="color: green">You entered a <c:out value="${activity.getLocation()}"/>
								and earned <c:out value="${activity.getGold()}"/> gold. 
								(<c:out value="${activity.getDate()}"/>)
							</p>
							</c:when>
							<c:otherwise>
								<p class="red" style="color: red">You entered a <c:out value="${activity.getLocation()}"/>
								and lost <c:out value="${activity.getGold()}"/> gold. 
								(<c:out value="${activity.getDate()}"/>)
								</p>
							</c:otherwise>
						</c:choose>
						
						
					</c:forEach>
				</div>
			</div>
		</div>
	</body>
</html>