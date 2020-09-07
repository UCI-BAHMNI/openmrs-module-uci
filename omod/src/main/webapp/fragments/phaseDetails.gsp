
<% if (phase) { %>
<div>
<p> Protocal : <b>${phase.protocol1.protocalName}</b> </p>
<p> Phase Name :<b>${phase.phaseName}</b> </p>
<p> Dignoses : <b><% phase.protocol1.diagnoses.each { %>
           <ul style="list-style-type:disc">                      
                 <li>${ ui.format(it.diagnosis) } </li>
           </ul>
          <% } %>
        </b> 
</p>
</div>

<% }  %>