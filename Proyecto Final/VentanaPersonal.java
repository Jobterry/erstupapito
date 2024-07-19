import javax.swing.*;
import java.awt.event.*;
import java.awt.Window;
import java.awt.Component;
import javax.swing.JPasswordField;

public class VentanaPersonal extends JFrame implements ActionListener  {
    // Create Objects
    private Texto titulo = new Texto("REGUISTRO PERSONAL", 10, 10, 400, 10);
    private Texto ci = new Texto("CI:", 60, 40, 150, 10);
    private Texto nombres = new Texto("Nombre Completo:", 60, 80, 150, 10);
    private Texto usuario = new Texto("Usuario:", 60, 120, 150, 10);
    private Texto cargo = new Texto("Cargo:", 60, 160, 150, 10);
    private Texto telefono = new Texto("Telefono:", 60, 200, 150, 10);
    private Texto direccion = new Texto("Direccion:", 60, 240, 150, 10);
    private Texto contraseña = new Texto("Contraseña:", 60, 280, 150, 10);
    
    private Caja tbci = new Caja(180, 40);
    private Caja tbnombres = new Caja(180, 80);
    private Caja tbusuario = new Caja(180, 120);
    private Caja tbcargo = new Caja(180, 160);
    private Caja tbtelefono = new Caja(180, 200);
    private Caja tbdireccion = new Caja(180, 240);
    private Caja tbcontraseña = new Caja(180, 280);
    private Caja tbbuscador= new Caja(210, 400);
    private Caja tbOldci= new Caja(0, 0);
    
    private Boton btnGuardar = new Boton("GUARDAR", 40, 350);
    private Boton btnmenu = new Boton("MENU", 210, 350);
    private Boton btnbuscar= new Boton("BUSCAR", 40, 400);
    private Boton btnactualizar= new Boton("ACTUALIZAR", 40, 450);
    private Boton btneliminar= new Boton("ELIMINAR", 210, 450);

    public VentanaPersonal() {
        // Add Objects
        add(titulo);
        add(ci);
        add(nombres);
        add(usuario);
        add(cargo);
        add(telefono);
        add(direccion);
        add(contraseña);
        
        add(tbci);
        add(tbnombres);
        add(tbusuario);
        add(tbcargo);
        add(tbtelefono);
        add(tbdireccion);
        add(tbcontraseña);
        add(tbbuscador);
        tbOldci.setVisible(false);
        add(tbOldci);
        
        
        add(btnGuardar);
        add(btnmenu);
        add(btnbuscar);
        add(btnactualizar);
        add(btneliminar);
        
        btnGuardar.addActionListener(this);
        btnmenu.addActionListener(this);
        btnbuscar.addActionListener(this);
        btnactualizar.addActionListener(this);
        btneliminar.addActionListener(this);
        
        
        // Config Frame
        GradientPanel gradientPanel = new GradientPanel();
        
        // Configurar el layout y añadir el GradientPanel al JFrame
        setLayout(null); // Usar layout nulo para que setBounds funcione
        gradientPanel.setBounds(0, 0, 550, 550); // Ajustar el tamaño del panel degradado
        add(gradientPanel);
    
        
        // Config Frame
        setLayout(null);
        setTitle("Registro Personal");
        setSize(550, 550);
        setVisible(true);

    }
    
    public void Personal(){
       int i = Integer.parseInt(tbci.getText());
       String n = tbnombres.getText();
       String u = tbusuario.getText();
       String c = tbcargo.getText();
       String t = tbtelefono.getText();
       String d = tbdireccion.getText();
       int co = Integer.parseInt(tbcontraseña.getText());

       Personal usu = new Personal(i, n, u, c, t, d, co);
       DBA.setPersonal(usu);
       setTitle("GUARDADO");

            // Limpiar los campos después del registro
       tbci.setText("");
       tbnombres.setText("");
       tbusuario.setText("");
       tbcargo.setText("");
       tbtelefono.setText(""); 
       tbdireccion.setText(""); 
       tbcontraseña.setText("");
       
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
            Personal();
        }
        
        if (e.getSource() == btnbuscar) {
            try {
                String ciStr = tbbuscador.getText().trim();
                System.out.println("Texto del buscador: " + ciStr); // Depuración: Verifica el texto ingresado
                int ci = Integer.parseInt(ciStr);
                
                System.out.println("CI Ingresando: "+ ci);//Depuracion
                
                Personal p = DBA.getPersonalPorCi(ci);
                if (p != null) {
                    System.out.println("Personal encontrado: " + p.getNombres()); // Depuración: Verifica que el personal es encontrado
                    tbci.setText(String.valueOf(p.getCi()));
                    tbnombres.setText(p.getNombres());  
                    tbusuario.setText(p.getUsuario());
                    tbcargo.setText(p.getCargo());
                    tbtelefono.setText(p.getTelefono());
                    tbdireccion.setText(p.getDireccion());
                    tbcontraseña.setText(String.valueOf(p.getContraseña()));
                    
                    // Almacenar el nombre antiguo en la caja de texto oculta
                    tbOldci.setText(String.valueOf(p.getCi()));// Almacena el CI antiguo
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
                int ci = !tbci.getText().isEmpty() ? Integer.parseInt(tbci.getText()) : 0;
                boolean eliminado = DBA.deletePersonal(ci);
                if (eliminado) {
                    setTitle("ELIMINADO");
                    JOptionPane.showMessageDialog(this, "Venta eliminada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Limpiar los campos después de la eliminación
                tbci.setText("");
                tbnombres.setText("");
                tbusuario.setText("");
                tbcargo.setText("");
                tbtelefono.setText("");
                tbdireccion.setText("");
                tbcontraseña.setText("");
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar la venta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnactualizar) {
            try {
                int ci = Integer.parseInt(tbOldci.getText().trim()); // Código antiguo
                System.out.println("Código antiguo ingresado para actualización: " + ci);
        
                int in = Integer.parseInt(tbci.getText());
                String n = tbnombres.getText();
                String u = tbusuario.getText();
                String c = tbcargo.getText();
                String t = tbtelefono.getText();
                String d = tbdireccion.getText();
                int co = Integer.parseInt(tbcontraseña.getText());
        
                Personal rv = new Personal(in, n, u, c, t, d, co);
                boolean actualizado = DBA.updatePersonal(ci, rv);
        
                if (actualizado) {
                    setTitle("ACTUALIZADO");
                    JOptionPane.showMessageDialog(this, "Venta actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Limpiar los campos después de la actualización
                tbci.setText("");
                tbnombres.setText("");
                tbusuario.setText("");
                tbcargo.setText("");
                tbtelefono.setText("");
                tbdireccion.setText("");
                tbcontraseña.setText("");
        
                // Limpiar la caja de texto oculta
                tbOldci.setText("");
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

