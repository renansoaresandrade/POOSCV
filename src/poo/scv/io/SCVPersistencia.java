package poo.scv.io;

import java.util.ArrayList;

import poo.scv.Cliente;
import poo.scv.ControleDeVendas;
import poo.scv.ItemPedido;
import poo.scv.Pedido;
import poo.scv.Produto;

public interface SCVPersistencia {
	public abstract void salvar(Produto produto);
	public abstract void salvar(Cliente cliente);
	public abstract void salvar(ItemPedido iPedido);
	public abstract void salvar(Pedido pedido);
	public abstract ArrayList<Produto> recuperarProdutos();
	public abstract ArrayList<Cliente> recuperarClientes();
	public abstract ArrayList<ItemPedido> recuperarItemPedidos();
	public abstract ArrayList<Pedido> recuperarPedidos();
}
