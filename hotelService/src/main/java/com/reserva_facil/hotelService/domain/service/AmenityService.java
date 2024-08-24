package com.reserva_facil.hotelService.domain.service;

import com.reserva_facil.hotelService.domain.exception.AmenityNaoEncontradoException;
import com.reserva_facil.hotelService.domain.exception.EntidadeEmUsoException;
import com.reserva_facil.hotelService.domain.model.Amenity;
import com.reserva_facil.hotelService.domain.repository.AmenityRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AmenityService {

    private static final String MSG_AMENITY_EM_USO = "Amenidade de código %d não pode ser removida," +
            " pois está em uso";

    @Autowired
    private AmenityRespository amenityRespository;

    public Amenity salvar(Amenity amenity) {
        return amenityRespository.save(amenity);
    }

    public Amenity buscarOuFalhar(Long amenityId) {
        return amenityRespository.findById(amenityId)
                .orElseThrow(() -> new AmenityNaoEncontradoException(amenityId));
    }

    @Transactional
    public void excluir(Long amenityId) {
        try {
            amenityRespository.deleteById(amenityId);
            amenityRespository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new AmenityNaoEncontradoException(amenityId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_AMENITY_EM_USO , amenityId));
        }
    }

}
