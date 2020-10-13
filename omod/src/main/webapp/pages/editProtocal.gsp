<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
var breadcrumbs = [
    { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' } ,
     { label: "${ ui.message("Edit Protocal Page")}" }
];
</script>

${ ui.includeFragment("ucionchology", "updateProtocal") }

${ ui.includeFragment("ucionchology", "protocals") }