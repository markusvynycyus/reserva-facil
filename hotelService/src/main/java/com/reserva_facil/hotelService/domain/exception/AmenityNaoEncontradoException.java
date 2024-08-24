package com.reserva_facil.hotelService.domain.exception;

public class AmenityNaoEncontradoException  extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public AmenityNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public AmenityNaoEncontradoException(Long amenityId) {
        this(String.format("Não existe um cadastro de Amenity com código %d", amenityId));
    }

}
