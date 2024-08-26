package com.reserva_facil.bookingService.domain.service;

import com.reserva_facil.bookingService.domain.exception.GuestNaoEncontradoException;
import com.reserva_facil.bookingService.domain.model.Guest;
import com.reserva_facil.bookingService.domain.repository.GuestRepository;
import com.reserva_facil.hotelService.domain.exception.EntidadeEmUsoException;
import com.reserva_facil.hotelService.domain.exception.RoomNaoEncontradoException;
import com.reserva_facil.hotelService.domain.model.Room;
import com.reserva_facil.hotelService.domain.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private static final String MSG_GUEST_EM_USO
            = "Guest(Hospede) de código %d não pode ser removido, pois está em uso";


    @Autowired
    private GuestRepository guestRepository;


    public Guest salvar(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest buscarOuFalhar(Long guestId) {
        return guestRepository.findById(guestId)
                .orElseThrow(() -> new GuestNaoEncontradoException(guestId));
    }

    @Transactional
    public void excluir(Long guestId) {
        try {
            guestRepository.deleteById(guestId);
            guestRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new RoomNaoEncontradoException(guestId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_GUEST_EM_USO, guestId));
        }
    }



}
