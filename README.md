# Projeto Base API

Projeto base para automação de API com RestAssured + Java.
## Índice

- [Sobre o projeto](#sobre-o-projeto)

## Título

Projeto de automação (Projeto)

## Descrição do projeto

Esse projeto tem como objetivo realizar a automação de testes da API.

### Swagger:

É a fonte que será utilizada para realizar a automação dos enpoints criados <br>


## Postman

Documentação da collection de testes https://reqres.in/

Instalar Java JDK 17

## Estrutura do Projeto de automação

O projeto foi estruturado em diferentes pacotes, sendo eles: <br>  
**Core**<br>
Contém a interface Constantes que realiza o chamdo do swagger para leitura dos endponts.
<br>
Contém uma classe BaseTest, que por sua vez implementa a interface de Constantes.
<br><br>
**Models**<br>
Nesse pacote vai conter as classes que necessitam repassar atributos como parâmetros para as classes de testes.
<br><br>
**Suite**<br>
Contém a classe principal que realiza a autorização através do TOKEN e será responsável por executar em lote todas as classes de teste contidas dentro do pacote de teste.
<br><br>
**Testes**<br>
Contém as classes de testes separadas por funcionalidades.
<br><br>
**Utils**<br>
Contém as classes com métodos que serão utilizados em várias em mais de um método de teste.
