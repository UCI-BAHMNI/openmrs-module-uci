<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script>
		function printDiv(divName){
			var printContents = document.getElementById(divName).innerHTML;
			var originalContents = document.body.innerHTML;
			document.body.innerHTML = printContents;
			window.print();
			document.body.innerHTML = originalContents;

		}
	</script>

<div id = 'print'>
${ ui.includeFragment("ucionchology", "dayDetails") }

${ ui.includeFragment("ucionchology", "drugs") }

</div>

<br>
<button onclick="printDiv('print')">Print Day details</button>