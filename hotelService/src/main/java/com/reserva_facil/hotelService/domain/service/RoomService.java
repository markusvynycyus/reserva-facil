package com.reserva_facil.hotelService.domain.service;

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
public class RoomService {

    private static final String MSG_ROOM_EM_USO
            = "Room de código %d não pode ser removido, pois está em uso";


    @Autowired
    private RoomRepository roomRepository;


    public Room salvar(Room room) {
        return roomRepository.save(room);
    }

    public Room buscarOuFalhar(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNaoEncontradoException(roomId));
    }

    @Transactional
    public void excluir(Long roomId) {
        try {
            roomRepository.deleteById(roomId);
            roomRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new RoomNaoEncontradoException(roomId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ROOM_EM_USO, roomId));
        }
    }

}
