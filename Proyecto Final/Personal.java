
/**
 * Write a description of class Vendedor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personal
{
   public int ci;
   public String nombres;
   public String usuario;
   public String cargo;
   public String telefono;
   public String direccion;
   public int contraseña;
   
   public Personal()
   {
       this.ci=0;
       this.nombres="";
       this.usuario="";
       this.cargo="";
       this.telefono="";
       this.direccion="";
       this.contraseña=0;
   }
   
   public Personal(int ci, String nombres, String usuario, String cargo,String telefono, String direccion, int contraseña)
   {
       this.ci=ci;
       this.nombres=nombres;
       this.usuario=usuario;
       this.cargo=cargo;
       this.telefono=telefono;
       this.direccion=direccion;
       this.contraseña=contraseña;
   }
   
   public Personal(String usuario, int contraseña)
   {
        this.usuario= usuario;
        this.contraseña=contraseña;
   }
   
   public void setCi(int ci)
   {
       this.ci=ci;
   }
   
   public int getCi()
   {
       return this.ci;
   }
   
   public void setNombres(String nombres)
   {
       this.nombres=nombres;
   }
   
   public String getNombres()
   {
       return this.nombres;
   }
   
   public void setUsuario(String usuario)
   {
       this.usuario=usuario;
   }
   
   public String getUsuario()
   {
       return this.usuario;
   }
   
   public void setCargo(String cargo)
   {
       this.cargo=cargo;
   }
   
   public String getCargo()
   {
       return this.cargo;
   }
   
   public void setTelefono(String telefono)
   {
       this.telefono=telefono;
   }
   
   public String getTelefono()
   {
       return this.telefono;
   }
   
   public void setDireccion(String direccion)
   {
       this.direccion=direccion;
   }
   
   public String getDireccion()
   {
       return this.direccion;
   }
   
   public void setContraseña(int contraseña)
   {
       this.contraseña=contraseña;
   }
   
   public int getContraseña()
   {
       return this.contraseña;
   }
}
