

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h1>Welcome ${name} </h1>
<hr>
<form:form action="" method="post"  modelAttribute="todo">
            <filedset class="mb-3">
            <form:label path="description">Description</form:label>
	  <form:input type="text"  path="description"   required="required"/>
	  <form:errors   path="description" cssClass="text-warning"/>
	  </filedset>
	  <br>
	  <filedset class="mb-3">
            <form:label path="targetdate">Targetdate</form:label>
	  <form:input type="text"  path="targetdate"   required="required"/>
	  <form:errors   path="targetdate" cssClass="text-warning"/>
	  </filedset>
	  
           <form:input type="hidden"  path="id"   />
           <form:input type="hidden"  path="done"  />
            <input type="submit" class="btn btn-success"/>
</form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
$('#targetdate').datepicker({
    format: 'yyyy-mm-dd'
});
</script>

