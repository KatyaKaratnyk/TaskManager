<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-3">

	<form:form method="POST" action="${pageContext.request.contextPath}/task${emailShareModel.id}/share" modelAttribute="emailShareModel">
		<div class="form-group row required">
    		<div class="col-md-12">
     			 <label class="control-label" for="email">e-mail користувача:</label>
      				<form:input path="email" maxlength="50" size="500" class="form-control" placeholder="email"></form:input>
					<form:errors  path="email" cssClass="error"></form:errors>
        	</div>
        </div>
		<div class="form-group row">
     		<div class="col-md-12">
  				<button class="btn link-as-button" type="submit">Поширити</button>
  			</div>
  		</div>
	</form:form>
	
	</div>
