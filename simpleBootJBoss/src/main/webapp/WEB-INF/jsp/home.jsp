<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>

	<meta charset="utf-8" /> 
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>'>
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/datepicker/css/bootstrap-datepicker3.min.css"/>'>
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/select2/css/select2.min.css"/>'>
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/application/css/styles.css"/>'>	
	
	
		
	<script type='text/javascript' src='<c:url value="/resources/jquery/js/jquery-3.2.1.min.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/select2/js/select2.full.min.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/select2/js/i18n/es.js"/>'></script>	
	<script type='text/javascript' src='<c:url value="/resources/datepicker/js/bootstrap-datepicker.min.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/datepicker/locales/bootstrap-datepicker.es.min.js"/>'></script>	
	<script type='text/javascript' src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>	
</head>

<body>	
	<div class="jumbotron text-center">
		<h1>Hola Mundo bootstrap</h1>
		<p>Resize this responsive page to see the effect!</p>
	</div>

	<div class="container">
		<div class="alert alert-success">
	  		<strong>Success!</strong> Indicates a successful or positive action.
		</div>
	
		<div class="row">
			<div class="col-sm-12">
				<h3>Ejemplo</h3>
				<p>Lorem ipsum dolor..</p>
				<p>Ut enim ad..</p>
			</div>					
		</div>
		
		<div class="row">
			<div class='col-sm-2'>
	            <div class="form-group">
	                <div class='input-group date' id='datetimepicker1'>
	                    <input type='text' class="form-control" />
	                    <span class="input-group-addon">
	                        <span class="glyphicon glyphicon-calendar"></span>
	                    </span>
	                </div>
	            </div>
	        </div>	      
		</div>
		
				
		<div class="row">
			<div class='col-sm-4'>
	            <div class="form-group">
	                <div>
	                   <select id="provincias" class="btn-primary btn-select-light">
						  <option value="" selected="selected">Seleccione...</option>
						</select>
	                </div>
	            </div>
	        </div>	      
		</div>					
	</div>
		
		
	
	<script type="text/javascript">
		$(document).ready(function() {
			$.fn.select2.defaults.set('language', 'es');
										
			 $('#datetimepicker1').datepicker({language: "es"});
			
			
			$("#provincias").select2({				  
				ajax: {
				    url: "${request.contextPath}/provincias",
				    dataType: 'json',
				    delay: 250,
				    data: function (params) {
				      return {
				        q: params.term, // search term
				        page: params.page
				      };
				    },
				    processResults: function (data, params) {
				    	 return {
			                results: $.map(data, function (item) {
			                    return {
			                        text: item.nombre,
			                        slug: item.nombre,
			                        id: item.id
			                    }
			                })
			            };
				    },
				    cache: true
				  },
				  escapeMarkup: function (markup) { return markup; }, // let our custom formatter work
				  minimumInputLength: 1,				 
				});
		});
	</script>
</body>
</html>