package com.reserva_facil.bookingService.domain.exception;

import com.reserva_facil.hotelService.domain.exception.EntidadeNaoEncontradaException;

public class BookingNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public BookingNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public BookingNaoEncontradoException(Long guestId) {
        this(String.format("Não existe um cadastro de Reserva com código %d", guestId));
    }
}
