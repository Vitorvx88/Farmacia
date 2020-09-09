package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Medicamento;
import Main.Usuario;
import Repositorio.RepositorioMedicamento;
import Repositorio.RepositorioUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JButton btnFinalizar;
	static private RepositorioMedicamento rep = new RepositorioMedicamento();
	private JPasswordField textSenha;
	private Usuario usu= new Usuario();
	private int entrar =0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("MyPharma");
		int idade = 21;
		
			
		if(RepositorioUsuario.buscar("12345678912")==false){
			if(RepositorioUsuario.addUsuario(usu,idade)==true) {
				usu.setNome("Vitor Felipe da Silva Lourenço");
				usu.setCpf("12345678912");
				usu.setIdade(21);
				usu.setSenha("123456789");
				
				Medicamento a1 = new Medicamento(0,"Dipirona",6,(float) 4.65,"");
				rep.addMedicamento(a1);
				Medicamento a2 = new Medicamento(1,"Suprin",12,(float) 14.95,"");
				rep.addMedicamento(a2);
				Medicamento a3 = new Medicamento(2,"Platin",21,(float) 19.23,"");
				rep.addMedicamento(a3);
				Medicamento a4 = new Medicamento(3,"Ecos",4,(float) 16.03,"");
				rep.addMedicamento(a4);
				Medicamento a5 = new Medicamento(4,"Fraldas M",33,(float) 95.09,"");
				rep.addMedicamento(a5);
				Medicamento a6 = new Medicamento(5,"Fraldas G",48,(float) 112.84,"");
				rep.addMedicamento(a6);
			}
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(122, 40, 101, 29);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(122, 116, 48, 14);
		contentPane.add(lblSenha);
		
		textLogin = new JTextField();
		textLogin.setBounds(122, 80, 167, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((RepositorioUsuario.buscar(textLogin.getText())==true) && (RepositorioUsuario.buscarSenha(textSenha.getText())==true)) {
					JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema!");
					Principal obj = new Principal();
					obj.setVisible(true);	
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado!");
					Login obj = new Login();
					obj.setVisible(true);	
					dispose();
				}
			}
		});
		btnEntrar.setBounds(211, 200, 89, 23);
		contentPane.add(btnEntrar);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setToolTipText("");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login obj = new Login();
				obj.setVisible(false);	
				dispose();
			}
		});
		btnFinalizar.setBounds(108, 200, 89, 23);
		contentPane.add(btnFinalizar);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(122, 141, 167, 20);
		contentPane.add(textSenha);
	}
}
