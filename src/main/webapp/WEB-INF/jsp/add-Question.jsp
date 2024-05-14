<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
 <div class="row">
  <div class="col-md-12 col-md-offset-0 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Add Question</div>
    <div class="panel-body">
     <form:form method="post" modelAttribute="add-Question">
      <form:hidden path="id" />
      <fieldset class="form-group">
       <form:label path="question">Question</form:label>
       <form:input path="question" type="text" class="form-control" autocomplete="off"
        required="required" />
       <form:errors path="question" cssClass="text-warning" />
      </fieldset>

      <fieldset class="form-group">
         <form:label path="answer">Answer</form:label>
         <form:textarea path="answer" rows="12" class="form-control" required="required" cssStyle="font-style:italic"/>
         <form:errors path="answer" cssClass="text-warning" />
        </fieldset>

      <fieldset class="form-group">
             <form:label path="category">Category</form:label>
             <form:select path="category" class="form-control">
                 <form:option value="JAVA" label="JAVA"/>
                 <form:option value="SPRING_BOOT" label="SPRING_BOOT"/>
                 <form:option value="DATABASE" label="DATABASE"/>
                 <form:option value="AWS" label="AWS"/>
                 <form:option value="MICROSERVICE" label="MICROSERVICE"/>
             </form:select>
             <form:errors path="category" cssClass="text-warning" />
        </fieldset>

      <%/*
      <fieldset class="form-group">
         <form:label path="subCategory">Sub Category</form:label>
         <form:input path="subCategory" type="text" class="form-control" autocomplete="off"
          required="required" />
         <form:errors path="subCategory" cssClass="text-warning" />
        </fieldset>
      */%>

      <button type="submit" class="btn btn-success">Save</button>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
<%@ include file="common/footer.jspf"%>