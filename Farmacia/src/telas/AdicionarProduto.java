package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import repositorio.RepositorioMedicamento;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdicionarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textQuant;
	private static RepositorioMedicamento r = new RepositorioMedicamento();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarProduto frame = new AdicionarProduto();
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
	public AdicionarProduto() {
		

		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(25, 195, 161, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textQuant = new JTextField();
		textQuant.setBounds(235, 195, 37, 20);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(25, 164, 102, 20);
		contentPane.add(lblNomeDoProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(226, 164, 74, 20);
		contentPane.add(lblQuantidade);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 439, 142);
		contentPane.add(scrollPane);
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
		btnVoltar.setBounds(161, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int Quant = Integer.parseInt((textQuant.getText()));
					String nome = textNome.getText();
					int IndexBus = RepositorioMedicamento.buscar(nome.toUpperCase());
					if(IndexBus!=-1){
						if(Quant>0) {
							RepositorioMedicamento.repMed.get(IndexBus).setQuantidade1(Quant);
							JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
							AdicionarProduto obj = new AdicionarProduto();
							obj.setLocationRelativeTo(null);
							obj.setResizable(false);
							obj.setVisible(true);
							dispose();
						}
						else
							JOptionPane.showMessageDialog(null, "Quatidade tem que ser maior que 0!");
					}
					else
					JOptionPane.showMessageDialog(null, "Esse produto não existe!");
				}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Não pode deixar os campos em branco e digite apenas números para quantade !");
				}
			}
		});
		btnAdicionar.setBounds(310, 163, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int Quant = Integer.parseInt((textQuant.getText()));
					String nome = textNome.getText();
					int IndexBus = RepositorioMedicamento.buscar(nome.toUpperCase());
					if(IndexBus!=-1){
						if(Quant>0) {
							if(Quant <= RepositorioMedicamento.repMed.get(IndexBus).getQuantidade()) {
								RepositorioMedicamento.repMed.get(IndexBus).setQuantidade1(-Quant);
								
								if(RepositorioMedicamento.repMed.get(IndexBus).getQuantidade()==0) {
									RepositorioMedicamento.repMed.remove(IndexBus);
									JOptionPane.showMessageDialog(null, "Quantidade removida com sucesso!");

									AdicionarProduto obj = new AdicionarProduto();
									obj.setLocationRelativeTo(null);
									obj.setVisible(false);
									obj.setResizable(false);
									dispose();
								}
								else
									JOptionPane.showMessageDialog(null, "Quantidade removida com sucesso!");
									AdicionarProduto obj = new AdicionarProduto();
									obj.setLocationRelativeTo(null);
									obj.setVisible(true);
									obj.setResizable(false);
									dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "O valor é maior que a quantidade em estoque!");	
						}
						else
							JOptionPane.showMessageDialog(null, "Quatidade tem que ser maior que 0!");
					}
					else
					JOptionPane.showMessageDialog(null, "Esse produto não existe!");
				}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Não pode deixar os campos em branco e digite apenas números para quantade !");
				}
			}
		});
		btnRemover.setBounds(310, 194, 89, 23);
		contentPane.add(btnRemover);
		

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
		table.getColumnModel().getColumn(0).setPreferredWidth(47);
		table.getColumnModel().getColumn(1).setPreferredWidth(148);
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		table.getColumnModel().getColumn(3).setPreferredWidth(66);
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for(int i = 0; i < RepositorioMedicamento.repMed.size(); i++) {
			model.addRow(new Object [] {RepositorioMedicamento.repMed.get(i).getId(),RepositorioMedicamento.repMed.get(i).getNome(),RepositorioMedicamento.repMed.get(i).getQuantidade(),RepositorioMedicamento.repMed.get(i).getPreço(),RepositorioMedicamento.repMed.get(i).getPromo()});
		}
	}
}
