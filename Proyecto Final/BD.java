public class BD
{
    public static Personal[] personal= new Personal[100];
    public static int ip= 0;
    
    public static Venta[] venta= new Venta[100];
    public static int iv= 0;
    
    //REGISTRAR Y MOSTRAR PERSONAL
    public static void registrarPersonal(Personal np)
    {
            personal[ip]= np;
            ip++;
    }
    
     public static boolean deletePersonal(int ci) {
        for (int i = 0; i < BD.ip; i++) {
            if (BD.personal[i].getCi() == ci) {
                for (int j = i; j < BD.ip - 1; j++) {
                    BD.personal[j] = BD.personal[j + 1];
                }
                BD.personal[BD.ip - 1] = null;
                BD.ip--;
                return true;
            }
        }
        return false;
    }
    
    //REGISTRAR Y MOSTRAR VENTA
    
    public static void registrarVenta(Venta nv)
    {
            venta[iv]= nv;
            iv++;
    }
    
    public static boolean deleteVenta(int codVenta) {
        for (int i = 0; i < BD.iv; i++) {
            if (BD.venta[i].getCodVenta() == codVenta) {
                for (int j = i; j < BD.iv - 1; j++) {
                    BD.venta[j] = BD.venta[j + 1];
                }
                BD.venta[BD.iv - 1] = null;
                BD.iv--;
                return true;
            }
        }
        return false;
    }
   
}
    
  
    