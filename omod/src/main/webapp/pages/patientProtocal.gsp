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
        { label: "${ ui.message("Protocal Page")}" }
    ];

</script>

<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>


 <% patient.names.each { name -> %> 
           ${name} 
        <% } %>

  ${ ui.includeFragment("ucionchology", "createPatientProtocal") }

 ${ ui.includeFragment("ucionchology", "viewPatientProtocal") }


 





    
