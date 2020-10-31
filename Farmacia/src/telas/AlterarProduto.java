package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Medicamento;
import repositorio.RepositorioCarrinho;
import repositorio.RepositorioMedicamento;
import repositorio.RepositorioPromocao;
import repositorio.RepositorioUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;

public class AlterarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textProduto;
	private JTextField textQuant;
	private JTextField textPreç;
	
	private int index = RepositorioMedicamento.repMed.get(0).getIndex();
	private String n = RepositorioMedicamento.repMed.get(index).getN();
	private String q= RepositorioMedicamento.repMed.get(index).getQ();
	private String p = RepositorioMedicamento.repMed.get(index).getP();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarProduto frame = new AlterarProduto();
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
	public AlterarProduto() {
		

		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(30, 48, 103, 21);
		contentPane.add(lblNomeDoProduto);
		
		textProduto = new JTextField();
		textProduto.setBounds(23, 73, 146, 21);
		contentPane.add(textProduto);
		textProduto.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(30, 131, 74, 14);
		contentPane.add(lblQuantidade);
		
		textQuant = new JTextField();
		textQuant.setBounds(30, 156, 57, 31);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(30, 212, 57, 21);
		contentPane.add(lblPreo);
		
		textPreç = new JTextField();
		textPreç.setBounds(30, 231, 57, 31);
		contentPane.add(textPreç);
		textPreç.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alterar obj = new Alterar();
				obj.setVisible(true);
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setBounds(80, 310, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				int Quant = Integer.parseInt(textQuant.getText());
				float Preç = Float.parseFloat(textPreç.getText());
		
				int aux=0;
				String produto = textProduto.getText();
				produto.toUpperCase();
				String verificarNull="";
				
				
				if(verificarNull.equals(produto)) {
					aux=1;
				}
				
				if(RepositorioUsuario.soConterLetras(produto)) {
					aux=1;	
				}
				
				if(Quant >0 && Preç>0 && aux ==0) {
					if(RepositorioMedicamento.repMed.get(index).getPromo()!="") {
						RepositorioMedicamento.repMed.get(index).setNome(textProduto.getText().toUpperCase());
						RepositorioMedicamento.repMed.get(index).setQuantidade(Quant);
						RepositorioMedicamento.repMed.get(index).setPreço(Preç);
						RepositorioMedicamento.repMed.get(index).setValorAnterior(Preç);
						RepositorioPromocao.desconto(index, RepositorioMedicamento.repMed.get(index).getDesc());
						
						JOptionPane.showMessageDialog(null,"Produto Alterado com sucesso!");
						
						Alterar obj3 = new Alterar();
						obj3.setVisible(true);	
						obj3.setResizable(false);
						obj3.setLocationRelativeTo(null);
						dispose();
					}
					else {
						RepositorioMedicamento.repMed.get(index).setNome(textProduto.getText().toUpperCase());
						RepositorioMedicamento.repMed.get(index).setQuantidade(Quant);
						RepositorioMedicamento.repMed.get(index).setPreço(Preç);
						RepositorioMedicamento.repMed.get(index).setValorAnterior(Preç);
						JOptionPane.showMessageDialog(null,"Produto Alterado com sucesso!");
						
						Alterar obj3 = new Alterar();
						obj3.setVisible(true);	
						obj3.setResizable(false);
						obj3.setLocationRelativeTo(null);
						dispose();
					}
				}
				else {
					if(Quant<=0) {
						JOptionPane.showMessageDialog(null,"Tem que ter ao menos uma quantidade de produto!");
					}
					else if(Preç <= 0) {
						JOptionPane.showMessageDialog(null,"O preço do produto não pode ser 0,00 !");
					}
					
					else {
						JOptionPane.showMessageDialog(null,"O nome do produto não pode ficar em branco ou conter números!");
					}
				}
			}
			catch(NumberFormatException exception) {
				JOptionPane.showMessageDialog(null,"Preencha todos os campos e Preço/Quantidade só digite apenas números!");
			}
			}
		
		});
		btnAlterar.setBounds(325, 310, 89, 23);
		contentPane.add(btnAlterar);
		
		JLabel label = new JLabel("Nome do Produto");
		label.setBounds(355, 61, 103, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Quantidade");
		label_1.setBounds(355, 131, 74, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Pre\u00E7o");
		label_2.setBounds(355, 199, 57, 21);
		contentPane.add(label_2);
		
		JLabel Nome = new JLabel(n);
		Nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Nome.setBounds(355, 84, 153, 23);
		contentPane.add(Nome);
		
		JLabel Quantidade = new JLabel(q);
		Quantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Quantidade.setBounds(355, 158, 45, 23);
		contentPane.add(Quantidade);
	
		JLabel Preço = new JLabel(p);
		Preço.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Preço.setBounds(355, 223, 57, 23);
		contentPane.add(Preço);
	}
	
}