<table>
<tr>
 <th>drug Id</th>
 <th>drug Name</th>
 <th>drug units</th>
 <th>drug dose value</th>
 <th>Protocol Name</th>
 <th>Phase Name</th>
 </tr>
 <% if (drugs) { %>
    <% drugs.each { %>
     <tr>
       <td>${ ui.format(it.id) }</td>
       <td>${ ui.format(it.drugName) }</td>
       <td>${ ui.format(it.units)}</td>
       <td>${ ui.format(it.dosageValue) }</td>
       <td>${ ui.format(it.stageDay.phase.protocol1.protocalName) }</td>
       <td>${ ui.format(it.stageDay.phase.phaseName) }</td>
     </tr>
   <% } %>
 <% } else { %>
 <tr>
   <td colspan="6">${ ui.message("general.none") }</td>
 </tr>
 <% } %>
</table>