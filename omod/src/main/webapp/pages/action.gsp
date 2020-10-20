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
     <%day_phase.sortedDays.each {otherDay -> %> 
          <input type="checkbox" id="${otherDay.id}" name="days" value="${otherDay.id}">
          <label for="${otherDay.id}">${otherDay.dayNumber}</label><br>
        <% } %>
    </p>


     <% if (day_phase.protocol1.isCyclic) { %>
          <p>Select Cycle</p>
           <% 1.upto(day_phase.protocol1.numberOfPhases) { cyclesNumber ->%>
                 <input type="checkbox" id="${cyclesNumber}" name="cycleNumbers" value="${cyclesNumber}">
                 <label for="${cyclesNumber}">${cyclesNumber}</label><br>  
            <% } %>
    
      <% } %>

<button id="submit" type="submit">Add Action</button>
</fieldset>
</form>