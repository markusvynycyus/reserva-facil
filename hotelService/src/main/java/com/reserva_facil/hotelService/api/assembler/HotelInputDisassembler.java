package com.reserva_facil.hotelService.api.assembler;

import com.reserva_facil.hotelService.domain.dto.input.HotelInput;
import com.reserva_facil.hotelService.domain.model.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class HotelInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Hotel toDomainObject(HotelInput hotelInput) {

        return modelMapper.map(hotelInput, Hotel.class);
    }

    public void copyToDomainObject(Long hotelInput, Hotel hotel) {
        modelMapper.map(hotelInput, hotel);
    }
}
