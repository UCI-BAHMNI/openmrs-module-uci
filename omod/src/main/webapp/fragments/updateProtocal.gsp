<div>

<form id="protocolForm" method="post">
	
<fieldset id="edit_protocol" >
    <legend>
      <p>Edit Protocal </p>
      </legend>

      <input id='protocol_id' hidden='false' name='protocalId' value='${protocal.id}'/> 
    <p >

        Protocal Name <input id='protocalName'  name='protocalName' value='${protocal.protocalName}'/>   
   </p>
   
    ${ ui.includeFragment("ucionchology", "diagnosis") }
   
    <p >
      Number Of Phases/Cycles <input id='numberOfPhases'  name='numberOfPhases' value='${protocal.numberOfPhases}'/>   
   </p>

  <p>  
          <input type="radio" id="cyclic" name="isCyclic" value="true">
          <label for="cyclic">Cyclic </label><br>   

          <input type="radio" id="phase" name="isCyclic" value="false">
          <label for="phase">By Phase</label><br>      
    </p>

<button id="submit" type="submit">Update Protocol</button>
</fieldset>
</form>