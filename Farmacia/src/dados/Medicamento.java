package dados;

public class Medicamento {
    private  int id;	
	private  String nome;
	private int quantidade;
	private double preco;
	private int QuantRemove;
	private String Promo="";

	//Marcelo
	private boolean promoAtiva = false;
	private double valorAnterior;
	private float desc;
	
	public double getValorAnterior() {
		return valorAnterior;
	}
	public void setValorAnterior(double valorInterior) {
		this.valorAnterior = valorInterior;
	}
	public boolean isPromoAtiva() {
		return promoAtiva;
	}
	public void setPromoAtiva(boolean promoAtiva) {
		this.promoAtiva = promoAtiva;
	}
	
	public int getQuantRemove() {
		return QuantRemove;
	}
	public void setQuantRemove(int quantRemove) {
		QuantRemove += +quantRemove;
	}


	private int index;
	private String n;
	private String q;
	private String p;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = +quantidade;
	}
	public void setQuantidade1(int quantidade) {
		this.quantidade += quantidade;
	}
	public double getPre�o() {
		return preco;
	}
	public void setPre�o(double preco) {
		this.preco = preco;
	}
	public Medicamento(int id, String nome1, int quantidade, double preco,String Promo) {
		this.id = id;
		this.nome = nome1;
		this.quantidade = quantidade;
		this.preco = preco;
		this.Promo=Promo;
		this.valorAnterior=preco;
	}
	public Medicamento() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getPromo() {
		return Promo;
	}
	public void setPromo(String promo) {
		Promo = promo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome1) {
		this.nome = nome1;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	public float getDesc() {
		return desc;
	}
	public void setDesc(float desc) {
		this.desc = desc;
	}


}
