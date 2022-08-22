public class Main {
	public static void main (String [] args) {
		Arquivo arquivo = new Arquivo("relatório.txt", "Entrevistados.csv");
		EntrevistadoVetor entrevistadoVetor = new EntrevistadoVetor(arquivo);
		try {
			arquivo.gravar(entrevistadoVetor.getRelatorio(arquivo));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}