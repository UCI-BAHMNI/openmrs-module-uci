<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
var breadcrumbs = [
    { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' } ,
     { label: "${ ui.message("Home Page")}" }
];
</script>

<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
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
    ${ ui.includeFragment("uicommons", "field/text", [ "id": "numberOfPhases", "label": "Number Of Phases/Cycles", "formFieldName": "numberOfPhases" ]) } 
   </p>

  <p>  
          <input type="radio" id="cyclic" name="isCyclic" value="true">
          <label for="cyclic">Cyclic </label><br>   

          <input type="radio" id="phase" name="isCyclic" value="false">
          <label for="phase">By Phase</label><br>      
    </p>

<button id="submit" type="submit">Create Protocol</button>
</fieldset>
</form>

${ ui.includeFragment("ucionchology", "protocals") }

</div>