package poo.scv;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Pedido {

	private String data;
	private Cliente cliente;
	private Integer codigoPedido ;
	private ArrayList<ItemPedido> listaItens = new ArrayList<ItemPedido>();
	private HashMap<Produto, ItemPedido> mapitens = new HashMap<Produto, ItemPedido>();	
	
	public void addProduto(Produto produto) {
		ItemPedido iPedido = new ItemPedido();
		iPedido.setProduto(produto);
		listaItens.add(iPedido);
	}

	public void addProduto(Produto produto, int quantidade) {
		ItemPedido iPedido = new ItemPedido();
		iPedido.setProduto(produto);
		iPedido.setQuantidade(quantidade);
		listaItens.add(iPedido);
	}	
	
	public double totalPedido() {
		double valorTotal = 0.0;
		for (ItemPedido iPedido : listaItens) {
			valorTotal += iPedido.getProduto().getPreco() * iPedido.getQuantidade();
		}
		return valorTotal;
	}
	
	public void setListaItens(ArrayList<ItemPedido> itenspedido) {
		listaItens = itenspedido;
	}
	
	public Iterator<ItemPedido> listarItensPedido() {
		return listaItens.iterator();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setCodigo(int codigo) {
		this.codigoPedido = codigo;
	}
	
	public Integer getCodigo() {
		return codigoPedido;
	}
}