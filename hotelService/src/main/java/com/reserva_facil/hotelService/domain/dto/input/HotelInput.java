package com.reserva_facil.hotelService.domain.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelInput {

    @NotBlank
    private String nome;
}
