package com.reserva_facil.notificationService.domain.service;

import com.reserva_facil.notificationService.domain.exception.EntidadeEmUsoException;
import com.reserva_facil.notificationService.domain.exception.NotificationNaoEncontradoException;
import com.reserva_facil.notificationService.domain.model.Notification;
import com.reserva_facil.notificationService.domain.repository.NotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final String MSG_NOTIFICATION_EM_USO
            = "Notificação de código %d não pode ser removida, pois está em uso";


    @Autowired
    private NotificationRepository notificationRepository;

    public Notification salvar(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification buscarOuFalhar(Long notificationId) {
        return notificationRepository.findById(notificationId)
                .orElseThrow(() -> new NotificationNaoEncontradoException(notificationId));
    }

    @Transactional
    public void excluir(Long notificationId) {
        try {
            notificationRepository.deleteById(notificationId);
            notificationRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new NotificationNaoEncontradoException(notificationId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_NOTIFICATION_EM_USO, notificationId));
        }
    }

}
