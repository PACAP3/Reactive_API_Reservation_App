package com.example.reactiveSpring.Controller;

import com.example.reactiveSpring.model.Reservation;
import com.example.reactiveSpring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResources.ROOM_V_1_RESERVATION)
@CrossOrigin
public class ReservationResources {
    public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";

    private final ReservationService reservationService;

    @Autowired
    public ReservationResources(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "{id}" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Reservation> getreservationById(@PathVariable String id){

        return reservationService.getReservation(id);

    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation){

        return reservationService.createReservation(reservation);

    }

    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Reservation>  updatePrice(@PathVariable String id,
            @RequestBody Mono<Reservation>   reservation){
        return reservationService.updateReservation(id,reservation);
    }


    @DeleteMapping(path = "{id}")
    public Mono<Boolean>  deleteReservation(@PathVariable String id){
        return reservationService.deleteReservation(id);

    }
}

