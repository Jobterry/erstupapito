
/**
 * Write a description of class Factura here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Venta
{
    public int codVenta;
    public String auto;
    public int precio;
    public String nombre;
    public String vendedor;
    
    public Venta()
    {
        this.codVenta=0;
        this.auto="";
        this.precio=0;
        this.nombre="";
        this.vendedor="";
    }
    
    public Venta(int codVenta, String auto, int precio, String nombre, String vendedor)
    {
        this.codVenta=codVenta;
        this.auto=auto;
        this.precio=precio;
        this.nombre=nombre;
        this.vendedor=vendedor;
    }
    
    public void setCodVenta(int codVenta)
    {
       this.codVenta=codVenta;
    }
   
    public int getCodVenta()
    {
       return this.codVenta;
    }
    
    public void setAuto(String auto)
    {
       this.auto=auto;
    }
   
    public String getAuto()
    {
       return this.auto;
    }
    
    public void setPrecio(int precio)
    {
       this.precio=precio;
    }
   
    public int getPrecio()
    {
       return this.precio;
    }
    
     public void setNombre(String nombre)
    {
       this.nombre=nombre;
    }
   
    public String getNombre()
    {
       return this.nombre;
    }
    
    public void setiVendedor(String vendedor)
    {
       this.vendedor=vendedor;
    }
   
    public String getVendedor()
    {
       return this.vendedor;
    }
}
