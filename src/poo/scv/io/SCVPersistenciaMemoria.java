package poo.scv.io;

import java.util.ArrayList;

import poo.scv.Cliente;
import poo.scv.ControleDeVendas;
import poo.scv.ItemPedido;
import poo.scv.Pedido;
import poo.scv.Produto;

public class SCVPersistenciaMemoria implements SCVPersistencia {
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<ItemPedido> itempedidos = new ArrayList<ItemPedido>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();


	private ControleDeVendas cVendas = new ControleDeVendas();

	public void salvar(Produto produto) {
		produtos.add(produto);
		cVendas.addProduto(produto);
	}	

	public void salvar(Cliente cliente) {
		clientes.add(cliente);
		cVendas.addCliente(cliente);
	}	
	
	public void salvar(ItemPedido iPedido) {
		itempedidos.add(iPedido);
	}	

	public void salvar(Pedido pedido) {
		pedidos.add(pedido);
	}	
	
	public ArrayList<Produto> recuperarProdutos() {
		return produtos;
	}
	
	public ArrayList<Cliente> recuperarClientes() {
		return clientes;
	}

	public ArrayList<ItemPedido> recuperarItemPedidos() {
		return itempedidos;
	}	

	public ArrayList<Pedido> recuperarPedidos() {
		return pedidos;
	}		
}