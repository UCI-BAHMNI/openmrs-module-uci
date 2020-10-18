
<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
var breadcrumbs = [
    { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' }
];
</script>

<script>
		function printDiv(divName){
			var printContents = document.getElementById(divName).innerHTML;
			var originalContents = document.body.innerHTML;
			document.body.innerHTML = printContents;
			window.print();
			document.body.innerHTML = originalContents;
		}
	</script>

<div id='print'>
<div style="margin-left:20px">
<p> Protocal : <b>${protocol.protocalName}</b> </p>
<p > Diagnosis : <b> <% protocol.diagnoses.each { %>
           <ul style="list-style-type:disc">                      
                 <li>${ ui.format(it.diagnosis) } </li>
           </ul>
          <% } %>  </b> </p>
        
</div>

<table>
    <% if (protocol.isCyclic) { %>
     <% 1.upto(protocol.numberOfPhases) { cycles ->%>
         
              <% protocol.sortedPhases.each { %>
                <tr>  
                  <td> Name : Cycle ${cycles} &nbsp;&nbsp;&nbsp;&nbsp; <a target="_blank" href='${ ui.pageLink("ucionchology","deletePhase") }?phaseId=${ ui.format(it.id)}' title="Edit Phase"><i class="icon-remove edit-action" > </i></a> </td>
                  <th style="width: 1%;"><a target="_blank" href='${ ui.pageLink("ucionchology","drug") }?phaseId=${ ui.format(it.id)}' title="Add drugs"> <i class="icon-medkit edit-action" > </i></a></th>
                  <th style="width: 1%;"><a target="_blank" href='${ ui.pageLink("ucionchology","action") }?phaseId=${ ui.format(it.id)}' title="Add Action"> <i class="icon-cogs edit-action" > </i></a></th>
                </tr>
                <tr>
                  <td colspan='3'> 
                    
                          <table>
                            <tr>                  
                                <td>
                                <div>               
                            
                            <% if (it.sortedDays) { %>
                          <% it.sortedDays.each { sortedDay -> %>
                          <div style="margin-left:20px ; border: 1px solid green" >
                            <p >
                              
                                <p> <a style="margin-left:10px"  target="_blank" href='${ ui.pageLink("ucionchology","viewDay") }?dayId=${ ui.format(it.id)}' title="View day"><b>Day ${ ui.format(sortedDay.dayNumber)} </b></a>  
                                  &nbsp;&nbsp;&nbsp;&nbsp;
                                   <a style="margin-left:10px"   target="_blank" href='${ ui.pageLink("ucionchology","deleteDay") }?dayId=${ ui.format(it.id)}' title="Delete day"><i class="icon-remove edit-action" ></i></a> 

                                </p>
                               
                              
                                  <table>
                                      <tr>
                                        <td>Drugs </td>
                                        <td> Actions </td>
                                      </tr>   
                                      <tr>
                                      <td>
                                    <% if (sortedDay.dosage) { %>
                                    <% sortedDay.dosage.each { %>  
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
                                        <% if (sortedDay.dayActions) { %>
                                        <% sortedDay.dayActions.each {act-> %>  
                                            
                                              <% if (act.cycleNumber == cycles ) { %>
                                                <div style="margin-left:20px">
                                                  <ul style="list-style-type:square">                  
                                                      <li>${ ui.format(act.description)}</li>                 
                                                  </ul> 
                                              <% } %>
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
           

          <% } %>

     <% } else { %>
            <% if (protocol.phase) { %>
              <% protocol.sortedPhases.each { %>
                <tr>  
                  <td> Name : ${ ui.format(it.phaseName) }  &nbsp;&nbsp;&nbsp;&nbsp;  Order  :  ${ ui.format(it.phase_order) }  &nbsp;&nbsp;&nbsp;&nbsp;
                  <a target="_blank" href='${ ui.pageLink("ucionchology","editPhase") }?phaseId=${ ui.format(it.id)}' title="Edit Phase"><i class="icon-edit edit-action" > </i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                 <a target="_blank" href='${ ui.pageLink("ucionchology","deletePhase") }?phaseId=${ ui.format(it.id)}' title="Edit Phase"><i class="icon-remove edit-action" > </i></a>
                  </td>
                  <th style="width: 1%;" ><a target="_blank" href='${ ui.pageLink("ucionchology","drug") }?phaseId=${ ui.format(it.id)}' title="Add drugs"> <i class="icon-medkit edit-action" > </i></a></th>
                  <th style="width: 1%;"><a target="_blank" href='${ ui.pageLink("ucionchology","action") }?phaseId=${ ui.format(it.id)}' title="Add Action"> <i class="icon-cogs edit-action" > </i></a></th>
                </tr>
                <tr>
                  <td colspan='3'> 
                    
                          <table>
                            <tr>                  
                                <td>
                                <div>               
                            
                            <% if (it.sortedDays) { %>
                          <% it.sortedDays.each { %>
                          <div style="margin-left:20px ; border: 1px solid green" >
                            <p >
                              
                                <p> <a style="margin-left:10px"  target="_blank" href='${ ui.pageLink("ucionchology","viewDay") }?dayId=${ ui.format(it.id)}' title="View day"><b>Day ${ ui.format(it.dayNumber)} </b></a> 
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                 <a style="margin-left:10px"   target="_blank" href='${ ui.pageLink("ucionchology","deleteDay") }?dayId=${ ui.format(it.id)}' title="Delete day"><i class="icon-remove edit-action" ></i></a> 
                                </p>
                                
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
         
     <% } %>
</table>
</div>
<br>
<button onclick="printDiv('print')">Print Protocal</button>