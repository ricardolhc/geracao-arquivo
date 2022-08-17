
/**
 * A classe <b>EntrevistadoVetor</b> e definida para a manipulacao de um entrevistado atraves de um vetor.
 * @author Ricardo Luiz Hentges Costa e Tales Schifelbein Soares
 * @since aug 2022
 * @version 1.1
 */

public class EntrevistadoVetor {

    /**
     * O atributo vetor entrevistado, do tipo <i><b>Entrevistado</b></i>, e utilizado para referenciar o entrevistado dependendo da sua posicao no vetor.
     */
    private Entrevistado[] entrevistado;

    /**
     * O atributo indice, do tipo <i>int</i>, e utilizado para referenciar a posicao atual do entrevistado que esta sendo adicionado.
     */
    private int indice = 0;

    /**
     * Construtor default da classe <b>EntrevistadoVetor</b>.<br>
     * <b>Uso: </b>
     * EntrevistadoVetor entrevistadoVetor = new EntrevistadoVetor(new Arquivo("nomeGravacaoArquivo", "nomeLeituraArquivo"), "nomeLeituraArquivo");<br><br>
     * @param arquivo <i>objeto</i> da classe <b>Arquivo</b> que manipula arquivos.
     * @param nomeLeituraArquivo <i>String</i> que identifica o nome do arquivo para ser lido.
     */
    public EntrevistadoVetor(Arquivo arquivo, String nomeLeituraArquivo) {
        entrevistado = new Entrevistado[arquivo.pegarTamanho(nomeLeituraArquivo)];
        for(int i = 1; i < arquivo.pegarTamanho(nomeLeituraArquivo) + 1; i++) {
			Entrevistado novo = new Entrevistado(arquivo.lerArquivo(nomeLeituraArquivo, arquivo.pegarTamanho(nomeLeituraArquivo))[i]);
            this.entrevistado[indice] = novo;
            indice++;
		}
    } // fim do construtor EntrevistadoVetor
    

    /** 
     * @param sexo <i>String</i> que identifica o sexo que quer ser contado.
     * @return <i>int</i> que identifica a quantidade de pessoas que tem aquele sexo.
     */
    public int getNumSexo(String sexo) {
        int quantidade = 0;
        for(int i = 0; i < entrevistado.length; i++) {
            if(entrevistado[i].getSexo().equals(sexo)) {
                quantidade++;
            }
        }
        return quantidade;
    } // fim do método getNumSexo

    
    /** 
     * @param faixaEtaria <i>String</i> que identifica a faixa etaria que quer ser contada.
     * @return <i>int</i> que identifica a quantidade de pessoas que tem aquela faixa etaria.
     */
    public int getNumFaixaEtaria(String faixaEtaria) {
        int quantidade = 0;
        for(int i = 0; i < entrevistado.length; i++) {
            if(entrevistado[i].getFaixaEtaria().equals(faixaEtaria)) {
                quantidade++;
            }
        }
        return quantidade;
    } // fim do método getNumFaixaEtaria

    
    /** 
     * @param escolaridade <i>String</i> que identifica a escolaridade que quer ser contada.
     * @return <i>int</i> que identifica a quantidade de pessoas que tem aquela escolaridade.
     */
    public int getNumEscolaridade(String escolaridade) {
        int quantidade = 0;
        for(int i = 0; i < entrevistado.length; i++) {
            if(entrevistado[i].getEscolaridade().equals(escolaridade)) {
                quantidade++;
            }
        }
        return quantidade;
    } // fim do método getNumEscolaridade


    /** 
     * @param area <i>String</i> que identifica a area que quer ser contada.
     * @return <i>int</i> que identifica a quantidade de pessoas que tem aquela area.
     */
    public int getNumArea(String area) {
        int quantidade = 0;
        for(int i = 0; i < entrevistado.length; i++) {
            if(entrevistado[i].getArea().equals(area)) {
                quantidade++;
            }
        }
        return quantidade;
    } // fim do método getNumArea
    

    /** 
     * @return <i>int</i> que identifica o total de entrevistados adicionados.
     */
    public int getTotalEntrevistados() {
        return indice;
    } // fim do método getTotalEntrevistados


