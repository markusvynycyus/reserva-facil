package com.reserva_facil.hotelService.api.controller;

import com.reserva_facil.hotelService.api.assembler.HotelInputDisassembler;
import com.reserva_facil.hotelService.api.assembler.HotelModelAssembler;
import com.reserva_facil.hotelService.domain.dto.HotelDTO;
import com.reserva_facil.hotelService.domain.dto.input.HotelInput;
import com.reserva_facil.hotelService.domain.exception.HotelNaoEncontradoException;
import com.reserva_facil.hotelService.domain.exception.NegocioException;
import com.reserva_facil.hotelService.domain.model.Hotel;
import com.reserva_facil.hotelService.domain.repository.HotelRepository;
import com.reserva_facil.hotelService.domain.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api/hoteis")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelModelAssembler hotelModelAssembler;

    @Autowired
    private HotelInputDisassembler hotelInputDisassembler;

    @GetMapping
    public List<HotelDTO> listar(){
        List<Hotel> hoteis = hotelRepository.findAll();
        return hotelModelAssembler.toCollectionModel(hoteis);
    }

    @GetMapping("/{hotelId}")
    public HotelDTO buscar(@PathVariable Long hotelId) {
        Hotel hotel = hotelService.buscarOuFalhar(hotelId);
        return hotelModelAssembler.toModel(hotel);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HotelDTO adicionar(@RequestBody @Valid HotelInput hotelInput) {
        Hotel hotel  = hotelInputDisassembler.toDomainObject(hotelInput);

        hotel = hotelService.salvar(hotel);

        return hotelModelAssembler.toModel(hotel);
    }

    @PutMapping("/{hotelId}")
    public HotelDTO atualizar(@PathVariable Long hotelId, @RequestBody Long hotelInput) {
        try {
            Hotel hotelAtual = hotelService.buscarOuFalhar(hotelInput);

            hotelInputDisassembler.copyToDomainObject(hotelInput, hotelAtual);

            hotelAtual = hotelService.salvar(hotelAtual);

            return hotelModelAssembler.toModel(hotelAtual);
        } catch (HotelNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }


    @DeleteMapping("/{hotelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long hotelId) {

        hotelService.excluir(hotelId);
    }


}
