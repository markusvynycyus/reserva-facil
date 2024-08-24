package com.reserva_facil.hotelService.api.assembler;


import com.reserva_facil.hotelService.domain.dto.input.AmenityInput;
import com.reserva_facil.hotelService.domain.model.Amenity;
import com.reserva_facil.hotelService.domain.model.Hotel;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmenityInputDissasembler {

    @Autowired
    private ModelMapper modelMapper;

    public Amenity toDomainObject(@Valid AmenityInput amenityInput) {

        return modelMapper.map(amenityInput, Amenity.class);
    }

    public void copyToDomainObject(Long amenityInput, Amenity amenity) {
        modelMapper.map(amenityInput, amenity);
    }



}
