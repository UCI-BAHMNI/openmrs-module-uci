<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
var breadcrumbs = [
    { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' }
];
</script>


<div>

<form id="protocolForm" method="post">
	
<fieldset id="create_protocol" >
    <legend>
      <p>Create Protocal </p>
      </legend>
    <p >
       ${ ui.includeFragment("uicommons", "field/text", [ "id": "protocalName", "label": "Protocal Name", "formFieldName": "protocalName" ])}  
   </p>
   
    ${ ui.includeFragment("ucionchology", "diagnosis") }
   
    <p >
    ${ ui.includeFragment("uicommons", "field/text", [ "id": "numberOfPhases", "label": "Number Of Phases", "formFieldName": "numberOfPhases" ]) } 
   </p>

<button id="submit" type="submit">Create Protocol</button>
</fieldset>
</form>

${ ui.includeFragment("ucionchology", "users") }

</div>