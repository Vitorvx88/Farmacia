package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Usuario;
import exceptions.UsuarioNaoExisteException;
import repositorio.RepositorioMedicamento;
import repositorio.RepositorioUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIdade;
	private JTextField textCPF;
	private Usuario usu= new Usuario();
	
	private int index = RepositorioUsuario.nomes.get(0).getIndex();
	private String n = RepositorioUsuario.nomes.get(index).getN();
	private String c= RepositorioUsuario.nomes.get(index).getC();
	private String i = String.valueOf(RepositorioUsuario.nomes.get(index).getI());
	private String s= RepositorioUsuario.nomes.get(index).getS();
	private JTextField textSenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarUsuario frame = new AlterarUsuario();
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
	public AlterarUsuario() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 11, 64, 23);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(12, 45, 258, 31);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Idade");
		lblNewLabel_1.setBounds(12, 153, 64, 23);
		contentPane.add(lblNewLabel_1);
		
		textIdade = new JTextField();
		textIdade.setBounds(12, 176, 64, 31);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int CPFNull=0;
					int nomeNull=0;
					int aux = Integer.parseInt(textIdade.getText());
					String auxNull ="";
					String CPF=textCPF.getText();
					String nome = textNome.getText();
					nome.toUpperCase();
				
				
					if(CPF.equals(auxNull)) {
						CPFNull=1;
					}
					if(textNome.getText().equals(auxNull)) {
						nomeNull=1;
					}
					if(CPFNull==0) {
						if(RepositorioUsuario.soConterNumeros(CPF)){
							if(RepositorioUsuario.digitosCPF(CPF)) {
								if(nomeNull==0) {
									if(RepositorioUsuario.soConterLetras(nome)!=true) {
										if(RepositorioUsuario.addUsuario(usu,aux)==true) {
											if(textSenha.getText().equals(auxNull)) {
												
												
												RepositorioUsuario.nomes.get(index).setNome(nome.toUpperCase());
												RepositorioUsuario.nomes.get(index).setCpf(CPF);
												RepositorioUsuario.nomes.get(index).setIdade(aux);
												RepositorioUsuario.nomes.remove(RepositorioUsuario.nomes.size()-1);
												JOptionPane.showMessageDialog(null, "Usuario Alterado com Sucesso!");
												
												Alterar obj3 = new Alterar();
												obj3.setVisible(true);	
												obj3.setResizable(false);
												obj3.setLocationRelativeTo(null);
												dispose();
											}
											else {
												if(RepositorioUsuario.TemMaisQueOitoDigitos(textSenha.getText())==true) {
													
													RepositorioUsuario.nomes.get(index).setNome(nome.toUpperCase());
													RepositorioUsuario.nomes.get(index).setCpf(CPF);
													RepositorioUsuario.nomes.get(index).setIdade(aux);
													RepositorioUsuario.nomes.get(index).setSenha(textSenha.getText());
													RepositorioUsuario.nomes.remove(RepositorioUsuario.nomes.size()-1);
													
													JOptionPane.showMessageDialog(null, "Usuario Alterado com Sucesso!");
													Alterar obj3 = new Alterar();
													obj3.setVisible(true);	
													obj3.setResizable(false);
													obj3.setLocationRelativeTo(null);
													dispose();
												}
												else {
													JOptionPane.showMessageDialog(null, "A senha tem que ser entre 8 e 14 digitos!");
												}
											}
											
										}
										else {
											JOptionPane.showMessageDialog(null, "Usuario precisa ter no minimo 18 anos!");
										}	
									}
									else
										JOptionPane.showMessageDialog(null, "O nome não pode conter números!");
								}
								else {
									JOptionPane.showMessageDialog(null, "O nome não pode ficar em branco!");
								}
							}
							else
								JOptionPane.showMessageDialog(null, "O CPF não tem 11 digitos!");
						}
						else
							JOptionPane.showMessageDialog(null, "O CPF só pode conter números!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Digite um CPF!");
					}
				}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos e em Idade digite apenas números!");
				}	
			}
		});
		btnNewButton_1.setBounds(392, 325, 94, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alterar obj = new Alterar();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				obj.setResizable(false);
				dispose();
			}
		});
		btnNewButton.setBounds(195, 327, 94, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(12, 86, 48, 14);
		contentPane.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(10, 111, 214, 31);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel label = new JLabel("Nome");
		label.setBounds(370, 11, 64, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("CPF");
		label_1.setBounds(370, 86, 48, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Idade");
		label_2.setBounds(370, 153, 64, 23);
		contentPane.add(label_2);
		
		JLabel lblSenhaopcional = new JLabel("Senha(Opcional)");
		lblSenhaopcional.setBounds(10, 218, 94, 23);
		contentPane.add(lblSenhaopcional);
		
		textSenha = new JTextField();
		textSenha.setBounds(12, 252, 212, 31);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(368, 218, 94, 23);
		contentPane.add(lblSenha);
		
		JLabel label_N = new JLabel(n);
		label_N.setBounds(370, 45, 323, 31);
		contentPane.add(label_N);
		
		JLabel label_C = new JLabel(c);
		label_C.setBounds(370, 111, 174, 31);
		contentPane.add(label_C);
		
		JLabel label_I = new JLabel(i);
		label_I.setBounds(370, 176, 58, 31);
		contentPane.add(label_I);
		
		JLabel label_S = new JLabel(s);
		label_S.setBounds(370, 252, 162, 31);
		contentPane.add(label_S);
		
		JButton btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepositorioUsuario.nomes.remove(index);
				JOptionPane.showMessageDialog(null, "Usuario Deletado com Sucesso!");
				Alterar obj3 = new Alterar();
				obj3.setVisible(true);	
				obj3.setResizable(false);
				obj3.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(604, 351, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}