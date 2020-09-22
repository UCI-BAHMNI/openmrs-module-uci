<% ui.decorateWith("appui", "standardEmrPage") %>

<script type="text/javascript">
var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.escapeJs(ui.encodeHtmlContent(ui.format(patient.patient))) }" ,
            link: '${ ui.urlBind("/" + contextPath + '/coreapps/clinicianfacing/patient.page', [ patientId: patient.uuid ] ) }'}
    ];
</script>

${patient.patient}
${ ui.includeFragment("ucionchology", "createPatientProtocal") }

${ ui.includeFragment("ucionchology", "viewPatientProtocal") }
