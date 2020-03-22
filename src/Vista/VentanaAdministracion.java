package Vista;

import Vista.Herramientas.colorMaker;
import Vista.Herramientas.windowMaker;

public class VentanaAdministracion extends windowMaker{
    private static final long serialVersionUID = 1L;
    
    public VentanaAdministracion(int width, int height, String rutaIconoAplicacion) {
        /**Constructor y personalizacion basica de la ventana */
        super(width, height, rutaIconoAplicacion);
        setTitle("Modulo de Facturacion - Administracion");
        setBackground(new colorMaker().obtainColor("grisEnfasisClaro"));
        /**Añadido de componentes */
        add(new PanelAdministracion().getPanel());
        /**Ajuste de comportamiento */
        setLocationRelativeTo(null);
        setVisible(true);
    }

}