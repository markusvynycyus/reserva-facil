package com.reserva_facil.notificationService.domain.exception;

public class NotificationNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public NotificationNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public NotificationNaoEncontradoException(Long notificationId) {
        this(String.format("Não existe um cadastro de Notification com código %d", notificationId));
    }
}
