<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-3">
	<form:form method="POST" action="${pageContext.request.contextPath}/register" modelAttribute="userAddRequestModel">
    
    	<div class="form-group row required">
    		<div class="col-md-12">
     			 <label class="control-label" for="lastname">Прізвище:</label>
      				<form:input path="lastName" maxlength="50" size="500" class="form-control" placeholder="Прізвище"></form:input>
					<form:errors  path="lastName" cssClass="error"></form:errors>
        	</div>
        </div>
    	<div class="form-group row required">
    		<div class="col-md-12">
     			 <label class="control-label" for="firstname">Ім'я:</label>
      				<form:input path="firstName" maxlength="50" size="500" class="form-control" placeholder="Ім'я"></form:input>
					<form:errors  path="firstName" cssClass="error"></form:errors>
       		</div>
    	</div>      
   		 <div class="form-group row required">
    		<div class="col-md-12">
     			 <label class="control-label" for="email">e-mail:</label>
      				<form:input path="email" maxlength="50" size="500" class="form-control is-invalid" id="email" placeholder="e-mail:"></form:input>
					<form:errors  path="email" cssClass="error"></form:errors>
        	</div>
   		</div>         
    	<div class="form-group row required">
    		<div class="col-md-12">
     			 <label class="control-label" for="password">Пароль:</label>
      				<form:password path="password" maxlength="50" size="500" class="form-control is-invalid" id="password" placeholder="Пароль"></form:password>
					<form:errors  path="password" cssClass="error"></form:errors>
        	</div>
    	</div>      
     	<div class="form-group row">
     		<div class="col-md-12">
  				<button class="btn link-as-button" type="submit">Реєстрація</button>
  			</div>
  		</div>
</form:form>
</div>
