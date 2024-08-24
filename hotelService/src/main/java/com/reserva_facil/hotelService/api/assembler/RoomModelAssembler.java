package com.reserva_facil.hotelService.api.assembler;

import com.reserva_facil.hotelService.domain.dto.RoomDTO;
import com.reserva_facil.hotelService.domain.model.Room;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomModelAssembler {

    @Autowired
    private ModelMapper modelMaper;

    public RoomDTO toModel(Room room) {

        return modelMaper.map(room, RoomDTO.class);
    }

    public List<RoomDTO> toCollectionModel(List<Room> rooms) {
        return rooms.stream()
                .map(room -> toModel(room))
                .collect(Collectors.toList());
    }
}
