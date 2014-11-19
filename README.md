Busca de caminho com menor custo.
=================================

Aplicação web que utiliza o algoritmo Dijkstra para calcular o menor caminho entre dois pontos, e calcular o custo dada a autonomia do veículo e o valor do combustível. 

## Arquitetura.
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
