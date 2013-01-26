package poo.scv;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import poo.scv.io.SCVPersistencia;
import poo.scv.io.SCVPersistenciaMemoria;

public class SCVFacade {
	
	private static int uPedido = 0;
	
	static SCVPersistencia persistencia = new SCVPersistenciaMemoria();
	
	static ControleDeVendas cVendas = new ControleDeVendas();
	
	public Cliente criarCliente(String nome, String cpf, String telefone) throws SCVException {
		Cliente nCliente = new Cliente();
		nCliente.setNome(nome);
		nCliente.setCpf(cpf);
		nCliente.setTelefone(telefone);
		cVendas.addCliente(nCliente);
		return nCliente;
	}

	public Produto criarProduto(int codigo, String nome, String descricao, double preco) throws SCVException {
		Produto nProduto = new Produto();
		nProduto.setCodigo(codigo);
		nProduto.setNome(nome);
		nProduto.setDescricao(descricao);
		nProduto.setPreco(preco);
		cVendas.addProduto(nProduto);
		return nProduto;
	}

	public Produto criarProdutoPerecivel(int codigo, String nome, String descricao, double preco, String validade) {
		ProdutoPerecivel nProduto = new ProdutoPerecivel();
		nProduto.setCodigo(codigo);
		nProduto.setNome(nome);
		nProduto.setDescricao(descricao);
		nProduto.setPreco(preco);
		nProduto.setValidade(validade);
		return nProduto;
	}	
	
	public ItemPedido criarItemPedido(Produto produto, int quantidade) {
		ItemPedido iPedido = new ItemPedido();
		iPedido.setProduto(produto);
		iPedido.setQuantidade(quantidade);
		return iPedido;
	}
	
	public Pedido criarPedido(String data, Cliente cliente, ArrayList<ItemPedido> itenspedido) {
		Pedido nPedido = new Pedido();
		nPedido.setData(data);
		nPedido.setCliente(cliente);
		nPedido.setListaItens(itenspedido);
		nPedido.setCodigo(uPedido);
		uPedido++;
		cVendas.novoPedido(nPedido);
		return nPedido;
	}
	
	public String pegarData() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		return (format.format(data));
	}
	
	public Cliente verificarCPF(String cpf) {
		ArrayList<Cliente> listaClientes = persistencia.recuperarClientes();
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getCpf().equals(cpf)) {
				return listaClientes.get(i);
			}
		}
		return null;
	}
	
	public Produto verificarProduto(int codigo) {
		ArrayList<Produto> listaProdutos = persistencia.recuperarProdutos();
		for (int i = 0; i < listaProdutos.size(); i++) {
			if (listaProdutos.get(i).getCodigo().equals(codigo)) {
				return listaProdutos.get(i);
			}
		}
		return null;
	}

	public Iterator<Produto> getProdutosIterator() {
//		return persistencia.recuperarProdutos().iterator();
		return cVendas.getProdutos().iterator();
	}

	public Iterator<Cliente> getClientesIterator() {
//  	return persistencia.recuperarClientes().iterator();
		return cVendas.getClientes().iterator();
	}

	public Iterator<ItemPedido> getItemPedidosIterator() {
		return persistencia.recuperarItemPedidos().iterator();
	}	

	public Iterator<Pedido> getPedidosIterator() {
//		return persistencia.recuperarPedidos().iterator();
		return cVendas.getPedidos().iterator();
	}	
	
}