package com.reserva_facil.notificationService.api.assembler;

import com.reserva_facil.notificationService.domain.dto.input.NotificationInput;
import com.reserva_facil.notificationService.domain.model.Notification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Notification toDomainObject(NotificationInput notificationInput ) {

        return modelMapper.map(notificationInput, Notification.class);
    }

    public void copyToDomainObject(NotificationInput notificationInput, Notification notification) {
        modelMapper.map(notificationInput, notification);
    }


}
