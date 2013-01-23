package poo.scv.io;

import java.util.ArrayList;

import poo.scv.Cliente;
import poo.scv.ItemPedido;
import poo.scv.Produto;

public class SCVPersistenciaMemoria implements SCVPersistencia {
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<ItemPedido> itempedidos = new ArrayList<ItemPedido>();


	public void salvar(Produto produto) {
		produtos.add(produto);
	}	

	public void salvar(Cliente cliente) {
		clientes.add(cliente);
	}	
	
	public void salvar(ItemPedido iPedido) {
		itempedidos.add(iPedido);
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
	
}