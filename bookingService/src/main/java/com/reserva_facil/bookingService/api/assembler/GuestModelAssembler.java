package com.reserva_facil.bookingService.api.assembler;

import com.reserva_facil.bookingService.domain.model.Guest;
import com.reserva_facil.bookingService.domain.model.dto.GuestDTO;
import com.reserva_facil.hotelService.domain.dto.HotelDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuestModelAssembler {

    @Autowired
    private ModelMapper modelMaper;

    public GuestDTO toModel(Guest guest) {

        return modelMaper.map(guest, GuestDTO.class);
    }

    public List<GuestDTO> toCollectionModel(List<Guest> guests) {
        return guests.stream()
                .map(guest -> toModel(guest))
                .collect(Collectors.toList());
    }


}
