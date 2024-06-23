package industria;

public class Main {

	public static void main(String[] args) {
		
		ListaDeFuncionarios funcionarios = new ListaDeFuncionarios();
		
		funcionarios.criaLista();
		
		funcionarios.imprimirFuncionarios();
		
		funcionarios.removeFuncionario("João");
		
		funcionarios.imprimirFuncionarios();
		
		funcionarios.aumentoSalario(null, 10);
		
		System.out.println("\nApós aumento de salário: \n");
		
		funcionarios.imprimirFuncionarios();
		
		funcionarios.agruparPorFuncao();
		
		funcionarios.imprimirAniversarianteDoMes(10);
		funcionarios.imprimirAniversarianteDoMes(12);
		
		funcionarios.imprimirFuncionarioMaisVelho();
		
		System.out.println("\nFuncionários em ordem alfabética:");		
		funcionarios.imprimirFuncionariosEmOrdemAlfabetica();
		
		System.out.println("\nA quantidade total de salário de é: " + funcionarios.salarioTotal());
      
		funcionarios.quantidadeSalarioMinimo();
		
	}
	
}
