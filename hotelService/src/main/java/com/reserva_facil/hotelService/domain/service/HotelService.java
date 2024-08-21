package com.reserva_facil.hotelService.domain.service;

import com.reserva_facil.hotelService.domain.exception.EntidadeEmUsoException;
import com.reserva_facil.hotelService.domain.exception.HotelNaoEncontradoException;
import com.reserva_facil.hotelService.domain.model.Hotel;
import com.reserva_facil.hotelService.domain.repository.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private static final String MSG_HOTEL_EM_USO
            = "Hotel de código %d não pode ser removido, pois está em uso";


    @Autowired
    private HotelRepository hotelRepository;


    public Hotel salvar(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel buscarOuFalhar(Long HotelId) {
        return hotelRepository.findById(HotelId)
                .orElseThrow(() -> new HotelNaoEncontradoException(HotelId));
    }

    @Transactional
    public void excluir(Long HotelId) {
        try {
            hotelRepository.deleteById(HotelId);
            hotelRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new HotelNaoEncontradoException(HotelId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_HOTEL_EM_USO, HotelId));
        }
    }

}
