package com.reserva_facil.hotelService.api.assembler;


import com.reserva_facil.hotelService.domain.dto.input.HotelInput;
import com.reserva_facil.hotelService.domain.dto.input.RoomInput;
import com.reserva_facil.hotelService.domain.model.Hotel;
import com.reserva_facil.hotelService.domain.model.Room;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomInputDissasembler {

    @Autowired
    private ModelMapper modelMapper;

    public Room toDomainObject(RoomInput roomInput) {

        return modelMapper.map(roomInput, Room.class);
    }

    public void copyToDomainObject(Long roomInput, Room room) {
        modelMapper.map(roomInput, room);
    }
}
