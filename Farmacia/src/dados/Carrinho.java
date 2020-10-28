package dados;

import repositorio.RepositorioCarrinho;
import repositorio.RepositorioMedicamento;

public class Carrinho {
	private String nome;
	private int ID;
	private int quantidade;
	private double preco;
	private String promo="";
	private static int indexRemove;
	private static int indexQuantRmove;
	private static int indexContRemove=-1;
	private static double valor;
	private static double descont;
	
	public  Carrinho(int ID, String nome, int quantidade, double d, String promo) {
		this.ID=ID;
		this.nome=nome;
		this.quantidade=quantidade;
		this.preco=d;
		this.promo=promo;
	}
	public Carrinho() {
		// TODO Auto-generated constructor stub
	}
	public static int VerificarPorNome(String produto){
		int achei=0;
		for(int i=0; i < RepositorioCarrinho.car.size(); i++) {
			if(RepositorioCarrinho.car.get(i).getNome().equals(produto)) {
				achei=RepositorioCarrinho.car.get(i).getID();
				break;
			}
		}
		return achei;
	}
	public static void desconto() {
		valor=descont*(15/100);
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setQuantidade1(int quantidade) {
		this.quantidade += + quantidade;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getIndexRemove() {
		return indexRemove;
	}
	
	public void setIndexRemove(int indexRemove) {
		Carrinho.indexRemove = indexRemove;
	}
	public static int getIndexQuantRmove() {
		return indexQuantRmove;
	}
	public static void setIndexQuantRmove(int indexQuantRmove) {
		Carrinho.indexQuantRmove = indexQuantRmove;
	}
	public static int getIndexContRemove() {
		return indexContRemove;
	}
	public static void setIndexContRemove(int indexContRemove) {
		Carrinho.indexContRemove += +indexContRemove;
	}
	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	public static void setValor(double valor) {
		Carrinho.valor = valor;
	}
	public static double getValor() {
		return valor;
	}
	public static double getDescont() {
		return descont;
	}
	public static void setDescont(double descont) {
		Carrinho.descont = descont;
	}

}
