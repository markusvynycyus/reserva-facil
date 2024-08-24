package com.reserva_facil.hotelService.api.controller;

import com.reserva_facil.hotelService.api.assembler.AmenityInputDissasembler;
import com.reserva_facil.hotelService.api.assembler.AmenityModelAsssembler;
import com.reserva_facil.hotelService.domain.dto.AmenityDTO;
import com.reserva_facil.hotelService.domain.dto.input.AmenityInput;
import com.reserva_facil.hotelService.domain.exception.HotelNaoEncontradoException;
import com.reserva_facil.hotelService.domain.exception.NegocioException;
import com.reserva_facil.hotelService.domain.model.Amenity;
import com.reserva_facil.hotelService.domain.repository.AmenityRespository;
import com.reserva_facil.hotelService.domain.service.AmenityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api/amenidades")
public class AmenityController {


    @Autowired
    private AmenityRespository amenityRespository;

    @Autowired
    private AmenityService amenityService;

    @Autowired
    private AmenityModelAsssembler amenityModelAsssembler;

    @Autowired
    private AmenityInputDissasembler amenityInputDisassembler;


    @GetMapping
    public List<AmenityDTO> listar(){
        List<Amenity> amenities = amenityRespository.findAll();
        return amenityModelAsssembler.toCollectionModel(amenities);
    }

    @GetMapping("/{amenityId}")
    public AmenityDTO buscar(@PathVariable Long amenityId) {
        Amenity amenity = amenityService.buscarOuFalhar(amenityId);
        return amenityModelAsssembler.toModel(amenity);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AmenityDTO adicionar(@RequestBody @Valid AmenityInput amenityInput) {
        Amenity amenity  = amenityInputDisassembler.toDomainObject(amenityInput);

        amenity = amenityService.salvar(amenity);

        return amenityModelAsssembler.toModel(amenity);
    }

    @PutMapping("/{amenityId}")
    public AmenityDTO atualizar(@PathVariable Long amenityId, @RequestBody Long amenityInput) {
        try {
            Amenity amenityAtual = amenityService.buscarOuFalhar(amenityInput);

            amenityInputDisassembler.copyToDomainObject(amenityInput, amenityAtual);

            amenityAtual = amenityService.salvar(amenityAtual);

            return amenityModelAsssembler.toModel(amenityAtual);
        } catch (HotelNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }


    @DeleteMapping("/{amenityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long amenityId) {

        amenityService.excluir(amenityId);
    }

}
