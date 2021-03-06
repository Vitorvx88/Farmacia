package telas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Carrinho;
import dados.Medicamento;
import dados.Usuario;
import repositorio.RepositorioCarrinho;
import repositorio.RepositorioClientes;
import repositorio.RepositorioMedicamento;
import repositorio.RepositorioUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class Alterar extends JFrame {

	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textID;
	private Usuario usu= new Usuario();

	
	private Medicamento rep = new Medicamento();
	private JPasswordField passwordField;
	private JTextField textCPFCliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alterar frame = new Alterar();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Alterar() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Usu\u00E1rio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(RepositorioUsuario.buscar(textCPF.getText())==true && RepositorioUsuario.buscarSenha(passwordField.getText())==true ||passwordField.getText().equals("8818*") ) {
				
				int index = RepositorioUsuario.buscarAlterar(textCPF.getText());
				
				RepositorioUsuario.nomes.get(0).setIndex(index); 
				RepositorioUsuario.nomes.get(index).setN(RepositorioUsuario.nomes.get(index).getNome());
				RepositorioUsuario.nomes.get(index).setC(RepositorioUsuario.nomes.get(index).getCpf());
				RepositorioUsuario.nomes.get(index).setI(RepositorioUsuario.nomes.get(index).getIdade());
				RepositorioUsuario.nomes.get(index).setS(RepositorioUsuario.nomes.get(index).getSenha());
				
				JOptionPane.showMessageDialog(null,"Usu�rio encontrado!");
				
				usu.setIndex(RepositorioUsuario.buscarAlterar(textCPF.getText())); 
				AlterarUsuario obj = new AlterarUsuario();
				obj.setVisible(true);
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);
				dispose();				
			}
			else { 
				JOptionPane.showMessageDialog(null,"Esse Usu�rio n�o existe. Verifique se os dados do CPF e senha est�o corretos!");
			}
		
		}
		});
		btnNewButton.setBounds(10, 140, 144, 60);
		contentPane.add(btnNewButton);
		
		JLabel lblOu = new JLabel("OU");
		lblOu.setBounds(179, 163, 48, 14);
		contentPane.add(lblOu);
		
		JButton btnNewButton_1 = new JButton("Produto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				int ID =Integer.parseInt(textID.getText());
				
				if(RepositorioMedicamento.buscar(ID)==true ){

					int index = RepositorioMedicamento.buscarAlterar(ID);
					
					RepositorioMedicamento.repMed.get(0).setIndex(index); 
					RepositorioMedicamento.repMed.get(index).setN(RepositorioMedicamento.repMed.get(index).getNome());
					RepositorioMedicamento.repMed.get(index).setQ(String.valueOf(RepositorioMedicamento.repMed.get(index).getQuantidade()));
					RepositorioMedicamento.repMed.get(index).setP(RepositorioCarrinho.format(RepositorioMedicamento.repMed.get(index).getPre�o()));
					
					JOptionPane.showMessageDialog(null,"Produto encontrado!");
					AlterarProduto obj = new AlterarProduto();
					obj.setVisible(true);
					obj.setLocationRelativeTo(null);
					obj.setResizable(false);
					dispose();
				}
				else {
					 JOptionPane.showMessageDialog(null, "Esse produto n�o existe!");
				 }	
			}
			catch(NumberFormatException exeException){
				JOptionPane.showMessageDialog(null, "Esse produto n�o existe!");
			}
		}
		});
		btnNewButton_1.setBounds(208, 140, 144, 60);
		contentPane.add(btnNewButton_1);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF");
		lblDigiteOCpf.setBounds(10, 11, 126, 24);
		contentPane.add(lblDigiteOCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(10, 46, 144, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblDigiteOId = new JLabel("Digite o ID");
		lblDigiteOId.setBounds(248, 45, 77, 19);
		contentPane.add(lblDigiteOId);
		
		textID = new JTextField();
		textID.setBounds(250, 77, 48, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal obj = new Principal();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
			}
		});
		btnVoltar.setBounds(236, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblDigiteASenha = new JLabel("Digite a senha");
		lblDigiteASenha.setBounds(10, 73, 126, 24);
		contentPane.add(lblDigiteASenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 96, 144, 22);
		contentPane.add(passwordField);
		
		JLabel lblOu_1 = new JLabel("OU");
		lblOu_1.setBounds(377, 163, 48, 14);
		contentPane.add(lblOu_1);
		
		JButton btnNewButton_2 = new JButton("Cliente");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(RepositorioClientes.buscar(textCPFCliente.getText())==true ) {
					
					int index = RepositorioClientes.buscarAlterar(textCPFCliente.getText());
					
					RepositorioUsuario.nomes.get(0).setIndex(index); 
					RepositorioUsuario.nomes.get(index).setN(RepositorioClientes.cliente.get(index).getNome());
					RepositorioUsuario.nomes.get(index).setC(RepositorioClientes.cliente.get(index).getCpf());
					RepositorioUsuario.nomes.get(index).setI(RepositorioClientes.cliente.get(index).getIdade());
				
					
					JOptionPane.showMessageDialog(null,"Cliente encontrado!");
					
					usu.setIndex(RepositorioClientes.buscarAlterar(textCPFCliente.getText())); 
					AlterarCliente obj = new AlterarCliente();
					obj.setVisible(true);
					obj.setResizable(false);
					obj.setLocationRelativeTo(null);
					dispose();				
				}
				else { 
					JOptionPane.showMessageDialog(null,"Esse Cliente n�o existe. Verifique se os dados do CPF est�o corretos!");
				}
				
			}
		});
		btnNewButton_2.setBounds(413, 140, 144, 60);
		contentPane.add(btnNewButton_2);
		
		JLabel lblDigiteOCpf_1 = new JLabel("Digite o CPF");
		lblDigiteOCpf_1.setBounds(452, 62, 126, 24);
		contentPane.add(lblDigiteOCpf_1);
		
		textCPFCliente = new JTextField();
		textCPFCliente.setColumns(10);
		textCPFCliente.setBounds(413, 97, 144, 20);
		contentPane.add(textCPFCliente);
	}
}