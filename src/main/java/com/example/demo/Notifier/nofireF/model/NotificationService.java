package com.example.demo.Notifier.nofireF.model;


import com.example.demo.Admin.Admin;
import com.example.demo.Admin.AdminRepository;
import com.example.demo.Armoire.Armoire;
import com.example.demo.Armoire.ArmoireCaracteristique;
import com.example.demo.Intervention.Intervention;
import com.example.demo.Intervention.InterventionRepository;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.Technicienne.Technicienne;
import com.example.demo.Technicienne.TechnicienneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final TechnicienneRepository technicienneRepository;
    private final InterventionRepository interventionRepository;
    private final PointLumineuxRepository pointLumineuxRepository;
    private final NotificationReponceRepository notificationReponceRepository;
    private final AdminRepository adminRepository;



    @Autowired
    public NotificationService(NotificationRepository notificationRepository,TechnicienneRepository technicienneRepository,InterventionRepository interventionRepository,PointLumineuxRepository pointLumineuxRepository, NotificationReponceRepository notificationReponceRepository,AdminRepository adminRepository){
        this.notificationRepository = notificationRepository;
        this.technicienneRepository=technicienneRepository;
        this.interventionRepository=interventionRepository;
        this.pointLumineuxRepository=pointLumineuxRepository;
        this.notificationReponceRepository=notificationReponceRepository;
        this.adminRepository=adminRepository;
    }

    public List<Notification> getAllNotification() {
        return notificationRepository.findAll();
    }
    public List<NotificationReponce> getAllNotificationReponce() {
        return notificationReponceRepository.findAll();
    }

    public void addNotification(Notification notification) throws IllegalAccessException {
        System.out.println("save notification ************");
        Technicienne t=new Technicienne();
        Intervention i=new Intervention();
        Boolean ex=technicienneRepository.existsById(notification.getTechnicienne().getId());
        if (notification.getIntervention()!=null) {
            if (notification.getIntervention().getPointLumineuxList() == null) {
                notification.getIntervention().setPointLumineuxList(new ArrayList<>());
            }

            boolean b = pointLumineuxRepository.existsById(notification.getIntervention().getPointLumineuxList().get(0).getReference());
            if (!b) {
                System.out.println("********************Produit with reference " + notification.getIntervention().getPointLumineuxList().get(0).getReference() + " does not exists");
            } else {
                System.out.println("*******************************************");
            }

            boolean bx = interventionRepository.existsById(notification.getIntervention().getId_Intervention());
            if (!bx) {
                Admin admin=new Admin();
                admin=adminRepository.getReferenceById(notification.getIntervention().getAdmin().getId());
                Intervention inte = new Intervention(notification.getIntervention().getDate_intervention(), notification.getIntervention().getType(), notification.getIntervention().getIntitule_Intervention(),
                        notification.getIntervention().getDure_Intervention(), notification.getIntervention().getEtat_intervention(), notification.getIntervention().getPointLumineuxList(), notification.getIntervention().getTechniciennes(),admin);
                interventionRepository.save(inte);
                notification.setIntervention(inte);
            }
        }
        if(ex){
            t=technicienneRepository.getReferenceById(notification.getTechnicienne().getId());
            notification.setTechnicienne(t);
            notificationRepository.save(notification);
        }
    }


    public void updateNotificationAdmin(NotificationReponce notification,Long ref) throws IllegalAccessException {
        NotificationReponce notificationReponce = notificationReponceRepository.findById(ref).orElseThrow(()-> new IllegalArgumentException("point with reference "+ref+" does not exists"));
        notificationReponce.setMessage(notification.getMessage());
        notificationReponce.getNotification().getIntervention().setDure_Intervention(notification.getNotification().getIntervention().getDure_Intervention());
        notificationReponce.getNotification().getIntervention().setEtat_intervention(notification.getNotification().getIntervention().getEtat_intervention());
        notificationReponceRepository.save(notificationReponce);
    }

    public void updateNotification(Notification notification,Long ref) throws IllegalAccessException {
        Notification not = notificationRepository.findById(ref).orElseThrow(()-> new IllegalArgumentException("point with reference "+ref+" does not exists"));
        not.setMessage(notification.getMessage());
        not.getIntervention().setDate_intervention(notification.getIntervention().getDate_intervention());
        not.getIntervention().setType(notification.getIntervention().getType());
        not.getIntervention().setTechniciennes(notification.getIntervention().getTechniciennes());
        not.getIntervention().setPointLumineuxList(notification.getIntervention().getPointLumineuxList());
        not.getIntervention().setIntitule_Intervention(notification.getIntervention().getIntitule_Intervention());
        notificationRepository.save(not);
    }

    public void addNotificationAdmin(NotificationReponce notification) throws IllegalAccessException {
        System.out.println("save notification Admin ************");
        Notification i=new Notification();
        Technicienne t=new Technicienne();
        boolean bx = notificationRepository.existsById(notification.getNotification().getId());
        if(bx) {
            System.out.println("-------------------------------------------------------------------------type "+notification.getNotification().getIntervention().getDure_Intervention());
            String dur=notification.getNotification().getIntervention().getDure_Intervention();
            String etat=notification.getNotification().getIntervention().getEtat_intervention();
            i=notificationRepository.getReferenceById(notification.getNotification().getId());
            t=technicienneRepository.getReferenceById(notification.getNotification().getIntervention().getCompleteur().getId());
            i.getIntervention().setCompleteur(t);
            notification.setNotification(i);

            Intervention in=new Intervention();

            Intervention inUp=new Intervention();
            in=interventionRepository.getReferenceById(notification.getNotification().getIntervention().getId_Intervention());
            inUp=in;

            inUp.setId_Intervention(in.getId_Intervention());
            inUp.setDure_Intervention(dur);//notification.getNotification().getIntervention().getType()
            inUp.setEtat_intervention(etat);//notification.getNotification().getIntervention().getType()
            System.out.println("-------------------------------------------------------------------------id de intervention "+notification.getNotification().getIntervention().getDure_Intervention());
            interventionRepository.save(inUp);
            notificationReponceRepository.save(notification);

        }
    }

}
