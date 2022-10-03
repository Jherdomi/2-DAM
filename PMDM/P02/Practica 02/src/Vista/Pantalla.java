package Vista;

import java.awt.*;
import static java.awt.BorderLayout.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.text.*;

import Modelo.*;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Pantalla extends JFrame{
    
    //Variable para saber que cuenta es la actual
    private static Cuenta actual;
    
    //Se añaden 5 cuentas
    Cuenta c1 = new Cuenta(toString(new GregorianCalendar()), 1220.00f, "Juan José");
    Cuenta c2 = new Cuenta(toString(new GregorianCalendar()), 10.00f, "Juan");
    Cuenta c3 = new Cuenta(toString(new GregorianCalendar()), 120.00f, "José");
    Cuenta c4 = new Cuenta(toString(new GregorianCalendar()), 220.00f, "Maria");
    Cuenta c5 = new Cuenta(toString(new GregorianCalendar()), 122.00f, "Pepe");
    
    //Contenido de las etiquetas
    private static final String titString = "GESTIÓN DE CUENTAS";
    private static final String numString = "Numero: ";
    private static final String fecString = "Fecha: ";
    private static final String salString = "Sueldo: ";
    private static final String propString = "Propiedad: ";
    
    //Labels para que quede bonito
    private final JLabel titField;
    private final JLabel numField;
    private final JLabel fecField;
    private final JLabel salField;
    private final JLabel propField;
    
    //TextFields para la recogida y muestra de datos
    private final TextField numTextFiled;
    private final TextField fecTextFiled;
    private final TextField salTextFiled;
    private final TextField propTextFiled;
    
    //Botones para el control de la APK
    private JButton botonSiguiente;
    private JButton botonAnterior;
    private JButton botonCrear;
    private JButton botonAceptar;
    private JButton botonCancelar;
    
    //Paneles que contendran los elementos o los demás paneles
    private final JPanel contentPanel;
    private final JPanel panelTitulo;
    private final JPanel panelFileds;
    private final JPanel panelTextFileds;
    private final JPanel panelButton;
    private final JPanel panelBoton2;
    
    public Pantalla(){
        super("Cuentas Banco");
        
        //Asignamos el actual a la primera cuenta
        actual = Cuenta.getFirst();
        
        //Crea las etiquetas
        titField = new JLabel(titString);
        numField = new JLabel(numString);
        fecField = new JLabel(fecString);
        salField = new JLabel(salString);
        propField = new JLabel(propString);
        
        //Crea los textFields
        numTextFiled = new TextField("", 30);
        numTextFiled.setBackground(Color.LIGHT_GRAY);
        numTextFiled.setFont(new Font("Arial", Font.PLAIN, 20));
        
        fecTextFiled = new TextField();
        fecTextFiled.setBackground(Color.LIGHT_GRAY);
        fecTextFiled.setFont(new Font("Arial", Font.PLAIN, 20));
        
        salTextFiled = new TextField();
        salTextFiled.setBackground(Color.LIGHT_GRAY);
        salTextFiled.setFont(new Font("Arial", Font.PLAIN, 20));
        
        propTextFiled = new TextField();
        propTextFiled.setBackground(Color.LIGHT_GRAY);
        propTextFiled.setFont(new Font("Arial", Font.PLAIN, 20));
        
        numTextFiled.setEditable(false);
        numTextFiled.setFocusable(false);
        fecTextFiled.setEditable(false);
        fecTextFiled.setFocusable(false);
        salTextFiled.setEditable(false);
        salTextFiled.setFocusable(false);
        propTextFiled.setEditable(false);
        propTextFiled.setFocusable(false);

        //Crea los Botones
        botonSiguiente = new JButton("Siguiente");
        botonAnterior = new JButton("Anterior");
        botonCrear = new JButton("Crear");
        botonAceptar = new JButton("Aceptar");
        botonCancelar = new JButton("Cancelar");
        
        //Panel para el titulo
        panelTitulo = new JPanel();
        panelTitulo.setLayout(new GridLayout(0, 1));
        panelTitulo.add(titField);
       
        //Panel para los elementos
        panelFileds = new JPanel();
        panelFileds.setLayout(new GridLayout(0, 1));
        panelFileds.add(numField);
        panelFileds.add(fecField);
        panelFileds.add(salField);
        panelFileds.add(propField);
        
        
        //Panel para los textFields
        panelTextFileds = new JPanel();
        panelTextFileds.setLayout(new GridLayout(0, 1));
        panelTextFileds.add(numTextFiled);
        panelTextFileds.add(fecTextFiled);
        panelTextFileds.add(salTextFiled);
        panelTextFileds.add(propTextFiled);
        
        //Panel para los botones
        panelButton = new JPanel();
        panelButton.setLayout(new BorderLayout());
        panelButton.setBackground(Color.getHSBColor(0.47f, 0.32f, 0.78f));
        panelButton.add(botonAnterior, WEST);
        panelButton.add(botonCrear, CENTER);
        panelButton.add(botonSiguiente, EAST);
        
        //Panel Botones Auxiliares
        panelBoton2 = new JPanel();
        panelBoton2.setLayout(new BorderLayout());
        panelBoton2.setBackground(Color.getHSBColor(0.47f, 0.32f, 0.78f));
        panelBoton2.add(botonAceptar, WEST);
        panelBoton2.add(botonCancelar, EAST);
        
        //Panel general
        contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(panelTitulo, BorderLayout.NORTH);
        contentPanel.add(panelFileds, BorderLayout.CENTER);
        contentPanel.add(panelTextFileds, BorderLayout.EAST);
        contentPanel.add(panelButton, BorderLayout.SOUTH);
        
        this.setContentPane(contentPanel);
        
        numTextFiled.setText(String.valueOf(actual.getNumero()));
        fecTextFiled.setText(actual.getFecha());
        salTextFiled.setText(String.valueOf(actual.getSaldo()) + " €");
        propTextFiled.setText(actual.getProp());
        botonAnterior.setEnabled(false);

        
        botonCrear.addActionListener(new ActionListener() {  // Evento de boton.
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.remove(panelButton);
                contentPanel.validate();
                contentPanel.add(panelBoton2, SOUTH);
                contentPanel.validate();
                
                salTextFiled.setEditable(true);
                salTextFiled.setFocusable(true);
                propTextFiled.setEditable(true);
                propTextFiled.setFocusable(true);
                
                numTextFiled.setText(String.valueOf(actual.getNumero()+1));
                fecTextFiled.setText(Pantalla.toString(new GregorianCalendar()));
                salTextFiled.setText("");
                propTextFiled.setText("");
            }
        });
        
        botonCancelar.addActionListener(new ActionListener() {  // Evento de boton.
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.remove(panelBoton2);
                contentPanel.validate();
                contentPanel.add(panelButton, SOUTH);
                contentPanel.validate();
                
                salTextFiled.setEditable(false);
                salTextFiled.setFocusable(false);
                propTextFiled.setEditable(false);
                propTextFiled.setFocusable(false);
                
                numTextFiled.setText(String.valueOf(actual.getNumero()));
                fecTextFiled.setText(actual.getFecha());
                salTextFiled.setText(String.valueOf(actual.getSaldo()) + " €");
                propTextFiled.setText(actual.getProp());
                
            }
        });
        
        botonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                if (actual.getPrevious() == null) 
                    //Si estamos en el primer objeto, se desactiva el boton
                    botonAnterior.setEnabled(false);
                else {
                    //Sino, se pasa al anterior
                    actual = actual.getPrevious();
                    if (!botonSiguiente.isEnabled())
                        // Si el botón "Siguiente" está desactivado, se activa
                        botonSiguiente.setEnabled(true);
                    if (actual.getPrevious() == null)
                        //Comprobamos si estamos en el primero
                        botonAnterior.setEnabled(false);
                    
                }
                
                //Se actualizan los datos
                numTextFiled.setText(String.valueOf(actual.getNumero()));
                fecTextFiled.setText(actual.getFecha());
                salTextFiled.setText(String.valueOf(actual.getSaldo()) + " €");
                propTextFiled.setText(actual.getProp());
            }
        });
        
        botonSiguiente.addActionListener(new ActionListener() {  // Evento de boton.
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (actual.getNext() == null)
                    //Si estamos en el último objeto, desactivamos el boton
                    botonSiguiente.setEnabled(false);
                else {
                    //Sino, pasamos al siguiente
                    actual = actual.getNext();
                    if (!botonAnterior.isEnabled())
                        // Si el botón "Anterior" está desactivado, lo activamos
                        botonAnterior.setEnabled(true);
                    if (actual.getNext() == null)
                        //Comprobamos si estamos en el último
                        botonSiguiente.setEnabled(false);
                }

                //Se actualizan los datos
                numTextFiled.setText(String.valueOf(actual.getNumero()));
                fecTextFiled.setText(actual.getFecha());
                salTextFiled.setText(String.valueOf(actual.getSaldo()) + " €");
                propTextFiled.setText(actual.getProp());
            }
        });
        
        botonAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String prop = propTextFiled.getText();
                String pep = "pep";

                try{
                    float prec = Float.parseFloat(salTextFiled.getText());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "ERROR: Ha introducido mal el precio, intriduzca solo números.");
                    pep = "";
                }
                
                if("".equals(prop)){
                    JOptionPane.showMessageDialog(null, "ERROR: Ha de rellenar el campo de propietario.");
                }else{
                    
                    if("".equals(pep)){
                        
                    }else{
                        actual = new Cuenta(
                            Pantalla.toString(new GregorianCalendar()),
                            Float.valueOf(salTextFiled.getText()),
                            propTextFiled.getText()
                        );
                
                        contentPanel.remove(panelBoton2);
                        contentPanel.validate();
                        contentPanel.add(panelButton, SOUTH);
                        contentPanel.validate();
                
                
                        //Se actualizan los datos
                        numTextFiled.setText(String.valueOf(actual.getNumero()));
                        fecTextFiled.setText(actual.getFecha());
                        salTextFiled.setText(String.valueOf(actual.getSaldo()) + " €");
                        propTextFiled.setText(actual.getProp());
                
                        salTextFiled.setEditable(false);
                        salTextFiled.setFocusable(false);
                        propTextFiled.setEditable(false);
                        propTextFiled.setFocusable(false);
                    }
                }
                
                
            }
            
            
            
        });
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        final Pantalla app = new Pantalla();
        
        //Si se cierra la ventana
        app.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        app.pack();
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
    
    public static String toString(GregorianCalendar cal)
    {
        /**
         * Básicamente va a crear un objeto de tipo Date (la versión más facil de 
         * usar de GregorianCalendar), y va a pasar de usar un GregorianCalendar
         * a un Date, y lo va a convertir, usando el formato declarado en los 
         * atributos, a una cadena.
        */
        
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date thisDate = cal.getTime();
            return sdf.format(thisDate);
        }
        catch(Exception e) {
            // Si la fecha no se puede formatear a una cadena
            return null;
        }
    }
    
}
