<div style="margin-left:20px">
<p> Protocal : <b>${protocol.protocalName}</b> </p>
<p> Diagnoses :  <b><% protocol.diagnoses.each { %>
           <ul style="list-style-type:disc">                      
                 <li>${ ui.format(it.diagnosis) } </li>
           </ul>
          <% } %>
        </b>  </p>
</div>