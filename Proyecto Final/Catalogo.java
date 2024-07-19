import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Catalogo extends JFrame implements ActionListener 
{
    JLabel imageLabel;
    Boton btnmenu= new Boton("MENU", 300, 950);
    
    public Catalogo()
    {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imagenes/catalogo1.png"));
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(5, 0, 768, 1024); // Ajustar posición y tamaño de la imagen
        add(imageLabel);
        add(btnmenu);
        
        btnmenu.addActionListener(this);
        
        setLayout(null);
        setTitle("LOGIN");
        setSize(800, 1030);
        setResizable(false); // Evitar que la ventana sea redimensionable
        setLocationRelativeTo(null); // Centrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        new Catalogo();
    }
    public static Sistema frmCrear;
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == btnmenu) {
            setVisible(false);
            frmCrear = new Sistema();
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }

    }
}