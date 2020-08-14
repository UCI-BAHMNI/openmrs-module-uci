
<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
var breadcrumbs = [
    { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' }
];
</script>

<div>
<p>Protocal :<h2>${protocol.protocalName}</h2> </p>
<p> Diagnosis :<h2>${protocol.diagnosis}</h2> </p>
</div>

<table>
   <% if (protocol.phase) { %>
   <% protocol.phase.each { %>
    <tr>
      
      <th><h4> ${ ui.format(it.phaseName) } </h4> </th>
      <th><h4> ${ ui.format(it.protocol1.protocalName) } </h4> </th>
    </tr>
     <tr>
      <td colspan ="2"> 
        
               <table>
                <% if (it.stageDay) { %>
               <% it.stageDay.each { %>
                  <tr>
                     <td>${ ui.format(it.id) }</td>
                      <td>${ ui.format(it.dayNumber) }</td>                 
                  </tr>
              <% } %>
              <% } else { %>
               <tr>
                 <td colspan="3">${ ui.message("no day") }</td>
              </tr>
             <% } %>
         </table>
         
      </td>
     </tr>   
  <% } %>
<% } else { %>
<tr>
  <td colspan="3">${ ui.message("general.none") }</td>
</tr>
<% } %>
</table>