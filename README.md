# Sistema de Reservas de Hotéis
# Microserviços para Gerenciamento de Hotéis, Quartos e Amenidades(Comodidades)

<h1 align="center">

## Descrição do Projeto
<p align="left">
Este projeto é um sistema de microserviços para gerenciamento de reservas de hotéis. O sistema é dividido em vários microserviços responsáveis por diferentes aspectos da gestão de hotéis, incluindo a administração de hotéis, quartos e amenidades. Cada microserviço expõe uma API RESTful para permitir operações de criação, leitura, atualização e exclusão (CRUD) dos recursos associados.
</p>

## Microserviços

### 1. HotelService
O `HotelService` é responsável pelo gerenciamento de informações sobre hotéis. Ele permite criar, atualizar, listar e remover hotéis.
- **Funcionalidades**:
  - Adicionar, atualizar, listar e remover hotéis.
  - Relacionar hotéis com amenidades e quartos.
- **Tecnologias Utilizadas**:
  - Java 17
  - Spring Boot
  - Spring Data JPA
  - Hibernate

### 2. RoomService
O `RoomService` gerencia os quartos dos hotéis, permitindo a criação, atualização, listagem e exclusão de quartos.
- **Funcionalidades**:
  - Adicionar, atualizar, listar e remover quartos dos hotéis.
  - Associar quartos a hotéis específicos.
- **Tecnologias Utilizadas**:
  - Java 17
  - Spring Boot
  - Spring Data JPA
  - Hibernate

### 3. AmenityService
O `AmenityService` é responsável pela gestão das amenidades oferecidas pelos hotéis, como Wi-Fi gratuito, café da manhã, entre outros.
- **Funcionalidades**:
  - Adicionar, atualizar, listar e remover amenidades.
  - Associar amenidades a hotéis.
- **Tecnologias Utilizadas**:
  - Java 17
  - Spring Boot
  - Spring Data JPA
  - Hibernate

## Estrutura do Projeto

### Pacotes Principais
- **Controller**: Gerencia as requisições HTTP para os recursos `Hotel`, `Room` e `Amenity`.
- **Service**: Contém as regras de negócio para operações CRUD em `Hotel`, `Room` e `Amenity`.
- **Repository**: Interfaces para acesso ao banco de dados usando Spring Data JPA.
- **DTO**: Objetos para transporte de dados entre camadas.
- **Exception**: Exceções personalizadas para erros específicos do domínio.

### Classes Principais
- **Hotel**: Representa um hotel com atributos como nome, localização e descrição.
- **Room**: Representa um quarto com atributos como número, capacidade e preço.
- **Amenity**: Representa uma amenidade oferecida pelo hotel, como Wi-Fi gratuito ou café da manhã.

## Tecnologias Utilizadas
- **Java 17**: Linguagem de programação.
- **Spring Boot**: Framework para desenvolvimento da aplicação.
- **Spring Data JPA**: Para interação com o banco de dados.
- **Hibernate**: Implementação JPA utilizada.
- **Maven**: Ferramenta de gerenciamento de dependências e build.

## Como Executar
Para rodar os microserviços, siga os passos abaixo para cada serviço:

1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
