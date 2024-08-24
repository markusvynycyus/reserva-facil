package com.reserva_facil.hotelService.api.controller;

import com.reserva_facil.hotelService.api.assembler.RoomInputDissasembler;
import com.reserva_facil.hotelService.api.assembler.RoomModelAssembler;
import com.reserva_facil.hotelService.domain.dto.RoomDTO;
import com.reserva_facil.hotelService.domain.dto.input.RoomInput;
import com.reserva_facil.hotelService.domain.exception.NegocioException;
import com.reserva_facil.hotelService.domain.exception.RoomNaoEncontradoException;
import com.reserva_facil.hotelService.domain.model.Room;
import com.reserva_facil.hotelService.domain.repository.RoomRepository;
import com.reserva_facil.hotelService.domain.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomModelAssembler roomModelAssembler;

    @Autowired
    private RoomInputDissasembler roomInputDisassembler;

    @GetMapping
    public List<RoomDTO> listar(){
        List<Room> rooms = roomRepository.findAll();
        return roomModelAssembler.toCollectionModel(rooms);
    }

    @GetMapping("/{roomId}")
    public RoomDTO buscar(@PathVariable Long roomId) {
        Room room = roomService.buscarOuFalhar(roomId);
        return roomModelAssembler.toModel(room);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDTO adicionar(@RequestBody @Valid RoomInput roomInput) {
        Room room  = roomInputDisassembler.toDomainObject(roomInput);

        room = roomService.salvar(room);

        return roomModelAssembler.toModel(room);
    }

    @PutMapping("/{hotelId}")
    public RoomDTO atualizar(@PathVariable Long roomId, @RequestBody Long roomInput) {
        try {
            Room roomAtual = roomService.buscarOuFalhar(roomInput);

            roomInputDisassembler.copyToDomainObject(roomInput, roomAtual);

            roomAtual = roomService.salvar(roomAtual);

            return roomModelAssembler.toModel(roomAtual);
        } catch (RoomNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{roomId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long roomId) {

        roomService.excluir(roomId);
    }

}
