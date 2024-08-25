# HotelService
# Serviço de Gerenciamento de Hotéis
<h1 align="center">

## Descrição do Projeto.
<p align="left">
O `HotelService` é um microserviço desenvolvido para gerenciar informações de hotéis, incluindo quartos e amenidades. Ele permite operações completas para criação, atualização, listagem e exclusão de hotéis, quartos e amenidades. Este microserviço faz parte de um sistema maior para reservas de hotéis, fornecendo funcionalidades RESTful para a gestão eficiente dos dados dos hotéis.
</p>

## Funcionalidades.
- **Gerenciamento de Hotéis**: Adicionar, atualizar, listar e remover hotéis.
- **Gerenciamento de Quartos**: Adicionar, atualizar, listar e remover quartos dos hotéis.
- **Gerenciamento de Amenidades**: Adicionar, atualizar, listar e remover amenidades oferecidas pelos hotéis.

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
Para rodar o `HotelService`, siga os passos abaixo:

1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
