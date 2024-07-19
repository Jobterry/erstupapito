import javax.swing.*;
import java.awt.*;
public class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Crear el color de degradado
        Color color1 = Color.BLUE;
        Color color2 = Color.GREEN;
        int width = getWidth();
        int height = getHeight();
        
        // Crear el objeto GradientPaint para el degradado
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}