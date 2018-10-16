<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="form-inline justify-content-between">
	<div class="form-group">
		<a href="${pageContext.request.contextPath}/add_task" class="btn link-as-button">
			<span>Додати нове завдання</span></a>
	</div>
</div>
<hr></hr>
<div>
	<div class="table-responsive" >
	<table class="table table-bordered" >
	<thead>
	<tr>
		<td style="width:30%">Автор завдання</td>
		<td style="width:50%">Назва завдання</td>
		<td style="width:20%">Дaта виконання</td>
	</tr>
	</thead> 
	<tbody>
		<c:forEach items="${tasksModel}" var="task">
			<tr onclick="openWin('${pageContext.request.contextPath}/task${task.id}')" >
				<td class="borderTable">${task.autor}</td>
				<td class="borderTable">${task.name}</td>
				<td class="borderTable">${task.date}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</div>