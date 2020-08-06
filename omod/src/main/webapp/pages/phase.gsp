<%
    ui.decorateWith("appui", "standardEmrPage")
%>

${ ui.includeFragment("ucionchology", "protocolDetails") }

<form id="phaseForm" method="post">

<fieldset id="create_protocol" >
    <legend>
      <p>Create Phase </p>
      </legend>
    <p >
       ${ ui.includeFragment("uicommons", "field/text", [ "id": "phaseName", "label": "Phase Name", "formFieldName": "phaseName" ])}  
   </p>
   
   <p> Protocol id</p>
    <input id='protocol_id'  name='protocol_id' value='${protocol.id}'/>
   
    <p >
    ${ ui.includeFragment("uicommons", "field/text", [ "id": "numberOfDays", "label": "Number Of Days", "formFieldName": "numberOfDays" ]) } 
   </p>
   
   <p >
   ${ ui.includeFragment("uicommons", "field/text", [ "id": "phase_order", "label": "Phase Order", "formFieldName": "phase_order" ]) } 
  </p>

<button id="submit" type="submit">Create Phase</button>
</fieldset>
</form>


${ ui.includeFragment("ucionchology", "phases") }

