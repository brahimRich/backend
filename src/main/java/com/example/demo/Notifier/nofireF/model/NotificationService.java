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



    @Autowired
    public NotificationService(NotificationRepository notificationRepository,TechnicienneRepository technicienneRepository,InterventionRepository interventionRepository,PointLumineuxRepository pointLumineuxRepository){
        this.notificationRepository = notificationRepository;
        this.technicienneRepository=technicienneRepository;
        this.interventionRepository=interventionRepository;
        this.pointLumineuxRepository=pointLumineuxRepository;
    }

    public List<Notification> getAllNotification() {
        return notificationRepository.findAll();
    }

    public void addNotification(Notification notification) throws IllegalAccessException {
        System.out.println("save notification ************");
        Technicienne t=new Technicienne();
        Intervention i=new Intervention();
        Boolean ex=technicienneRepository.existsById(notification.getTechnicienne().getId());

        if (notification.getIntervention().getPointLumineuxList() == null) {
            notification.getIntervention().setPointLumineuxList(new ArrayList<>());
        }
        boolean b = pointLumineuxRepository.existsById(notification.getIntervention().getPointLumineuxList().get(0).getReference());
        if(!b){
            System.out.println("********************Produit with reference "+notification.getIntervention().getPointLumineuxList().get(0).getReference()+" does not exists");
        }else{
            System.out.println("*******************************************");
        }

        boolean bx = interventionRepository.existsById(notification.getIntervention().getId_Intervention());
        if(!bx) {
            Intervention inte = new Intervention(notification.getIntervention().getDate_intervention(), notification.getIntervention().getType(), notification.getIntervention().getIntitule_Intervention(),
                    notification.getIntervention().getDure_Intervention(), notification.getIntervention().getEtat_intervention(), notification.getIntervention().getPointLumineuxList(), notification.getIntervention().getTechniciennes());
            interventionRepository.save(inte);
            notification.setIntervention(inte);
        }

        if(ex){
            t=technicienneRepository.getReferenceById(notification.getTechnicienne().getId());
            notification.setTechnicienne(t);
            notificationRepository.save(notification);
        }
    }

}
