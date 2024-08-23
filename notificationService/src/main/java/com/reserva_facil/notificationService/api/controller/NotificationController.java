package com.reserva_facil.notificationService.api.controller;

import com.reserva_facil.notificationService.api.assembler.NotificationInputDisassembler;
import com.reserva_facil.notificationService.api.assembler.NotificationModelAssembler;
import com.reserva_facil.notificationService.domain.dto.NotificationDTO;
import com.reserva_facil.notificationService.domain.dto.input.NotificationInput;
import com.reserva_facil.notificationService.domain.exception.NegocioException;
import com.reserva_facil.notificationService.domain.exception.NotificationNaoEncontradoException;
import com.reserva_facil.notificationService.domain.model.Notification;
import com.reserva_facil.notificationService.domain.repository.NotificationRepository;
import com.reserva_facil.notificationService.domain.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private NotificationModelAssembler notificationModelAssembler;

    @Autowired
    private NotificationInputDisassembler notificationInputDisassembler;

    @GetMapping
    public List<NotificationDTO> listar() {
        List<Notification> notifications = notificationRepository.findAll();
        return notificationModelAssembler.toCollectionModel(notifications);
    }

    @GetMapping("/{notificationId}")
    public NotificationDTO buscar(@PathVariable Long notificationId) {
        Notification notification = notificationService.buscarOuFalhar(notificationId);
        return notificationModelAssembler.toModel(notification);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotificationDTO adicionar(@RequestBody @Valid NotificationInput notificationInput) {
        Notification notification  = notificationInputDisassembler.toDomainObject(notificationInput);

        notification = notificationService.salvar(notification);

        return notificationModelAssembler.toModel(notification);
    }

    @PutMapping("/{notificationId}")
    public NotificationDTO atualizar(@PathVariable Long notificationId,
                                   @RequestBody @Valid NotificationInput notificationInput) {
        try {
            Notification notificationAtual = notificationService.buscarOuFalhar(notificationId);

            notificationInputDisassembler.copyToDomainObject(notificationInput, notificationAtual);

            notificationAtual = notificationService.salvar(notificationAtual);

            return notificationModelAssembler.toModel(notificationAtual);
        } catch (NotificationNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{notificationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long notificationId) {

        notificationService.excluir(notificationId);
    }

}