    /** 
     * @param faixaEtaria <i>String</i> que identifica a faixa etaria que quer ser contada.
     * @param tecnologia <i>String</i> que identifica a tecnologia que quer ser contada.
     * @return <i>int</i> que identifica a quantidade de pessoas que usam a tecnologia e tem aquela faixa etaria. 
     */
    public int getNumFaixaEtariaTecnologia(String faixaEtaria, String tecnologia) {
        int quantidade = 0;
        for(int i = 0; i < entrevistado.length; i++) {
            if(entrevistado[i].getFaixaEtaria().equals(faixaEtaria) && entrevistado[i].getTecnologia().equals(tecnologia)) {
                quantidade++;
            }
        }
        return quantidade;
    } // fim do método getNumFaixaEtariaTecnologia

    
    /** 
     * @param faixaEtaria vetor de <i>String</i> que identifica as faixas etarias presentes no questionario.
     * @param tecnologia <i>String</i> que identifica a tecnologia que quer ser contada.
     * @return <i>String</i> que identifica as faixas etarias que mais utilizam aquela tecnologia.
     */
    public String getMaisUtilizaTecnologiaFaixaEtaria(String[] faixaEtaria, String tecnologia) {
        String conteudo = "";
        int[] quantidadeFaixaEtaria = new int[faixaEtaria.length];
        
        for(int i = 0; i < faixaEtaria.length; i++) {
            quantidadeFaixaEtaria[i] = getNumFaixaEtariaTecnologia(faixaEtaria[i], tecnologia);
        }

        for(int i = 0; i < faixaEtaria.length; i++) {
            for(int j = i + 1; j < faixaEtaria.length; j++) {
                if(quantidadeFaixaEtaria[i] < quantidadeFaixaEtaria[j]) {
                    faixaEtaria = trocaOrdemString(faixaEtaria, i, j);
                    quantidadeFaixaEtaria = trocaOrdemInt(quantidadeFaixaEtaria, i, j);
                }
            }
        }

        int i = 0;
        do {
            conteudo += "\n" + faixaEtaria[i];
        } while(i + 1 != quantidadeFaixaEtaria.length && quantidadeFaixaEtaria[i] == quantidadeFaixaEtaria[++i]);
        
        return conteudo;
    } // fim do método getMaisUtilizaTecnologiaFaixaEtaria

    
    /** 
     * @param faixaEtaria <i>String</i> que identifica a faixa etaria que quer ser contada.
     * @param tecnologia vetor de <i>String</i> que identifica as tecnologias presentes no questionario.
     * @return <i>String</i> que identifica as tecnologias menos utilizadas por aquela faixa etaria.
     */
    public String getMenosUtilizaFaixaEtariaTecnologia(String faixaEtaria, String[] tecnologia) {
        String conteudo = "";
        int[] quantidadeTecnologia = new int[tecnologia.length];
        
        for(int i = 0; i < tecnologia.length; i++) {
            quantidadeTecnologia[i] = getNumFaixaEtariaTecnologia(faixaEtaria, tecnologia[i]);
        }

        for(int i = 0; i < tecnologia.length; i++) {
            for(int j = i + 1; j < tecnologia.length; j++) {
                if(quantidadeTecnologia[i] > quantidadeTecnologia[j]) {
                    tecnologia = trocaOrdemString(tecnologia, i, j);
                    quantidadeTecnologia = trocaOrdemInt(quantidadeTecnologia, i, j);
                }
            }
        }

        int i = 0;
        do {
            conteudo += "\n" + tecnologia[i];
        } while(i + 1 != quantidadeTecnologia.length && quantidadeTecnologia[i] == quantidadeTecnologia[++i]);

        return conteudo;
    } // fim do método getMenosUtilizaFaixaEtariaTecnologia

    
    /** 
     * @param vetor <i>int</i> vetor identifica a variavel que possui elementos para a troca
     * @param i <i>int</i> que identifica a primeira posicao para a troca
     * @param j <i>int</i> que identifica a segunda posicao para a troca
     * @return <i>int[]</i> que identifica o vetor trocado 
     */
    public int[] trocaOrdemInt(int[] vetor, int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
        return vetor;
    } // fim do método trocaOrdemInt

    
    /** 
     * @param vetor vetor de <i>String</i> que identifica a variavel que possui elementos para a troca
     * @param i <i>int</i> que identifica a primeira posicao para a troca
     * @param j <i>int</i> que identifica a segunda posicao para a troca
     * @return <i>String[]</i> que identifica o vetor trocado 
     */
    public String[] trocaOrdemString(String[] vetor, int i, int j) {
        String aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
        return vetor;
    } // fim do método trocaOrdemString

    
} // fim da classe EntrevistadoVetor