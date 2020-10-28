package repositorio;

import java.util.ArrayList;

import dados.Usuario;



	public class RepositorioUsuario {
	public static ArrayList <Usuario> nomes = new ArrayList<>();

	public static boolean addUsuario (Usuario usu, int aux){  
	    
	    if(aux>=18) {
	    	
	    		nomes.add(usu);	       
	    		return true;
	  
	    }
	    else {
	    	return false;
	    
	    }
	}
	    
	    public static boolean buscar(String cpf){
	        boolean achei=false;
	        
	        for(Usuario u:nomes){
	            
	            if(u.getCpf().equals(cpf)){
	                achei=true;
	            }
	        }
	        return achei; 
	    } 
	    public static boolean buscarSenha(String senha){
	        boolean achei=false;
	        
	        for(Usuario u:nomes){
	            
	            if(u.getSenha().equals(senha)){
	                achei=true;
	            }
	        }
	        return achei; 
	    }
	    
	    public static int buscarAlterar(String cpf){
	        int achei=-1;
	        for(int i=0;i<RepositorioUsuario.nomes.size();i++) {
  	            if(RepositorioUsuario.nomes.get(i).getCpf().equals(cpf)){
  	                achei=i;
  	            }
	        }
	        return achei; 
	   }
	    public static boolean TemMaisQueOitoDigitos(String x) {                  
			int qtdDigitos = 0;
			
			for (int i = 0; i < x.length(); i++) {  
		        char dig = x.charAt(i);  
		        if(dig != ' ') {
		        	qtdDigitos++;
		        	
		        }
	        }
			if (qtdDigitos > 7 && qtdDigitos <15) {
        		return true;
        	}
			
	        return false;  
		}
	    
	    public static boolean digitosCPF(String x) {                  
			int qtdDigitos = 0;
			boolean aux=false;
			x = x.replaceAll(" ","");
			for (int i = 0; i < x.length(); i++) {  
		        char dig = x.charAt(i);  
		        if(dig != ' ') {
		        	qtdDigitos++;
		        }  
	        }  
			if (qtdDigitos ==11) {
        		aux = true;
        	}
	        return aux;  
		}
	    public static boolean soConterNumeros(String CPF) {
	        if(CPF == null)
	            return false;
	        for (char letra : CPF.toCharArray())
	            if(letra < '0' || letra > '9')
	                return false;
	        return true;
	         
	    }
	    public static boolean soConterLetras(String nome) {
	    	String[] num = {"0","1","2","3","4","5","6","7","8","9"};
	    	for(int i = 0; i < nome.length(); i++){
	    		String str = Character.toString(nome.charAt(i));

	    		for(int j = 0; j < num.length; j++){
	    			if(str.equals(num[j])) return true;					
	    		}
	    	}
	    	return false;
	    }
	}
