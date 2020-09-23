<% if (innitialisedProtocal) { %>
<div>
<p> Protocal :<b> ${innitialisedProtocal.protocol3.protocalName}</b></p>
<p> Start Start : <b> ${innitialisedProtocal.dateStarted} </b></p>
<p> End Stoped : <b> ${innitialisedProtocal.dateStopped} </b> </p>
</div>
<% } else { %>
Patient Not Innitialised A protocal
<% } %>