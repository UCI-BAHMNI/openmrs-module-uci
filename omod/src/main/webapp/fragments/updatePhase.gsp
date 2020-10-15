
<form id="phaseForm" method="post">
	
<fieldset id="edit_phase" >
    <legend>
      <p>Edit Phase</p>
  </legend>

<input id='phase_id' hidden='false' name='phaseId' value='${phase.id}'/> 

<p> Phase name <input id='phaseName'  name='phaseName' value='${phase.phaseName}'/> </p>

<p> Current Order  ${phase.phase_order} </p>

<p>Set new Order </p>
 <p>
        
        <% orders.each {order -> %> 
          <input type="radio" id="${order}" name="phase_order" value="${order}">
          <label for="${order}">${order}</label><br>
        <% } %>
</p>

<button id="submit" type="submit">Update Phase</button>
</fieldset>
</form>