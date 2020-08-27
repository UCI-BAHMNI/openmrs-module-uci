
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
    </tr>
     <tr>
      <td > 
        
               <table>
                <tr>                  
                     <td>
                     <div>
                     <p>Days</p>                
                 
                <% if (it.stageDay) { %>
               <% it.stageDay.each { %>
               <div style="margin-left:20px">
                  <ul style="list-style-type:disc">                  
                      <li>${ ui.format(it.dayNumber)}</li>                 
                  </ul> 
                         <% if (it.dosage) { %>
                         <% it.dosage.each { %>  
                                <div style="margin-left:20px">
                                   <ul style="list-style-type:square">                  
                                       <li>${ ui.format(it.drugName)}</li>                 
                                  </ul> 
                                 </div> 
                          <% } %>
                           <% } else { %>
                           <ul>
                                    No drug
                            </ul>
                             <% } %>
                </div>
              <% } %>
              <% } else { %>
               <ul>
                 <td colspan="3">${ ui.message("no day") }</td>
              </ul>
             <% } %>
              </div>
               </td> 
              </tr>
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