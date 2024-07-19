import javax.swing.*;
import java.awt.event.*;
import java.awt.Window;
import java.awt.Component;
import javax.swing.JPasswordField;

public class VentanaVenta extends JFrame implements ActionListener {
    // Create Objects
    private Texto titulo = new Texto("REGUISTRO VENTA", 10, 10, 400, 10);
    private Texto auto = new Texto("Auto:", 60, 80, 150, 10);
    private Texto nombre = new Texto("Nombre del Comprador: ", 60, 120, 150, 10);
    private Texto vendedor = new Texto("Nombre del Vendedor: ", 60, 160, 150, 10);
    private Texto precio = new Texto("Precio: ", 60, 200, 150, 10);
    private Texto codventa = new Texto("Cod: Venta: ", 60, 40, 150, 10);
    
    private Caja tbauto = new Caja(210, 80);
    private Caja tbnombre = new Caja(210, 120);
    private Caja tbvendedor = new Caja(210, 160);
    private Caja tbprecio = new Caja(210, 200);
    private Caja tbbuscador= new Caja(210, 360);
    private Caja tbOldcod= new Caja(0, 0);
    private Caja tbcodventa= new Caja(210, 40);
    
    private Boton btnGuardar = new Boton("GUARDAR", 40, 320);
    private Boton btnmenu = new Boton("MENU", 210, 320);
    private Boton btnbuscar= new Boton("BUSCAR", 40, 360);
    private Boton btnactualizar= new Boton("ACTUALIZAR", 40, 400);
    private Boton btneliminar= new Boton("ELIMINAR", 210, 400);

    public VentanaVenta() {
        // Add Objects
        add(titulo);
        add(auto);
        add(nombre);
        add(vendedor);
        add(precio);
        add(codventa);
        
        add(tbauto);
        add(tbnombre);
        add(tbvendedor);
        add(tbprecio);
        add(tbprecio);
        add(tbbuscador);
        tbOldcod.setVisible(false);
        add(tbOldcod);
        add(tbcodventa);
        
        add(btnGuardar);
        add(btnmenu);
        add(btnactualizar);
        add(btnbuscar);
        add(btneliminar);
    
        btnGuardar.addActionListener(this);
        btnmenu.addActionListener(this);
        btnactualizar.addActionListener(this);
        btnbuscar.addActionListener(this);
        btneliminar.addActionListener(this);
        
        // Config Frame
        GradientPanel gradientPanel = new GradientPanel();
        
        // Configurar el layout y añadir el GradientPanel al JFrame
        setLayout(null); // Usar layout nulo para que setBounds funcione
        gradientPanel.setBounds(0, 0, 400, 500); // Ajustar el tamaño del panel degradado
        add(gradientPanel);

        
        // Config Frame
        setLayout(null);
        setTitle("Registro Ventas");
        setSize(400, 500);
        setVisible(true);

    }
    
    public void Venta(){
       int c = !tbcodventa.getText().isEmpty()?Integer.parseInt(tbcodventa.getText()) :0;
       String a = tbauto.getText();
       int p = Integer.parseInt(tbprecio.getText());
       String n = tbnombre.getText();
       String v = tbvendedor.getText();
       
       System.out.println("Registrando venta con codigo: "+c);//depuracion
       

       Venta usu = new Venta(c, a, p, n, v);
       DBA.setVenta(usu);
       setTitle("GUARDADO");

            // Limpiar los campos después del registro
       tbcodventa.setText("");
       tbauto.setText("");
       tbnombre.setText("");
       tbvendedor.setText("");
       tbprecio.setText(""); 
    }
    public static Sistema frmCrear;
    public static Login frmLogin;
      public void actionPerformed(ActionEvent e) {
           if (e.getSource() == btnmenu) {
             setVisible(false);
            frmCrear = new Sistema();
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
        if (e.getSource()==btnGuardar){
            Venta();
        }
        
        if (e.getSource() == btnbuscar) {
            try {
                String codStr = tbbuscador.getText().trim();
                int c = Integer.parseInt(codStr); // Convertir el texto del campo de búsqueda a un entero
                System.out.println("Código Ingresado: " + c); // Depuración
                
                // Buscar la venta por código
                Venta v = DBA.getVentaPorCodVenta(c);
                if (v != null) {
                    // Si se encuentra la venta, actualizar los campos con los datos de la venta
                    tbcodventa.setText(String.valueOf(v.getCodVenta()));  
                    tbauto.setText(v.getAuto());
                    tbnombre.setText(v.getNombre());
                    tbvendedor.setText(v.getVendedor());
                    tbprecio.setText(String.valueOf(v.getPrecio()));
                    
                    // Almacenar el código de venta en la caja de texto oculta
                    tbOldcod.setText(String.valueOf(v.getCodVenta()));
                } else {
                    JOptionPane.showMessageDialog(this, "Registro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al visualizar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btneliminar) {
            try {
                int codVenta = !tbcodventa.getText().isEmpty() ? Integer.parseInt(tbcodventa.getText()) : 0;
                boolean eliminado = DBA.deleteVenta(codVenta);
                if (eliminado) {
                    setTitle("ELIMINADO");
                    JOptionPane.showMessageDialog(this, "Venta eliminada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Limpiar los campos después de la eliminación
                tbcodventa.setText("");
                tbauto.setText("");
                tbnombre.setText("");
                tbvendedor.setText("");
                tbprecio.setText("");
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar la venta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnactualizar) {
            try {
                int cod = Integer.parseInt(tbOldcod.getText().trim()); // Código antiguo
                System.out.println("Código antiguo ingresado para actualización: " + cod);
        
                int c = Integer.parseInt(tbcodventa.getText());
                String a = tbauto.getText();
                int p = Integer.parseInt(tbprecio.getText());
                String n = tbnombre.getText();
                String v = tbvendedor.getText();
        
                Venta rv = new Venta(c, a, p, n, v);
                boolean actualizado = DBA.updateVenta(cod, rv);
        
                if (actualizado) {
                    setTitle("ACTUALIZADO");
                    JOptionPane.showMessageDialog(this, "Venta actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Limpiar los campos después de la actualización
                tbcodventa.setText("");
                tbauto.setText("");
                tbnombre.setText("");
                tbvendedor.setText("");
                tbprecio.setText("");
        
                // Limpiar la caja de texto oculta
                tbOldcod.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar la venta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void main (String[] args){
        new VentanaPersonal ();
    }
}
