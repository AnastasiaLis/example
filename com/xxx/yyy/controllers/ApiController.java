package com.xxx.yyy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.xxx.yyy.util.XXXUtil;

@RestController
@RequestMapping("/api/xxx")
public class ApiController {
    @RequestMapping("/NameOfRequest")
    public ResponseEntity<?> NameOfRequest(HttpSession session, @RequestParam(value = "NumberLicensePlate") String NumberLicensePlate, @RequestParam(value = "state") String state) {
        //Returns vehicle data in string format: year,.....
        String vehicleString = XXXUtil.getMemcached(NumberLicensePlate.toUpperCase()+","+state);
        String dataTakenFromMemcached = "0";
        if(vehicleString==null || vehicleString.equals("")){
            vehicleString = licenseplate_decoder(NumberLicensePlate, state);
            XXXUtil.setMemcached(NumberLicensePlate.toUpperCase()+","+state, vehicleString);
        }else{
            dataTakenFromMemcached = "1";
        }
        try{
            XXXX.saveHistoryOfUsageToDataBase(User_ID, "Source or request", NumberLicensePlate, state, dataTakenFromMemcached);
        }
        catch(Exception e){
            System.out.println(" NameOfRequest save data error  "+ e.toString());
        }
        if(vehicleString.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        String[] decoderValues = vehicleString.split(",");
        ... result = new ...();
		...
        result.Year = decoderValues[0];
        //...
        return ResponseEntity.ok(result);
    }
}