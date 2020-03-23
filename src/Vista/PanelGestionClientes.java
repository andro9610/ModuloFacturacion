package Vista;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controlador.GestionClientesController;
import Vista.Herramientas.buttonMaker;
import Vista.Herramientas.colorMaker;
import Vista.Herramientas.fontMaker;
import Vista.Herramientas.inputMaker;
import Vista.Herramientas.labelMaker;
import Vista.Herramientas.panelMaker;
import Vista.Herramientas.tableMaker;

public class PanelGestionClientes {

    panelMaker panelGestionClientes;

    /** Elementos del formulario */
    inputMaker campoBusqueda;
    tableMaker creadorTablas;
    buttonMaker botonAgregarCliente;

    /** Extras funcionales */
    DefaultTableModel dm;

    int alto = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 30);
    int ancho = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);

    private void crear() {
        int altoPanel = alto;
        int anchoPanel = ancho;

        panelGestionClientes = new panelMaker(
                (int) (anchoPanel * 0.1620), 0,
                (int) (anchoPanel * 0.8382), altoPanel,
                new colorMaker().obtainColor("grisEnfasisClaro"));

        /** Defincion de los elementos del formulario */
        campoBusqueda = new inputMaker(
            (int) (anchoPanel * 0.03214), (int) (altoPanel * 0.1233),
            (int) (anchoPanel * 0.3464), (int) (altoPanel * 0.0455),
            new colorMaker().obtainColor("azulEnfasisMedio"),
            new colorMaker().obtainColor("grisEnfasisOscuro"),
            new fontMaker().obtainFont("fuenteInput"));

        campoBusqueda.setHorizontalAlignment(SwingConstants.LEFT);

        /** Creacion de la tabla */
        String[] columnas = {
            "Numero de documento",
            "Tipo",
            "Nombres",
            "Apellidos",
            "Genero",
            "Edad"
        };

        creadorTablas = new tableMaker();
        JScrollPane tablaResultados = creadorTablas.getTabla(
            columnas,
            (int) (anchoPanel * 0.1532),(int) (altoPanel * 0.2455),
            (int) (anchoPanel * 0.5267), (int) (altoPanel * 0.3822)
        );
        /** Creacion de botones */
        Color[] agregarClienteNormal = {
            new colorMaker().obtainColor("verdeEnfasisOscuro"),
            new colorMaker().obtainColor("blanco")
        };

        Color[] agregarClienteFocused = {
            new colorMaker().obtainColor("verdeEnfasisMedio"),
            new colorMaker().obtainColor("blanco")
        };

        botonAgregarCliente = new buttonMaker(
            "Agregar Cliente",
            (int) (anchoPanel * 0.7017), (int) (altoPanel * 0.9011),
            (int) (anchoPanel * 0.10714), (int) (altoPanel * 0.0355),
            agregarClienteNormal, agregarClienteFocused,
            new fontMaker().obtainFont("fuenteBotones"),
            new fontMaker().obtainFont("fuenteBotones"));

        /** Agregado de los elementos al panel */
        panelGestionClientes.add(
            new labelMaker(
                "GESTION DE CLIENTES",
                (int) (anchoPanel * 0.02767),(int) (altoPanel * 0.0355),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444),
                new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTitulo")
            )
        );

        panelGestionClientes.add(
            new labelMaker(
                "Ingresa un criterio de busqueda",
                (int) (anchoPanel * 0.02767), (int) (altoPanel * 0.0755),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444),
                new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")
            )
        );

        panelGestionClientes.add(campoBusqueda);
        panelGestionClientes.add(
            new labelMaker(
                "RESULTADOS DE BUSQUEDA",
                (int) (anchoPanel * 0.02767), (int) (altoPanel * 0.1855),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444),
                new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteBanner")
            )
        );

        panelGestionClientes.add(tablaResultados);
        panelGestionClientes.add(botonAgregarCliente);
        addController(creadorTablas);
        panelGestionClientes.updateUI();
    }

    public panelMaker getPanel() {
        if (panelGestionClientes == null) {
            crear();
        }
        return panelGestionClientes;
    }

    protected void addController(tableMaker creadorTablas) {
        GestionClientesController buttonAction =  new GestionClientesController();
        buttonAction.setCampos(creadorTablas);
        botonAgregarCliente.addActionListener(buttonAction);

        botonAgregarCliente.setActionCommand("agregarCliente");
 
        campoBusqueda.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                filtrarInformacion(
                    campoBusqueda.getValue(),
                    creadorTablas.getMetatabla());
            }
        });
    }

    /**Metodo para manejar las busquedas en vivo */
    private void filtrarInformacion(String consulta, JTable tablaObjetivo){
        dm = (DefaultTableModel) tablaObjetivo.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        tablaObjetivo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
}