Busca de caminho com menor custo
=================================

Aplicação web que utiliza o algoritmo Dijkstra para calcular o menor caminho entre dois pontos, e calcular o custo dada a autonomia do veículo e o valor do combustível. 

## Arquitetura
Para essa projeto foi utilizado banco relacional HQSLDB para que o a aplicação seja iniciada facilmente, porém com algumas alterações na configuração pode ser usado PostgreSQL ou Oracle, por exemplo.

Com o Spring Framework, a implementação de padrões de projeto e boas práticas é facilitada, aumentando assim produtividade e qualidade.

Abaixo lista de frameworks e tecnologias utilizadas:

<ul>
<li>JEE 7</li>
<li>Spring MVC</li>
<li>Spring Data</li>
<li>HSQLDB</li>
<li>Spring Test</li>
<li>JUnit</li>
</ul>

## Pré-requisitos
<ul>
<li>Java 7</li>
<li>Gradle 2</li>
</ul>

## Quick Start
Para iniciar a aplicação basta digitar: gradle jettyRun

## Testes
A aplicação estará disponível em http://localhost:8080/searchpath.

O retorno das requisições é baseado no protocolo HTTP.

Exemplo de POST para criação de novo mapa utilizando curl:

```
curl -X POST -H "Content-Type: application/json" -d '{"name":"SP","routes":[{"origin":"A", "destination":"B", "distance":"10"}, {"origin":"B", "destination":"D", "distance":"15"}, {"origin":"A", "destination":"C", "distance":"20"}, {"origin":"C", "destination":"D", "distance":"50"}, {"origin":"B", "destination":"E", "distance":"30"}]}' http://localhost:8080/searchpath/map
```

Exemplo de GET para cálculo da rota de entrega e seu custo utilizando curl:
```
curl -X GET -H "Content-Type: application/json" -d '{"mapName":"SP","from":"A", "to":"D", "autonomy":"10", "fuelValue":"2.50"}' http://localhost:8080/searchpath/shipment/path
```
Retorno
```
{
  "places":["A","B","D"],
  "cost":6.25
}
```
