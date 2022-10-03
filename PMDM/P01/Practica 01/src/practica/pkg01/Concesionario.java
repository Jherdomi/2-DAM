package practica.pkg01;


/**
 *
 * @author Juan Fco Hernández Domínguez
 */
public class Concesionario {

    /**
     * @param args the command line arguments
     */
    
    //Se crean los automoviles precargados
    private static Automovil a1, a2;
    
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Accediendo al concesionario...");
        System.out.println("Cargando autos guardados anteriormente...");
        
        //Se rellenan los datos precargados
        a1 = new Automovil("Toyota", "Corola");
        a2 = new Automovil("Fiat", "500", 15000);
        
        //Inicio de la gestión
        gestionConcesionario();
        
    }
    
    private static void gestionConcesionario(){
        //Método que muestra los datos precargados al iniciar el programa
        estadoConcesionario();
        
        //Variable para el control del menú
        int op = 0;
        
        //Bucle que repite el menú hasta que se introduzca la opción para el menú
        do{
            System.out.println("--------------------------------------------");
            System.out.println("MENU");
            System.out.println("--------------------------------------------");
            System.out.println("1.- Ver marca de un automovil.");
            System.out.println("2.- Ver modelo de un automovil.");
            System.out.println("3.- Ver precio de un autovil.");
            System.out.println("4.- Cambiar modelo de un autovil.");
            System.out.println("5.- Establecer precio a un automovil.");
            System.out.println("6.- Listado de automoviles.");
            System.out.println("7.- Salir.");
            
            do{
                //Se pide la opción a elegir
                op = Terminal.leeEntero("Introduzca una opcion: ");
            }while(op < 0 || op > 7);
            //If que realiza la opción deseada
            switch (op) {
                case 1:
                    verMarca();
                    break;
                case 2:
                    verModelo();
                    break;
                case 3:
                    verPrecio();
                    break;
                case 4:
                    cambiarModelo();
                    break;
                case 5:
                    ponerPrecio();
                    break;
                case 6:
                    listadoAutomoviles();
                    break;
                default:
                    break;
            }
        }while(op != 7);
        
    }
    
    public static void estadoConcesionario(){
        
        //Se muestran los datos
        System.out.println("Mostrando datos:");
        System.out.println("---------------------------------------------------");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println("---------------------------------------------------");
    }
 
    public static void verMarca(){
        //Variables para la recogida de datos
        int auto = 1;
        String marca;
        
        //Se pide el auto a seleccionar
        auto = Terminal.leeEntero("¿Qué automovil quiere elegir? [1/2]: ");
        
        if(auto == 1){
            marca = a1.getMarca();
            System.out.println("\n---------------------------------------");
            System.out.println(marca);
            System.out.println("---------------------------------------");
        }else if (auto == 2){
            marca = a2.getMarca();
            System.out.println("\n---------------------------------------");
            System.out.println(marca);
            System.out.println("---------------------------------------");
        }else{
            System.out.println("---------------------------------------");
            Terminal.imprimeMensaje("ERROR: Solo hay 2 automoviles entre los que elegir.");
            System.out.println("---------------------------------------");
        }
    }
    
    public static void verModelo(){
        //Variables para la recogida de datos
        int auto = 1;
        String modelo;
        
        //Se pide el auto a seleccionar
        auto = Terminal.leeEntero("¿Qué automovil quiere elegir? [1/2]: ");
        
        if(auto == 1){
            modelo = a1.getModelo();
            System.out.println("\n---------------------------------------");
            System.out.println(modelo);
            System.out.println("---------------------------------------");
        }else if (auto == 2){
            modelo = a2.getModelo();
            System.out.println("\n---------------------------------------");
            System.out.println(modelo);
            System.out.println("---------------------------------------");
        }else{
            System.out.println("---------------------------------------");
            Terminal.imprimeMensaje("ERROR: Solo hay 2 automoviles entre los que elegir.");
            System.out.println("---------------------------------------");
        }
    }
    
     public static void verPrecio(){
         //Variables para la recogida de datos
        int auto = 1;
        int precio = 0;
        
        //Se pide el auto a seleccionar
        auto = Terminal.leeEntero("¿Qué automovil quiere elegir? [1/2]: ");
        
        if(auto == 1){
            precio = a1.getPrecio();
            System.out.println("\n---------------------------------------");
            System.out.println(precio);
            System.out.println("---------------------------------------");
        }else if (auto == 2){
            precio = a2.getPrecio();
            System.out.println("\n---------------------------------------");
            System.out.println(precio);
            System.out.println("---------------------------------------");
        }else{
            System.out.println("---------------------------------------");
            Terminal.imprimeMensaje("ERROR: Solo hay 2 automoviles entre los que elegir.");
            System.out.println("---------------------------------------");
        }
    }
     
    public static void cambiarModelo(){
        int auto = 1;
        String modelo;
        
        //Se pide el auto a seleccionar
        auto = Terminal.leeEntero("¿A qué automovil le quieres cambiar el modelo? [1/2]: ");
        
        //Se pide el modelo para proceder al cambio
        modelo = Terminal.leeCadena("Introduce un nuevo modelo: ");
        
        if(auto == 1){
            a1.setModelo(modelo);
        }else if (auto == 2){
            a2.setModelo(modelo);
        }else{
            System.out.println("---------------------------------------");
            Terminal.imprimeMensaje("ERROR: Solo hay 2 automoviles entre los que elegir.");
            System.out.println("---------------------------------------");
        }
    }
    
    public static void ponerPrecio(){
        int auto = 1;
        int precio;
        
        //Se pide el auto a seleccionar
        auto = Terminal.leeEntero("¿A qué automovil le quieres poner precio? [1/2]: ");
        
        //Se pide el precio para el cambio
        precio = Terminal.leeEntero("Introduce un precio para el automovil: ");
        
        if(auto == 1){
            if(precio >= a1.getPrecio()){
                a1.setPrecio(precio);
            }else{
                System.out.println("---------------------------------------");
                Terminal.imprimeMensaje("ERROR: El precio no puede ser inferior al anterior: " + a1.getPrecio() + "€.");
                System.out.println("---------------------------------------");
            }
        }else if (auto == 2){
            if(precio >= a2.getPrecio()){
                a2.setPrecio(precio);
            }else{
                System.out.println("---------------------------------------");
                Terminal.imprimeMensaje("ERROR: El precio no puede ser inferior al anterior: " + a2.getPrecio() + "€.");
                System.out.println("---------------------------------------");
            }
        }else{
            System.out.println("---------------------------------------");
            Terminal.imprimeMensaje("ERROR: Solo hay 2 automoviles entre los que elegir.");
            System.out.println("---------------------------------------");
        }
    }
    
    public static void listadoAutomoviles(){
        
        System.out.println("---------------------------------------");
        Terminal.imprimeMensaje("Se va a proceder a mostrar un listado de todos los automóviles...");
        System.out.println("---------------------------------------");
        
        System.out.println(a1);
        System.out.println(a2);
        System.out.println("---------------------------------------");
        
    }
    
}
