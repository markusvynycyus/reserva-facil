package com.reserva_facil.hotelService.api.assembler;

import com.reserva_facil.hotelService.domain.dto.AmenityDTO;
import com.reserva_facil.hotelService.domain.model.Amenity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AmenityModelAsssembler {

    @Autowired
    private ModelMapper modelMaper;

    public AmenityDTO toModel(Amenity amenity) {

        return modelMaper.map(amenity, AmenityDTO.class);
    }

    public List<AmenityDTO> toCollectionModel(List<Amenity> amenities) {
        return amenities.stream()
                .map(amenity -> toModel(amenity))
                .collect(Collectors.toList());
    }

}
