package com.reserva_facil.bookingService.domain.exception;

import com.reserva_facil.hotelService.domain.exception.NegocioException;

public class EntidadeEmUsoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }

}
