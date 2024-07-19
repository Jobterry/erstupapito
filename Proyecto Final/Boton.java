import javax.swing.*;
/**
 * Write a description of class Boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boton extends JButton
{
    public Boton(String txt, int px, int py)
    {
        setText(txt);
        setSize(150, 35);
        setLocation(px, py);
    }
}