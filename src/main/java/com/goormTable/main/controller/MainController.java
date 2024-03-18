package com.goormTable.main.controller;


import com.goormTable.main.dto.MainDto;
import com.goormTable.main.service.MainService;
import com.goormTable.member.dto.ReservationDto;
import com.goormTable.member.entity.Reservation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "MainController", description = "손님 정보입력 API")
@RestController
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @Operation(summary = "대기자 정보입력", description = "대기자 정보를 처리합니다.")
    @PostMapping("/custLogin")
    public ResponseEntity<Reservation> createReservation(@RequestParam String phoneNum,
                                    @RequestParam Integer peopleNum,
                                    @RequestParam String extra) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setPhoneNum(phoneNum);
        reservationDto.setPeopleNum(peopleNum);
        reservationDto.setExtra(extra);

        Reservation newReservation = mainService.save(reservationDto);
        return ResponseEntity.ok(newReservation);
    }


}
