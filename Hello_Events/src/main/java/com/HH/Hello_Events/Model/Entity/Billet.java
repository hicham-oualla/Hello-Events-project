package com.HH.Hello_Events.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Getter @Setter
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  ID;
    private String evenement_associe;
    private String utilisateur_associe;
    private Date date_achat;

}
