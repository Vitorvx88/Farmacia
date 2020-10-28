package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Clientes;
import dados.Usuario;
import repositorio.RepositorioClientes;
import repositorio.RepositorioMedicamento;
import repositorio.RepositorioUsuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField IntIdade;
	

	private Clientes cliente= new Clientes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCliente frame = new CadastrarCliente();
					frame.setVisible(true);
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
	public CadastrarCliente() {
		
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(10, 36, 290, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 64, 28);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 75, 48, 14);
		contentPane.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(10, 92, 290, 28);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal obj = new Principal();
				obj.setVisible(true);
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnVoltar.setBounds(10, 223, 89, 23);
		contentPane.add(btnVoltar);
	
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					int CPFNull=0;
					int nomeNull=0;
					int idade = Integer.parseInt(IntIdade.getText());
					String nome = textNome.getText();
					nome.toUpperCase();
					String CPF = textCPF.getText();
					String auxNull ="";
					
					if(textCPF.getText().equals(auxNull)) {
						CPFNull=1;
					}
					if(textNome.getText().equals(auxNull)) {
						nomeNull=1;
					}
					if(CPFNull==0){
						if(nomeNull==0){
							if(RepositorioClientes.soConterLetras(nome)!=true) {
								if(RepositorioClientes.buscar(CPF)!=true) {
									if(RepositorioClientes.soConterNumeros(CPF)){
										if(RepositorioClientes.digitosCPF(CPF)) {
											if(RepositorioClientes.addCliente(cliente,idade)==true) {
												cliente.setNome(nome.toUpperCase());
												cliente.setCpf(CPF = CPF.replaceAll(" ",""));
												cliente.setIdade(idade);
												JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
												dispose();
												CadastrarCliente obj3 = new CadastrarCliente();
												obj3.setVisible(true);	
												obj3.setResizable(false);
												obj3.setLocationRelativeTo(null);
												dispose();
											}
											else {
												JOptionPane.showMessageDialog(null, "Cliente precisa ter no minimo 18 anos!");
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "O CPF não tem 11 digitos!");
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "O CPF só pode conter números!");
									}
								}
								else
									JOptionPane.showMessageDialog(null, "Esse CPF já estar Cadastrado!");
							}
							else
								JOptionPane.showMessageDialog(null, "O nome não pode conter números!");
						}
						else {
							JOptionPane.showMessageDialog(null, "O nome não pode ficar em branco!");
						}	
					}
					else {
						JOptionPane.showMessageDialog(null, "Digite um CPF!");
					}
				}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos e em Idade digite apenas número!");
				}
			}
		});
		btnNewButton.setBounds(173, 223, 98, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 131, 48, 14);
		contentPane.add(lblIdade);
		
		IntIdade = new JTextField();
		IntIdade.setBounds(10, 156, 48, 28);
		contentPane.add(IntIdade);
		IntIdade.setColumns(10);
	}
}
