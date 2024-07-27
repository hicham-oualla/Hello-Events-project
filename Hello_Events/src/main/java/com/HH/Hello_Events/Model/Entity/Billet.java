package com.HH.Hello_Events.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @JoinColumn(name ="id_client", nullable = false)
    private  Client client;

    @ManyToOne
    @JoinColumn(name ="id", nullable = false)
    private  Event event;


}
