package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import repositorio.AtualizarLista;
import repositorio.RepositorioAtualizarLista;
import repositorio.RepositorioCarrinho;
import repositorio.RepositorioCompra;
import repositorio.RepositorioMedicamento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class ListarProdutosMaisVendidos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProdutosMaisVendidos frame = new ListarProdutosMaisVendidos();
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
	public ListarProdutosMaisVendidos() {
		setTitle("Top Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 433, 184);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Coloca\u00E7\u00E3o", "Nome", "Quantidade", "Pre\u00E7o", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(65);
		table.getColumnModel().getColumn(1).setPreferredWidth(183);
		table.getColumnModel().getColumn(3).setPreferredWidth(59);
		table.getColumnModel().getColumn(4).setPreferredWidth(63);
		scrollPane.setViewportView(table);
		
		
		Collections.sort(RepositorioAtualizarLista.topProdutos);
		for(int i = 0; i <RepositorioAtualizarLista.topProdutos.size(); i++) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object [] {i,RepositorioAtualizarLista.topProdutos.get(i).getNome(),RepositorioAtualizarLista.topProdutos.get(i).getQuantidade(),RepositorioAtualizarLista.topProdutos.get(i).getPreco(),RepositorioAtualizarLista.topProdutos.get(i).getQuantidade()*RepositorioAtualizarLista.topProdutos.get(i).getPreco()});
		}
		
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal obj = new Principal();
				obj.setVisible(true);
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
