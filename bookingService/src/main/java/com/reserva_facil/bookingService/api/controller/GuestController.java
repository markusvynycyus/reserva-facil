package com.reserva_facil.bookingService.api.controller;

import com.reserva_facil.bookingService.api.assembler.GuestInputDisassembler;
import com.reserva_facil.bookingService.api.assembler.GuestModelAssembler;
import com.reserva_facil.bookingService.domain.model.Guest;
import com.reserva_facil.bookingService.domain.model.dto.GuestDTO;
import com.reserva_facil.bookingService.domain.model.input.GuestInput;
import com.reserva_facil.bookingService.domain.repository.GuestRepository;
import com.reserva_facil.bookingService.domain.service.GuestService;
import com.reserva_facil.hotelService.domain.exception.HotelNaoEncontradoException;
import com.reserva_facil.hotelService.domain.exception.NegocioException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api/guest")
public class GuestController {

    @Autowired
    private GuestRepository hotelRepository;

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestModelAssembler guestModelAssembler;

    @Autowired
    private GuestInputDisassembler guestInputDisassembler;

    @GetMapping
    public List<GuestDTO> listar(){
        List<Guest> guests = hotelRepository.findAll();
        return guestModelAssembler.toCollectionModel(guests);
    }

    @GetMapping("/{guestId}")
    public GuestDTO buscar(@PathVariable Long guestId) {
        Guest guest = guestService.buscarOuFalhar(guestId);
        return guestModelAssembler.toModel(guest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestDTO adicionar(@RequestBody @Valid GuestInput guestInput) {
        Guest guest  = guestInputDisassembler.toDomainObject(guestInput);

        guest = guestService.salvar(guest);

        return guestModelAssembler.toModel(guest);
    }

    @PutMapping("/{guestId}")
    public GuestDTO atualizar(@PathVariable Long guestId, @RequestBody Long guestInput) {
        try {
            Guest guestAtual = guestService.buscarOuFalhar(guestInput);

            guestInputDisassembler.copyToDomainObject(guestInput, guestAtual);

            guestAtual = guestService.salvar(guestAtual);

            return guestModelAssembler.toModel(guestAtual);
        } catch (HotelNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }


    @DeleteMapping("/{guestId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long guestId) {

        guestService.excluir(guestId);
    }

}
