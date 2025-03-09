package controlador;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JComponent;
import java.net.URL;


public class controlarJavaHelp {

    private static HelpSet helpSet;
    private static HelpBroker helpBroker;

    /**
     * Inicializa el sistema de ayuda.
     */
    public static void inicializarAyuda() {
        try {
            URL hsURL = controlarJavaHelp.class.getClassLoader().getResource("Help/help_set.hs");
            if (hsURL == null) {
                System.out.println("El archivo HelpSet no existe en el classpath.");
                return;
            }

            helpSet = new HelpSet(null, hsURL);
            helpBroker = helpSet.createHelpBroker();
        } catch (Exception e) {
            System.out.println("Error al inicializar el HelpSet: " + e.getMessage());
            e.printStackTrace();
        }
    }

   
    public static void asociarAyuda(JComponent component, String helpID) {
        if (helpBroker != null) {
            helpBroker.enableHelpKey(component, helpID, helpSet);
        }
    }

  
    public static void asociarAyudaBoton(JComponent component, String helpID) {
        if (helpBroker != null) {
            helpBroker.enableHelpOnButton(component, helpID, helpSet);
        }
    }

    /**
     * Muestra la ventana de ayuda.
     */
    public static void mostrarAyuda() {
        if (helpBroker != null) {
            helpBroker.setDisplayed(true);
        } else {
            System.out.println("El sistema de ayuda no está disponible.");
        }
    }
}
