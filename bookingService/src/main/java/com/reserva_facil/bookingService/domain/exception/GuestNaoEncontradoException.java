package com.reserva_facil.bookingService.domain.exception;

import com.reserva_facil.hotelService.domain.exception.EntidadeNaoEncontradaException;

public class GuestNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public GuestNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public GuestNaoEncontradoException(Long guestId) {
        this(String.format("Não existe um cadastro de Hospede com código %d", guestId));
    }
}
