package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dados.Carrinho;
import dados.Medicamento;
import repositorio.AtualizarLista;
import repositorio.RepositorioAtualizarLista;
import repositorio.RepositorioCarrinho;
import repositorio.RepositorioMedicamento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListarProdutos extends JFrame {

	private JPanel contentPane;
	private RepositorioMedicamento rep = new RepositorioMedicamento();
	
	private RepositorioCarrinho recar = new RepositorioCarrinho();
	private JTextField textQuant;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProdutos frame = new ListarProdutos();
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
	public ListarProdutos() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "QUANTIDADE", "PRE\u00C7O", "PROMO\u00C7\u00C3O"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(71);
		table.getColumnModel().getColumn(4).setPreferredWidth(73);
		scrollPane.setViewportView(table);
		for(int i = 0; i < RepositorioMedicamento.repMed.size(); i++) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object [] {(RepositorioMedicamento.repMed.get(i).getId()),(RepositorioMedicamento.repMed.get(i).getNome()),
					RepositorioMedicamento.repMed.get(i).getQuantidade(),RepositorioMedicamento.repMed.get(i).getPreço(),RepositorioMedicamento
					.repMed.get(i).getPromo()});
			scrollPane.setColumnHeaderView(table);
		}
		scrollPane.setViewportView(table);
		
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
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAddAoCarrinho = new JButton("Add ao Carrinho");
		btnAddAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
					int ID= table.getSelectedRow();
					int Quant= Integer.parseInt(textQuant.getText());
					int VerifID = RepositorioCarrinho.Verificar(RepositorioMedicamento.repMed.get(ID).getNome());//vai verificar se há o produto no carrinho
					if(RepositorioCarrinho.buscarID(ID)==true) {
						if(RepositorioMedicamento.repMed.get(ID).getQuantidade()!=0) {//verificar se tem no stoque
							if(Quant > 0) {//verificando se a quantida que o adm quer é maior que 0
							if(Quant <= RepositorioMedicamento.repMed.get(ID).getQuantidade()) {// virificando se quantidade que o adm quer é menor que a quantidade em etoque		
									if(VerifID !=-1) {//se for diferente de -1 é pq o produto existe
										RepositorioMedicamento.repMed.get(ID).setQuantidade1(-Quant);
										RepositorioCarrinho.car.get(VerifID).setQuantidade1(Quant);
										JOptionPane.showMessageDialog(null, "Produto adicionado no carrinho");
										ListarProdutos obj = new ListarProdutos();
										obj.setVisible(true);
										obj.setLocationRelativeTo(null);
										obj.setResizable(false);
										dispose();
										
									}else {
										RepositorioMedicamento.repMed.get(ID).setQuantidade1(-Quant);
										RepositorioMedicamento.repMed.get(ID).setQuantRemove(Quant);
										JOptionPane.showMessageDialog(null, "Produto adicionado no carrinho");
										Carrinho m1 = new Carrinho (RepositorioCarrinho.car.size(),RepositorioMedicamento.repMed.get(ID).getNome(),Quant,RepositorioMedicamento.repMed.get(ID).getPreço(),RepositorioMedicamento.repMed.get(ID).getPromo());
										RepositorioCarrinho.addNoCarrinho(m1);
										ListarProdutos obj = new ListarProdutos();
										obj.setVisible(true);
										obj.setLocationRelativeTo(null);
										obj.setResizable(false);
										dispose();
									}
								}
								else
									JOptionPane.showMessageDialog(null,"Quantidade de produto é maior que a quante em estoque!");
							}
							else
								JOptionPane.showMessageDialog(null,"Digite ao menos uma Quantidade!");
						}
						else {
							JOptionPane.showMessageDialog(null,"Acabou o produto em estoque");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Esse pruduto não exite!");
					}
				
				}
				catch(java.lang.NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Digite o ID do produto para ser adicionado no carrinho!");
				}
				}
				catch(IndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "Esse produto não existe, virifique o ID!");
				}
				
			}
		});
		btnAddAoCarrinho.setBounds(287, 227, 137, 23);
		contentPane.add(btnAddAoCarrinho);
		
		JLabel lblQuant = new JLabel("Quant.");
		lblQuant.setBounds(204, 231, 46, 14);
		contentPane.add(lblQuant);
		
		textQuant = new JTextField();
		textQuant.setBounds(239, 230, 40, 20);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
	}
}
