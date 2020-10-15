<table>
<tr>
 
 <th>Protocal Name</th>
 <th>Number of Phases</th>
 <th>Is Cyclic</th>
</tr>
<% if (protocals) { %>
   <% protocals.each { %>
    <tr>
      <td>${ ui.format(it.protocalName) }</td>
      <td>${ ui.format(it.numberOfPhases) }</td>
      <td>${ ui.format(it.isCyclic) }</td>
      <td><a target="_blank" href='${ ui.pageLink("ucionchology","phase") }?id=${ ui.format(it.id)}' title="Complete Protocal"><i class="icon-share edit-action" > </i></a></td>
       <td><a target="_blank" href='${ ui.pageLink("ucionchology","viewProtocal")}?protocalId=${ ui.format(it.id)}' title="View Protocal"><i class="icon-eye-open edit-action" > </i></a></td>
      <td><a target="_blank" href='${ ui.pageLink("ucionchology","editProtocal")}?protocalId=${ ui.format(it.id)}' title="Edit Protocal"><i class="icon-edit edit-action" > </i></a></td>
       <td><a target="_blank" href='${ ui.pageLink("ucionchology","deleteProtocal")}?protocalId=${ ui.format(it.id)}' title="Delete Protocal"><i class="icon-remove edit-action" > </i></a></td>
    </tr>
  <% } %>
<% } else { %>
<tr>
  <td colspan="4">${ ui.message("general.none") }</td>
</tr>
<% } %>
</table>