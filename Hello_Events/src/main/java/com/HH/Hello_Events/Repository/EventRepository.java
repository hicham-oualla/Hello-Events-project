package com.HH.Hello_Events.Repository;

import com.HH.Hello_Events.Model.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {

}
