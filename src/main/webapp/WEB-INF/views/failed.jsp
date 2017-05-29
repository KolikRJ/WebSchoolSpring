<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Web School</title>
<link rel='stylesheet' href='webjars/bootstrap/2.3.2/css/bootstrap.min.css'>
<script type="text/javascript" src="webjars/jquery/1.9.0/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/2.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
.well {
	margin-top: 240px;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="well span4 offset4 ">
				<legend>
					<strong>Форма входа</strong>
				</legend>
				<spring:form method="POST" modelAttribute="user" action="list">
					<label for="login"><strong>Логин</strong></label>
					<spring:input path="login" type="text" class="span4" id="login" />

					<label for="password"> <strong>Пароль</strong></label>
					<spring:input path="password" type="password" class="span4" id="password" />
					<button type="submit" class="btn btn-info btn-block">Вход</button>
					<legend></legend>
					<div class="alert alert-error" id="error">
						<h6>Неверные учетные данные!</h6>
						<h6>Подсказка - Логин: admin, Пароль: admin</h6>
					</div>
				</spring:form>
			</div>
		</div>
	</div>
</body>
</html>
