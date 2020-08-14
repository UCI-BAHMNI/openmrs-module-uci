<table>
<tr>
 <th>day Id</th>
 <th>day Number</th>
 <th>Phase Name</th> 
 <th>Protocol Name</th>
</tr>
<% if (days) { %>
   <% days.each { %>
    <tr>
      <td>${ ui.format(it.id) }</td>
      <td>${ ui.format(it.dayNumber)}</td>
      <td>${ ui.format(it.phase.phaseName) }</td>
      <td>${ ui.format(it.phase.protocol1.protocalName) }</td>
      <td><a target="_blank" href='${ ui.pageLink("ucionchology","drug") }?dayId=${ ui.format(it.id)}' title="Complete day"><i class="icon-share edit-action" > </i></a></td>
    </tr>
  <% } %>
<% } else { %>
<tr>
  <td colspan="4">${ ui.message("general.none") }</td>
</tr>
<% } %>
</table>