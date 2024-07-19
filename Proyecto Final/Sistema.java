import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class Ventana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sistema extends JFrame implements ActionListener
{
    Texto titulo= new Texto("WELCOME TO CARITO", 115, 10, 200, 10);
    
    Boton btncatalogo= new Boton("Catalogo", 100, 80);
    Boton btnventa= new Boton("Registro Venta", 100, 160);
    Boton btnpersonal= new Boton("Registro Personal", 100, 240);
    
        
    /**
     * Constructor for objects of class Ventana
     */
    public Sistema()
    {
        //AÑADIR OBJETOS
        add(titulo);
        add(btncatalogo);
        add(btnventa);
        add(btnpersonal);
        
        
        //ACTION BUTTONS
        btncatalogo.addActionListener(this);
        btnventa.addActionListener(this);
        btnpersonal.addActionListener(this);
        
        // Config Frame
        GradientPanel gradientPanel = new GradientPanel();
        
        // Configurar el layout y añadir el GradientPanel al JFrame
        setLayout(null); // Usar layout nulo para que setBounds funcione
        gradientPanel.setBounds(0, 0, 400, 400); // Ajustar el tamaño del panel degradado
        add(gradientPanel);
        
        //CONFIG FRAME
        setLayout(null);
        setTitle("LOGIN");
        setSize(400, 400);
        setVisible(true);
    }
    
    public static Catalogo frmCatalogo;
    public static VentanaVenta frmVentanaVenta;
    public static VentanaPersonal frmVentanaPersonal;
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()== btncatalogo){
            frmCatalogo= new Catalogo();
        }
        if (e.getSource()== btnventa){
            frmVentanaVenta= new VentanaVenta();
        }
        if (e.getSource()== btnpersonal){
            frmVentanaPersonal= new VentanaPersonal();
        }
    }
    
}
