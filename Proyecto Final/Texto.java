import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class Texto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Texto extends JLabel
{
    public Texto(String txt, int px, int py, int tx, int ty)
    {
        setText(txt);  
        setLocation(px, py);
        setSize(tx, ty);
        // Cambiar el color del texto
        setForeground(Color.WHITE); // Puedes cambiar Color.RED por cualquier otro color
    }
}   