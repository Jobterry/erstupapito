import javax.swing.*;
/**
 * Write a description of class Caja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caja extends JTextField
{
    /**
     * Constructor for objects of class Caja
     */
    public Caja(int px, int py)
    {
        setLocation(px, py);
        setSize(120, 30);
    }
}