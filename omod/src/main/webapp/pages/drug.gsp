<%
    ui.decorateWith("appui", "standardEmrPage")
%>


<form id="drugForm" method="post">

<fieldset id="create_drug" >
    <legend>
      <p>Add Drug</p>
      </legend>
      ${ ui.includeFragment("ucionchology", "drugList") }
    
   <p >
   ${ ui.includeFragment("uicommons", "field/text", [ "id": "dosageValue", "label": "doze value", "formFieldName": "dosageValue" ])}  
  </p>

   <p >
   ${ ui.includeFragment("uicommons", "field/text", [ "id": "maxdosageValue", "label": "Maximum doze value", "formFieldName": "maxDoseValue" ])}  
  </p>
 
    <p>
     <p>Select days</p>
     <%phaseDays.each {otherDay -> %> 
          <input type="checkbox" id="${otherDay.id}" name="days" value="${otherDay.id}">
         <label for="vehicle1">${otherDay.dayNumber}</label><br>
        <% } %>
    </p>

<button id="submit" type="submit">Add Drug</button>
</fieldset>
</form>
