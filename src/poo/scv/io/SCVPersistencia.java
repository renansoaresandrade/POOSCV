package poo.scv.io;

import java.util.ArrayList;

import poo.scv.Cliente;
import poo.scv.ItemPedido;
import poo.scv.Produto;

public interface SCVPersistencia {
	public abstract void salvar(Produto produto);
	public abstract void salvar(Cliente cliente);
	public abstract void salvar(ItemPedido iPedido);
	public abstract ArrayList<Produto> recuperarProdutos();
	public abstract ArrayList<Cliente> recuperarClientes();
	public abstract ArrayList<ItemPedido> recuperarItemPedidos();
}
