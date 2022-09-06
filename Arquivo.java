import java.io.*;

/**
 * A classe <b>Arquivo</b> e definida para a manipulacao de arquivos.
 * @author Ricardo Luiz Hentges Costa e Tales Schifelbein Soares
 * @since aug 2022
 * @version 1.1
 */

public class Arquivo {

	/**
	 * O atributo nome nomeGravacao, do tipo <i>String</i>, e utilizado para gerar um novo arquivo com o nome desejado.
	 */
	private String nomeGravacao;

	/**
	 * O atributo nome nomeLeitura, do tipo <i>String</i>, e utilizado para ler um arquivo existente.
	 */
	private String nomeLeitura;

	/**
	 * Construtor default da classe <b>Arquivo</b>.<br>
	 * <b>Uso: </b>
	 * Arquivo arquivo = new Arquivo("nomeGravacao", "nomeLeitura");<br><br>
	 * @param nomeGravacao <i>String</i> que identifica o nome para a gravacao do arquivo.
	 * @param nomeLeitura <i>String</i> que identifica o nome para a leitura de um arquivo existente.
	 */
	public Arquivo(String nomeGravacao, String nomeLeitura) {
		this.nomeGravacao = nomeGravacao;
		this.nomeLeitura = nomeLeitura;
	} // fim do construtor Arquivo

	
	/** 
	 * @return <i>String</i> que contem o nome do arquivo para a gravacao.
	 */
	public String getNomeGravacao() {
		return this.nomeGravacao;
	} //fim do método getNomeGravacao

	
	/** 
	 * @return <i>String</i> que contem o nome do arquivo para a leitura.
	 */
	public String getNomeLeitura() {
		return this.nomeLeitura;
	} // fim do método getNomeLeitura

	
	/** 
	 * @param nomeLeitura <i>String</i> que contem o nome do arquivo que deseja mudar para a leitura.
	 */
	public void setNomeLeitura(String nomeLeitura) {
		this.nomeLeitura = nomeLeitura;
	} // fim do método setNomeLeitura

	
	/** 
	 * @param nomeGravacao <i>String</i> que contem o nome do arquivo que deseja mudar para a gravacao.
	 */
	public void setNomeGravacao(String nomeGravacao) {
		this.nomeGravacao = nomeGravacao;
	} // fim do método setNomeGravacao

	
	/** 
	 * @param conteudo <i>String</i> que contem o conteudo que deseja gravar no novo arquivo.
	 * @throws Exception que contem, caso aconteca, um erro.
	 */
	public void gravar(String conteudo) throws Exception {	
		FileOutputStream outFile = new FileOutputStream(new File(this.nomeGravacao));
		BufferedWriter buff = new BufferedWriter(new OutputStreamWriter(outFile, "UTF-8"));

		buff.write(conteudo);

		buff.close();  
		outFile.close();
	} // fim do método gravar

	
	/** 
	 * @return <i>int</i> que identifica o numero de linhas do arquivo.
	 * @throws Exception que contem, caso aconteca, um erro.
	 */
	public int getTamanho() throws Exception {        
		int numLinhas;
		
        FileInputStream inFile = new FileInputStream(new File(this.nomeLeitura));
        BufferedReader buff = new BufferedReader(new InputStreamReader(inFile, "UTF-8"));

		numLinhas = Integer.parseInt(buff.readLine());

		buff.close();
        inFile.close();

		return numLinhas;
	} // fim do método getTamanho


	/** 
	 * @return <i>String[]</i> que identifica, em cada linha, as informacoes respondidas por cada entrevistado.
	 * @throws Exception que contem, caso aconteca, um erro.
	 */
	public String[] getLinhas() throws Exception { 
       	String[] linhas = new String[getTamanho() + 1];
		String linha;
		int i = 0;

		FileInputStream inFile = new FileInputStream(new File(this.nomeLeitura));
        BufferedReader buff = new BufferedReader(new InputStreamReader(inFile, "UTF-8"));
		
		do {
			linha = buff.readLine();
			if(linha != null) {
				linhas[i++] = linha; 
			}
		} while(linha != null);
            
        buff.close();
        inFile.close();

		return linhas;
    } // fim do método getLinhas

} // fim da classe Arquivo