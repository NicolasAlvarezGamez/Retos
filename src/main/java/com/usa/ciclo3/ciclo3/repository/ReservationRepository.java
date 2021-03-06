package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Nicolás Gámez
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int idReservation){
        return reservationCrudRepository.findById(idReservation);
    }
    
    public Reservation saveReservation(Reservation r){
        return reservationCrudRepository.save(r);
    }
    
    public void delete(Reservation id){
        reservationCrudRepository.delete(id);
    }
}
