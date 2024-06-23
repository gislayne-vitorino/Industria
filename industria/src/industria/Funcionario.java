package industria;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Funcionario extends Pessoa {

	public Funcionario(String nome, LocalDate dataDeNascimento, BigDecimal salario, String funcao) {
		super(nome, dataDeNascimento);
		this.salario = salario.setScale(2, RoundingMode.HALF_UP);
		this.funcao = funcao;
	}

	public void aumentoSalario(int porcentagem) {
        BigDecimal porcentagemReal = new BigDecimal(porcentagem);

        BigDecimal porcento = new BigDecimal(100);
        BigDecimal novaPorcentagem = porcentagemReal.divide(porcento);
        
        BigDecimal novoSalario = this.salario.add(this.salario.multiply(novaPorcentagem));

        this.salario = novoSalario.setScale(2, RoundingMode.HALF_UP);
	}
	
	public String getFuncao() {
		return funcao;
	}
	
    public int getIdade(LocalDate dataDeNascimento) {
        LocalDate localDateNow = LocalDate.now();
        return Period.between(dataDeNascimento, localDateNow).getYears();
    }
	
	public BigDecimal getSalario() {
		return salario;
	}
	

	public String getSalarioFormatado() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        
        return decimalFormat.format(this.salario);
	}
	
	public boolean isAniversariante(LocalDate dataDeNascimento) {
		if (dataDeNascimento.equals(this.getDataDeNascimento())) {
			return true;
		}
		return false;	
	}
	
	public boolean isAniversarianteDoMes(int mesDeAniversario) {
		if (mesDeAniversario == this.getDataDeNascimento().getMonthValue()) {
			return true;
		}
		return false;	
	}
	
	public int quantidadeSalarioMinimo() {
		BigDecimal salarioMinimo = new BigDecimal(1212.00);
		
		return  this.salario.divide(salarioMinimo, 2, RoundingMode.DOWN).intValue();
	}

	private String funcao;
	private BigDecimal salario;
}
