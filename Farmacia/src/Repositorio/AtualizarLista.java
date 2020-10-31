package repositorio;



public class AtualizarLista implements Comparable<AtualizarLista>{
	private String nome;
	private int ID;
	private int quantidade;
	private double preco;
	private String Promo="";
	private double total;

	
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
	public void setQuantidade2(int quantidade) {
		this.quantidade += quantidade;
	}


	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;

	}
	public void setPreço(double preço) {
		this.preco = preço;

	}


	public  AtualizarLista(int ID, String nome, int quantidade, double d, String Promo) {
		this.ID=ID;
		this.nome=nome;
		this.quantidade=quantidade;
		this.preco=d;
		this.Promo=Promo;
	}
	public  AtualizarLista(int ID, String nome, int quantidade, double total) {
		this.ID=ID;
		this.nome=nome;
		this.quantidade=quantidade;
		this.preco = total;
	}


	@Override
	public int compareTo(AtualizarLista o) {
		return (o.getQuantidade()-this.quantidade);
	}

}
