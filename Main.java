public class Main {
	public static void main (String [] args) throws Exception {
		Arquivo arquivo = new Arquivo("relatório.txt", "Entrevistados.csv");
		EntrevistadoVetor entrevistadoVetor = new EntrevistadoVetor(arquivo);
		arquivo.gravar(entrevistadoVetor.getRelatorio(arquivo));
	}
}