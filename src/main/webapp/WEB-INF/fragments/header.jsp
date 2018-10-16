<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<sec:authorize access="!isAuthenticated()">
			<div class="col-md-9">
				<h2>
					Task Manager
				</h2>
			</div>
		<div class="col-md-3">
				 <ul class="nav navbar-nav">
					<li class="nav-item">
						<a class="nav-link" href="/login">Вхід</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/register">Реєстрація</a>
					</li>
				</ul>
			</div>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
			<div class="col-md-9">
			<h2>
				Task Manager
			</h2>
		</div>
		<div class="row col-md-3">
			<ul class="nav navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="/tasks">Мої завдання</a>
				</li>
				<!-- <li class="nav-item">
					<a class="nav-link" href="#">Мій профіль</a>
				</li> -->
				<li class="nav-item">
					<form:form action="/logout" method="post">
						<input type="submit" class= "btn btn-link btn_custom" value="Вихід">
					</form:form>
				</li>
				
			</ul>
		</div>
		
	</sec:authorize>
</div>

