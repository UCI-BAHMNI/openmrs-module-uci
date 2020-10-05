

<form id="patientProtocal" method="post">
<fieldset id="innitiate_protocol" >
    <legend>
      <p>Innitiate Protocal For the Patient </p>
      </legend> 

       <input id='protocol_id' hidden='true' name='patientId' value='${patient.uuid}'/>

       </p>
   
   <p>
   Select Protocal
   <input type="text" list="list" name ="protocalId_test" id="answerInput">
   
    <datalist id="list">
     <% protocals.each { prot -> %> 
          <option value="${prot.id}"> ${prot.protocalName} </option>
        <% } %>
    </datalist> 

    <input type="hidden" name="protocalId" id="answerInput-hidden">
    </p>
   
   <p>
     ${ ui.includeFragment("uicommons", "field/datetimepicker", [ "id": "startDateField", "label": "From Date", "formFieldName": "startDate", "defaultToday": true, "useTime": true ]) }
   </p>
<button id="submit" type="submit">Start Protocal</button>
</fieldset>
</form>


</div>

<script>
document.querySelector('#answerInput').addEventListener('input', function(e) {
    var input = e.target,   
        list = input.getAttribute('list'),
        options = document.querySelectorAll('#' + list + ' option[value="'+input.value+'"]'),
        hiddenInput = document.getElementById(input.getAttribute('id') + '-hidden');

    if (options.length > 0) {
      hiddenInput.value = input.value;
      input.value = options[0].innerText;
      }
});
</script>