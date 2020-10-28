package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Usuario;
import repositorio.RepositorioMedicamento;
import repositorio.RepositorioUsuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField IntIdade;
	

	private Usuario usu= new Usuario();
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 383);
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
				obj.setVisible(false);
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnVoltar.setBounds(10, 297, 89, 23);
		contentPane.add(btnVoltar);
	
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					int CPFNull=0;
					int nomeNull=0;
					int senhaNull=0;
					int idade = Integer.parseInt(IntIdade.getText());
					String nome = textNome.getText();
					nome.toUpperCase();
					String CPF = textCPF.getText();
					String senha = textSenha.getText();
					String auxNull ="";
					
					if(textCPF.getText().equals(auxNull)) {
						CPFNull=1;
					}
					if(textNome.getText().equals(auxNull)) {
						nomeNull=1;
					}
					if(textSenha.getText().equals(auxNull)) {
						senhaNull=1;
					}
					if(CPFNull==0){
						if(nomeNull==0){
							if(RepositorioUsuario.soConterLetras(nome)!=true) {
								if(senhaNull==0){
									if(RepositorioUsuario.TemMaisQueOitoDigitos(senha)==true) {
										if(RepositorioUsuario.buscar(CPF)!=true) {
											if(RepositorioUsuario.soConterNumeros(CPF)){
												if(RepositorioUsuario.digitosCPF(CPF)) {
													if(RepositorioUsuario.addUsuario(usu,idade)==true) {
														usu.setNome(nome.toUpperCase());
														usu.setCpf(CPF = CPF.replaceAll(" ",""));
														usu.setIdade(idade);
														usu.setSenha(senha);
														JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso!");
														dispose();
														Cadastro obj3 = new Cadastro();
														obj3.setVisible(true);	
														obj3.setResizable(false);
														obj3.setLocationRelativeTo(null);
														dispose();
													}
													else {
														JOptionPane.showMessageDialog(null, "Usuario precisa ter no minimo 18 anos!");
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
									else {
										JOptionPane.showMessageDialog(null, "A senha tem que ser entre 8 e 14 digitos!");
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "A senha não pode ficar em branco!");
								}
							
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
		btnNewButton.setBounds(178, 297, 98, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 131, 48, 14);
		contentPane.add(lblIdade);
		
		IntIdade = new JTextField();
		IntIdade.setBounds(10, 156, 48, 28);
		contentPane.add(IntIdade);
		IntIdade.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 195, 64, 28);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(10, 228, 148, 28);
		contentPane.add(textSenha);
	}
}
