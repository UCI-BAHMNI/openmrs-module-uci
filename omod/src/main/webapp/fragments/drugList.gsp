   <p>
   select Drug
   <input type="text" list="list" name ="drugName" >
   </p>
   
   <datalist id="list">
       <% drugList.each { dg -> %> 
          <option value="${dg}">
        <% } %>
    </datalist>