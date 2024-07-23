package com.HH.Hello_Events.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private   int  id;
   private String titre;
   private Date date;
   private String lieu;
   private String  categorie ;
   @OneToMany(mappedBy ="event")
    private List<Billet> billets;
}
