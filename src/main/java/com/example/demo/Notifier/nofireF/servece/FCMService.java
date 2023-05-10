package com.example.demo.Notifier.nofireF.servece;


import com.example.demo.Notifier.nofireF.model.PushNotificationRequest;
import com.google.firebase.messaging.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.google.firebase.messaging.Notification;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.print.attribute.standard.Chromaticity;

@Service
public class FCMService {
    private Logger logger = LoggerFactory.getLogger(FCMService.class);

    public void sendMessage(Map<String, String> data, com.example.demo.Notifier.nofireF.model.Notification request)
            throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessageWithData(data, request);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutput = gson.toJson(message);
        String response = sendAndGetResponse(message);
        logger.info("Sent message with data. Topic: " + request.getToken() + ", " + response+ " msg "+jsonOutput);
    }
    public void sendMessageWithoutData(com.example.demo.Notifier.nofireF.model.Notification request)
            throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessageWithoutData(request);
        String response = sendAndGetResponse(message);
        logger.info("Sent message without data. Topic: " + request.getToken() + ", " + response);
    }
    public void sendMessageToToken(com.example.demo.Notifier.nofireF.model.Notification request)
            throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessageToToken(request);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutput = gson.toJson(message);
        String response = sendAndGetResponse(message);
        logger.info("Sent message to token. Device token: " + request.getToken() + ", " + response+ " msg "+jsonOutput);
    }
    private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
        return FirebaseMessaging.getInstance().sendAsync(message).get();
    }
    private AndroidConfig getAndroidConfig(String topic) {
        return AndroidConfig.builder()
                .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(topic)
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder().setSound("NotificationParameter.SOUND.getValue()")
                        .setColor("#FF0000").setTag(topic).build()).build();
    }
    private ApnsConfig getApnsConfig(String topic) {
        return ApnsConfig.builder()
                .setAps(Aps.builder().setCategory(topic).setThreadId(topic).build()).build();
    }
    private Message getPreconfiguredMessageToToken(com.example.demo.Notifier.nofireF.model.Notification request) {
        return getPreconfiguredMessageBuilder(request).setToken(request.getToken())
                .build();
    }
    private Message getPreconfiguredMessageWithoutData(com.example.demo.Notifier.nofireF.model.Notification request) {
        return getPreconfiguredMessageBuilder(request).setTopic(request.getToken())
                .build();
    }
    private Message getPreconfiguredMessageWithData(Map<String, String> data, com.example.demo.Notifier.nofireF.model.Notification request) {
        return getPreconfiguredMessageBuilder(request).putAllData(data).setToken(request.getToken())
                .build();
    }
    private Message.Builder getPreconfiguredMessageBuilder(com.example.demo.Notifier.nofireF.model.Notification request) {
        AndroidConfig androidConfig = getAndroidConfig(request.getToken());
        ApnsConfig apnsConfig = getApnsConfig(request.getToken());
        return Message.builder()
                .setApnsConfig(apnsConfig).setAndroidConfig(androidConfig).setNotification(
                        new Notification(request.getTitle(), request.getMessage()));
    }
}