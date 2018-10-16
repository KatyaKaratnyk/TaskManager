
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="container">
<sec:authorize access="!isAuthenticated()">

<div class="col-md-4">
			<form:form action="/login"  method="POST">
				<div class="form-group">
					 
					<label>
						e-mail
					</label>
					<input class="form-control" id="email"  placeholder="e-mail" name="email" type="text"/>
				</div>
				<div class="form-group">
					 
					<label>
						Пароль
					</label>
					<input type="password" class="form-control" id="password" placeholder="пароль" name="password" type="password" value=""/>
				</div>
				<div class="checkbox">
					 
					<label>
						<input type="checkbox" /> запам'ятати мене
					</label>
				</div> 
				<input class="btn btn_custom" type="submit" value="Увійти">
			</form:form>
			
			<c:if test="${param.fail}">
				<p class="failLogin error">
					Ви вказали невірний логін або пароль
				</p>
			</c:if>
		</div>

	</sec:authorize>
	
</div>
<sec:authorize access="isAuthenticated()">
	<div class="col-md-1">
		<a href="${pageContext.request.contextPath}/add_task"><img alt="" src="${pageContext.request.contextPath}/resources/img/task.jpg"></a>
	</div>
</sec:authorize>