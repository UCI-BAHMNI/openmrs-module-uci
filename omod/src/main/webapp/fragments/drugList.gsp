   <p>
   select Drug
   <input type="text" list="drugList" name ="drugName" >
   </p>
   
   <datalist id="drugList">
       <% drugList.each { dg -> %> 
          <option value="${dg}">
        <% } %>
    </datalist>

     <p>
   select Unit
   <input type="text" list="unitsList" name ="units" >
   </p>
   
   <datalist id="unitsList">
       <% unitsList.each { unit -> %> 
          <option value="${unit}">
        <% } %>
    </datalist>

     <p>
   select Route
   <input type="text" list="routesList" name ="routes" >
   </p>
   
   <datalist id="routesList">
       <%routesList.each { route -> %> 
          <option value="${route}">
        <% } %>
    </datalist>


      <p>
   select Frequence
   <input type="text" list="frequencyList" name ="dosageFrequence" >
   </p>
   
   <datalist id="frequencyList">
       <%frequecyList.each {frequency -> %> 
          <option value="${frequency}">
        <% } %>
    </datalist>