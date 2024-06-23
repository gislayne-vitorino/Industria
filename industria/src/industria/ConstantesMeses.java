package industria;

public class ConstantesMeses {
	
	    public static final String JANEIRO = "Janeiro";
	    public static final String FEVEREIRO = "Fevereiro";
	    public static final String MARCO = "Março";
	    public static final String ABRIL = "Abril";
	    public static final String MAIO = "Maio";
	    public static final String JUNHO = "Junho";
	    public static final String JULHO = "Julho";
	    public static final String AGOSTO = "Agosto";
	    public static final String SETEMBRO = "Setembro";
	    public static final String OUTUBRO = "Outubro";
	    public static final String NOVEMBRO = "Novembro";
	    public static final String DEZEMBRO = "Dezembro";

	    public static String getMes(String mes) {
	        switch (mes) {
	            case "1":
	                return JANEIRO;
	            case "2":
	                return FEVEREIRO;
	            case "3":
	                return MARCO;
	            case "4":
	                return ABRIL;
	            case "5":
	                return MAIO;
	            case "6":
	                return JUNHO;
	            case "7":
	                return JULHO;
	            case "8":
	                return AGOSTO;
	            case "9":
	                return SETEMBRO;
	            case "10":
	                return OUTUBRO;
	            case "11":
	                return NOVEMBRO;
	            case "12":
	                return DEZEMBRO;
	            default:
	                throw new IllegalArgumentException("Mês inválido: " + mes);
	        }
	    }
	}