package com.reserva_facil.hotelService.domain.exception;

public class HotelNaoEncontradoException  extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public HotelNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public HotelNaoEncontradoException(Long hotelId) {
        this(String.format("Não existe um cadastro de Hotel com código %d", hotelId));
    }


}
