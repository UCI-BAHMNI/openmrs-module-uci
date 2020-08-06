<table>
<tr>
 <th>Protocal</th>
 <th>Protocal Name</th>
 <th>Diagnosis</th>
</tr>
<% if (protocals) { %>
   <% protocals.each { %>
    <tr>
      <td>${ ui.format(it.id) }</td>
      <td>${ ui.format(it.protocalName) }</td>
      <td>${ ui.format(it.diagnosis) }</td>
      <td><a href='${ ui.pageLink("ucionchology","phase") }?id=${ ui.format(it.id)}'><i class="icon-plus-sign edit-action" > </i></a></td>
    </tr>
  <% } %>
<% } else { %>
<tr>
  <td colspan="2">${ ui.message("general.none") }</td>
</tr>
<% } %>
</table>