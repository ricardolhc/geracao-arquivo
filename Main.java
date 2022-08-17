
public class Main {
	public static void main (String [] args) {
		Arquivo arquivo = new Arquivo("relatório.txt", "Entrevistados.csv");
		EntrevistadoInterface entrevistadoInterface = new EntrevistadoInterface();
		arquivo.gravarTexto(entrevistadoInterface.getRelatorio(arquivo), arquivo.getNomeGravacao());
	}
}