package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.IOAerolinea;
import Controlador.IOCliente;
import Controlador.IOVenta;
import Controlador.IOVuelo;
import DAO.Interfaces.*;
import panels.*;


import java.awt.Font;

public class FramePrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = -5522966213537914564L;
	private JPanel contentPane;
	
	private JMenuItem itemBuscarClientes;
	private JMenuItem itemAltaCliente;
	private JMenuItem itemListarClientes;

	private JMenuItem itemBuscarAviones;
	private JMenuItem itemAltaAvion;
	private JMenuItem itemListarAviones;

	private JMenuItem itemBuscarAeropuertos;
	private JMenuItem itemAltaAeropuerto;
	private JMenuItem itemListarAeropuertos;

	private JMenuItem itemBuscarVuelos;
	private JMenuItem itemAltaVuelo;
	private JMenuItem itemListarVuelos;

	private JMenuItem itemBuscarVentas;
	private JMenuItem itemAltaVenta;
	private JMenuItem itemListarVentas;

	private IOCliente clienteDAO;
	private IOAerolinea avionDAO;
	private IOAerolinea aeropuertoDAO;
	private IOVuelo vueloDAO;
	private IOVenta ventaDAO;

	public FramePrincipal(IOCliente clidao,   IOAerolinea aerodao, IOVuelo vuedao, IOVenta vendao) {

		this.clienteDAO = clidao;
	//	this.avionDAO = avidao;
		this.aeropuertoDAO = aerodao;
		this.vueloDAO = vuedao;
		this.ventaDAO = vendao;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		menuBar.add(mnClientes);

		itemListarClientes = new JMenuItem("Consulta");
		itemListarClientes.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnClientes.add(itemListarClientes);
		itemListarClientes.addActionListener(this);

		itemAltaCliente = new JMenuItem("Alta Clientes");
		itemAltaCliente.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnClientes.add(itemAltaCliente);
		itemAltaCliente.addActionListener(this);

		itemBuscarClientes = new JMenuItem("Eliminar | Modificar");
		itemBuscarClientes.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnClientes.add(itemBuscarClientes);
		itemBuscarClientes.addActionListener(this);

		JMenu mnAvion = new JMenu("Aviones");
		mnAvion.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		menuBar.add(mnAvion);

		itemListarAviones = new JMenuItem("Listado");
		itemListarAviones.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnAvion.add(itemListarAviones);
		itemListarAviones.addActionListener(this);

		itemAltaAvion = new JMenuItem("Alta Avion");
		itemAltaAvion.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnAvion.add(itemAltaAvion);
		itemAltaAvion.addActionListener(this);

		itemBuscarAviones = new JMenuItem("Eliminar | Modificar");
		itemBuscarAviones.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnAvion.add(itemBuscarAviones);
		itemBuscarAviones.addActionListener(this);

		JMenu mnAeropuerto = new JMenu("Aeropuerto");
		mnAeropuerto.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		menuBar.add(mnAeropuerto);

		itemListarAeropuertos = new JMenuItem("Listado");
		itemListarAeropuertos.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnAeropuerto.add(itemListarAeropuertos);
		itemListarAeropuertos.addActionListener(this);

		itemAltaAeropuerto = new JMenuItem("Nuevo Aeropuerto");
		itemAltaAeropuerto.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnAeropuerto.add(itemAltaAeropuerto);
		itemAltaAeropuerto.addActionListener(this);

		itemBuscarAeropuertos = new JMenuItem("Eliminar | Modificar");
		itemBuscarAeropuertos.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnAeropuerto.add(itemBuscarAeropuertos);
		itemBuscarAeropuertos.addActionListener(this);

		JMenu mnVuelos = new JMenu("Vuelos");
		mnVuelos.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		menuBar.add(mnVuelos);

		itemListarVuelos = new JMenuItem("Listado");
		itemListarVuelos.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnVuelos.add(itemListarVuelos);
		itemListarVuelos.addActionListener(this);

		itemAltaVuelo = new JMenuItem("Nuevo");
		itemAltaVuelo.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnVuelos.add(itemAltaVuelo);
		itemAltaVuelo.addActionListener(this);

		itemBuscarVuelos = new JMenuItem("Eliminar | Modificar");
		itemBuscarVuelos.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnVuelos.add(itemBuscarVuelos);
		itemBuscarVuelos.addActionListener(this);

		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		menuBar.add(mnVentas);

		itemListarVentas = new JMenuItem("Listado");
		itemListarVentas.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnVentas.add(itemListarVentas);
		itemListarVentas.addActionListener(this);

		itemAltaVenta = new JMenuItem("Nuevo");
		itemAltaVenta.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnVentas.add(itemAltaVenta);
		itemAltaVenta.addActionListener(this);

		itemBuscarVentas = new JMenuItem("Eliminar | Modificar");
		itemBuscarVentas.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnVentas.add(itemBuscarVentas);
		itemBuscarVentas.addActionListener(this);
	}

	private void refrescarPaneles() {
		
		getContentPane().add(contentPane);
		this.repaint();
		this.revalidate();
	}

	private void removerPaneles() {
		
		try {
			this.remove(contentPane);
			contentPane = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(itemBuscarClientes)) {
			this.removerPaneles();
			contentPane = new ClienteModificacionEliminacion(this.clienteDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemAltaCliente)) {
			this.removerPaneles();
			contentPane = new ClienteAlta(this.clienteDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemListarClientes)) {
			this.removerPaneles();
			contentPane = new ClienteListado(this.clienteDAO);
			this.refrescarPaneles();
		}
		///////////
		if (e.getSource().equals(itemBuscarAviones)) {
			this.removerPaneles();
			contentPane = new AvionModificacionEliminacion(this.avionDAO, this.aeropuertoDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemAltaAvion)) {
			this.removerPaneles();
			contentPane = new AvionAlta(this.avionDAO, this.aeropuertoDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemListarAviones)) {
			this.removerPaneles();
			contentPane = new AvionListado(this.avionDAO);
			this.refrescarPaneles();
		}
		//////////
		if (e.getSource().equals(itemBuscarAeropuertos)) {
			this.removerPaneles();
			contentPane = new AeropuertoModificacionEliminacion(this.aeropuertoDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemAltaAeropuerto)) {
			this.removerPaneles();
			contentPane = new AeropuertoAlta(this.aeropuertoDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemListarAeropuertos)) {
			this.removerPaneles();
			contentPane = new AeropuertoListado(this.aeropuertoDAO);
			this.refrescarPaneles();
		}
		//////////
		if (e.getSource().equals(itemBuscarVuelos)) {
			this.removerPaneles();
			contentPane = new VueloModificacionEliminacion(this.vueloDAO,this.avionDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemAltaVuelo)) {
			this.removerPaneles();
			contentPane = new VueloAlta(this.vueloDAO,this.avionDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemListarVuelos)) {
			this.removerPaneles();
			contentPane = new VueloListado(this.vueloDAO,this.avionDAO);
			this.refrescarPaneles();
		}
		//////////
		if (e.getSource().equals(itemBuscarVentas)) {
			this.removerPaneles();
			contentPane = new VentaModificacionEliminacion(this.ventaDAO,this.vueloDAO,this.clienteDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemAltaVenta)) {
			this.removerPaneles();
			contentPane = new VentaAlta(this.ventaDAO,this.vueloDAO,this.clienteDAO);
			this.refrescarPaneles();
		} else if (e.getSource().equals(itemListarVentas)) {
			this.removerPaneles();
			contentPane = new VentaListado(this.ventaDAO,this.vueloDAO,this.clienteDAO);
			this.refrescarPaneles();
		}
	}

}
