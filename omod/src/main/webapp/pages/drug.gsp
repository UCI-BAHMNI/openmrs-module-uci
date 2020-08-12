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
       ${ ui.includeFragment("uicommons", "field/text", [ "id": "units", "label": "units", "formFieldName": "units" ])}  
   </p>
   
   <p >
   ${ ui.includeFragment("uicommons", "field/text", [ "id": "dosageValue", "label": "doze value", "formFieldName": "dosageValue" ])}  
  </p>
  
  <p >
  ${ ui.includeFragment("uicommons", "field/text", [ "id": "dosageForm", "label": "Drug Form", "formFieldName": "dosageForm" ])}  
 </p>
 
 <p >
 ${ ui.includeFragment("uicommons", "field/text", [ "id": "dosageFrequence", "label": "Frequence", "formFieldName": "dosageFrequence" ])}  
</p>
    
    <input id='dayId' type='hidden' name='dayId' value='${day.id}'/>

<button id="submit" type="submit">Add Drug</button>
</fieldset>
</form>

${ ui.includeFragment("ucionchology", "drugs") }