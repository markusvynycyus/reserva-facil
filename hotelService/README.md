# Sistema de Reservas de Hotéis
# Microserviços para Gerenciamento de Hotéis, Quartos, Amenidades e Notificações.

<h1 align="center">

## Descrição do Projeto
<p align="left">
Este projeto é um sistema de microserviços para gerenciamento de reservas de hotéis. O sistema é dividido em vários microserviços responsáveis por diferentes aspectos da gestão de hotéis, incluindo a administração de hotéis, quartos, amenidades e notificações. Cada microserviço expõe uma API RESTful para permitir operações de criação, leitura, atualização e exclusão (CRUD) dos recursos associados.
</p>

## Microserviços

### 1. HotelService
O `HotelService` é responsável pelo gerenciamento de informações sobre Hotéis. Ele permite criar, atualizar, listar e remover hotéis.
- **Funcionalidades**:
    - Adicionar, atualizar, listar e remover Hotéis.
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

### 4. NotificationService
O `NotificationService` é responsável pelo gerenciamento e envio de notificações para os usuários, como confirmações de reserva, lembretes e alertas.
- **Funcionalidades**:
    - Enviar notificações por e-mail ou SMS.
    - Gerenciar templates de notificação e logs de envio.
- **Tecnologias Utilizadas**:
    - Java 17
    - Spring Boot
    - Spring Messaging
    - APIs de envio de e-mail e SMS (por exemplo, SendGrid, Twilio)

## Estrutura do Projeto

### Pacotes Principais
- **Controller**: Gerencia as requisições HTTP para os recursos `Hotel`, `Room`, `Amenity`, e `Notification`.
- **Service**: Contém as regras de negócio para operações CRUD em `Hotel`, `Room`, `Amenity`, e `Notification`.
- **Repository**: Interfaces para acesso ao banco de dados usando Spring Data JPA.
- **DTO**: Objetos para transporte de dados entre camadas.
- **Exception**: Exceções personalizadas para erros específicos do domínio.

### Classes Principais
- **Hotel**: Representa um hotel com atributos como nome, localização e descrição.
- **Room**: Representa um quarto com atributos como número, capacidade e preço.
- **Amenity**: Representa uma amenidade oferecida pelo hotel, como Wi-Fi gratuito ou café da manhã.
- **Notification**: Representa uma notificação enviada aos usuários, com atributos como tipo de notificação e conteúdo.

## Tecnologias Utilizadas
- **Java 17**: Linguagem de programação.
- **Spring Boot**: Framework para desenvolvimento da aplicação.
- **Spring Data JPA**: Para interação com o banco de dados.
- **Hibernate**: Implementação JPA utilizada.
- **Spring Messaging**: Para gerenciamento e envio de mensagens.
- **Maven**: Ferramenta de gerenciamento de dependências e build.

## Como Executar
Para rodar os microserviços, siga os passos abaixo para cada serviço:

1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
