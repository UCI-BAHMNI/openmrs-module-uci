<%
    ui.decorateWith("appui", "standardEmrPage")
%>


${ ui.includeFragment("ucionchology", "dayDetails") }

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
    <input id='dayId'  name='dayId' value='${day.id}' readonly/>
   </p>

    <p>
     <p>Select Other days</p>
  <select name="otherDays" id="cars" multiple>
     <%phaseDays.each {otherDay -> %> 
          <option value="${otherDay.id}">${otherDay.dayNumber}</option>
        <% } %>
   </select>
    </p>

<button id="submit" type="submit">Add Drug</button>
</fieldset>
</form>

${ ui.includeFragment("ucionchology", "drugs") }