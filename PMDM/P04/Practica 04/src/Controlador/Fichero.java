//Clase que va a trabajar con la entrada/salida de cuentas mediante un fichero

package Controlador;



import Modelo.Cuenta;
import java.io.*;

public class Fichero {

    static final String CARPETA = "./src/Datos"; //ruta donde se encuentra la carpeta
    static final String FICHERO= CARPETA+"/datos"; //ruta donde se encuentra el archivo 

    public static void crearCarpeta(){ //método que como su nombre indica crea una carpeta
        File carpeta = new File(CARPETA);

        if(!carpeta.exists()){
            System.out.println("CREANDO CARPETA");
            carpeta.mkdir();
        }
    }

    public static void subirDatos(Lista lista) throws IOException { //método que sube los datos del programa al fichero
            File fichero = new File(FICHERO); //Objeto tipo fichero en la ruta especificada

            fichero.createNewFile(); //crea el fichero si no existe
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero, false)); //escribirmos los datos en el fichero
                                                                                                   //false es para situarse al principio del fichero

            for(int i = 0; i< lista.getList().length;i++){ //recorro la lista
                Cuenta aux;
                if(lista.getList()[i] == null){ //si no hay un nodo, en esa posición de la lista
                    out.close(); //cierro el buffer de salida
                    return;//fuerza la salida 
                } else {
                    aux = (Cuenta) lista.getList()[i].getDato(); 
                    out.writeObject(aux); //esto escribe cuenta por cuenta
                }
            }
            out.close();
    }

    public static Lista cargarDatos() throws IOException, ClassNotFoundException{ //método que sube los datos del fichero al programa
        File fichero = new File(FICHERO);

        if(fichero.exists()){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichero)); //sacamos los datos del fichero
            Lista aux = new Lista(10);
            Cuenta Caux;
            int i;
            while(in.available() > 0){    //mientras el tamaño del archivo sea mayor que 0 
                i = 0;
                Caux = (Cuenta) in.readObject(); //introduce los datos en la cuenta auxiliar
                if(Caux == null){ //si es nulo, se fuerza la ejecución
                    break;
                }
                aux.insertarNodo(Caux.getNumeroCuenta(), Caux); //Si no, se inserta el nodo, con su numero de cuenta, y cuenta respectívamente
                i++;
            }
            in.close();
            return aux;
        }
        return null;
    }
}
