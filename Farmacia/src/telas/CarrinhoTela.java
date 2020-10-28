package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arquivo.ManipuladorArquivo;
import dados.Carrinho;
import dados.Compra;
import repositorio.AtualizarLista;
import repositorio.RepositorioAtualizarLista;
import repositorio.RepositorioCarrinho;
<<<<<<< HEAD:Farmacia/src/telas/CarrinhoTela.java
import repositorio.RepositorioClientes;
=======
>>>>>>> f77c50d2a7c15d5a913271f457fb6c0a614d6c5e:Farmacia/src/Tela/CarrinhoTela.java
import repositorio.RepositorioCompra;
import repositorio.RepositorioMedicamento;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;



public class CarrinhoTela extends JFrame {


	private JPanel contentPane;
	
	private Carrinho car = new Carrinho();
	private JTextField textQuant;

<<<<<<< HEAD:Farmacia/src/telas/CarrinhoTela.java
	private double total =0;
=======
	private double total = 0;
>>>>>>> f77c50d2a7c15d5a913271f457fb6c0a614d6c5e:Farmacia/src/Tela/CarrinhoTela.java
	private String a ="";
	private JTable table;
	private int test=0;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarrinhoTela frame = new CarrinhoTela();
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
	public CarrinhoTela() {
		
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter foratadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data= hoje.format(foratadorBarra);
		String horas=RepositorioCarrinho.hora();
	
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 471, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "QUANTIDADE", "PRE\u00C7O", "TOTAL", "PROMO\u00C7\u00C3O"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(48);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(79);
		table.getColumnModel().getColumn(3).setPreferredWidth(64);
		table.getColumnModel().getColumn(4).setPreferredWidth(66);
		table.getColumnModel().getColumn(5).setPreferredWidth(73);
		scrollPane.setViewportView(table);
		
		for(int i = 0; i < RepositorioCarrinho.car.size(); i++) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object [] {(RepositorioCarrinho.car.get(i).getID()),(RepositorioCarrinho.car.get(i).getNome()),
<<<<<<< HEAD:Farmacia/src/telas/CarrinhoTela.java
			RepositorioCarrinho.car.get(i).getQuantidade(),RepositorioCarrinho.car.get(i).getPreco(),(RepositorioCarrinho.car.get(i).getPreco()*RepositorioCarrinho.car.get(i).getQuantidade()-car.getValor()),RepositorioCarrinho.car.get(i).getPromo()});
			scrollPane.setColumnHeaderView(table);
			total+=((RepositorioCarrinho.car.get(i).getPreco()*RepositorioCarrinho.car.get(i).getQuantidade()));
			car.setDescont(total);
			total+=-car.getValor();
=======
			RepositorioCarrinho.car.get(i).getQuantidade(),RepositorioCarrinho.car.get(i).getPreco(),(RepositorioCarrinho.car.get(i).getPreco()*RepositorioCarrinho.car.get(i).getQuantidade()),RepositorioCarrinho.car.get(i).getPromo()});
			scrollPane.setColumnHeaderView(table);
			total+=(RepositorioCarrinho.car.get(i).getPreco()*RepositorioCarrinho.car.get(i).getQuantidade());
