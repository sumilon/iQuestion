<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="/add-Question">Add Question</a>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Important Questions</h3>
  </div>
  <div class="panel-body">

   <table id="example" class="display" style="width:100%">
       <thead>
           <tr>
               <th></th>
               <th>Question</th>
               <th>Category</th>
               <th>Update</th>
               <th>Delete</th>
           </tr>
       </thead>
   </table>

  </div>
 </div>

</div>
<%@ include file="common/footer.jspf"%>