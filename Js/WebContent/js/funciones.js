function mostrarEdad() {
	document.getElementById("miedad").innerHTML = document
			.getElementById("edad").value;
}

function esCorrectoEmail(mail) {
	return /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(mail);
}

function validarEmail(campo) {
	if (!esCorrectoEmail(campo.value)) {
		mostrarErrorConSpan(campo.id, "Error: Email incorrecto");
	} else {
		eliminarErrorConSpan(campo.id);
	}
}

function validarDNI(campo) {
	valor = campo.value;
	var letras = [ 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
			'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T' ];
	// Comprobar formato (8 números y 1 letra)
	if (!(/^\d{8}[A-Z]$/.test(valor))) {
		return false;
	}
	// Comprobar letra correcta
	if (valor.charAt(8) != letras[(valor.substring(0, 8)) % 23]) {
		return false;
	}
}

function validarTelefono(campo) {
	valor = campo.value;
	// nueve dígitos consecutivos y sin espacios ni guiones entre las cifras
	if (!(/^\d{9}$/.test(valor))) {
		return false;
	}

}

function validar(campo) {
	if (campo.value == null || campo.value.length == 0
			|| /^\s+$/.test(campo.value)) {
		mostrarError(campo.id, "Error: Nombre Vacío")
	} else {
		eliminarError(campo.id);
	}
}

function validarConSpan(campo) {
	if (campo.value == null || campo.value.length == 0
			|| /^\s+$/.test(campo.value)) {
		mostrarErrorConSpan(campo.id, "Error: Apellidos Vacío")
	} else {
		eliminarErrorConSpan(campo.id);
	}
}

function validarEdad(campo) {
	valor = campo.value;
	if (isNaN(valor)) {
		mostrarErrorConSpan(campo.id, "Error: Edad debe ser número")
	} else {
		eliminarErrorConSpan(campo.id);
	}
}

function mostrarError(idCampo, texto) {
	if (document.getElementById("errorNombre") == null) {
		var nuevo_parrafo = document.createElement("span");
		nuevo_parrafo.id = "errorNombre";
		nuevo_parrafo.style = "color: red";
		nuevo_parrafo.appendChild(document.createTextNode(texto));
		insertAfter(document.getElementById(idCampo), nuevo_parrafo);
	}
}

function mostrarErrorConSpan(idCampo, texto) {
	var spancampo = document.getElementById("sp" + idCampo);
	spancampo.innerHTML = texto;
}

function eliminarError(idCampo) {
	document.getElementById("td" + idCampo).removeChild(
			document.getElementById("errorNombre"));
}

function eliminarErrorConSpan(idCampo) {
	document.getElementById("sp" + idCampo).innerHTML = "";
}

function insertAfter(nodoInicial, nodoInsertar) {
	if (nodoInicial.nextSibling) {
		nodoInicial.parentNode.insertBefore(nodoInsertar,
				nodoInicial.nextSibling);
	} else {
		nodoInicial.parentNode.appendChild(nodoInsertar);
	}
}

function validarFormulario() {
	var correcto = false;

	// valores del radiobutton
	var elementos = document.getElementsByName("estado");
	for (var i = 0; i < elementos.length; i++) {
		alert(" Elemento: " + elementos[i].value + "\n Seleccionado: "
				+ elementos[i].checked);
	}

	var elemento = document.getElementById("condiciones");
	alert(" Elemento: " + elemento.value + "\n Seleccionado: "
			+ elemento.checked);
	elemento = document.getElementById("privacidad");
	alert(" Elemento: " + elemento.value + "\n Seleccionado: "
			+ elemento.checked);

	// select
	// Obtener la referencia a la lista
	var lista = document.getElementById("ciudades");
	// Obtener el índice de la opción que se ha seleccionado
	var indiceSeleccionado = lista.selectedIndex;
	// Con el índice y el array "options", obtener la opción seleccionada
	var opcionSeleccionada = lista.options[indiceSeleccionado];
	// Obtener el valor y el texto de la opción seleccionada
	var textoSeleccionado = opcionSeleccionada.text;
	var valorSeleccionado = opcionSeleccionada.value;
	alert("Opción seleccionada: " + textoSeleccionado
			+ "\n Valor de la opción: " + valorSeleccionado);

	// normalmente se abrevian todos los pasos necesarios en una única
	// instrucción
	var lista = document.getElementById("ciudades");
	// Obtener el valor de la opción seleccionada
	var valorSeleccionado = lista.options[lista.selectedIndex].value;
	// Obtener el texto que muestra la opción seleccionada
	var valorSeleccionado = lista.options[lista.selectedIndex].text;

	// validar que se ha seleccionado un elemento de la lista
	indice = document.getElementById("ciudades").selectedIndex;
	if (indice == null || indice == 0) {
		return false;
	}

	return correcto;
}

function limita(maximoCaracteres) {
	var elemento = document.getElementById("texto");
	if (elemento.value.length >= maximoCaracteres) {
		return false;
	} else {
		return true;
	}
}