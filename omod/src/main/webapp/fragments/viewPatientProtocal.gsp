<% if (innitialisedProtocal) { %>
<div>
<p> Protocal :<b> ${innitialisedProtocal.protocol3.protocalName}</b></p>
<p> Date Started : <b> ${innitialisedProtocal.dateStarted} </b></p>
<p> Date Stoped : <b> ${innitialisedProtocal.dateStopped} </b> </p>
</div>
<% } else { %>
Patient Not Innitialised A protocal
<% } %>