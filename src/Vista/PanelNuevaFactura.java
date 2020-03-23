package Vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controlador.NuevaFacturaController;
import Vista.Herramientas.buttonMaker;
import Vista.Herramientas.colorMaker;
import Vista.Herramientas.inputMaker;
import Vista.Herramientas.panelMaker;
import Vista.Herramientas.tableMaker;
import Vista.Herramientas.labelMaker;
import Vista.Herramientas.fontMaker;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelNuevaFactura {

    panelMaker pNuevaFactura;

    /** Elementos del formulario */
    String fecha;
    inputMaker idCliente, busquedaProducto, subTotal, Fletes, total;
    tableMaker creadorTablas;
    buttonMaker botonAgregarProducto, botonBorrarSeleccion, botonFacturar;

    /** Otros */
    DefaultTableModel dtm;

    private void crear() {
        int altoPanel = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 30);
        int anchoPanel = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        getFecha();
        pNuevaFactura = new panelMaker((int) (anchoPanel * 0.121), 0, (int) (anchoPanel * 0.88), altoPanel,
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
        Color[] facturarNormal = { new colorMaker().obtainColor("verdeEnfasisMedio"),
                new colorMaker().obtainColor("blanco") };

        Color[] facturarFocused = { new colorMaker().obtainColor("verdeEnfasisOscuro"),
                new colorMaker().obtainColor("blanco") };

        Color[] borrarItemNormal = { new colorMaker().obtainColor("rojoEnfasisMedio"),
                new colorMaker().obtainColor("blanco") };

        Color[] borrarItemFocused = { new colorMaker().obtainColor("rojoEnfasisOscuro"),
                new colorMaker().obtainColor("blanco") };

        Color[] agregarProductoNormal = { new colorMaker().obtainColor("amarilloEnfasisMedio"),
                new colorMaker().obtainColor("grisEnfasisOscuro") };

        Color[] agregarProductoFocused = { new colorMaker().obtainColor("amarilloEnfasisOscuro"),
                new colorMaker().obtainColor("blanco") };

        botonFacturar = new buttonMaker("Facturar", (int) (anchoPanel * 0.7226), (int) (altoPanel * 0.8988),
                (int) (anchoPanel * 0.10714), (int) (altoPanel * 0.0355), facturarNormal, facturarFocused,
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
        String[] columnas = { "ID", "Producto","Tipo de producto", "Talla", "Color", "Marca", "Unidades", "Costo unitario",
                "Costo total" };
        creadorTablas = new tableMaker();
        JScrollPane listaCompra = creadorTablas.getTabla(columnas, (int) (anchoPanel * 0.0432),
                (int) (altoPanel * 0.2455), (int) (anchoPanel * 0.7867), (int) (altoPanel * 0.3822));
        /** Agregado de los elementos al panel */
        pNuevaFactura.add(new labelMaker("NUEVA FACTURA", (int) (anchoPanel * 0.02767), (int) (altoPanel * 0.0355),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTituloTabla")));

        pNuevaFactura.add(new labelMaker("Cedula Cliente", (int) (anchoPanel * 0.03767), (int) (altoPanel * 0.0855),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaFactura.add(idCliente);

        pNuevaFactura.add(new labelMaker("Buscar producto", (int) (anchoPanel * 0.46767), (int) (altoPanel * 0.0855),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaFactura.add(busquedaProducto);

        pNuevaFactura.add(new labelMaker("   Fecha: " + fecha, (int) (anchoPanel * 0.04767), (int) (altoPanel * 0.1355),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaFactura.add(new labelMaker("LISTA DE COMPRA", (int) (anchoPanel * 0.02767), (int) (altoPanel * 0.2055),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTituloTabla")));

        pNuevaFactura.add(listaCompra);

        pNuevaFactura.add(new labelMaker("Subtotal", (int) (anchoPanel * 0.50767), (int) (altoPanel * 0.6855),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaFactura.add(subTotal);

        pNuevaFactura.add(new labelMaker("Fletes", (int) (anchoPanel * 0.50767), (int) (altoPanel * 0.7385),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaFactura.add(Fletes);

        pNuevaFactura.add(new labelMaker("Total", (int) (anchoPanel * 0.50767), (int) (altoPanel * 0.7855),
                (int) (anchoPanel * 0.275), (int) (altoPanel * 0.04444), new colorMaker().obtainColor("negro"),
                new fontMaker().obtainFont("fuenteTextoEmergente")));

        pNuevaFactura.add(total);

        pNuevaFactura.add(botonAgregarProducto);
        pNuevaFactura.add(botonBorrarSeleccion);
        pNuevaFactura.add(botonFacturar);

        addController();
    }

    public panelMaker getPanel() {
        if (pNuevaFactura == null) {
            crear();
        }
        return pNuevaFactura;
    }

    private void getFecha() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd / mm / yyyy   hh:mm");
        fecha = dateFormat.format(date);
    }

    protected void addController() {
        NuevaFacturaController buttonAction = new NuevaFacturaController(idCliente, busquedaProducto, subTotal, Fletes,
                total, creadorTablas);

        botonAgregarProducto.addActionListener(buttonAction);
        botonBorrarSeleccion.addActionListener(buttonAction);
        botonFacturar.addActionListener(buttonAction);

        botonAgregarProducto.setActionCommand("agregarProducto");
        botonBorrarSeleccion.setActionCommand("borrarSeleccion");
        botonFacturar.setActionCommand("facturar");

        busquedaProducto.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                filtrarInformacion(
                    busquedaProducto.getValue(),
                    creadorTablas.getMetatabla());
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