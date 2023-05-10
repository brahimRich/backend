package com.example.demo.Notifier.nofireF;

import com.example.demo.Armoire.Armoire;
import com.example.demo.Armoire.ArmoireService;
import com.example.demo.Notifier.nofireF.model.Notification;
import com.example.demo.Notifier.nofireF.model.NotificationService;
import com.example.demo.Notifier.nofireF.model.PushNotificationResponse;
import com.example.demo.Notifier.nofireF.servece.PushNotificationService;
import com.example.demo.Technicienne.Technicienne;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/notification")
public class PushNotificationController {
    private final NotificationService notificationService;

    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);

    private PushNotificationService pushNotificationService;

    @Autowired
    public PushNotificationController(PushNotificationService pushNotificationService,NotificationService notificationService) {
        this.pushNotificationService = pushNotificationService;
        this.notificationService=notificationService;
    }
    @PostMapping("/topic")
    public ResponseEntity sendNotification(@RequestBody com.example.demo.Notifier.nofireF.model.Notification request) {
        pushNotificationService.sendPushNotificationWithoutData(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
    @PostMapping("/token")
    public ResponseEntity sendTokenNotification(@RequestBody com.example.demo.Notifier.nofireF.model.Notification request) {
        pushNotificationService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
    @PostMapping("/data")
    public ResponseEntity sendDataNotification(@RequestBody com.example.demo.Notifier.nofireF.model.Notification request) throws FirebaseMessagingException, IllegalAccessException {
        pushNotificationService.sendPushNotification(request,request.getTechnicienne().getIdc(), request.getIntervention());
        notificationService.addNotification(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Notification> getpointLumineux() {
        return notificationService.getAllNotification();
    }

    @GetMapping("/a")
    public ResponseEntity<List<com.example.demo.Notifier.nofireF.model.Notification>> getAllNotifications() {
        List<com.example.demo.Notifier.nofireF.model.Notification> notifications = notificationService.getAllNotification();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

}