var secuencia = [];
var nuevoNum, i, intervalID;

var pantallaInicio = document.getElementById("pantalla-inicio");
var pantallaJuego = document.getElementById("pantalla-juego");
var pantallaFin = document.getElementById("pantalla-fin");

var texto = document.getElementById("texto");
var resultado = document.getElementById("resultado");
var teclado = document.getElementsByClassName("num");
var cantidad_digitos = document.getElementById("digitos");

function jugar(){
	pantallaInicio.style.display = "none";
	pantallaJuego.style.display = "block";
	pantallaFin.style.display = "none";

	secuencia = [];

	comenzar();
}

function comenzar(){

	//genero un número aleatorio y lo guardo en el arreglo
	nuevoNum = Math.round(Math.random()*9);
	secuencia.push(nuevoNum);


	texto.innerHTML = "MEMORIZA LA SECUENCIA";
	resultado.innerHTML = "";

	//Muestro la secuencia de números en el arreglo
	i=0;
	//cada 1,3segundos muestro un nuevo numero de la secuencia
	intervalID = setInterval(mostrarSecuencia,1300);

}


function mostrarSecuencia(){
	//agrego la animación para el numero
	teclado[secuencia[i]].classList.add("show");

	//despues de .7s llamo a limpiarShow. Esta función quita la clase
	//show de todos los elementos
	setTimeout(limpiarShow,700);
	

	//compruebo si he llegado al final de la secuencia
	if(i==(secuencia.length-1)){//si llegue al final
		//detengo el timer
		clearInterval(intervalID);
		i=0;
		setTimeout(mensajeTuTurno, 1500);	
	} else{//en caso que no haya llegado al final
		i++;
	}
}

function limpiarShow(){
	for(j=0; j<=9;j++){
		teclado[j].classList.remove("show");
	}
}

function mensajeTuTurno(){
	texto.innerHTML = "TU TURNO";
}


//funcion que compara el mumero presionado del usuario con 
//con el correspondiente numero de la secuencia
function comparar(numSeleccionado){

	if(secuencia[i] == numSeleccionado.innerHTML){//numero correcto
		i++;
	} else { //numero incorrecto
		resultado.innerHTML = "INCORRECTO";
		resultado.style.color = "#772424"

		//espero 2.5s y muestro la pantalla final con el resultado
		setTimeout(mostrarPantallaFinal,2500);

	}

	//compruebo si llegue al final de la secuencia
	if(i==secuencia.length){ 
		resultado.innerHTML = "CORRECTO!!";
		resultado.style.color = "#0cff51";

		limpiarShow();

		//vuelvo a comenzar para insertar un nuevo numero en la secuencia
		setTimeout(comenzar,1000);
	}
}

function mostrarPantallaFinal(){
	pantallaInicio.style.display = "none";
	pantallaJuego.style.display = "none";
	cantidad_digitos.innerHTML = secuencia.length - 1;
	pantallaFin.style.display = "block";
}


































