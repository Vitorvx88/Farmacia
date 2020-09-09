package Main;
//@author Anizio Barbosa
public class Usuario {
	private String cpf;	
	private String nome;
	private int Idade;
	private int index1;
	private String senha;
	private String n;
	private String c;
	private int i;
	private String s;
	
	public Usuario(String cpf, String nome, int Idade) {
		this.cpf = cpf;
		this.nome = nome;
		this.Idade = Idade;

	}
	

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIndex() {
		return index1;
	}

	public void setIndex(int index) {
		this.index1 = index;
	}


		public int getIdade() {
		return Idade;
	}


	public void setIdade(int idade) {
		Idade = idade;
	}

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getN() {
		return n;
	}


	public void setN(String n) {
		this.n = n;
	}


	public String getC() {
		return c;
	}


	public void setC(String c) {
		this.c = c;
	}


	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}


	public String getS() {
		return s;
	}


	public void setS(String s) {
		this.s = s;
	}

}