<div style="margin-left:20px">
<p> Protocal : <b>${day_phase.protocol1.protocalName} </b> </p>
<p> Phase   : <b> ${day_phase.phaseName} </b> </p>
<p> Diagnoses : <b> <% day_phase.protocol1.diagnoses.each { %>
           <ul style="list-style-type:disc">                      
                 <li>${ ui.format(it.diagnosis) } </li>
           </ul>
          <% } %> </b> </p>
</div>