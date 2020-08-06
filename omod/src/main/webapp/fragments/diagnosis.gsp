 <p>
   diagnosis
   <input type="text" list="list" name ="diagnosis" >
   </p>
   
   <datalist id="list">
       <% diagnoses.each { dg -> %> 
          <option value="${dg}">
        <% } %>
    </datalist>