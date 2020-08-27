<table>
<tr>
 <th>Phase Id</th>
 <th>Phase Name</th>
 <th>Protocol Name</th>
</tr>
<% if (phases) { %>
   <% phases.each { %>
    <tr>
      <td>${ ui.format(it.id) }</td>
      <td>${ ui.format(it.phaseName) }</td>
      <td>${ ui.format(it.protocol1.protocalName) }</td>
      <td><a target="_blank" href='${ ui.pageLink("ucionchology","day") }?phaseId=${ ui.format(it.id)}' title="Add day"><i class="icon-share edit-action" > </i></a></td>
       <td><a target="_blank" href='${ ui.pageLink("ucionchology","drug") }?phaseId=${ ui.format(it.id)}' title="Add drugs"><i class="icon-share edit-action" > </i></a></td>
    </tr>
  <% } %>
<% } else { %>
<tr>
  <td colspan="3">${ ui.message("general.none") }</td>
</tr>
<% } %>
</table>