package com.reserva_facil.hotelService.api.controller;

import com.reserva_facil.hotelService.api.assembler.HotelInputDisassembler;
import com.reserva_facil.hotelService.api.assembler.HotelModelAssembler;
import com.reserva_facil.hotelService.domain.dto.HotelDTO;
import com.reserva_facil.hotelService.domain.model.Hotel;
import com.reserva_facil.hotelService.domain.repository.HotelRepository;
import com.reserva_facil.hotelService.domain.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    public List<HotelDTO> listar(){
        List<Hotel> hoteis = hotelRepository.findAll();
        return hotelModelAssembler.toCollectionModel(hoteis);
    }

}
