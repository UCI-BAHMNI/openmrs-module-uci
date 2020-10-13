<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
var breadcrumbs = [
    { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' } ,
     { label: "${ ui.message("Action Page")}" }
];
</script>

<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>

 ${ ui.includeFragment("ucionchology", "drugProtocalDetails") }

<form id="ActionForm" method="post">

<fieldset id="create_Action" >
    <legend>
      <p>Add Action</p>
      </legend>
    
   <p >
   ${ ui.includeFragment("uicommons", "field/text", [ "id": "actionName", "label": "Action Name", "formFieldName": "actionName" ])}  
  </p>

   <p >
   ${ ui.includeFragment("uicommons", "field/text", [ "id": "description", "label": "Description", "formFieldName": "description" ])}  
  </p>

    <p>
     <p>Select days</p>
     <%actionPhaseDays.each {otherDay -> %> 
          <input type="checkbox" id="${otherDay.id}" name="days" value="${otherDay.id}">
          <label for="${otherDay.id}">${otherDay.dayNumber}</label><br>
        <% } %>
    </p>

<button id="submit" type="submit">Add Action</button>
</fieldset>
</form>