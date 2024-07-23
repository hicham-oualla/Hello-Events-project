package com.HH.Hello_Events.Model.Entity;

import jakarta.persistence.*;
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
    private int id_billet;

    @ManyToOne
    @JoinColumn(name ="id_client")
    private  Client client;

    @ManyToOne
    @JoinColumn(name ="id")
    private  Event event;


}
