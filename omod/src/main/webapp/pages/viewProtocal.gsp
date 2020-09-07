
<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
var breadcrumbs = [
    { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' }
];
</script>

<div style="margin-left:20px">
<p> Protocal : <b>${protocol.protocalName}</b> </p>
<p > Diagnosis : <b> <% protocol.diagnoses.each { %>
           <ul style="list-style-type:disc">                      
                 <li>${ ui.format(it.diagnosis) } </li>
           </ul>
          <% } %>  </b> </p>
        
</div>

<table>
   <% if (protocol.phase) { %>
   <% protocol.sortedPhases.each { %>
    <tr>  
      <td> Name : ${ ui.format(it.phaseName) }  &nbsp;&nbsp;&nbsp;&nbsp;  Order  :  ${ ui.format(it.phase_order) } </td>
      <th><a target="_blank" href='${ ui.pageLink("ucionchology","drug") }?phaseId=${ ui.format(it.id)}' title="Add drugs"> <i class="icon-medkit edit-action" > </i></a></th>
       <th><a target="_blank" href='${ ui.pageLink("ucionchology","action") }?phaseId=${ ui.format(it.id)}' title="Add Action"> <i class="icon-cogs edit-action" > </i></a></th>
    </tr>
     <tr>
      <td > 
        
               <table>
                <tr>                  
                     <td>
                     <div>               
                 
                <% if (it.sortedDays) { %>
               <% it.sortedDays.each { %>
               <div style="margin-left:20px ; border: 1px solid green" >
                 <p >
                  
                     <p> <a style="margin-left:10px"  target="_blank" href='${ ui.pageLink("ucionchology","viewDay") }?dayId=${ ui.format(it.id)}' title="View day"><b>Day ${ ui.format(it.dayNumber)} </b></a> </p>
                    
                       <table>
                           <tr>
                             <td>Drugs </td>
                              <td> Actions </td>
                           </tr>   
                          <tr>
                           <td>
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
                       
                             </td>
                               <td>
                             <% if (it.dayActions) { %>
                         <% it.dayActions.each { %>  
                                <div style="margin-left:20px">
                                   <ul style="list-style-type:square">                  
                                       <li>${ ui.format(it.description)}</li>                 
                                  </ul> 

                                 </div> 
                          <% } %>
                           <% } else { %>
                           <ul>
                                    No Action
                            </ul>
                             <% } %>
                        
                         </td>
                        </tr>  
                        </table> 
                        </p>
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