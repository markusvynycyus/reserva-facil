package com.reserva_facil.hotelService.domain.exception;

public class RoomNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public RoomNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public RoomNaoEncontradoException(Long roomId) {
        this(String.format("Não existe um cadastro de Hotel com código %d", roomId));
    }

}
