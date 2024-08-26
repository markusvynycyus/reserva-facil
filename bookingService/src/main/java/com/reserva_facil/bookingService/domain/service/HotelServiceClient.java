package com.reserva_facil.bookingService.domain.service;

import com.reserva_facil.hotelService.domain.model.Room;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HotelServiceClient {

    private final RestTemplate restTemplate;
    private final String hotelServiceUrl = "http://hotel-service/api/rooms"; // URL do serviço de hotel

    public HotelServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Room getRoomById(Long roomId) {
        return restTemplate.getForObject(hotelServiceUrl + "/" + roomId, Room.class);
    }
}
