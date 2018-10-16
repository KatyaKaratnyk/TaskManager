<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-3">
	<form:form method="POST" action="${pageContext.request.contextPath}/add_task" modelAttribute="taskAddRequestModel">
    
    	<div class="form-group row ">
    		<div class="col-md-12">
     			 <label class="control-label" for="name">Назва:</label>
      				<form:input path="name" maxlength="50" size="500" class="form-control" placeholder="Назва"></form:input>
					<form:errors  path="name" cssClass="error"></form:errors>
        	</div>
        </div>
    	<div class="form-group row required">
    		<div class="col-md-12">
     			 <label class="control-label" for="description">Опис:</label>
      				<form:textarea path="description" maxlength="1000" size="1000" type="text" rows="10" style="resize:none" class="form-control is-invalid" id="description" placeholder="Опис"></form:textarea>
					<form:errors  path="description" cssClass="error"></form:errors>
       		</div>
    	</div>      
   		 <div class="form-group row required">
    		<div class="col-md-12">
     			 <label class="control-label" for="dateExecute">Дата виконання:</label>
      				<form:input type = "date" path="dateExecute" maxlength="50" size="500" class="form-control is-invalid" placeholder="Дата виконання"></form:input>
					<form:errors  path="dateExecute" cssClass="error"></form:errors>
        	</div>
   		</div>     
     	<div class="form-group row">
     		<div class="col-md-12">
  				<button class="btn link-as-button" type="submit">Додaти</button>
  			</div>
  		</div>
</form:form>
</div>