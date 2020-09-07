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
   
 
    <input id='protocol_id' type='hidden' name='protocol_id' value='${protocol.id}'/>
   
    <p >
    ${ ui.includeFragment("uicommons", "field/text", [ "id": "numberOfDays", "label": "Number Of Days", "formFieldName": "numberOfDays" ]) } 
   </p>
   
    <p>
     <p>Set Order</p>
     <%orders.each {order -> %> 
          <input type="radio" id="${order}" name="phase_order" value="${order}">
          <label for="${order}">${order}</label><br>
        <% } %>
    </p>

<button id="submit" type="submit">Create Phase</button>
</fieldset>
</form>


${ ui.includeFragment("ucionchology", "phases") }

