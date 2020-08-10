<%
    ui.decorateWith("appui", "standardEmrPage")
%>



${ ui.includeFragment("ucionchology", "dayDetails") }

<form id="dayForm" method="post">

<fieldset id="create_day" >
    <legend>
      <p>Add Drug</p>
      </legend>
    <p >
       ${ ui.includeFragment("uicommons", "field/text", [ "id": "dayNumber", "label": "Day Nymber", "formFieldName": "dayNumber" ])}  
   </p>
    
    <input id='pase_id' type = "hidden" name='phase_id' value='${phase.id}'/>

<button id="submit" type="submit">Add Drug</button>
</fieldset>
</form>

${ ui.includeFragment("ucionchology", "drugs") }