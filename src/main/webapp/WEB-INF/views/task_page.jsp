<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-md-10">
	<div>
	     <div class="form-inline">
				<div class="form-group">
					<a href="${pageContext.request.contextPath}/task${taskShowModel.id}/edit" class="btn link-as-button">
					<span>Редагувати</span></a>
				</div>
				<div class="form-group">
					<a href="${pageContext.request.contextPath}/task${taskShowModel.id}/delete" class="btn link-as-button">
					<span>Видалити</span></a>
				</div>
				<div class="form-group">
					<a href="${pageContext.request.contextPath}/task${taskShowModel.id}/share" class="btn link-as-button">
					<span>Поширити</span></a>
				</div>											
  		</div>
  <hr></hr>	  	
	 <div class="form-group row">
    	<label class="col-sm-2 control-label">Автор:</label>
    		<div class="col-sm-10">
      			<span>${taskShowModel.autor}</span>
    		</div>
	</div>
     <div class="form-group row">
    	<label class="col-sm-2 control-label">Назва:</label>
    		<div class="col-sm-6">
      			<span>${taskShowModel.name}</span>
    		</div>
	</div>
     <div class="form-group row">
    	<label class="col-sm-2 control-label">Опис:</label>
    		<div class="col-sm-10">
      			<span>${taskShowModel.description}</span>
    		</div>
	</div>
		<div class="form-group row">
    		<label class="col-sm-2 control-label">Дата виконання:</label>
    			<div class="col-sm-10">
      				<span>${taskShowModel.date}</span>
    			</div>
		</div>	
		
	
</div>
</div>

