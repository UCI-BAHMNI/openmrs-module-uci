<table>
<tr>
 <th>Drug Id</th>
 <th>Drug Name</th>
 <th>Drug units</th>
 <th>Drug dose value</th>
 <th>Route</th>
 <th>Frequence</th>
 <th>Instruction</th>
 </tr>
 <% if (drugs) { %>
    <% drugs.each { %>
     <tr>
       <td>${ ui.format(it.id) }</td>
       <td>${ ui.format(it.drugName) }</td>
       <td>${ ui.format(it.units)}</td>
       <td>${ ui.format(it.dosageValue) }</td>
       <td>${ ui.format(it.dosageRoute) }</td>
       <td>${ ui.format(it.dosageFrequence) }</td>
       <td>${ ui.format(it.instructions) }</td>
       <td> <a target="_blank" href='${ ui.pageLink("ucionchology","deleteDrug") }?drugId=${ ui.format(it.id)}' title="Delete Drug"><i class="icon-remove edit-action" > </i></a></td>
     </tr>
   <% } %>
 <% } else { %>
 <tr>
   <td colspan="7">${ ui.message("No drugs") }</td>
 </tr>
 <% } %>
</table>

<br>
<b>ACTIONS </b>
<p>
<% if (actions) { %>
    <% actions.each { %>
       <div style="margin-left:20px">
                     <ul style="list-style-type:square">                  
                          <li>${ ui.format(it.description)} <a target="_blank" href='${ ui.pageLink("ucionchology","deleteAction") }?actionId=${ ui.format(it.id)}' title="Delete Action"><i class="icon-remove edit-action" > </i></a> </li>                                        
                     </ul> 
       </div> 
   <% } %>
 <% } else { %>
   ${ ui.message("No Actions") }
 <% } %>

 </p>