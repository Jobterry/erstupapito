public class DBA
{
    // PERSONAL
    public static void setPersonal(Personal p)
    {
        Personal pdb = new Personal();

        pdb.nombres= !p.nombres.equalsIgnoreCase("")?p.nombres:"Sin nombres";
        pdb.usuario= !p.usuario.equalsIgnoreCase("")?p.usuario:"Sin nombres";
        pdb.cargo= !p.cargo.equalsIgnoreCase("")?p.cargo:"Sin nombres";
        pdb.telefono= !p.telefono.equalsIgnoreCase("")?p.telefono:"Sin nombres";
        pdb.direccion= !p.direccion.equalsIgnoreCase("")?p.direccion:"Sin nombres";

        pdb.contraseña= p.contraseña>0?p.contraseña:0;
        pdb.ci= p.ci>0?p.ci:0;
                
        BD.registrarPersonal(pdb);
    }
    
    public static void getPersonal(Personal p)
    {
        System.out.println("\n===============================");
        System.out.println("Ci: "+p.ci);
        System.out.println("Nombres: "+p.nombres);
        System.out.println("Usuario: "+p.usuario);
        System.out.println("Cargo: "+p.cargo);
        System.out.println("Telefono: "+p.telefono);
        System.out.println("Direccion: "+p.direccion);
        System.out.println("Contraseña: "+p.contraseña);
    }
    
    public static boolean existePersonal(Personal p){
        boolean res= false;

        for(int i=0; i<BD.ip; i++){
            if(p.getUsuario().equals(BD.personal[i].getUsuario()) && p.getContraseña()==(BD.personal[i].getContraseña()))
                res= true;
        }
        return res;
    }
    
    public static Personal getPersonalPorCi(int ci) {
        for (int i = 0; i < BD.ip; i++) {
            if (BD.personal[i].getCi() == ci) {
                return BD.personal[i];
            }
        }
        return null; // Retorna null si no se encuentra el cliente
    } 
    
    public static boolean deletePersonal(int ci) {
        return BD.deletePersonal(ci);
    }
    
    public static boolean updatePersonal(int ci, Personal p) {
        System.out.println("Buscando cliente con nombre antiguo: " + ci);
        for (int i = 0; i < BD.ip; i++) {
            System.out.println("Comparando con producto en posición " + i + ": " + BD.personal[i].getCi());
            if (BD.personal[i].getCi() == ci) {
                BD.personal[i] = p;
                System.out.println("Cliente actualizado en posicion " + i + ": " + p.getCi()); // Depuración
                return true;
            }
        }
        System.out.println("Cliente con nombre " + ci + " no encontrado.");
        return false; // Retorna false si no se encuentra el producto
    }
    //VENTA
    public static void setVenta(Venta v)
    {
        Venta vdb = new Venta();

        vdb.auto= !v.auto.equalsIgnoreCase("")?v.auto:"Sin nombres";
        vdb.nombre= !v.nombre.equalsIgnoreCase("")?v.nombre:"Sin nombres";
        vdb.vendedor= !v.vendedor.equalsIgnoreCase("")?v.vendedor:"Sin nombres";

        vdb.codVenta= v.codVenta>0?v.codVenta:0;
        vdb.precio= v.precio>0?v.precio:0;
                
        BD.registrarVenta(vdb);
    }
    
    public static void getVenta(Venta v)
    {
        System.out.println("\n===============================");
        System.out.println("Cod. Venta: "+v.codVenta);
        System.out.println("Auto: "+v.auto);
        System.out.println("Precio: "+v.precio);
        System.out.println("Nombre: "+v.nombre);
        System.out.println("Vendedor: "+v.vendedor);
    }
    
    public static Venta getVentaPorCodVenta(int codVenta) {
        System.out.println("Buscando venta con Cod. venta: " + codVenta); // Depuración
        
        // Comprobar si el código de venta es válido
        if (codVenta <= 0) {
            System.out.println("Código de venta no válido: " + codVenta); // Depuración
            return null; // Manejo de entrada no válida
        }
    
        // Iterar sobre el array de ventas
        for (int i = 0; i < BD.iv; i++) {
            // Mostrar información de la venta para depuración
            System.out.println("Comparando venta en posición " + i + ": " + BD.venta[i].getCodVenta()); // Depuración
    
            // Comparar el código de venta
            if (BD.venta[i].getCodVenta() == codVenta) {
                System.out.println("Venta encontrada en posición " + i + ": " + BD.venta[i].getAuto() + ", " + BD.venta[i].getNombre()); // Depuración
                return BD.venta[i]; // Retorna la venta si el código coincide
            }
        }
    
        // Mensaje de depuración cuando no se encuentra la venta
        System.out.println("No se encontró ninguna venta con el código: " + codVenta); // Depuración
        return null; // Retorna null si no se encuentra la venta
    } 
    
    public static boolean updateVenta(int cod, Venta v) {
        System.out.println("Buscando venta con nombre antiguo: " + cod);
        for (int i = 0; i < BD.iv; i++) {
            System.out.println("Comparando venta en posición " + i + ": " + BD.venta[i].getCodVenta());
            if (BD.venta[i].getCodVenta() == cod) {
                BD.venta[i] = v;
                System.out.println("Venta actualizado en posicion " + i + ": " + v.getCodVenta()); // Depuración
                return true;
            }
        }
        System.out.println("Venta con nombre " + cod + " no encontrado.");
        return false; // Retorna false si no se encuentra el producto
    }
    
    public static boolean deleteVenta(int codVenta) {
        return BD.deleteVenta(codVenta);
    }
}