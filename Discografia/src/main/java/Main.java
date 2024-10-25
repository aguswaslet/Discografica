
import Modelos.Discografia;
import Modelos.GestorPermanencia;
import Vistas.MainFrame;

/**
 *
 * @author agust
 */
public class Main {
    public static void main(String[] args){
        Discografia adm;
        GestorPermanencia gestor = new GestorPermanencia();
        
        adm = gestor.cargar();
        MainFrame VentanaMain = new MainFrame();
        VentanaMain.setVisible(true);
        if(!VentanaMain.isVisible()){
            gestor.guardar(adm);
        }
    }
}

