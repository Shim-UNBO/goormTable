package com.goormTable.main.service;

import com.goormTable.member.dto.ReservationDto;
import com.goormTable.member.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainService {

    private final Map<Integer, Reservation> store = new HashMap<>();
    private static int sequence = 0;


//    public Reservation saveId(Reservation reservation){
//        store.put(reservation.getReserveSeq(), reservation);
//        return reservation;
//    }
//
//    public Reservation findByReserveSeq(Integer seq){
//        return store.get(seq);
//    }


    public Reservation save(ReservationDto reserveDto){
        Reservation reservation = new Reservation();

        int reserveSeq = ++sequence;
        reservation.setReserveSeq(reserveSeq);
        reservation.setPeopleNum(reserveDto.getPeopleNum());
        reservation.setPhoneNum(reserveDto.getPhoneNum());
        reservation.setExtra(reserveDto.getExtra());

        store.put(reservation.getReserveSeq(),reservation);
        return reservation;
    }


}



