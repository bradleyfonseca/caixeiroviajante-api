# SISTEMA DE ENTREGAS - REST API #

Este sistema de entregas visa armazenar rotas e traçar o trajeto mais barato para as entregas.

----------

## Tecnologia ##
- Java 8
- Spring 5
- Spring Boot
- JUnit
- Apache Tomcat (Spring Boot embedded Server)

## IMPORT PROJECT ##
Eclipse: Importar o projeto como "Existing Maven Projects";

## EXECUÇÃO DA APLICAÇÃO ##
Executar como Aplicação Java a classe EntregasApiAplication.java:

    Run as > Java Aplication

As informações serão exibidas no console, e a seguinte mensagem informa que a aplicação está pronta

    Started EntregasApiAplication in 8.247 seconds (JVM running for 9.442)

Sendo assim, já é possível acessar as API, testar no navegador a seguinte URL:

[http://localhost:8080/rota](http://localhost:8080/rota "http://localhost:8080/rota")

Será exibido somente um Array vazio pois não há informações persistidas em memória, mas você pode carregar as rotas padrão a partir da seguinte URL:

[http://localhost:8080/carregarRotasPadrao](http://localhost:8080/carregarRotasPadrao "http://localhost:8080/carregarRotasPadrao")

> Obs: Essa URL somente poderá ser executada 1 vez, as demais ocorrerão ERRO 500;

## TESTES UNITÁRIOS ##
A aplicação foi desenvolvida com testes unitários da camada de serviço, sendo testes para:
- CRUD Rotas (RotasTest.java): Teste de inclusão, exclusão, alteração e busca de rotas;
- Melhor Trajeto (MapaTest.java): Testa o calculo para encontrar um melhor trajeto;

Os testes unitários são executados automaticamente com o maven (goal package), ou pode ser executado na própria IDE Eclipse:

    Run As > JUnit Test

# API DOCUMENTATION #
## Listar rotas ##
- Método: GET
- URL: http://localhost:8080/rota
- Response example:     `[
    {
    "origem": "A",
    "destino": "B",
    "distancia": 10
    },
    {
    "origem": "B",
    "destino": "D",
    "distancia": 15
    }]`

## Inserir rota ##
- Método: POST
- URL: http://localhost:8080/rota
- Request example:
    {
    	"origem":"A",
    	"destino":"B",
    	"distancia":"10"
    }
- Response example:     `[
    {
    "origem": "A",
    "destino": "B",
    "distancia": 10
    },
    {
    "origem": "B",
    "destino": "D",
    "distancia": 15
    }]`

## Alterar rota ##
- Método: PUT
- URL: http://localhost:8080/rota
- Request example:
    {
    	"origem":"A",
    	"destino":"B",
    	"distancia":"10"
    }
- Response example:     `[
    {
    "origem": "A",
    "destino": "B",
    "distancia": 10
    },
    {
    "origem": "B",
    "destino": "D",
    "distancia": 15
    }]`

## Excluir rota ##
- Método: DELETE
- URL: http://localhost:8080/rota
- Request example:
    {
    	"origem":"A",
    	"destino":"B",
    	"distancia":"10"
    }
- Response example:     `[
    {
    "origem": "A",
    "destino": "B",
    "distancia": 10
    },
    {
    "origem": "B",
    "destino": "D",
    "distancia": 15
    }]`

## Carregar Rotas Padrão ##
- Método: GET
- URL: http://localhost:8080/carregarRotasPadrao
- Response example:     `[
    {
    "origem": "A",
    "destino": "B",
    "distancia": 10
    },
    {
    "origem": "B",
    "destino": "D",
    "distancia": 15
    }]`

## Calcular Trajeto ##
- Método: POST
- URL: http://localhost:8080/tracarRota
- Request example:
    {
    	"origem":"A",
    	"destino":"D",
    	"autonomia":"10",
    	"valorLitro":"2.5"
    }
- Response example:     `[
    {
	    "rota": "A B D",
	    "custo": 6.25
    }