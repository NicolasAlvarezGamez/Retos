package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolás Gámez
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }
    
    public Reservation saveReservation(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.saveReservation(r);
        }else{
            Optional<Reservation> paux=reservationRepository.getReservation(r.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.saveReservation(r);
            }else{
                return r;
            }
        }
    }     
    public Reservation update(Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation>g =reservationRepository.getReservation(r.getIdReservation());
            if(!g.isEmpty()){
                if(r.getStartDate()!=null){
                    g.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus()!=null){
                    g.get().setStatus(r.getStatus());
                }
                if(r.getScore()!=null){
                    g.get().setScore(r.getScore());
                }
                return reservationRepository.saveReservation(g.get());
            }
        }
        return r;
    }
    
    public boolean deleteReservation(int id){
        Optional<Reservation> r=getReservation(id);
        if(!r.isEmpty()){
            reservationRepository.delete(r.get());
            return true;
        }
        return false;
    }
    
}