>>>>>>> f77c50d2a7c15d5a913271f457fb6c0a614d6c5e:Farmacia/src/Tela/CarrinhoTela.java
			}
		scrollPane.setViewportView(table);
		
		a = RepositorioCarrinho.format(total);	///Label do total!
		
		textQuant = new JTextField();
		textQuant.setBounds(387, 211, 38, 20);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total:"+ a);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 211, 153, 23);
		contentPane.add(lblNewLabel);
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
		btnVoltar.setBounds(10, 239, 75, 23);
		contentPane.add(btnVoltar);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<RepositorioCarrinho.car.size(); i++) {//Passando a lista carrinho para um lista de compra
<<<<<<< HEAD:Farmacia/src/telas/CarrinhoTela.java
					Compra m1 = new Compra(RepositorioCompra.compr.size()-1,RepositorioCarrinho.car.get(i).getNome(),RepositorioCarrinho.car.get(i).getQuantidade(),(RepositorioCarrinho.car.get(i).getQuantidade()*RepositorioCarrinho.car.get(i).getPreco()),data,horas,RepositorioCarrinho.car.get(i).getPreco());
=======
					Compra m1 = new Compra(RepositorioCompra.compr.size()-1,RepositorioCarrinho.car.get(i).getNome(),RepositorioCarrinho.car.get(i).getQuantidade(),(RepositorioCarrinho.car.get(i).getQuantidade()*RepositorioCarrinho.car.get(i).getPreco()),data,horas);
>>>>>>> f77c50d2a7c15d5a913271f457fb6c0a614d6c5e:Farmacia/src/Tela/CarrinhoTela.java
					RepositorioCompra.addCompra(m1);
				}//fim copia
				
				for(int i = 0; i<RepositorioCarrinho.car.size(); i++) {//Passando a lista carrinho para um lista de compra
					RepositorioCarrinho.car.get(i).setQuantidade(0);	
				}
				
				String Nomes=""; String quant=""; int Quantidades=0; String QuantidadesNome =""; double Preccos=0; String pre="";
				
				for(int i =0; i< RepositorioCarrinho.car.size();i++) {
					Nomes = Nomes + "|"+ RepositorioCarrinho.car.get(i).getNome();
					QuantidadesNome = QuantidadesNome + "|" +RepositorioCompra.compr.get(i).getQuantidade();
					Quantidades = Quantidades  + RepositorioCompra.compr.get(i).getQuantidade();
					quant = quant +"|"+ RepositorioCompra.compr.get(i).getQuantidade();
					Preccos = Preccos  +  (RepositorioCarrinho.car.get(i).getPreco() * Quantidades);
					pre = pre +"|"+ RepositorioCarrinho.format(RepositorioCarrinho.car.get(i).getPreco());
					
				
				}
				String Preccos2 = RepositorioCarrinho.format(total);
				
				RepositorioCarrinho.car.removeAll(RepositorioCarrinho.car);//limpando o carrinho!
				String arq = "C:\\Users\\Vitor_2\\Desktop\\NotaFiscal.txt";
				String textoR = ManipuladorArquivo.leitor(arq);
					if(textoR.isEmpty()) {
						String Inf =("NOME       : " + Nomes +"|\n"+
								"PREÇO      : " + pre+"|\n"+
								"QUANTIDADES: "+quant 
								+ "\n" + "TOTAL      : " +Preccos2 +"\n" + "DATA       : " +
								data+ "\n" + "HORAS      : "+horas);
						ManipuladorArquivo.Write(arq, Inf);
					}
					else {
						ManipuladorArquivo.deleteTree("D:\\Usuário\\Vitorvx\\Desktop\\NotaFiscal.txt");
						String Inf =("NOME       :" + Nomes +"|\n"+"QUANTIDADES:"+QuantidadesNome + "|\n" + "TOTAL      :" +Preccos2 +"\n" + "DATA       :" +data+ "\n" + "HORAS      :"+horas);
						ManipuladorArquivo.Write(arq, Inf);
					}
				
					for(int i = 0; i<RepositorioCompra.compr.size(); i++) {
						
						String produto =RepositorioCompra.compr.get(i).getNome().toUpperCase();
						int aux= RepositorioAtualizarLista.vrfNome(produto);
						boolean busca = RepositorioAtualizarLista.Verificar(produto);
						if(aux!=-1){
							for(int j = 0; j<RepositorioCompra.compr.size(); j++) {
								if(RepositorioCompra.compr.get(j).getNome().equals(produto)) {
									test+=RepositorioCompra.compr.get(j).getQuantidade();
								}
							}
							RepositorioAtualizarLista.topProdutos.get(aux).setQuantidade(test);
							test=0;
						}
						if(busca!=true) {
							AtualizarLista m1 = new AtualizarLista (RepositorioAtualizarLista.topProdutos.size(),RepositorioCompra.compr.get(i).getNome(),RepositorioCompra.compr.get(i).getQuantidade(),RepositorioCompra.compr.get(i).getPreco());
							RepositorioAtualizarLista.addTopLista(m1);		
						}
					}
				car.setValor(0);
				/**************************************************************************************/
				JOptionPane.showMessageDialog(null, "Venda Efetuada com Sucesso!");
				CarrinhoTela obj = new CarrinhoTela();
				obj.setVisible(true);
				obj.setResizable(false);
				obj.setLocationRelativeTo(null);
				dispose();
		}
		});
		btnComprar.setBounds(372, 239, 98, 23);
		contentPane.add(btnComprar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						int ID = table.getSelectedRow();
						int VerifID=0;
						int Quant = Integer.parseInt(textQuant.getText());
						if(Quant > RepositorioCarrinho.car.get(ID).getQuantidade()) {
							car.setIndexRemove(ID);
							car.setIndexQuantRmove(Quant);
							RemoverDoCarrinho obj3 = new RemoverDoCarrinho();
							obj3.setVisible(true);
							obj3.setResizable(false);
							obj3.setLocationRelativeTo(null);
							dispose();	
						}
						else{
							if(Quant>0) {
								VerifID = RepositorioMedicamento.VerificarPorNome(RepositorioCarrinho.car.get(ID).getNome());
								RepositorioCarrinho.car.get(ID).setQuantidade1(-Quant);
								RepositorioMedicamento.repMed.get(VerifID).setQuantidade1(Quant);
								if(RepositorioCarrinho.car.get(ID).getQuantidade()==0) {
									RepositorioCarrinho.car.remove(ID);
									for(int i = 0; i<RepositorioCarrinho.car.size(); i++) {//Passando a lista carrinho para um lista auxiliar
										AtualizarLista m1 = new AtualizarLista (RepositorioAtualizarLista.att.size()-1,RepositorioCarrinho.car.get(i).getNome(),RepositorioCarrinho.car.get(i).getQuantidade(),RepositorioCarrinho.car.get(i).getPreco(),RepositorioMedicamento
												.repMed.get(i).getPromo());
										RepositorioAtualizarLista.addNaLista(m1);
										RepositorioAtualizarLista.att.get(i).toString();		
									}//fim copia
									RepositorioCarrinho.car.removeAll(RepositorioCarrinho.car);
									for(int i = 0; i<RepositorioAtualizarLista.att.size(); i++) {
										Carrinho m1 = new Carrinho (RepositorioCarrinho.car.size(),RepositorioAtualizarLista.att.get(i).getNome(),RepositorioAtualizarLista.att.get(i).getQuantidade(),RepositorioAtualizarLista.att.get(i).getPreco(),RepositorioMedicamento
												.repMed.get(i).getPromo());
										RepositorioCarrinho.addNoCarrinho(m1);
									}
									RepositorioAtualizarLista.att.removeAll(RepositorioAtualizarLista.att);
									JOptionPane.showMessageDialog(null, "Quantidade Removida com sucesso!");
									scrollPane.setViewportView(table);
									CarrinhoTela obj3 = new CarrinhoTela();
									obj3.setVisible(true);
									obj3.setResizable(false);
									obj3.setLocationRelativeTo(null);
									dispose();
								}
								else {
									if(Quant <0 || Quant ==0) {
										JOptionPane.showMessageDialog(null, "Digite ao menos uma quantidade!");
									}
									else {
										if(Quant <0 || Quant ==0) {
											JOptionPane.showMessageDialog(null, "Digite ao menos uma quantidade!");
										}
										JOptionPane.showMessageDialog(null, "Quantidade Removida com sucesso!");
										CarrinhoTela obj3 = new CarrinhoTela();
										obj3.setVisible(true);
										obj3.setResizable(false);
										obj3.setLocationRelativeTo(null);
										dispose();
									}
									
								}
							}
							else {
								if(Quant <0 || Quant ==0) {
									JOptionPane.showMessageDialog(null, "Digite ao menos uma quantidade!");
								}
								else {
									if(Quant <0 || Quant ==0) {
										JOptionPane.showMessageDialog(null, "Digite ao menos uma quantidade!");
									}
									CarrinhoTela obj3 = new CarrinhoTela();
									obj3.setVisible(true);
									obj3.setResizable(false);
									obj3.setLocationRelativeTo(null);
									dispose();
								}
								
							}
					 	}
					}
					catch(NumberFormatException exception){
						JOptionPane.showMessageDialog(null, "Digite o ID e a Quantidade, apenas números Ou Verifique o ID do produto!");
					}
					
				}
				catch(IndexOutOfBoundsException exception ) {
					JOptionPane.showMessageDialog(null, "Esse produto não existe no carrinho!");
				}
			
			}
		});
		btnRemover.setBounds(273, 239, 89, 23);
		contentPane.add(btnRemover);
		
		JLabel lblQuant = new JLabel("Quant.");
		lblQuant.setBounds(345, 214, 48, 14);
		contentPane.add(lblQuant);
		
		JTextPane textCPF = new JTextPane();
		textCPF.setBounds(110, 242, 98, 20);
		contentPane.add(textCPF);
		
		JButton btnNewButton = new JButton("%");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textCPF.getText();
				if(RepositorioClientes.buscar(cpf)) {
					JOptionPane.showMessageDialog(null, car.getDescont());
					//Carrinho.desconto();
					car.setValor(car.getDescont()*0.15);
					JOptionPane.showMessageDialog(null, "Desconto aplicado!");
					CarrinhoTela obj3 = new CarrinhoTela();
					obj3.setVisible(true);
					obj3.setResizable(false);
					obj3.setLocationRelativeTo(null);
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "CPF invalido!");
			}
		});
		btnNewButton.setBounds(218, 239, 45, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(117, 217, 46, 14);
		contentPane.add(lblNewLabel_1);
	}
}
