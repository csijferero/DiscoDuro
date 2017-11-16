/**
 * 
 */

var aleatorio = 0;
var intentos = 1;

function init() {
	var var1 = "Usu";
	var var2 = "Apel";

	var var3 = 5 / 0;

	var var4 = "4";
	var var5 = "5";

	// alert("Yo soy " + var1);
	// alert("Mis apellidos + 2 es igual a " + (var2 + 2));
	// alert("5/0= " + var3);
	// alert("4*5= " + (var4 + var5));

	aleatorio = parseInt(Math.random() * 10) + 1;
}

function calcularEdad() {
	var nombre = document.getElementById("nombre").value;
	var edad = document.getElementById("edad").value;

	var dias = edad * 365;

	document.getElementById("resultado").innerHTML = nombre + " tiene " + edad
			+ " años y en días son " + dias;
}

function calcularMayor(num1, num2) {
	var mensaje = "";
	if (num1 > num2) {
		mensaje = num1 + " es mayor que " + num2;
	} else if (num2 > num1) {
		mensaje = num2 + " es mayor que " + num1;
	} else {
		mensaje = num2 + " es igual que " + num1;
	}
	document.getElementById("mensaje").innerHTML = mensaje;
}

function mostrarFrase(frase, contador) {
	var texto = "";
	var i = 1;
	// while (i<=contador) {
	// texto += frase + "<br />";
	// i++;
	// }

	for (var j = 1; j <= contador; j++) {
		texto += frase + "<br />";
	}

	document.getElementById("mensaje2").innerHTML = texto;
}

function mostrarFacto() {
	var num = document.getElementById("facto").value;
	var fact = 1;
	for (var i = 1; i <= num; i++) {
		fact = fact * i;
	}
	document.getElementById("resFacto").innerHTML = fact;
}

function calcularPotencia() {
	var base = document.getElementById("base").value;
	var exponente = document.getElementById("exponente").value;
	var potencia = Math.pow(base, exponente);
	document.getElementById("potencia").innerHTML = potencia;
}

function adivinarNumero(numero) {
	if (intentos <= 5) {
		if (numero < aleatorio)
			document.getElementById("mensajeAdivinar").innerHTML = "El número es mayor";
		else if (numero > aleatorio)
			document.getElementById("mensajeAdivinar").innerHTML = "El número es menor";
		else
			document.getElementById("mensajeAdivinar").innerHTML = "Encontrado en "
					+ intentos + " intentos";
		intentos++;
	} else {
		document.getElementById("mensajeAdivinar").innerHTML = "No tiene más intentos";
	}
}

var contador = 0;
var suma = 0;
var producto = 1;

function calcularRepetido(numero) {
	if (numero != 9999) {
		contador++;
		suma += parseInt(numero);
		producto *= parseInt(numero);
		document.getElementById("numrep").focus();
	} else {
		// mostrar contador en el span resultadoRep
		document.getElementById("resultadoRep").innerHTML = "Nº Introducidos: "
				+ contador + " Suma: " + suma + " Producto: " + producto;

		contador = 0;
		suma = 0;
		producto = 1;

		document.getElementById("calcularRep").disabled = true;
	}
}

function reiniciarRepetido() {
	contador = 0;
	suma = 0;
	producto = 1;
	document.getElementById("calcularRep").disabled = false;
	document.getElementById("numrep").value = "";
	document.getElementById("numrep").focus();
	document.getElementById("resultadoRep").innerHTML = "";
}

function calcularMultiplos(numero) {
	var multiplos = new Array();
	var pos = 0;

	var objeto = document.getElementById("resultadoMult");
	objeto.innerHTML = "<p style='border: 1px solid black'>Múltiplos de "
			+ numero + "</p>";

	var i = 1;
	var cont = 0;
	objeto.innerHTML += "1 ";
	while (cont < 15) {
		if (i % numero == 0) {
			// objeto.innerHTML += i + " ";
			multiplos[pos] = i;
			pos++;
			cont++;
		}
		i++;
	}

	for (var i = 0; i < multiplos.length; i++) {
		objeto.innerHTML += multiplos[i] + " ";
	}
}

function calcularTabla(numero) {
	var objeto = document.getElementById("resultadoTabla");
	objeto.innerHTML = "";
	for (var i = 1; i <= 10; i++) {
		objeto.innerHTML += numero + "*" + i + " = " + (numero * i) + "<br />";
	}
}

function comprobarPrimo(numero) {
	var objeto = document.getElementById("resultadoPrimo");
	if (esPrimo(numero)) {
		objeto.innerHTML = "<p style='color: blue'>" + numero + " es PRIMO</p>";
	} else {
		objeto.innerHTML = "<p style='color: red'>" + numero
				+ " no es PRIMO</p>";
	}
}

function esPrimo(numero) {
	var resto;
	for (var i = 2; i < numero - 1; i++) {
		resto = numero % i;
		if (resto == 0) {
			return false;
		}
	}
	return true;
}

function pulsadoNumero(numero) {
	var resultado = document.getElementById("calcu");
	resultado.value += numero;
}

function pulsadoOperacion(op) {
	var resultado = document.getElementById("calcu");
	if (!resultado.value.length == 0 && comprobarUltimoCaracter()) {
		resultado.value += op;
	}
}

function pulsadoIgual() {
	var resultado = document.getElementById("calcu");
	resultado.value = eval(resultado.value);
}

function comprobarUltimoCaracter() {
	var resultado = document.getElementById("calcu").value;
	var ult = resultado.charAt(resultado.length - 1);
	if (ult != "+" && ult != "-" && ult != "*" && ult != "/")
		return true;
	else
		return false;
}

function comprobarVocales() {
	var campo = document.getElementById("textoVocales");
	// array de contadores
	var contadores = new Array(0, 0, 0, 0, 0);

	// total de vocales
	var totalVocales = 0;

	// recorrer el texto e ir comprobando
	for (var i = 0; i < campo.value.length; i++) {
		var caracter = campo.value.toLowerCase().charAt(i);
		var pos = posicionVocal(caracter);
		if (pos != -1) {
			contadores[pos]++;
			totalVocales++;
		}
	}

	var spanresult = document.getElementById("resultVocales");
	spanresult.innerHTML = "A: " + contadores[0] + "<br/>E: " + contadores[1]
			+ "<br/>I: " + contadores[2] + "<br/>O: " + contadores[3] + "<br/>U: "
			+ contadores[4] + "<br/>TOTAL: " + totalVocales;
	console.log(totalVocales);
	console.log(contadores);
}

function posicionVocal(caracter) {
	var vocales = new Array("a", "e", "i", "o", "u");
	for (var i = 0; i < vocales.length; i++) {
		if (vocales[i] == caracter) {
			return i;
		}
	}
	return -1;
}