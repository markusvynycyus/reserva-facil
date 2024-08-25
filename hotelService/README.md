#HotelService
Descrição do Projeto

O HotelService é um microserviço desenvolvido para gerenciar hotéis, quartos e amenidades. Ele faz parte de uma arquitetura de microsserviços projetada para um sistema de reservas de hotéis. Este serviço permite a manipulação dos dados relacionados a hotéis, seus quartos e amenidades, incluindo operações de criação, leitura, atualização e exclusão (CRUD).
Estrutura do Projeto

O projeto é construído utilizando Spring Boot e segue o padrão de design REST para a criação de APIs. Abaixo, estão as principais entidades e funcionalidades implementadas:
Entidades

    Hotel: Representa um hotel no sistema.
    Room (Quarto): Representa os quartos disponíveis em um hotel.
    Amenity (Amenidade): Representa as comodidades ou facilidades oferecidas por um hotel, como Wi-Fi gratuito, estacionamento, etc.

Controllers

    HotelController: Controlador responsável por gerenciar as operações relacionadas a hotéis.
    RoomController: Controlador responsável por gerenciar as operações relacionadas a quartos de hotéis.
    AmenityController: Controlador responsável por gerenciar as operações relacionadas às amenidades oferecidas pelos hotéis.

Serviços

    HotelService: Serviço que encapsula a lógica de negócios relacionada aos hotéis.
    RoomService: Serviço que encapsula a lógica de negócios relacionada aos quartos.
    AmenityService: Serviço que encapsula a lógica de negócios relacionada às amenidades.

Repositórios

    HotelRepository: Interface que define as operações de persistência relacionadas aos hotéis.
    RoomRepository: Interface que define as operações de persistência relacionadas aos quartos.
    AmenityRepository: Interface que define as operações de persistência relacionadas às amenidades.

Exceções

    HotelNaoEncontradoException: Exceção lançada quando um hotel não é encontrado no banco de dados.
    RoomNaoEncontradoException: Exceção lançada quando um quarto não é encontrado no banco de dados.
    AmenityNaoEncontradoException: Exceção lançada quando uma amenidade não é encontrada no banco de dados.
    EntidadeEmUsoException: Exceção lançada quando se tenta remover uma entidade que está em uso.

Como Executar

    Pré-requisitos: Certifique-se de ter o Java 17 e Maven instalados.
    Compilar o Projeto: Use o comando mvn clean install para compilar o projeto.
    Executar o Serviço: Use o comando mvn spring-boot:run para iniciar o serviço.

Endpoints Principais

    Hotéis:
        GET /api/hoteis: Lista todos os hotéis.
        GET /api/hoteis/{hotelId}: Busca um hotel por ID.
        POST /api/hoteis: Cria um novo hotel.
        PUT /api/hoteis/{hotelId}: Atualiza um hotel existente.
        DELETE /api/hoteis/{hotelId}: Remove um hotel.

    Quartos:
        GET /api/rooms: Lista todos os quartos.
        GET /api/rooms/{roomId}: Busca um quarto por ID.
        POST /api/rooms: Cria um novo quarto.
        PUT /api/rooms/{roomId}: Atualiza um quarto existente.
        DELETE /api/rooms/{roomId}: Remove um quarto.

    Amenidades:
        GET /api/amenidades: Lista todas as amenidades.
        GET /api/amenidades/{amenityId}: Busca uma amenidade por ID.
        POST /api/amenidades: Cria uma nova amenidade.
        PUT /api/amenidades/{amenityId}: Atualiza uma amenidade existente.
        DELETE /api/amenidades/{amenityId}: Remove uma amenidade.

Contribuições

Se você deseja contribuir com este projeto, sinta-se à vontade para enviar pull requests ou reportar issues.
