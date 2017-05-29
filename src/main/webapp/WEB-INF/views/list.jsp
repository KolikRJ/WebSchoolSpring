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
<body>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<p class="brand">Привет ${user.login}</p>
			</div>
		</div>
		<div>${list.table}</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<spring:form method="POST" modelAttribute="student" action="addStudent">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Добавить ученика</h4>
					</div>
					<div class="modal-body">
						<label for="firstname"><strong>Имя</strong></label>
						<spring:input path="firstname" type="text" id="firstname" />
						<label for="lastname"> <strong>Фамилия</strong></label>
						<spring:input path="lastname" type="text" id="lastname" />

						<label for="phone"><strong>Номер телефона</strong></label>
						<spring:input path="phone" type="text" id="phone" />
						<label for="dateofbirth"> <strong>Дата рождения</strong></label>
						<spring:input path="dateofbirth" type="text" id="dateofbirth" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
						<button type="submit" class="btn btn-primary">Добавить</button>
					</div>
				</div>
			</div>
		</spring:form>
	</div>
	<!-- Modal -->
	<div class="modal fade " id="myUpdateModal" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<spring:form method="POST" modelAttribute="student" action="updateStudent">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Изменить ученика</h4>
					</div>
					<div class="modal-body">
						<label for="firstname"><strong>Имя</strong></label>
						<spring:input path="firstname" type="text" id="firstname" />
						<label for="lastname"> <strong>Фамилия</strong></label>
						<spring:input path="lastname" type="text" id="lastname" />

						<label for="phone"><strong>Номер телефона</strong></label>
						<spring:input path="phone" type="text" id="phone" />
						<label for="dateofbirth"> <strong>Дата рождения</strong></label>
						<spring:input path="dateofbirth" type="text" id="dateofbirth" />
						<spring:input path="id" type="hidden" id="idUpdateStudent" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
						<button type="submit" class="btn btn-success">Сохранить</button>
					</div>
				</div>
			</div>
		</spring:form>
	</div>

	<!-- Modal Delete -->
	<div class="modal fade " id="myDeleteModal" tabindex="-3" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<spring:form method="POST" modelAttribute="student" action="deleteStudent">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Удалить ученика</h4>
					</div>
					<div class="modal-body">
						<h3>Вы точно хотите удалить?</h3>
						<spring:input path="id" type="hidden" id="idDeleteStudent" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
						<button type="submit" class="btn btn-danger">Удалить</button>
					</div>
				</div>
			</div>
		</spring:form>
	</div>

</body>
<script>
	$("button[id^=update]").click(function() {
		$("#idUpdateStudent").val(this.id.substring(6, this.id.length));
	});
	$("button[id^=delete]").click(function() {
		$("#idDeleteStudent").val(this.id.substring(6, this.id.length));
	});
</script>
</html>
