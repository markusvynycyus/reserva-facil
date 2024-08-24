package com.reserva_facil.hotelService.domain.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoomDTO {

    private String roomNumber;
    private int capacity;
    private double price;
    private HotelDTO hotel;
}
