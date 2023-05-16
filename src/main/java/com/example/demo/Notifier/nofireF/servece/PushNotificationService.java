package com.example.demo.Notifier.nofireF.servece;

import com.example.demo.Intervention.Intervention;
import com.example.demo.Notifier.nofireF.model.Notification;
import com.example.demo.Notifier.nofireF.model.NotificationReponce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PushNotificationService {
    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
    private FCMService fcmService;
    public PushNotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }
    public void sendPushNotification(com.example.demo.Notifier.nofireF.model.Notification request,String  userId,Intervention intervention) {
        try {
            Map<String, String> payloadData = getSamplePayloadData(request, userId,intervention);
            fcmService.sendMessage(payloadData, request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void sendPushNotificationReponce(com.example.demo.Notifier.nofireF.model.NotificationReponce request,String  userId,Intervention intervention) {
        try {
            Map<String, String> payloadData = getSamplePayloadDataReponce(request, userId,intervention);
            fcmService.sendMessageReponce(payloadData, request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void sendPushNotificationWithoutData(com.example.demo.Notifier.nofireF.model.Notification request) {
        try {
            fcmService.sendMessageWithoutData(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
    public void sendPushNotificationToToken(com.example.demo.Notifier.nofireF.model.Notification request) {
        try {
            fcmService.sendMessageToToken(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
    private Map<String, String> getSamplePayloadData(Notification request, String userId, Intervention intervention) {
        Map<String, String> pushData = new HashMap<>();
        pushData.put("userId", userId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateString =dateFormat.format(intervention.getDate_intervention());
        pushData.put("DateIn",dateString);
        pushData.put("TypeIn", intervention.getType());
        pushData.put("IntiIn", intervention.getIntitule_Intervention());
        LocalDateTime createdAt = request.getCreatedAt();
        Date date = Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
        String dateString2 =dateFormat.format(date);
        pushData.put("DateNo", dateString2);
        String numberAsString = String.valueOf(intervention.getId_Intervention());
        System.out.println(
                "ID DE INTERVENTION /************************************************************/ "+request.getId()
        );
        pushData.put("IdIn", numberAsString);
        return pushData;
    }

    private Map<String, String> getSamplePayloadDataReponce(NotificationReponce request, String userId, Intervention intervention) {
        Map<String, String> pushData = new HashMap<>();
        pushData.put("userId", userId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //String dateString =dateFormat.format(intervention.getDate_intervention());
        //pushData.put("DateIn",dateString);
        //pushData.put("TypeIn", intervention.getType());
        //pushData.put("IntiIn", intervention.getIntitule_Intervention());
        LocalDateTime createdAt = request.getCreatedAt();
        Date date = Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
        String dateString2 =dateFormat.format(date);
        pushData.put("DateNo", dateString2);
        String numberAsString = String.valueOf(intervention.getId_Intervention());
        System.out.println(
                "ID DE INTERVENTION /************************************************************/ "+request.getId()
        );
        pushData.put("IdIn", numberAsString);
        return pushData;
    }
}