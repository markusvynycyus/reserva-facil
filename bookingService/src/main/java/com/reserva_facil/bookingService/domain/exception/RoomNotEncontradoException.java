package com.reserva_facil.bookingService.domain.exception;

public class RoomNotEncontradoException extends Throwable {
    private static final long serialVersionUID = 1L;

    public RoomNotEncontradoException(String mensagem) {
        super(mensagem);
    }

    public RoomNotEncontradoException(Long roomId) {
        this(String.format("Não existe um cadastro de Quarto com código %d", roomId));
    }
}
