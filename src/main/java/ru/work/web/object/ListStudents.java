package ru.work.web.object;

import java.util.List;

public class ListStudents {
	
	private List<Student> students;
	private String table = "";
	
	public String getTable() {
		table = "";
		if(students != null){
			table += getOpenTable();
			for (int i = 0; i < students.size(); i++) {
				Student student = students.get(i);
				table += getBodyTable(i, student);
			}
			table += getCloseTable();
			table += getAddBtn();
		}else
		table = "<tr><td><h3>Нет подключения к базе данных</h3></td></tr>";
		return table;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	private String getSuccesBtn(int id){
		return "<button id='update" + id + "' class='btn btn-success' data-toggle='modal' data-target='#myUpdateModal'>Изменить</button>";
	}
	private String getDeleteBtn(int id){
		return "<button id='delete" + id + "' class='btn btn-danger' data-toggle='modal' data-target='#myDeleteModal'>Удалить</button>";
	}
	private String getAddBtn(){
		return "<button data-toggle='modal' data-target='#myModal' class='btn btn-info'>Добавить ученика</button>";
	}
	private String getOpenTable(){
		return "<table class='table'>" +
				"<thead><tr>" + 
				"<th>№</th>" + 
				"<th>Имя</th>" + 
				"<th>Фамилия</th>" + 
				"<th>Номер телефона</th>" + 
				"<th>Дата рождения</th>" + 
				"</tr></thead>" + 
				"<tbody>";
	}
	private String getCloseTable(){
		return "</tbody></table>";
	}
	private String getBodyTable(int i, Student student){
		return "<tr>" +
				"<td>" + (i + 1) + "</td>" + 
				"<td>" + student.getFirstname() + "</td>" +
				"<td>"+ student.getLastname() +"</td>" +
				"<td>"+ student.getPhone() +"</td>" +
				"<td>"+ student.getDateofbirth() +"</td>" +
				"<td>" + getSuccesBtn(student.getId()) + "</td>" +
				"<td>" + getDeleteBtn(student.getId()) + "</td>" +
			"</tr>";
	}
}
