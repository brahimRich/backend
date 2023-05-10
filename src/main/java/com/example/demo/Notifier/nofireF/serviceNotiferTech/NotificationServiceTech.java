package com.example.demo.Notifier.nofireF.serviceNotiferTech;

import com.example.demo.Notifier.nofireF.model.NotificationRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceTech {
    /*private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void sendNotifications() throws FirebaseMessagingException {
        List<com.example.demo.Notifier.nofireF.model.Notification> notifications = notificationRepository.findAll();

        for (com.example.demo.Notifier.nofireF.model.Notification notification : notifications) {
            Message message = Message.builder()
                    .setNotification(new Notification(notification.getTitle(), notification.getMessage()))
                    .setTopic(notification.getTechnicienne().getFirebaseTopic()) // Utilisez la propriété appropriée pour spécifier le destinataire de la notification
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);
            notification.setSent(true);
            notification.setSentAt(LocalDateTime.now());
            notificationRepository.save(notification);

            // Traitez la réponse de Firebase si nécessaire
            // ...
        }
    }*/
}

