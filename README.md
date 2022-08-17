# Geração de Arquivo

## Objetivo do Repositório

O objetivo deste repositório é arquivar e demonstrar a programação realizada para o segundo trabalho dado pelos professores da Unipampa (Universidade Federal do Pampa).

## Configuração 

As ferramentas utilizadas para a realização do trabalho são o [Visual Studio Code](https://code.visualstudio.com/download) e [GDB Online](https://www.onlinegdb.com).

## Autores

* Ricardo Luiz Hentges Costa
* Tales Schifelbein Soares

## Enunciado 

O programa de extensão Programa C possui como premissa propiciar a colaboração entre os cursos Ciência da Computação e Engenharia de Software na resolução de problemas da comunidade, com o auxílio de tecnologia computacional. No programa são realizadas diversas atividades, dentre as quais está a atividade Gera!, cujo objetivo é a identificação dos problemas junto à comunidade. Para a realização dessa atividade, a equipe executora do programa elaborou, de forma colaborativa, um questionário, a fim de levantar os problemas existentes na comunidade alegretense.

Elabore uma aplicação na linguagem de programação Java que acessa as respostas do questionário em um arquivo com extensão .csv (disponibilizado) e apresenta as seguintes estatísticas:

1. Total de entrevistados;
2. Percentual de entrevistados do sexo feminino, do sexo masculino e que tenha se identificado como outro;
3. Número de entrevistados por faixa etária;
4. Percentual de entrevistados por grau de escolaridade;
5. Número de entrevistados com pelo menos o ensino superior completo;
6. A faixa etária que mais utiliza smartphone;
7. A tecnologia menos utilizada pelos entrevistados com idade até 15 anos;
8. Número de entrevistados por área prioritária.

Adicionalmente, a aplicação deve gerar um relatório em arquivo texto, legível para o usuário final, com todas as estatísticas solicitadas no enunciado.

### São requisitos para o desenvolvimento deste trabalho:

1. organizar em classes: o projeto deve ter, no mínimo, as classes de domínio: Entrevistado.java e EntrevistadoVetor.java (vetor de entrevistados) e a classe de interação com arquivo (ex.: Arquivo.java);
2. separar a interface do usuário (leituras de dados com o Scanner) das classes de domínio;
3. ler dados de arquivo texto, disponibilizado no MOODLE (formato .csv);
4. gerar relatório em arquivo texto, legível para o usuário final, com todas as estatísticas solicitadas no enunciado;
5. documentar projeto com JavaDoc.

### Acompanhamento

* 28/07 - Enunciado disponibilizado no Moodle.
<br>
* 01/08 - Desenvolvimento da atividade nos grupos.
<br>
* 04/08 - Acompanhamento 1 (25%): por dupla com avaliação (classe Entrevistado, classe Entrevistados com a implementação e teste das estatísticas referentes aos itens 1 a 3).
<br>
* 08/08 - Acompanhamento 2 (25%): por dupla com avaliação (classe Entrevistados com a implementação e teste das estatísticas referentes aos itens 4 a 8, geração do relatório)
<br>
* 11/08 - Apresentação (50%): entrega e apresentação (funcionamento do programa, observando as estatísticas solicitadas e requisitos)

### Apresentação

A apresentação deve ser realizada no dia 11/08/2022 no horário da aula. Durante a apresentação, o sistema produzido deve ser apresentado, portanto cabe ao grupo escolher que operações serão realizadas, bem como conhecer os resultados esperados. Adicionalmente, os professores irão analisar partes de código escolhidas aleatoriamente.

### Anexo: Questionário (Contexto)

<b>1. Qual é o seu gênero (ou com qual gênero você se identifica)?</b> (marque apenas uma resposta)
<br>
( ) Feminino 
<br>
( ) Masculino 
<br>
( ) Outro

<b>2. Qual é a sua idade?</b> (marque apenas uma resposta)

( ) Até 15 anos
<br>
( ) De 16 a 29 anos
<br>
( ) De 30 a 59 anos
<br>
( ) Acima de 60 anos

<b>3. Qual é o seu grau de escolaridade?</b> (marque apenas uma resposta)
<br>
( ) Ensino fundamental incompleto
<br>
( ) Ensino fundamental completo
<br>
( ) Ensino médio incompleto 
<br>
( ) Ensino médio completo
<br>
( ) Ensino superior incompleto
<br>
( ) Ensino superior completo

<b>4. Em qual região da cidade você mora?</b> (marque apenas uma resposta)
<br>
( ) Região Cidade Alta/Aguateiros 
<br>
( ) Região Extremo Leste
<br>
( ) Região Extremo Oeste 
<br>
( ) Região Leste/Ibirapuitã
<br>
( ) Região Norte 
<br>
( ) Região Oeste/Regalado
<br>
( ) Região Sul

<b>5. Qual tecnologia computacional a seguir você mais utiliza no seu dia-a-dia?</b> (marque apenas uma resposta)
<br>
( ) Computador Pessoal 
<br>
( ) Notebook ou Netbook
<br>
( ) Smartphone 
<br>
( ) Tablet
<br>
( ) Nenhuma

<b>6. Para você, qual é a área prioritária para a resolução de problemas envolvendo tecnologias digitais?</b> (marque apenas uma resposta)
<br>
( ) Alimentação 
<br>
( ) Cultura
<br>
( ) Educação 
<br>
( ) Emprego
<br>
( ) Lazer 
<br>
( ) Saúde
<br>
( ) Segurança 
<br>
( ) Transporte