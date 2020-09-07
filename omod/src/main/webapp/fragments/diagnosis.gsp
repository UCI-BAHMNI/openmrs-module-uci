   <p>
   Diagnoses
   <select name="diagnoses" id="diagnoses" size="10" multiple>
       <% diagnoses.each { dg -> %> 
          <option value="${dg}"> ${dg} </option>
        <% } %>
   </select>
    </p>