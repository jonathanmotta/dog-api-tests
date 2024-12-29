# Dog API Tests

Este repositório contém os testes automatizados da Dog API, realizados com **Rest Assured** e **JUnit 5**, e integrados ao **Allure Reports** para geração de relatórios.

## 1. Configuração do Ambiente

### Pré-requisitos
Antes de rodar os testes, certifique-se de ter os seguintes pré-requisitos instalados:

- **Java 11 ou superior**: Certifique-se de que o JDK esteja instalado corretamente.
- **Maven**: O Maven é utilizado para gerenciar dependências e construir o projeto.
- **IDE**: Uma IDE como o IntelliJ IDEA para desenvolver e executar os testes.
- **Allure Commandline**: Para visualizar os relatórios gerados, você precisará ter o Allure instalado. Você pode seguir as instruções de instalação no [site oficial do Allure](https://allure.qameta.io/).

### Instalando as dependências do projeto

1. Clone o repositório:
   git clone git@github.com:jonathanmotta/dog-api-tests.git ou https://github.com/jonathanmotta/dog-api-tests.git

2. Navegue até o diretório do projeto:
cd dog-api-tests

3. Instale as dependências do projeto usando Maven:
mvn clean install

Isso instalará todas as dependências necessárias, como o Rest Assured, JUnit, e Allure REST Assured.


## 2. Execução dos Testes
Testes Unitários com JUnit

1. Para executar os testes, basta rodar o comando Maven abaixo:
mvn test

2. Caso queira executar apenas os testes de uma classe específica, você pode usar:
mvn -Dtest=NomeDaClasseDeTeste test

Exemplo:
mvn -Dtest=DogApiTests test

## Testes com Allure
Para gerar e visualizar os relatórios do Allure após a execução dos testes, siga os passos abaixo:

1. Executando os testes com Allure: Após rodar os testes, gere o relatório com o seguinte comando:
mvn allure:serve

Isso irá:

* Executar os testes.
* Gerar o relatório do Allure.
* Abrir automaticamente o relatório no navegador.

2. Gerar o relatório sem abrir no navegador: Se preferir apenas gerar o relatório e visualizar manualmente, use:
mvn allure:report

3. Visualizando o Relatório: O comando mvn allure:serve abre o relatório automaticamente no navegador. Se você gerou o relatório manualmente, use o comando abaixo para visualizar o relatório em um navegador:
allure serve target/allure-results

## 3. Leitura dos Relatórios
Após executar os testes e gerar o relatório com o Allure, você pode acessar as seguintes informações no relatório:

* Status dos Testes: Mostra se os testes passaram ou falharam.
* Gráficos e Métricas: Informações sobre a cobertura de testes e tempos de execução.
* Logs: Logs detalhados para os testes que falharam, incluindo os parâmetros e as respostas da API.

O Allure oferece uma interface visual para analisar o desempenho dos testes, o que ajuda a entender rapidamente a saúde da aplicação e os pontos de falha.

## 4. Estrutura do Projeto
* src/test/java/com/dogapi/tests/DogApiTests.java: Contém os testes para a Dog API utilizando Rest Assured e JUnit 5.
* pom.xml: Arquivo de configuração do Maven com as dependências necessárias para executar os testes e gerar os relatórios com Allure.
* target/allure-results: Diretório onde os resultados do Allure são armazenados após a execução dos testes.
