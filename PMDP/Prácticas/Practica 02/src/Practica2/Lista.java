package Practica2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Lista extends JFrame
{
    
    private static Grupo actual;

    //Campos de texto
    private JLabel nombreLabel;
    private JLabel precioLabel;
    private JLabel fechaLabel;
    private JLabel numLabel;

    //Etiquetas
    private static String nombreString = "Grupo: ";
    private static String precioDisco = "Precio de Disco: ";
    private static String fechaSalida = "Fecha de salida: ";
    private static String numDisco = "Numero de canciones: ";

    //Text fields
    private TextField nombreField;
    private TextField precioField;
    private TextField fechaField;
    private TextField numField;
    private JButton buttonAnterior = new JButton("Anterior");
    private JButton buttonSiguiente = new JButton("Siguiente");
    private JButton buttonCrear = new JButton("Crear");
    private JButton buttonCancelar = new JButton("Cancelar");
    private JButton buttonGuardar = new JButton("Guardar");

    private boolean focusIsSet = false;

    public Lista() {
        super("Grupos de Música");
        
        actual = Grupo.getPrimero();
        
        /*-------------------------------------------------------------------------*/
        
        nombreLabel = new JLabel(nombreString);
        precioLabel = new JLabel(precioDisco);
        fechaLabel = new JLabel(fechaSalida);
        numLabel = new JLabel(numDisco);
        
        /*-------------------------------------------------------------------------*/
        
        nombreField = new TextField(10);
        precioField = new TextField(10);
        fechaField = new TextField(10);
        numField = new TextField(10);
        
        /*-------------------------------------------------------------------------*/
        
        JPanel panelEtiquetas = new JPanel();
        panelEtiquetas.setLayout(new GridLayout(0, 1));
        panelEtiquetas.add(nombreLabel);
        panelEtiquetas.add(precioLabel);
        panelEtiquetas.add(fechaLabel);
        panelEtiquetas.add(numLabel);
        

        
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new GridLayout(0, 1));
        panelCampos.add(nombreField);
        panelCampos.add(precioField);
        panelCampos.add(fechaField);
        panelCampos.add(numField);
   
        /*-------------------------------------------------------------------------*/
        
        final JPanel panelBotonMov = new JPanel();
        panelBotonMov.setLayout(new BorderLayout());
        panelBotonMov.add(buttonAnterior, BorderLayout.WEST);
        panelBotonMov.add(buttonSiguiente, BorderLayout.CENTER);
        panelBotonMov.add(buttonCrear, BorderLayout.EAST);
        
        final JPanel panelBotonCreacion = new JPanel();
        panelBotonCreacion.setLayout(new BorderLayout());
        panelBotonCreacion.add(buttonCancelar, BorderLayout.WEST);
        panelBotonCreacion.add(buttonGuardar, BorderLayout.EAST);
        
        final JPanel panelGeneral = new JPanel();
        panelGeneral.setBorder(
        BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelGeneral.setLayout(new BorderLayout());
        panelGeneral.add(panelEtiquetas, BorderLayout.WEST);
        panelGeneral.add(panelCampos, BorderLayout.EAST);
        panelGeneral.add(panelBotonMov, BorderLayout.SOUTH);
        
        super.add(panelGeneral);
        
        nombreField.setEditable(false);
        nombreField.setFocusable(false);
        precioField.setEditable(false);
        precioField.setFocusable(false);
        fechaField.setEditable(false);
        fechaField.setFocusable(false);
        numField.setEditable(false);
        numField.setFocusable(false);
        
        /*-------------------------------------------------------------------------*/
             
        buttonAnterior.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                Grupo.atras();
                nombreField.setText(Grupo.nombreDeActual());
                precioField.setText(String.valueOf(Grupo.precioDeActual()));
                fechaField.setText(Grupo.fechaDeActual());
                numField.setText(String.valueOf(Grupo.numDeActual()));
                if (Grupo.esPrimero())
                    buttonAnterior.setEnabled(false);
            }
        });
        
        /*-------------------------------------------------------------------------*/
        
        buttonSiguiente.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Siguiente");
                buttonAnterior.setEnabled(true);
                Grupo.adelante();
                nombreField.setText(Grupo.nombreDeActual());  
                precioField.setText(String.valueOf(Grupo.precioDeActual()));
                fechaField.setText(Grupo.fechaDeActual());
                numField.setText(String.valueOf(Grupo.numDeActual()));
            }
        });
        
        /*-------------------------------------------------------------------------*/
        
        buttonCrear.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                panelGeneral.remove(panelBotonMov);
                panelGeneral.validate();
                panelGeneral.add(panelBotonCreacion, BorderLayout.SOUTH);
                panelGeneral.validate();
                
                nombreField.setText("");
                fechaField.setText("");
                numField.setText("");
                precioField.setText("");
                
                
                nombreField.setEditable(true);
                nombreField.setFocusable(true);
                precioField.setEditable(true);
                precioField.setFocusable(true);
                fechaField.setEditable(true);
                fechaField.setFocusable(true);
                numField.setEditable(true);
                numField.setFocusable(true);

            }
        });
        
        /*-------------------------------------------------------------------------*/
        
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                panelGeneral.remove(panelBotonCreacion);
                panelGeneral.validate();
                panelGeneral.add(panelBotonMov, BorderLayout.SOUTH);
                panelGeneral.validate();
                
       
                nombreField.setText(actual.getNombre());
                precioField.setText(String.valueOf(actual.getPrecio()));
                fechaField.setText(actual.getFecha());
                numField.setText(String.valueOf(actual.getDisco()));

           
                nombreField.setEditable(false);
                nombreField.setFocusable(false);
                precioField.setEditable(false);
                precioField.setFocusable(false);
                fechaField.setEditable(false);
                fechaField.setFocusable(false);
                numField.setEditable(false);
                numField.setFocusable(false);

            }
        });
        
        /*-------------------------------------------------------------------------*/
        
        buttonGuardar.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                panelGeneral.remove(panelBotonCreacion);
                panelGeneral.validate();
                panelGeneral.add(panelBotonMov, BorderLayout.SOUTH);
                panelGeneral.validate();
                
                
                actual = new Grupo(
                        nombreField.getText(),
                        Float.parseFloat(precioField.getText()),
                        fechaField.getText(),
                        Integer.parseInt(numField.getText())
                );
                
                
                nombreField.setText(actual.getNombre());
                precioField.setText(String.valueOf(actual.getPrecio()));
                fechaField.setText(actual.getFecha());
                numField.setText(String.valueOf(actual.getDisco()));
                
                
                nombreField.setEditable(false);
                nombreField.setFocusable(false);
                precioField.setEditable(false);
                precioField.setFocusable(false);
                fechaField.setEditable(false);
                fechaField.setFocusable(false);
                numField.setEditable(false);
                numField.setFocusable(false);
            }
        });
    }
    
    
    public static void main(String[] args) {
        
        final Lista app = new Lista();
        
        Grupo g1 = new Grupo("A7X", 15.00f,"10/10/2000", 5);
        Grupo g2 = new Grupo("Falling In Reverse", 10.40f, "25/12/2001", 7);
        Grupo g3 = new Grupo("Queen", 20.50f, "10/11/2002", 15);
        Grupo g4 = new Grupo("The Beatles", 17.30f,"02/03/2003", 20);
        Grupo g5 = new Grupo("3 Days Grace", 15.00f,"08/10/2004", 5);
        Grupo g6 = new Grupo("Thousand Foot Krutch", 10.40f, "29/12/2005", 7);
        Grupo g7 = new Grupo("Treyarch", 20.50f, "13/07/2006", 15);
        Grupo g8 = new Grupo("Black Veil Brides", 5.00f,"26/09/2007", 20);
        Grupo g9 = new Grupo("SIM", 30.45f,"12/01/2008", 20);
        Grupo g10 = new Grupo("Dragonforce", 15.50f,"17/03/2009", 20);
        
        
        app.buttonAnterior.setEnabled(false);
        app.nombreField.setText(Grupo.nombreDeActual());
        app.precioField.setText(String.valueOf(Grupo.precioDeActual()));
        app.fechaField.setText(Grupo.fechaDeActual());
        app.numField.setText(String.valueOf(Grupo.numDeActual()));

        //Para que se cierre al cerrar la pestaña
        app.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            //Pone el focus
            @Override
            public void windowActivated(WindowEvent e) {
                app.setFocus();
            }
        });
        app.pack();
        app.setVisible(true);
    }

    private void setFocus() {
        if (!focusIsSet) {
            nombreField.requestFocus();
            focusIsSet = true;
        }
    }
    

}

