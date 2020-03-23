package Vista;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controlador.NuevaCotizacionController;
import Vista.Herramientas.buttonMaker;
import Vista.Herramientas.colorMaker;
import Vista.Herramientas.fontMaker;
import Vista.Herramientas.inputMaker;
import Vista.Herramientas.labelMaker;
import Vista.Herramientas.panelMaker;
import Vista.Herramientas.tableMaker;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PanelNuevaCotizacion {

    panelMaker pNuevaCotizacion;
    /** ELementos del formulario */
    String fecha;
    inputMaker idCliente, busquedaProducto, subTotal, Fletes, total;
    tableMaker creadorTablas;
    buttonMaker botonAgregarProducto, botonBorrarSeleccion, botonCotizacion;

    /** Otros */
    DefaultTableModel dtm;

    private void crear() {
        int altoPanel = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 30);
        int anchoPanel = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        getFecha();
        pNuevaCotizacion = new panelMaker((int) (anchoPanel * 0.121), 0, (int) (anchoPanel * 0.88), altoPanel,
                new colorMaker().obtainColor("grisEnfasisClaro"));

        /** Definicion de los elementos del formulario */
        idCliente = new inputMaker((int) (anchoPanel * 0.10214), (int) (altoPanel * 0.0911),
                (int) (anchoPanel * 0.2642), (int) (altoPanel * 0.0355),
                new colorMaker().obtainColor("azulEnfasisMedio"), new colorMaker().obtainColor("grisEnfasisOscuro"),
                new fontMaker().obtainFont("fuenteInput"));

        idCliente.setHorizontalAlignment(SwingConstants.LEFT);

        busquedaProducto = new inputMaker((int) (anchoPanel * 0.56214), (int) (altoPanel * 0.0911),
                (int) (anchoPanel * 0.2642), (int) (altoPanel * 0.0355),
                new colorMaker().obtainColor("azulEnfasisMedio"), new colorMaker().obtainColor("grisEnfasisOscuro"),
                new fontMaker().obtainFont("fuenteInput"));

        busquedaProducto.setHorizontalAlignment(SwingConstants.LEFT);

        subTotal = new inputMaker((int) (anchoPanel * 0.56214), (int) (altoPanel * 0.6911), (int) (anchoPanel * 0.2642),
                (int) (altoPanel * 0.0355), new colorMaker().obtainColor("azulEnfasisMedio"),
                new colorMaker().obtainColor("grisEnfasisMedio"), new fontMaker().obtainFont("fuenteInput"));
        subTotal.setEditable(false);
        subTotal.setFocusable(false);

        Fletes = new inputMaker((int) (anchoPanel * 0.56214), (int) (altoPanel * 0.7411), (int) (anchoPanel * 0.2642),
                (int) (altoPanel * 0.0355), new colorMaker().obtainColor("azulEnfasisMedio"),
                new colorMaker().obtainColor("grisEnfasisMedio"), new fontMaker().obtainFont("fuenteInput"));
        Fletes.setEditable(false);
        Fletes.setFocusable(false);

        total = new inputMaker((int) (anchoPanel * 0.56214), (int) (altoPanel * 0.7911), (int) (anchoPanel * 0.2642),
                (int) (altoPanel * 0.0355), new colorMaker().obtainColor("azulEnfasisMedio"),
                new colorMaker().obtainColor("grisEnfasisMedio"), new fontMaker().obtainFont("fuenteInput"));
        total.setEditable(false);
        total.setFocusable(false);
        /** Creacion de botones */
        Color[] CotizacionNormal = { new colorMaker().obtainColor("verdeEnfasisMedio"),
                new colorMaker().obtainColor("blanco") };

        Color[] CotizacionFocused = { new colorMaker().obtainColor("verdeEnfasisOscuro"),
                new colorMaker().obtainColor("blanco") };

        Color[] borrarItemNormal = { new colorMaker().obtainColor("rojoEnfasisMedio"),
                new colorMaker().obtainColor("blanco") };

        Color[] borrarItemFocused = { new colorMaker().obtainColor("rojoEnfasisOscuro"),
                new colorMaker().obtainColor("blanco") };

        Color[] agregarProductoNormal = { new colorMaker().obtainColor("amarilloEnfasisMedio"),
                new colorMaker().obtainColor("grisEnfasisOscuro") };

        Color[] agregarProductoFocused = { new colorMaker().obtainColor("amarilloEnfasisOscuro"),
                new colorMaker().obtainColor("blanco") };

        botonCotizacion = new buttonMaker("Guardar cotizacion", (int) (anchoPanel * 0.7226), (int) (altoPanel * 0.8988),
                (int) (anchoPanel * 0.10714), (int) (altoPanel * 0.0355), CotizacionNormal, CotizacionFocused,
                new fontMaker().obtainFont("fuenteBotones"), new fontMaker().obtainFont("fuenteBotones"));

        botonBorrarSeleccion = new buttonMaker("Borrar seleccion", (int) (anchoPanel * 0.1726),
                (int) (altoPanel * 0.6488), (int) (anchoPanel * 0.10714), (int) (altoPanel * 0.0355), borrarItemNormal,
                borrarItemFocused, new fontMaker().obtainFont("fuenteBotones"),
                new fontMaker().obtainFont("fuenteBotones"));

        botonAgregarProducto = new buttonMaker("Agregar producto", (int) (anchoPanel * 0.0426),
                (int) (altoPanel * 0.6488), (int) (anchoPanel * 0.10714), (int) (altoPanel * 0.0355),
                agregarProductoNormal, agregarProductoFocused, new fontMaker().obtainFont("fuenteBotones"),
                new fontMaker().obtainFont("fuenteBotones"));

        /** Creacion de la tabla de productos */
        String[] columnas = { "ID", "Producto", "Tipo de producto", "Talla", "Color", "Marca", "Unidades",
                "Costo unitario", "Costo total" };
        creadorTablas = new tableMaker();
        JScrollPane listaCompra = creadorTablas.getTabla(columnas, (int) (anchoPanel * 0.0432),
                (int) (altoPanel * 0.2455), (int) (anchoPanel * 0.7867), (int) (altoPanel * 0.3822));
        /** Agregado de los elementos al panel */
        pNuevaCotizacion.add(new labelMaker("NUEVA COTIZACION", (int) (anchoPanel * 0.02767),
                (int) (altoPanel * 0.0355), (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444),
                new colorMaker().obtainColor("negro"), new fontMaker().obtainFont("fuenteTituloTabla")));

        pNuevaCotizacion.add(new labelMaker("Cedula Cliente", (int) (anchoPanel * 0.03767), (int) (altoPanel * 0.0855),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaCotizacion.add(idCliente);

        pNuevaCotizacion.add(new labelMaker("Buscar producto", (int) (anchoPanel * 0.46767), (int) (altoPanel * 0.0855),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaCotizacion.add(busquedaProducto);

        pNuevaCotizacion.add(new labelMaker("   Fecha: " + fecha, (int) (anchoPanel * 0.04767),
                (int) (altoPanel * 0.1355), (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444),
                new colorMaker().obtainColor("negro"), new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaCotizacion.add(new labelMaker("LISTA DE COMPRA", (int) (anchoPanel * 0.02767), (int) (altoPanel * 0.2055),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTituloTabla")));

        pNuevaCotizacion.add(listaCompra);

        pNuevaCotizacion.add(new labelMaker("Subtotal", (int) (anchoPanel * 0.50767), (int) (altoPanel * 0.6855),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaCotizacion.add(subTotal);

        pNuevaCotizacion.add(new labelMaker("Fletes", (int) (anchoPanel * 0.50767), (int) (altoPanel * 0.7385),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaCotizacion.add(Fletes);

        pNuevaCotizacion.add(new labelMaker("Total", (int) (anchoPanel * 0.50767), (int) (altoPanel * 0.7855),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaCotizacion.add(total);

        pNuevaCotizacion.add(botonAgregarProducto);
        pNuevaCotizacion.add(botonBorrarSeleccion);
        pNuevaCotizacion.add(botonCotizacion);

        addController();
        pNuevaCotizacion.updateUI();
    }

    public panelMaker getPanel() {
        if (pNuevaCotizacion == null) {
            crear();
        }
        return pNuevaCotizacion;
    }

    private void getFecha() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd / mm / yyyy   hh:mm");
        fecha = dateFormat.format(date);
    }

    protected void addController() {
        NuevaCotizacionController buttonAction = new NuevaCotizacionController(idCliente, busquedaProducto, subTotal,
                Fletes, total, creadorTablas);

        botonAgregarProducto.addActionListener(buttonAction);
        botonBorrarSeleccion.addActionListener(buttonAction);
        botonCotizacion.addActionListener(buttonAction);

        botonAgregarProducto.setActionCommand("agregarProducto");
        botonBorrarSeleccion.setActionCommand("borrarSeleccion");
        botonCotizacion.setActionCommand("Cotizacion");

        busquedaProducto.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                filtrarInformacion(
                    busquedaProducto.getValue(),
                    creadorTablas.getMetatabla()
                );
            }            
        });
    }

    /**Metodo para manejar las busquedas en vivo */
    private void filtrarInformacion(String consulta, JTable tablaObjetivo){
        dtm = (DefaultTableModel) tablaObjetivo.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dtm);
        tablaObjetivo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
}