<html>
	<head>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<title>Ninja's Getting Money</title>
		<style type="text/css">
			.box{
				border:2px solid black;
				height:140px;
				width:20%;
				margin:2%;
				display: inline-block;
				vertical-align: top;
				text-align:center;
			}

			textarea{
				width:99%;
				height:100px;
				margin-top:2px;
			}
		</style>
	</head>
	<body>
		<h2>Your Gold: <c:out value="${totalGold}"/></h2>
		<div>
			<div class="box">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<form method="POST" action="/farm">
					<input type="submit" value="Find Gold!">
				</form>
			</div>
			<div class="box">
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<form method="POST" action="/cave">
					<input type="submit" value="Find Gold!">
				</form>
			</div>
			<div class="box">
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<form method="POST" action="/house">
					<input type="submit" value="Find Gold!">
				</form>
			</div>
			<div class="box">
				<h2>Casino</h2>
				<p>(earns/takes 0-50 gold)</p>
				<form method="POST" action="/casino">
					<input type="submit" value="Find Gold!">
				</form>
			</div>
		</div>
		<div>
			<h2>Activities</h2>
			<textarea style="width:90%; height: 100px">
				<c:forEach items="${messages}" var="message">
<c:out value="${message}"/>
				</c:forEach>
			</textarea>
		</div>
		<form method="POST" action="/reset">
			<input type="submit" value="Reset Game">		
		</form>	
	</body>
</html>