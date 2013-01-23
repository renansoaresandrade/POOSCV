package poo.scv.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;


import poo.scv.Cliente;
import poo.scv.ItemPedido;
import poo.scv.Produto;
import poo.scv.SCVException;
import poo.scv.SCVFacade;


public class SCV {

	static SCVFacade facade = new SCVFacade();
	
	public static void main (String[] args) {
		exibirMenu();
	}
	
	public static void exibirMenu() {
		String o = JOptionPane.showInputDialog("Bem vindo ao sistema de Gerenciamento de Vendas!\nEscolha a opção desejada:\n1-Cadastrar Produto\n2-Listar Produtos\n3-Cadastrar Clientes\n4-Listar Clientes\n5-Criar Item de Pedido\n6-Listar Itens de Pedido\n0-Sair","Sua opção");		
		lerEntradaUsuario(o);
	}

	private static void lerEntradaUsuario(String o) {
		int nOpcao = Integer.parseInt(o);
		switch (nOpcao) {
			case 1:
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do Produto:"));
				String nome = JOptionPane.showInputDialog("Nome do produto:");
				String descricao = JOptionPane.showInputDialog("Descrição do produto:");
				double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do produto:"));
				int perecivel = Integer.parseInt(JOptionPane.showInputDialog("1 - Produto Perecível \n 2 - Produto não perecível"));
				try {
					while (perecivel != 1 && perecivel != 2) {	
						JOptionPane.showMessageDialog(null, "Opção inválida! \n Digite novamente.");
						perecivel = Integer.parseInt(JOptionPane.showInputDialog("1 - Produto Perecível \n2 - Produto não perecível"));
					}
					if (perecivel == 2) {
						String validade = JOptionPane.showInputDialog("Digite a validade em formato dd/MM/yyyy:");
						facade.criarProdutoPerecivel(codigo, nome, descricao, preco, validade);
					} else if (perecivel == 1) {
						facade.criarProduto(codigo, nome, descricao, preco);
					}
				JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
				} catch (SCVException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				exibirMenu();
				break;
			case 2:
				Iterator<Produto> p1;
				p1 = facade.getProdutosIterator();
				String produtos = "";
				while (p1.hasNext()) {
					Produto p2 = p1.next();
					produtos +=  "[ Código: " + p2.getCodigo() + " || Nome: " + p2.getNome() + " || Descrição: " + p2.getDescricao() + " || Descrição: " + p2.getPreco() +  " ] " + "\n";
				}
				JOptionPane.showMessageDialog(null, produtos);
				exibirMenu();
				break;
			case 3:
				nome = JOptionPane.showInputDialog("Nome do cliente:");
				String cpf = JOptionPane.showInputDialog("CPF do cliente:");
				String telefone = JOptionPane.showInputDialog("Telefone do cliente:");

				try {
					facade.criarCliente(nome, cpf, telefone);
				JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
				} catch (SCVException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				exibirMenu();
				break;
			case 4:
				Iterator<Cliente> c1;
				c1 = facade.getClientesIterator();
				String clientes = "";
				while (c1.hasNext()) {
					Cliente c2 = c1.next();
					clientes +=  "[ Nome: " + c2.getNome() + " || Telefone: " + c2.getTelefone() + " || CPF: " + c2.getTelefone() + " ] " + "\n";
				}
				JOptionPane.showMessageDialog(null, clientes);
				exibirMenu();
				break;
			case 5:
				Iterator<Produto> i1;
				int idProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: "));
				i1 = facade.getProdutosIterator();
				int i = 0;
				while (i1.hasNext()) {
					Produto p2 = i1.next();
					if (p2.getCodigo() == idProduto) {
						i = 1;
						int idQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: "));
						facade.criarItemPedido(p2, idQuantidade);
						JOptionPane.showMessageDialog(null, "Item de Pedido adicionado com sucesso!");
						break;
					}
				}
				if (i == 0) {
					JOptionPane.showMessageDialog(null, "Não há produtos com o código digitado.");
				}
				exibirMenu();
				break;
			case 6:
				Iterator<ItemPedido> ip1;
				ip1 = facade.getItemPedidosIterator();
				String itempedidos = "";
				while (ip1.hasNext()) {
					ItemPedido ip2 = ip1.next();
					itempedidos +=  "[ Nome do produto: " + ip2.getProduto().getNome() + " || Quantidade: " + ip2.getQuantidade() + " ] " + "\n";
				}
				JOptionPane.showMessageDialog(null, itempedidos);
				exibirMenu();
				break;
		}
	}
}