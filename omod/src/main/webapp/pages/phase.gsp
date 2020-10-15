<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
var breadcrumbs = [
    { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' } ,
     { label: "${ ui.message("Create Phase Page")}" }
];
</script>

<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>


${ ui.includeFragment("ucionchology", "protocolDetails") }

<br>


<form id="phaseForm" method="post">

<fieldset id="create_phase" >
   
       <% if (protocol.isCyclic) { %>
           <% if (protocol.phase) { %>
              
                Cycle Created
             <% } else { %> 
             <legend>
                <p>Create Cycle </p>
              </legend>
      
              <input id='phaseName' type='hidden' name='phaseName' value='Cycle'/>
    
              <input id='protocol_id' type='hidden' name='protocol_id' value='${protocol.id}'/>
      
               <p >
                ${ ui.includeFragment("uicommons", "field/text", [ "id": "numberOfDays", "label": "Number Of Days", "formFieldName": "numberOfDays" ]) } 
              </p>
              <input id='Cycle' type='hidden' name='phase_order' value='1'/>

              <button id="submit" type="submit">Create Cycle</button>
             <% } %> 
        <% } else { %>
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
   
      <p>Set Order</p>
        <% orders.each {order -> %> 
          <input type="radio" id="${order}" name="phase_order" value="${order}">
          <label for="${order}">${order}</label><br>
        <% } %>
    </p>
     
     <button id="submit" type="submit">Create Phase</button>
     <% } %>

</fieldset>
</form>


${ ui.includeFragment("ucionchology", "phases") }

