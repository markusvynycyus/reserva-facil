package com.reserva_facil.notificationService.api.assembler;

import com.reserva_facil.notificationService.domain.dto.NotificationDTO;
import com.reserva_facil.notificationService.domain.model.Notification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NotificationModelAssembler {

    @Autowired
    private ModelMapper modelMaper;

    public NotificationDTO toModel(Notification notification) {

        return modelMaper.map(notification, NotificationDTO.class);
    }

    public List<NotificationDTO> toCollectionModel(List<Notification> notifications) {
        return notifications.stream()
                .map(notification -> toModel(notification))
                .collect(Collectors.toList());
    }
}
