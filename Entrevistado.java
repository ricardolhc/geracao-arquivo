/**
 * A classe <b>Entrevistado</b> e definida para a separacao dos dados do entrevistado.
 * @author Ricardo Luiz Hentges Costa e Tales Schifelbein Soares
 * @since aug 2022
 * @version 1.1
 */

public class Entrevistado {
    
    /**
     * O atributo sexo, do tipo <i>String</i>, e utilizado para definir o sexo do entrevistado.
     */
    private String sexo;

    /**
     * O atributo faixaEtaria, do tipo <i>String</i>, e utilizado para definir a faixa etaria do entrevistado.
     */
    private String faixaEtaria;

    /**
     * O atributo escolaridade, do tipo <i>String</i>, e utilizado para definir a escolaridade do entrevistado.
     */
    private String escolaridade;

    /**
     * O atributo regiao, do tipo <i>String</i>, e utilizado para definir a regiao do entrevistado.
     */
    private String regiao;

    /**
     * O atributo tecnologia, do tipo <i>String</i>, e utilizado para definir a tecnologia que o entrevistado mais utiliza.
     */
    private String tecnologia;

    /**
     * O atributo area, do tipo <i>String</i>, e utilizado para definir a area prioritaria para a resolucao de problemas envolvendo
    tecnologias digitais do entrevistado.
     */
    private String area;

    
    /**
     * Construtor default da classe <b>Entrevistado</b>.<br>
     * <b>Uso: </b>
     * Entrevistado entrevistado = new Arquivo("dados");<br><br>
     * @param linha <i>String</i> que identifica, em uma unica linha, os dados das respostas dos entrevistados.
     */
    public Entrevistado(String linha) {
        String[] dadoSeparado = new String[6];

        for(int i = 0; i < dadoSeparado.length; i++) {
            dadoSeparado = linha.split(", ");
        }
 
        this.sexo = dadoSeparado[0];
        this.faixaEtaria = dadoSeparado[1];
        this.escolaridade = dadoSeparado[2];
        this.regiao = dadoSeparado[3];
        this.tecnologia = dadoSeparado[4];
        this.area = dadoSeparado[5];
    } // fim do construtor Entrevistado


    /** 
     * @return <i>String</i> que contem a faixa etaria do entrevistado.
     */
    public String getFaixaEtaria() { 
        return this.faixaEtaria; 
    } // fim do método getFaixaEtaria

    
    /** 
     * @return <i>String</i> que contem o sexo do entrevistado.
     */
    public String getSexo() { 
        return this.sexo; 
    } // fim do método getSexo

    
    /** 
     * @return <i>String</i> que contem a escolaridade do entrevistado.
     */
    public String getEscolaridade() { 
        return this.escolaridade; 
    } // fim do método getEscolaridade

    
    /** 
     * @return <i>String</i> que contem a regiao do entrevistado.
     */
    public String getRegiao() { 
        return this.regiao; 
    } //fim do método getRegiao

    
    /** 
     * @return <i>String</i> que contem a tecnologia do entrevistado.
     */
    public String getTecnologia() { 
        return this.tecnologia; 
    } // fim do método getTecnologia

    
    /** 
     * @return <i>String</i> que contem a area do entrevistado.
     */
    public String getArea() { 
        return this.area; 
    } // fim do método getArea

    
    /* MÉTODOS FACILITADORES */

    /** 
     * @param faixaEtaria <i>String</i> que identifica a faixa etaria a ser examinada.
     * @return <i>boolean</i> que identifica se a faixa etaria do entrevistado é a mesma da faixa etaria do parametro.
     */
    public boolean isFaixaEtaria(String faixaEtaria) {
        if(getFaixaEtaria().equals(faixaEtaria)) {
            return true;
        }
        return false;
    }

    
    /** 
     * @param tecnologia <i>String</i> que identifica a tecnologia a ser examinada.
     * @return <i>boolean</i> que identifica se a tecnologia do entrevistado é a mesma da tecnologia do parametro.
     */
    public boolean isTecnologia(String tecnologia) {
        if(getTecnologia().equals(tecnologia)) {
            return true;
        }
        return false;
    }

    
    /** 
     * @param area <i>String</i> que identifica a area a ser examinada.
     * @return <i>boolean</i> que identifica se a area do entrevistado é a mesma da area do parametro.
     */
    public boolean isArea(String area) {
        if(getArea().equals(area)) {
            return true;
        }
        return false;
    }

    
    /** 
     * @param escolaridade <i>String</i> que identifica a escolaridade a ser examinada.
     * @return <i>boolean</i> que identifica se a escolaridade do entrevistado é a mesma da escolaridade do parametro.
     */
    public boolean isEscolaridade(String escolaridade) {
        if(getEscolaridade().equals(escolaridade)) {
            return true;
        }
        return false;
    }


    /** 
     * @param sexo <i>String</i> que identifica a sexo a ser examinada.
     * @return <i>boolean</i> que identifica se a sexo do entrevistado é a mesma da sexo do parametro.
     */
    public boolean isSexo(String sexo) {
        if(getSexo().equals(sexo)) {
            return true;
        }
        return false;
    }

    
} // fim da classe Entrevistado