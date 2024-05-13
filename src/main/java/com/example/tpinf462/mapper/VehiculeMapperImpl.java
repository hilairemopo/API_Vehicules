package com.example.tpinf462.mapper;

import com.example.tpinf462.domaine.Vehicule;
import com.example.tpinf462.dto.VehiculeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/*@Service
public class VehiculeMapperImpl {
    public VehiculeDTO mapToEntity(Vehicule vehicule){
        VehiculeDTO vehiculeDTO=new VehiculeDTO();
        BeanUtils.copyProperties(vehiculeDTO,vehicule);
        return vehiculeDTO;
    }
    public Vehicule mapToDTO(VehiculeDTO vehiculeDTO){
        Vehicule vehicule=new Vehicule();
        BeanUtils.copyProperties(vehicule ,vehiculeDTO);
        return vehicule;
    }


}*/
@Service
public class VehiculeMapperImpl {
    public VehiculeDTO mapToDTO(Vehicule vehicule){
        VehiculeDTO vehiculeDTO = new VehiculeDTO();
        BeanUtils.copyProperties(vehicule, vehiculeDTO);
        return vehiculeDTO;
    }

    public Vehicule mapToEntity(VehiculeDTO vehiculeDTO){
        Vehicule vehicule = new Vehicule();
        BeanUtils.copyProperties(vehiculeDTO, vehicule);
        return vehicule;
    }
}

