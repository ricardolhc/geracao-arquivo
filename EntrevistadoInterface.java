/**
 * A classe <b>EntrevistadoInterface</b> e definida para a geracao de relatorios a partir dos dados obtidos.
 * @author Ricardo Luiz Hentges Costa
 * @since aug 2022
 * @version 1.1
 */

public class EntrevistadoInterface {

    /**
     * O atributo entrevistadoVetor, do tipo <i><b>EntrevistadoVetor</b></i>, e utilizado para referenciar o vetor para gerar o relatório.
     */
    private EntrevistadoVetor entrevistadoVetor;

    /** 
     * @param arquivo <i>objeto</i> da classe <b>Arquivo</b> que manipula arquivos.
     * @return <i>String</i> que contem o relatorio com as estatisticas solicitadas.
     */
    public String getRelatorio(Arquivo arquivo) throws Exception {
        String conteudoParaRelatorio = "";

        this.entrevistadoVetor = new EntrevistadoVetor(arquivo);
        
        //final String[] REGIAO = {"Região Cidade Alta/Aguateiros", "Região Extremo Oeste", "Região Norte", "Região Sul",
        //                         "Região Extremo Leste", "Região Leste/Ibirapuitã", "Região Oeste/Regalado"};
        final String[] SEXO = {"Masculino", "Feminino", "Outro"};
        final String[] FAIXAETARIA = {"Até 15 anos", "De 16 a 29 anos", "De 30 a 59 anos", "Acima de 60 anos"};
		final String[] ESCOLARIDADE = {"Ensino fundamental incompleto", "Ensino médio incompleto", "Ensino superior incompleto",
	                                   "Ensino fundamental completo", "Ensino médio completo", "Ensino superior completo"};
		final String[] TECNOLOGIA = {"Computador Pessoal", "Smartphone", "Nenhuma", "Notebook ou Netbook", "Tablet"};
		final String[] AREA = {"Alimentação", "Educação", "Lazer", "Segurança", "Cultura", "Emprego", "Saúde", "Transporte"};

        /* ESTATISTICA 1 */
        conteudoParaRelatorio += "Total de entrevistados: " + this.entrevistadoVetor.getTotalEntrevistados() + "\n\n";

        /* ESTATISTICA 2 */
        conteudoParaRelatorio += getRelatorioEntrevistadosSexo(SEXO);

        /* ESTATISTICA 3 */
        conteudoParaRelatorio += getRelatorioEntrevistadosFaixaEtaria(FAIXAETARIA);

        /* ESTATISTICA 4 */
        conteudoParaRelatorio += getRelatorioEntrevistadosEscolaridade(ESCOLARIDADE);

        /* ESTATISTICA 5 */
        conteudoParaRelatorio += getRelatorioEntrevistadosSuperiorCompleto();

        /* ESTATISTICA 6 */
        conteudoParaRelatorio += getRelatorioEntrevistadosSmartphone(FAIXAETARIA);

        /* ESTATISTICA 7 */
        conteudoParaRelatorio += getRelatorioTecnologiaMenosFaixaEtaria15(TECNOLOGIA);

        /* ESTATISTICA 8 */
        conteudoParaRelatorio += getRelatorioEntrevistadosArea(AREA);

        System.out.println("Relatório Gerado!");

        return conteudoParaRelatorio;
    } // fim do método getRelatorio

    
    /** 
     * @param sexo vetor de <i>String</i> que identifica os sexos presentes no questionario.
     * @return <i>String</i> que identifica o sexo com a sua respectiva porcentagem de entrevistados.
     */
    public String getRelatorioEntrevistadosSexo(String[] sexo) {
        String conteudo = "Porcentagem entrevistados por sexo: \n";
        for(int i = 0; i < sexo.length; i++) {
            conteudo += sexo[i] + ": " + doubleParaStringFormatado(calculoPorcentagem(this.entrevistadoVetor.getNumSexo(pegarPrimeiroCaracterStr(sexo[i]).toLowerCase()), this.entrevistadoVetor.getTotalEntrevistados())) + "%\n";
        }
        return conteudo += "\n";
    } // fim do método getRelatorioEntrevistadosSexo

    
    /** 
     * @param faixaEtaria vetor de <i>String</i> que identifica as faixas etarias presentes no questionario.
     * @return <i>String</i> que identifica a faixa etaria com a sua respectiva quantidade de entrevistados.
     */
    public String getRelatorioEntrevistadosFaixaEtaria(String[] faixaEtaria) {
        String conteudo = "Quantidade de entrevistados por faixa etária: \n";
        for(int i = 0; i < faixaEtaria.length; i++) {
            conteudo += faixaEtaria[i] + ": " + this.entrevistadoVetor.getNumFaixaEtaria(faixaEtaria[i]) + "\n";
        }
        return conteudo += "\n";
    } // fim do método getRelatorioEntrevistadosFaixaEtaria

    
    /** 
     * @param escolaridade vetor de <i>String</i> que identifica as escolaridades presentes no questionario.
     * @return <i>String</i> que identifica a escolaridade com a sua respectiva porcentagem de entrevistados.
     */
    public String getRelatorioEntrevistadosEscolaridade(String[] escolaridade) {
        String conteudo = "Percentual de entrevistados por grau de escolaridade: \n";
        for(int i = 0; i < escolaridade.length; i++) {
            conteudo += escolaridade[i] + ": " + doubleParaStringFormatado(calculoPorcentagem(this.entrevistadoVetor.getNumEscolaridade(escolaridade[i]), this.entrevistadoVetor.getTotalEntrevistados())) + "%\n";
        }
        return conteudo += "\n";
    } // fim do método getRelatorioEntrevistadosEscolaridade

    
    /** 
     * @param area vetor de <i>String</i> que identifica as areas presentes no questionario.
     * @return <i>String</i> que identifica a area com a sua respectiva quantidade de entrevistados.
     */
    public String getRelatorioEntrevistadosArea(String[] area) {
        String conteudo = "Número de entrevistados por área prioritária: \n";
        for(int i = 0; i < area.length; i++) {
            conteudo += area[i] + ": " + this.entrevistadoVetor.getNumArea(area[i]) + "\n";
        }
        return conteudo;
    } // fim do método getRelatorioEntrevistadosArea

    
    /** 
     * @return <i>String</i> que identifica a quantidade de entrevistados com pelo menos o ensino superior completo.
     */
    public String getRelatorioEntrevistadosSuperiorCompleto() {
        String conteudo = "Entrevistados com pelo menos o ensino superior completo: ";
		return conteudo += this.entrevistadoVetor.getNumEscolaridade("Ensino superior completo") + "\n\n";	
    } // fim do método getRelatorioEntrevistadosSuperiorCompleto

    
    /** 
     * @param faixaEtaria vetor de <i>String</i> que identifica as faixas etarias presentes no questionario.
     * @return <i>String</i> que identifica a faixa etaria que mais utiliza <b>Smartphone</b>.
     */
    public String getRelatorioEntrevistadosSmartphone(String[] faixaEtaria) {
        String conteudo = "Faixa etária que mais utiliza Smartphone:";
		return conteudo += this.entrevistadoVetor.getMaisUtilizaTecnologiaFaixaEtaria(faixaEtaria, "Smartphone") + "\n\n";
    } // fim do método getRelatorioEntrevistadosSmartphone

    
    /** 
     * @param tecnologia vetor de <i>String</i> que identifica as tecnologias presentes no questionario.
     * @return <i>String</i> que identifica a tecnologia menos utilizada pela faixa etaria <b>Ate 15 anos</b>
     */
    public String getRelatorioTecnologiaMenosFaixaEtaria15(String[] tecnologia) {
        String conteudo = "Tecnologia menos utilizada com faixa etária até 15 anos:";
		return conteudo += this.entrevistadoVetor.getMenosUtilizaFaixaEtariaTecnologia("Até 15 anos", tecnologia) + "\n\n";
    } // fim do método getRelatorioTecnologiaMenosFaixaEtaria15

    
    /** 
     * @param quantidade <i>double</i> que identifica a quantidade para saber a porcentagem.
     * @param total <i>double</i> que identifica o total daquela porcentagem.
     * @return <i>double</i> que identifica quantos porcentos equivale aquela quantidade.
     */
    public double calculoPorcentagem(double quantidade, double total) {
		return 100.0 * quantidade / total;
	} // fim do método calculoPorcentagem

    
    /** 
     * @param valor <i>double</i> que identifica o valor para ser formatado.
     * @return <i>String</i> que identifica o valor formatado com duas casas decimais.
     */
    public String doubleParaStringFormatado(double valor) {
		return String.format("%.2f", valor);
	} // fim do método doubleParaStringFormatado

    
    /** 
     * @param cadeia <i>String</i> que identifica a variavel que queira pegar o primeiro caracter.
     * @return <i>String</i> que contem o primeiro caracter de <b>cadeia</b>.
     */
    public String pegarPrimeiroCaracterStr(String cadeia) {
        String caracterStr = "";
        char[] caracter = cadeia.toCharArray();
        return caracterStr += caracter[0];
    } // fim do método pegarPrimeiroCaracterStr
    

} // fim da classe EntrevistadoInterface