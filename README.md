# sonda

<h1 align="center">Desafio Sonda Elo7 </h1>

<p align="center"> 🚀 Foi desenvolvida uma API com o objetivo de movimentar a sonda espacial através de comandos.</p>

<p align="center">
 <h1> Objetivo • </h1>
  O desafio proposto, foi movimentar a sonda espacial dentro de um espaço 5x5, onde a mesma começa em uma posição e através de comandos ela chega ao seu destino esperado.
  O espaço da área pode ter uma ou várias sondas.
<p align="center">
 <h1>• 🛠 Tecnologias •</h1>

As seguintes ferramentas foram usadas na construção do projeto:
- Framework: Spring Boot 2.7.4
- Gerenciamento de dependências/ build: Maven 
- Linguagem: Java versão 11
- Testes: JUnit versão 5



<p align="center">


## Posição e Comandos para Sonda

Tamanho da área do planeta : 5x5

Posição de pouso da sonda 1: x=1, y=2 apontando para Norte
Sequencia de comandos: LMLMLMLMM
Posição final da sonda: x=1 y=3 apontando para Norte

Posição de pouso da sonda 2: x=3, y=3 apontando para Leste
Sequencia de comandos: MMRMMRMRRML
Posição final da sonda: x=5 y=1 apontando para Norte


## Exemplo
* Quando rodar o projeto, verifique sua porta, no exemplo é 8080 que é a porta padrão.
* Passamos via parâmetro o nosso comando: <b>LMLMLMLMM</b> <br>
http://localhost:8080/sondas?comando=LMLMLMLMM
<br>

*Informe o ponto inicial da sonda conforme o exemplo acima. <br>

<img width="889" alt="Captura de Tela 2022-09-29 às 19 37 25" src="https://user-images.githubusercontent.com/86304288/193154358-c2d19887-93d7-4fb2-95f2-158a0286692d.png">




## Lista Todas Sondas
GET /sondas

* Lista todas posições da sondas
http://localhost:8080/sondas





## Controle de movimentação da sonda
M - Movimenta. <br>
L - Vira a esquerda 90 Graus. <br>
R - Vira a direita 90 Graus. <br>

