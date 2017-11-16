function init() {
	localStorage.setItem("PROFILE_REAUTH_EMAIL", document
			.getElementById("inputEmail").value);
	if (document.getElementById("recordar").checked)
		localStorage.setItem("recordar",
				document.getElementById("inputEmail").value);
	else
		localStorage.removeItem("recordar");
}

function recordar() {
	if (localStorage.getItem("recordar") != null)
		document.getElementById("inputEmail").value = localStorage
				.getItem("recordar");
}

function loading() {
	if (!document.getElementById("recipient-name").checkValidity()) {
		document.getElementById("recipient-name").style.background = '#FFDDDD';
	} else
		document.getElementById("recipient-name").style.background = '#FFFFFF';
	if (!document.getElementById("message-text").checkValidity())
		document.getElementById("message-text").style.background = '#FFDDDD';
	else
		document.getElementById("message-text").style.background = '#FFFFFF';
	if (document.getElementById("recipient-name").checkValidity()
			&& document.getElementById("message-text").checkValidity()) {
		for (i = 0; i <= 100; ++i) {
			setDelay(i);
		}
	}

}

function setDelay(i) {
	setTimeout(function() {
		document.getElementById("progress-bar").style.width = i + '%';
	}, 50 * i + 1);
}

function outin() {
	$(document).ready(function() {
		$("#myTable").tablesorter({});
	});

	$(".navbar a").on("click", function() {
		$(".navbar").find(".active").removeClass("active");
		$(this).parent().addClass("active");
	});

	emailResult = localStorage.getItem("PROFILE_REAUTH_EMAIL");
	for (var i = 0; i < emailResult.length; i++) {
		if (emailResult[i] == '@')
			document.getElementById("emailLocal").innerHTML = emailResult
					.substring(0, i)
	}
	document.getElementById("recipient-name").value = emailResult;
}

function myFunction() {
	// Declare variables
	var input, filter, table, tr, td, i;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");

	// Loop through all table rows, and hide those who don't match the search
	// query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

function icon(n) {
	if (!document.getElementsByTagName("th")[n].getElementsByTagName("i")[0].classList
			.contains('visible')) {
		document.getElementsByTagName("th")[n].getElementsByTagName("i")[0].classList
				.add('fa-sort-asc');
		document.getElementsByTagName("th")[n].getElementsByTagName("i")[0].classList
				.remove('fa-sort-desc');
		document.getElementsByTagName("th")[n].getElementsByTagName("i")[0].classList
				.add('visible');
	} else {
		document.getElementsByTagName("th")[n].getElementsByTagName("i")[0].classList
				.remove('fa-sort-asc');
		document.getElementsByTagName("th")[n].getElementsByTagName("i")[0].classList
				.add('fa-sort-desc');
		document.getElementsByTagName("th")[n].getElementsByTagName("i")[0].classList
				.remove('visible');
	}

	for (var i = 0; i < document.getElementsByTagName("th").length; i++) {
		if (document.getElementsByTagName("th")[i].getElementsByTagName("i")[0].classList
				.contains('fa-sort-desc')
				&& n != i) {
			document.getElementsByTagName("th")[i].getElementsByTagName("i")[0].classList
					.remove('fa-sort-desc');
			document.getElementsByTagName("th")[i].getElementsByTagName("i")[0].classList
					.remove('visible');
		} else if (document.getElementsByTagName("th")[i]
				.getElementsByTagName("i")[0].classList.contains('fa-sort-asc')
				&& n != i) {
			document.getElementsByTagName("th")[i].getElementsByTagName("i")[0].classList
					.remove('fa-sort-asc');
			document.getElementsByTagName("th")[i].getElementsByTagName("i")[0].classList
					.add('visible');
		}
	}
}
