//Clase creada con la finalidad de poder ordenar el arrayList

package Controlador;

import java.util.Comparator;

public class ComparatorNodo implements Comparator<Nodo>{ //implementa la interfaz comparator

    //Método de la interfaz comparator, que compara 2 elementos
    
    @Override
    public int compare(Nodo o1, Nodo o2) { //en este caso, se están comparando 2 nodos, exactamente la clave (indice) de estos
        if(o1.getClave()>o2.getClave()){
            return 1;
        }if(o1.getClave()<o2.getClave()){
            return -1;
        }
        return 0;
    }
    
}
