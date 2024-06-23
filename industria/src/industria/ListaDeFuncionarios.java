package industria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListaDeFuncionarios {

	public ArrayList<Funcionario> criaLista() {		 
		this.funcionarios.add(new Funcionario("Maria", LocalDate.of(2020, Month.OCTOBER, 18), new BigDecimal(2009.44), "Operador"));
		this.funcionarios.add(new Funcionario("João", LocalDate.of(1990, Month.MAY, 12), new BigDecimal(2284.38), "Operador"));
		this.funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, Month.MAY, 2), new BigDecimal(9836.14), "Coordenador"));
		this.funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, Month.OCTOBER, 14), new BigDecimal(19119.88), "Diretor"));
		this.funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, Month.JANUARY, 5), new BigDecimal(2236.68), "Recepcionista"));
		this.funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19), new BigDecimal(1582.72), "Operador"));
		this.funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, Month.MARCH, 31), new BigDecimal(4071.84), "Contador"));
		this.funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, Month.JULY, 8), new BigDecimal(3017.45), "Gerente"));
		this.funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, Month.MAY, 24), new BigDecimal(1606.85), "Eletricista"));
		this.funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, Month.SEPTEMBER, 2), new BigDecimal(2799.93), "Gerente"));
		 
		return this.funcionarios;
	}
	
	public void agruparPorFuncao() {
		Map<String, List<Funcionario>> funcionariosPorFuncao = this.funcionarios.stream()
				.collect(Collectors.groupingBy(Funcionario::getFuncao));
	  
		funcionariosPorFuncao.forEach((funcao, listaFuncionarios) -> {
		  System.out.println("\nFuncionários da função: " + funcao);
		  
			for(Funcionario funcionario : listaFuncionarios) {
				System.out.println("Funcionário: " + funcionario.getNome() + 
						", Data de Nascimento: " + funcionario.getDataDeNascimentoFormatada() + 
						", Salário: " + funcionario.getSalarioFormatado() + 
						", Função: " + funcionario.getFuncao());
			}		});
	}
	
	public void aumentoSalario(Funcionario funcionario, int porcentagem) {
		 if(funcionario == null) {
				for(int i = 0; i < this.funcionarios.size(); i++) {
					this.funcionarios.get(i).aumentoSalario(porcentagem);
				}
		 }
		 else {
			 funcionario.aumentoSalario(porcentagem);
		 }
	}
	
	public void imprimirAniversarianteDoMes(int mes) {
	    boolean haAniversariante = false;

		for(Funcionario funcionario : this.funcionarios) {
			if(funcionario.isAniversarianteDoMes(mes)) {
				haAniversariante = true;
				
				System.out.println("\nFuncionário: " + funcionario.getNome() + " é aniversariante do mês de " +
						 _getMes(String.valueOf(mes)) + 
						"!\nData de Nascimento: " + funcionario.getDataDeNascimentoFormatada() + 
						", Função: " + funcionario.getFuncao());
			}
		}
		if(!haAniversariante) {
			System.out.println("\nNão há aniversariantes no mês de " + _getMes(String.valueOf(mes)) + ".");

		}
	}
	
	public void imprimirFuncionarios() {
		System.out.println("\nLista de funcionários atual:");
		for(Funcionario funcionario : this.funcionarios) {
			System.out.println("Funcionário: " + funcionario.getNome() + 
					", Data de Nascimento: " + funcionario.getDataDeNascimentoFormatada() + 
					", Salário: " + funcionario.getSalarioFormatado() + 
					", Função: " + funcionario.getFuncao());
		}
	}
	
    public void imprimirFuncionarioMaisVelho() {
        Funcionario funcionarioMaisVelho = null;
        int maiorIdade = 0;

        for (Funcionario funcionario : funcionarios) {
            int idade = funcionario.getIdade(funcionario.getDataDeNascimento());
            if (idade > maiorIdade) {
            	maiorIdade = idade;
            	funcionarioMaisVelho = funcionario;
            }
        }
            System.out.println("\nFuncionário mais velho é: " + funcionarioMaisVelho.getNome() +
            		", com a idade de " + maiorIdade + " anos!");
    }
	
    public void imprimirFuncionariosEmOrdemAlfabetica() {
        ArrayList<Funcionario> funcionariosEmOrdemAlfabetica = new ArrayList<>(funcionarios);
        Collections.sort(funcionariosEmOrdemAlfabetica, Comparator.comparing(Funcionario::getNome));

        for (Funcionario funcionario : funcionariosEmOrdemAlfabetica) {
            System.out.println(funcionario.getNome());
        }
    }
    
	public BigDecimal salarioTotal() {
		BigDecimal salarioTotal = new BigDecimal(0);
		
		for(Funcionario funcionario : this.funcionarios) {
			salarioTotal = salarioTotal.add(funcionario.getSalario());
		}
		
		return salarioTotal;
	}
	
	public void quantidadeSalarioMinimo() {
		for(Funcionario funcionario : this.funcionarios) {
			int quantidadeSalarioMinimo = funcionario.quantidadeSalarioMinimo();
			
			if(quantidadeSalarioMinimo > 1) {
				System.out.print("\nFuncionário " + funcionario.getNome() + " recebe " + quantidadeSalarioMinimo +
						" salários mínimos.");
			} else {
				System.out.print("\nFuncionário " + funcionario.getNome() + " recebe " + quantidadeSalarioMinimo +
						" salário mínimo.");				
			}
		}
	}
	
	public ArrayList<Funcionario> removeFuncionario(String nome) {
		 
		for(Funcionario funcionario : this.funcionarios) {
			if(funcionario.getNome().equals(nome)) {
				this.funcionarios.remove(funcionario);
				break;
			}
		}
		 return this.funcionarios;
	}
	
	private String _getMes(String mes) {
		return ConstantesMeses.getMes(mes);
	}
	
	ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	
}
