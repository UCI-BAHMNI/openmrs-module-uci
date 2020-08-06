<table>
<tr>
 <th>Phase</th>
 <th>Phase Name</th>
 <th>Protocol Name</th>
</tr>
<% if (phases) { %>
   <% phases.each { %>
    <tr>
      <td>${ ui.format(it.id) }</td>
      <td>${ ui.format(it.phaseName) }</td>
      <td>${ ui.format(it.protocol1.protocalName) }</td>
    </tr>
  <% } %>
<% } else { %>
<tr>
  <td colspan="3">${ ui.message("general.none") }</td>
</tr>
<% } %>
</table>