   <p>
   Diagnosis
   <p>
   <input type="text" list="list" name ="diagnoses" >
   
    <datalist id="list">
     <% diagnoses.each { dg -> %> 
          <option value="${dg}">
        <% } %>
    </datalist> 
    </p>