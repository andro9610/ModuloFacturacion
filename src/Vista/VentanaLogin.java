package Vista;

import Vista.Herramientas.colorMaker;
import Vista.Herramientas.panelMaker;
import Vista.Herramientas.windowMaker;

public class VentanaLogin extends windowMaker{
    private static final long serialVersionUID = 1L;

    public static panelMaker pLogin;

    public VentanaLogin(int width, int height, String rutaIconoAplicacion) {
        /**Constructor y personalizacion basica de la ventana */
        super(width, height, rutaIconoAplicacion);
        setTitle("Modulo de Facturacion - Login");
        setBackground(new colorMaker().obtainColor("transparenteEnfasisOscuro"));
        /**Añadido de componentes */
        //add(new PanelLogin().getPanel());

        /**Ajuste de comportamiento */
        setLocationRelativeTo(null);
        setVisible(true);
    }
}