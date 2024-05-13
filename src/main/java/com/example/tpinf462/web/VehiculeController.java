package com.example.tpinf462.web;

import com.example.tpinf462.domaine.Vehicule;
import com.example.tpinf462.dto.VehiculeDTO;
import com.example.tpinf462.service.VehiculeService;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@AllArgsConstructor
public class VehiculeController {
    private VehiculeService vehiculeService;


    @PostMapping("/vehicules")
  public ResponseEntity<Object> ajoutervehicule(@RequestBody VehiculeDTO vehicule){
        if(vehiculeService!=null){
            vehiculeService.create(vehicule);
          return   ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("vehiculeservice is null");
        }

    }
    @GetMapping("/vehicules")
    @ResponseBody
    public List<VehiculeDTO> getvehicule(){
     return vehiculeService.findALL();
    }
    @DeleteMapping("vehicules/{id}")
    public void deletevehicule(@PathVariable Long id){
        vehiculeService.delete(id);
    }
    @PutMapping("vehicule/{id}")
    public VehiculeDTO uploadVehicule(@PathVariable Long id, @RequestBody VehiculeDTO vehiculeDTO){
        vehiculeDTO.setId(id);
       return vehiculeService.uploadvehicule(vehiculeDTO);
    }
    @GetMapping("/vehicules/{registration}")
    public VehiculeDTO getByRegistration(@PathVariable String registration) {
        VehiculeDTO vehiculeDTO = vehiculeService.getByregistration(registration);
        return vehiculeDTO;
    }

    @GetMapping("/vehicues/{rentalPrice}")
    public VehiculeDTO getByPrice(@PathVariable double rentalPrice) {
        VehiculeDTO vehiculeDTO = vehiculeService.getByprice(rentalPrice);
       return vehiculeDTO;
    }

}
