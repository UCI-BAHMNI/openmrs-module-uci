<% if (innitialisedProtocal) { %>
<div style="margin-left:20px">
<p> Protocal :<b> ${innitialisedProtocal.protocol3.protocalName}</b></p>
<p> Start Date : <b> ${innitialisedProtocal.dateStarted} </b></p>
<p> End date : <b> ${innitialisedProtocal.dateStopped} </b> </p>
</div>
<button style="margin-left:100px"><a target="_blank" href='${ ui.pageLink("ucionchology","patientCalender") }?patientId=${ ui.format(patient.uuid)}' title="Vie Patient Calender"><i class="icon-eye-open edit-action" > </i></a></button>
<% } else { %>
Patient Not Innitialised A protocal
<% } %>