<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<div class="col-md-8">
<form:form method="POST" action="${pageContext.request.contextPath}/task${taskModel.id}/edit"  modelAttribute="taskModel">

		<div class="form-group row required">
    			<div class="col-md-12">
     			 	<label class="control-label col-sm-2" for="name">Назва:</label>
      				<form:input path="name" maxlength="50" size="500" class="form-control is-invalid" placeholder="Назва"></form:input>
					<form:errors  path="name" cssClass="error"></form:errors>
        		</div>
       		</div>
       		
    		<div class="form-group row required">
    			<div class="col-md-12">
     				 <label class="control-label col-sm-2" for="firstname">Опис:</label>
      				<form:textarea path="description" maxlength="1000" size="1000" type="text" rows="10" style="resize:none" class="form-control is-invalid" id="description" placeholder="Опис"></form:textarea>
					<form:errors  path="description" cssClass="error"></form:errors>
       			</div>
    		</div>   
    		
    		  <div class="form-group row">
    			<div class="col-md-12">
     			 	<label class="control-label col-sm-2" for="dateExecute">Дата виконання:</label>
      				<form:input type = "date" path="dateExecute" maxlength="50" size="500" class="form-control is-invalid" placeholder="Дата виконання"></form:input>
					<form:errors  path="dateExecute" cssClass="error"></form:errors>
        		</div>
   			</div> 
		    	
     	<div class="form-group row">
     		<div class="col-md-6 mb-3">
  				<button class="btn link-as-button" type="submit"><span>Зберегти</span></button>
  			</div>
  		</div>
	</form:form>
</div>