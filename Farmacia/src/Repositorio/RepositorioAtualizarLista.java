package repositorio;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class RepositorioAtualizarLista {
	public static  ArrayList <AtualizarLista> att = new ArrayList<>();
	
	public static  ArrayList <AtualizarLista> topProdutos = new ArrayList<>();
	
	public static void addNaLista(AtualizarLista Atualizar) {
		att.add(Atualizar);
	}
	
	public static void addTopLista(AtualizarLista Atualizar) {
		topProdutos.add(Atualizar);
	}
	
	public static int vrfNome(String nome) {
		int result = -1;
		for(int i=0; i<RepositorioAtualizarLista.topProdutos.size();i++) {
			if(RepositorioAtualizarLista.topProdutos.get(i).getNome().equals(nome)) {
				result = RepositorioAtualizarLista.topProdutos.get(i).getID();
			}
		}
		return result;
	}
	
	
	public static boolean Verificar(String produto){
		boolean achei=false;
		for(int i=0; i < RepositorioAtualizarLista.topProdutos.size(); i++) {
			if(RepositorioAtualizarLista.topProdutos.get(i).getNome().equals(produto)) {
				achei=true;
				break;
			}
		}
		return achei;
	}
	
	public static ArrayList<AtualizarLista> getAtt() {
		return att;
	}

	public static void setAtt(ArrayList<AtualizarLista> att) {
		RepositorioAtualizarLista.att = att;
	}
	
}
