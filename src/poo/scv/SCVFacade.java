package poo.scv;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import poo.scv.io.SCVPersistencia;
import poo.scv.io.SCVPersistenciaMemoria;

public class SCVFacade {
	
	static SCVPersistencia persistencia = new SCVPersistenciaMemoria();
	
	public Cliente criarCliente(String nome, String cpf, String telefone) throws SCVException {
		Cliente nCliente = new Cliente();
		nCliente.setNome(nome);
		nCliente.setCpf(cpf);
		nCliente.setTelefone(telefone);
		persistencia.salvar(nCliente);
		return nCliente;
	}

	public Produto criarProduto(int codigo, String nome, String descricao, double preco) throws SCVException {
		Produto nProduto = new Produto();
		nProduto.setCodigo(codigo);
		nProduto.setNome(nome);
		nProduto.setDescricao(descricao);
		nProduto.setPreco(preco);
		persistencia.salvar(nProduto);
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
	
	public Pedido criarPedido(String data, Cliente cliente) {
		Pedido nPedido = new Pedido();
		nPedido.setData(data);
		nPedido.setCliente(cliente);
		return nPedido;
	}
	
	public String pegarData() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		return (format.format(data));
	}
	
	public Iterator<Produto> getProdutosIterator() {
		return persistencia.recuperarProdutos().iterator();
	}

	public Iterator<Cliente> getClientesIterator() {
		return persistencia.recuperarClientes().iterator();
	}

	public Iterator<ItemPedido> getItemPedidosIterator() {
		return persistencia.recuperarItemPedidos().iterator();
	}	
}