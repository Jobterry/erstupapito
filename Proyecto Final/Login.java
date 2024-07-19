import javax.swing.*;
import java.awt.event.*;
import java.awt.Window;
import java.awt.Component;
import javax.swing.JPasswordField;
import java.util.Scanner;
import java.awt.Color;
public class Login extends JFrame implements ActionListener {
    public Scanner sc= new Scanner(System.in);
    // Create Objects
    private Texto titulo = new Texto("Login", 10, 10, 200, 10);
    private Texto usuario = new Texto("Usuario:", 20, 40, 150, 10);
    private Texto contraseña = new Texto("Contraseña:", 20, 70, 150, 10);
    private Caja tbusuario = new Caja(150, 30);
    private Caja tbcontraseña = new Caja(150,65); 
    private Boton btningresar = new Boton("INGRESAR", 10, 130);
    private Boton btnregistrar = new Boton("REGISTRAR", 160, 130);

    public Login() {
        // Add Objects
        
        add(titulo);
        add(usuario);
        add(contraseña);
        add(tbusuario);
        add(tbcontraseña);
        add(btningresar);
        add(btnregistrar);
        

        // Action Buttons
        btningresar.addActionListener(this);
        btnregistrar.addActionListener(this);
        
        // Config Frame
        GradientPanel gradientPanel = new GradientPanel();
        
        // Configurar el layout y añadir el GradientPanel al JFrame
        setLayout(null); // Usar layout nulo para que setBounds funcione
        gradientPanel.setBounds(0, 0, 330, 270); // Ajustar el tamaño del panel degradado
        add(gradientPanel);
                
        
        // Config Frame
        setLayout(null);
        setTitle("LOGIN");
        setSize(330, 270);
        setVisible(true);
        
    }
    
    public static Sistema frmSistema;
    public static VentanaPersonal frmRegistro;
    public void ingresar(){
        Personal usu= new Personal(tbusuario.getText(),Integer.parseInt(tbcontraseña.getText()));
        if (DBA.existePersonal(usu)) {
                frmSistema= new Sistema();
                dispose();
            } else {
                setTitle("ERROR");
            }
    }
    
     public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnregistrar)
        {
        frmRegistro= new VentanaPersonal();
        setVisible(false);
       }
       if (e.getSource()== btningresar){
            ingresar();
       }
    }
}