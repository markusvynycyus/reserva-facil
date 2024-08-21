package com.reserva_facil.hotelService.api.assembler;

import com.reserva_facil.hotelService.domain.dto.HotelDTO;
import com.reserva_facil.hotelService.domain.model.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelModelAssembler {

    @Autowired
    private ModelMapper modelMaper;

    public HotelDTO toModel(Hotel hotel) {

        return modelMaper.map(hotel, HotelDTO.class);
    }

    public List<HotelDTO> toCollectionModel(List<Hotel> hoteis) {
        return hoteis.stream()
                .map(hotel -> toModel(hotel))
                .collect(Collectors.toList());
    }
}
