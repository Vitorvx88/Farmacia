package repositorio;

public class AtualizarLista {
	private String nome;
	private int ID;
	private int quantidade;
	private double preco;
	private String Promo="";

	
	public String getPromo() {
		return Promo;
	}


	public void setPromo(String promo) {
		Promo = promo;
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


	public double getPreco() {
		return preco;
	}


	public void setPre�o(double pre�o) {
		this.preco = pre�o;
	}


	public  AtualizarLista(int ID, String nome, int quantidade, double d, String Promo) {
		this.ID=ID;
		this.nome=nome;
		this.quantidade=quantidade;
		this.preco=d;
		this.Promo=Promo;
	}

}
