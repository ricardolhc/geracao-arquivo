
import java.io.*;

/**
 * A classe <b>Arquivo</b> e definida para a manipulacao de arquivos.
 * @author Ricardo Luiz Hentges Costa e Tales Schifelbein Soares
 * @since aug 2022
 * @version 1.0
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
		return nomeGravacao;
	} //fim do método getNomeGravacao

	
	/** 
	 * @return <i>String</i> que contem o nome do arquivo para a leitura.
	 */
	public String getNomeLeitura() {
		return nomeLeitura;
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
	 * @param nomeGravacao <i>String</i> que contem o nome do arquivo que será gerado.
	 * @throws Exception que contem, caso aconteca, um erro.
	 */
	public void gravar(String conteudo, String nomeGravacao) throws Exception {
		//abre o arquivo para escrita
		FileOutputStream outFile = new FileOutputStream(new File(nomeGravacao));
		BufferedWriter buff = new BufferedWriter(new OutputStreamWriter(outFile, "UTF-8"));

		//escreve no arquivo
		buff.write(conteudo);

		// fecha o arquivo
		buff.close();  
		outFile.close();
	} // fim do método gravar

	
	/** 
	 * @param nomeLeitura <i>String</i> que contem o nome de leitura do arquivo.
	 * @return <i>int</i> que identifica o numero de linhas do arquivo.
	 * @throws Exception que contem, caso aconteca, um erro.
	 */
	public int getTamanho(String nomeLeitura) throws Exception {
		
		// declaração das variáveis        
		String linha;
		int linhas;
        //abre o arquivo para leitura
        FileInputStream inFile = new FileInputStream(new File(nomeLeitura));
        BufferedReader buff = new BufferedReader(new InputStreamReader(inFile, "UTF-8"));

        //lê a primeira linha do arquivo (numero de linhas)
		linha = buff.readLine();
		linhas = Integer.parseInt(linha);
		buff.close();
        inFile.close();

		return linhas;
	} // fim do método getTamanho


	/** 
	 * @param nomeLeitura <i>String</i> que contem o nome de leitura do arquivo.
	 * @return <i>String[]</i> que identifica, em cada linha, as informacoes respondidas por cada entrevistado.
	 * @throws Exception que contem, caso aconteca, um erro.
	 */
	public String[] getLinhas(String nomeLeitura) throws Exception {
        // declaração das variáveis        
       	String[] linhas;
		String linha;
		int nlinhas, i = 0;
        //abre o arquivo para leitura
        FileInputStream inFile = new FileInputStream(new File(nomeLeitura));
        BufferedReader buff = new BufferedReader(new InputStreamReader(inFile, "UTF-8"));

        //lê a primeira linha do arquivo (numero de linhas)
		linha = buff.readLine();
		nlinhas = Integer.parseInt(linha);
		linhas = new String[nlinhas+1];
		linhas[i++] = linha;

		//lê as demais linhas do arquivo
		do {
			linha = buff.readLine();
			if(linha != null)
				linhas[i++] = linha; 
		} while(linha != null);
            
        //fecha o arquivo
        buff.close();
        inFile.close();
		
		return linhas;
    } // fim do método getLinhas

	
	/** 
	 * @param nomeLeitura <i>String</i> que contem o nome de leitura do arquivo.
	 * @return <i>int</i> que identifica o tamanho total do arquivo.
	 */
	public int pegarTamanho(String nomeLeitura) {
		int tamanho = 0;
		try{
			tamanho = getTamanho(nomeLeitura);
	    } catch (Exception e) {
		    System.err.println(e.getMessage());
	    }
		return tamanho;
	} // fim do método pegarTamanho

	
	/** 
	 * @param conteudo <i>String</i> que contem o conteudo para ser gravado.
	 * @param nomeGravacao <i>String</i> que contem o nome do arquivo que será gerado.
	 */
	public void gravarTexto(String conteudo, String nomeGravacao) {
		try {
			gravar(conteudo, nomeGravacao);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	} // fim do método gravarTexto

	
	/** 
	 * @param nomeLeitura <i>String</i> que contem o nome de leitura do arquivo.
	 * @param tamanho <i>int</i> que indentifica o tamanho total do arquivo.
	 * @return <i>String[]</i> que identifica, em cada linha, as informacoes respondidas por cada entrevistado.
	 */
	public String[] lerArquivo(String nomeLeitura, int tamanho) {
		String[] linha = new String[tamanho];
		try{
			linha = getLinhas(nomeLeitura);
	    } catch (Exception e) {
		    System.err.println(e.getMessage());
	    }
		return linha;
	} // fim do método lerArquivo

} // fim da classe Arquivo