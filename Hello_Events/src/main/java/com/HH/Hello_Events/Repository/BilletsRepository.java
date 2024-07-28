package com.HH.Hello_Events.Repository;

import com.HH.Hello_Events.Model.Entity.Billet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BilletsRepository extends JpaRepository<Billet,Integer> {
}
