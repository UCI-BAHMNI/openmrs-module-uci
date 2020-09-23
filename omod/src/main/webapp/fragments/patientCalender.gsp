
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
      select: function(start, end) {
        var title = prompt('Enter Title');
        var eventData;
        if (title) {
          eventData = {
            title: title,
            start: start,
            end: end
          };
          jq('#calendar').fullCalendar('renderEvent', eventData, true); 
        }
        jq('#calendar').fullCalendar('unselect');
      }      
    });

    var event= {id:1 , title: 'New event', start: new Date()};

    for(let i = 0; i < eventsArray.length; i++){ 
        jq('#calendar').fullCalendar( 'renderEvent',eventsArray[i], true); 
     }
  });

</script>

<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }

</style>

<body>
<div id='calendar'></div>
</body>