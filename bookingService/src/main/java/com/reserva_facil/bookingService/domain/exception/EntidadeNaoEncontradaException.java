package com.reserva_facil.bookingService.domain.exception;

import com.reserva_facil.hotelService.domain.exception.NegocioException;

public class EntidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
