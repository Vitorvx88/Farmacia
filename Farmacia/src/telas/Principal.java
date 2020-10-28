package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.LabelUI;

import dados.Medicamento;
import repositorio.AtualizarLista;
import repositorio.RepositorioMedicamento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
	
		
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar Usuario");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcessarCadastroUsuario obj = new AcessarCadastroUsuario();
				obj.setVisible(true);	
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);

			}
		});
		btnCadastrar.setBounds(275, 22, 165, 40);
		contentPane.add(btnCadastrar);
		
		JButton btnListarProdutos = new JButton("Listar Usuarios");
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuariosCadastrados obj = new ListarUsuariosCadastrados();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
				
			}
		});
		btnListarProdutos.setBounds(10, 73, 153, 40);
		contentPane.add(btnListarProdutos);
		
		JButton btnNewButton = new JButton("Listar Produtos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProdutos obj = new ListarProdutos();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
						
			}
		});
		btnNewButton.setBounds(10, 124, 153, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Produto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//label.setText("qwew");
				
				CadastrarProduto obj3 = new CadastrarProduto();
				obj3.setVisible(true);
				obj3.setLocationRelativeTo(null);
				obj3.setResizable(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(275, 73, 165, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Encerrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login obj3 = new Login();
				obj3.setVisible(true);
				obj3.setLocationRelativeTo(null);
				obj3.setResizable(false);
				dispose();
			}
		});
		btnNewButton_2.setBounds(351, 382, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alterar obj = new Alterar();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
			}
		});
		btnNewButton_3.setBounds(275, 277, 165, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Carrinho");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarrinhoTela obj = new CarrinhoTela();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
			}
		});
		btnNewButton_4.setBounds(10, 22, 153, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Cadastrar Promo\u00E7\u00E3o");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Promocao obj = new Promocao();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
			}
		});
		btnNewButton_5.setBounds(275, 175, 165, 40);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Promo\u00E7\u00E3o");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPromocao obj = new ListarPromocao();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
			}
		});
		btnNewButton_6.setBounds(10, 226, 153, 40);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Adicionar Produto");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarProduto obj = new AdicionarProduto();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
			}
		});
		btnNewButton_7.setBounds(275, 226, 165, 40);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Produtos Vendidos");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProdutosVendidos obj = new ListarProdutosVendidos();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
			}
		});
		btnNewButton_8.setBounds(10, 329, 153, 40);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Top Produtos");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarProdutosMaisVendidos obj = new ListarProdutosMaisVendidos();
				obj.setVisible(true);
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_9.setBounds(10, 278, 153, 40);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Cadastrar Clientes");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente obj = new CadastrarCliente();
				obj.setVisible(true);	
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_10.setBounds(275, 124, 165, 40);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Listar Clientes");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClientesCadastrados obj = new ListarClientesCadastrados();
				obj.setVisible(true);
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_11.setBounds(10, 175, 153, 40);
		contentPane.add(btnNewButton_11);
		float b = 1;
		String a = String.valueOf(b);
	}
}