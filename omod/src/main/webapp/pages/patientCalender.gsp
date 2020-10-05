
<% ui.decorateWith("appui", "standardEmrPage")
    ui.includeJavascript("uicommons", "fullcalendar/fullcalendar.min.js")
    ui.includeJavascript("uicommons", "fullcalendar/gcal.js")
    ui.includeCss("uicommons", "fullcalendar/fullcalendar.css")
    ui.includeJavascript("uicommons", "moment-with-locales.min.js")
   %>
   

<script type="text/javascript">
  var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.escapeJs(ui.encodeHtmlContent(ui.format(patient.names))) }" ,
            link: "/" + OPENMRS_CONTEXT_PATH + '/coreapps/clinicianfacing/patient.page?patientId=${patient.uuid}'} ,
        { label: "${ ui.message("Protocal Calender Page")}" }
    ];

</script>


 <% patient.names.each { name -> %> 
           ${name} 
        <% } %>

<% if (innitialisedProtocal) { %>

<div style="margin-left:20px">
<p> Protocal :<b> ${innitialisedProtocal.protocol3.protocalName}</b></p>
<p> Start Date : <b> ${innitialisedProtocal.dateStarted} </b></p>
<p> End date : <b> ${innitialisedProtocal.dateStopped} </b> </p>
</div>


<script type="text/javascript">
  // var tes = '${patient.allergyStatus}';
  var dateStarted = '${innitialisedProtocal.dateStarted}';

   var datearr = dateStarted.split('-');
   var Startyear = datearr[0];
   var StartMonth = datearr[1];
   var dayArr= datearr[2];
   var startDay = dayArr.split(' ');
   var inntialDay = startDay[0];

   var intStartMonth = parseInt(StartMonth)- 1 ;

   var eventsArray =  ${events};

   var jq = jQuery;
    jq(document).ready(function() {
    
    //alert(JSON.stringify(eventsArray, null, 4));

    jq('#calendar').fullCalendar({
      header: {
        left: 'prev,next,today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
      },
      year: Startyear,
      month:intStartMonth,
      date: inntialDay,
      navLinks: true, 
      businessHours: true, 
      editable: true,
      selectable: true ,
      weekends: true ,
      selectHelper: true,
      dayClick: function(date, allDay, jsEvent, view) {

              if (allDay) {
                  // Clicked on the entire day
                  jq('#calendar')
                      .fullCalendar('changeView', 'agendaDay'/* or 'basicDay' */)
                      .fullCalendar('gotoDate',
                          date.getFullYear(), date.getMonth(), date.getDate());
              }
          }

    });

    for(let i = 0; i < eventsArray.length; i++){ 
        jq('#calendar').fullCalendar( 'renderEvent',eventsArray[i], true); 
     }


  });

</script>

<style>

  body {
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 980px;
    margin: 0 auto;
  }

</style>

<body>
<div id='calendar'></div>
</body>

<% } else { %>
<br>   <br>
Patient Not Innitialised A protocal
<% } %>