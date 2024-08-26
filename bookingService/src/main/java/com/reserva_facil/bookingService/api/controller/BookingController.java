package com.reserva_facil.bookingService.api.controller;

import com.reserva_facil.bookingService.api.assembler.BookingInputDisassembler;
import com.reserva_facil.bookingService.api.assembler.BookingModelAssembler;
import com.reserva_facil.bookingService.domain.exception.BookingNaoEncontradoException;
import com.reserva_facil.bookingService.domain.exception.RoomNotEncontradoException;
import com.reserva_facil.bookingService.domain.model.Booking;
import com.reserva_facil.bookingService.domain.model.dto.BookingDTO;
import com.reserva_facil.bookingService.domain.model.input.BookingInput;
import com.reserva_facil.bookingService.domain.service.BookingService;
import com.reserva_facil.hotelService.domain.exception.NegocioException;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingModelAssembler bookingModelAssembler;

    @Autowired
    private BookingInputDisassembler bookingInputDisassembler;


    @GetMapping
    public List<BookingDTO> listar() {
        List<Booking> bookings = bookingService.findAll();
        return bookingModelAssembler.toCollectionModel(bookings);
    }



    @GetMapping("/{bookingId}")
    public BookingDTO buscar(@PathVariable Long bookingId) {
        Booking booking = bookingService.buscarOuFalhar(bookingId);
        return bookingModelAssembler.toModel(booking);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDTO adicionar(@RequestBody @Valid BookingInput bookingInput) {
        try {
            Booking booking = bookingInputDisassembler.toDomainObject(bookingInput);
            booking = bookingService.createBooking(booking);
            return bookingModelAssembler.toModel(booking);
        } catch (RoomNotEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }




    @DeleteMapping("/{guestId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long bookingId) {

        bookingService.excluir(bookingId);
    }
}
