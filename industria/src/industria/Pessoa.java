package industria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
	
	  public Pessoa(String nome, LocalDate dataDeNascimento) {
		  	this.nome = nome;
		    this.dataDeNascimento = dataDeNascimento;
	  }
	  
	  public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	  }
	  
	  public String getDataDeNascimentoFormatada() {
		  return (this.dataDeNascimento.format(dateTimeFormatter));
		   
	  }
	  
	  public String getNome() {
		return nome;
	  }

	  private LocalDate dataDeNascimento;
	  private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	  private String nome;
}
