

<form id="patientProtocal" method="post">
<fieldset id="innitiate_protocol" >
    <legend>
      <p>Innitatiate Protocal For the Patient </p>
      </legend> 

       <input id='protocol_id'  name='patientId' value='${patient.uuid}'/>

       </p>
   
   <p>
   Select Protocal
   <input type="text" list="list" name ="protocalId" >
   
    <datalist id="list">
     <% protocals.each { prot -> %> 
          <option value="${prot.id}"> ${prot.protocalName} </option>
        <% } %>
    </datalist> 
    </p>
   
<button id="submit" type="submit">Start Protocal</button>
</fieldset>
</form>

</div>