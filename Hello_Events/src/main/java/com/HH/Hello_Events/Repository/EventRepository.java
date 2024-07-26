package com.HH.Hello_Events.Repository;

import com.HH.Hello_Events.Model.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event,Integer> {

    @Query("SELECT COUNT  (*) from  Event ")
    long countEvent();


}
