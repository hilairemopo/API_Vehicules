package com.example.tpinf462.service.Impl;
import com.example.tpinf462.domaine.Vehicule;
import com.example.tpinf462.dto.VehiculeDTO;
import com.example.tpinf462.exception.RegistrationException;
import com.example.tpinf462.exception.RentablePriceException;
import com.example.tpinf462.mapper.VehiculeMapperImpl;
import com.example.tpinf462.repository.VehiculeRepository;
import com.example.tpinf462.service.VehiculeService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class VehiculeServiceImpl implements VehiculeService {
    private VehiculeRepository vehiculeRepository;
    private VehiculeMapperImpl vehiculeMapper;
    private final Logger logger = LoggerFactory.getLogger(VehiculeServiceImpl.class);

    @Override
    public VehiculeDTO create(VehiculeDTO vehiculeDTO) {
        Vehicule vehicule=vehiculeMapper.mapToEntity(vehiculeDTO);
log.info(String.valueOf(vehicule));
        Vehicule vehicule1 = vehiculeRepository.save(vehicule);
        return vehiculeMapper.mapToDTO(vehicule1);
    }
/* public Optional<UtilisateurDTO> partialUpdate(UtilisateurDTO utilisateurDTO) {
        logger.debug("Request to partially update Utilisateur : {}", utilisateurDTO);
        return Optional.of(utilisateurRepository.findById(utilisateurDTO.getId())
                .map(existingUtilisateur -> {
                    logger.debug("Request to partially update Utilisateur : {}", existingUtilisateur);
                    if (utilisateurDTO.getEmail() != null && !utilisateurDTO.getEmail().equals(existingUtilisateur.getEmail())) {
                        if (utilisateurRepository.existsByEmailEqualsIgnoreCase(utilisateurDTO.getEmail())) {
                            throw new EntityNotFoundException("Email is already in use!", "dd", "emailExist", ErrorCode.ERROR_401);
                        }
                        existingUtilisateur.setEmail(utilisateurDTO.getEmail());
                    }
                    if (utilisateurDTO.getUsername() != null && !utilisateurDTO.getUsername().equals(existingUtilisateur.getUsername())) {
                        if (utilisateurRepository.existsByUsername(utilisateurDTO.getUsername())) {

                            throw new EntityNotFoundException("Username is already taken ", "Utilisateur", "usernameExist", ErrorCode.ERROR_401);
                        }
                        existingUtilisateur.setUsername(utilisateurDTO.getUsername());
                    }

                    existingUtilisateur.setEnabled(utilisateurDTO.getEnabled());
                    existingUtilisateur.setRoles(utilisateurDTO.getRoles().stream().map(RoleDTO::mapToEntity).collect(Collectors.toList()));
                    return existingUtilisateur;
                }).map(utilisateurRepository::save).map(UtilisateurDTO::mapToDTO)).orElseThrow(() -> new EntityNotFoundException("User not exist", "Utilisateur", "userNotExist", ErrorCode.ERROR_404));
    }
*/
    @Override
    public VehiculeDTO uploadvehicule(VehiculeDTO vehiculeDTO) {
        logger.debug("Request to partially update Utilisateur : {}", vehiculeDTO);
        Optional<Vehicule> vehicule=vehiculeRepository.findById(vehiculeDTO.getId());
        if(!vehicule.isPresent()){
            throw new RuntimeException("vehicule avec cette id n'existe pas ");
        }

        Vehicule vehicule1=vehicule.get();
        if(vehiculeDTO.getRegistratioNumber()!=null){
            vehicule1.setRegistratioNumber(vehiculeDTO.getRegistratioNumber());
        }
        if(vehiculeDTO.getMake()!=null){
            vehicule1.setMake(vehiculeDTO.getMake());
        }
        if(vehiculeDTO.getModel()!=null){
            vehicule1.setModel(vehiculeDTO.getModel());
        }
        if(vehiculeDTO.getYear()!=null){
            vehicule1.setYear(vehiculeDTO.getYear());
        }

        log.info(String.valueOf(vehicule));
        Vehicule vehicule2 = vehiculeRepository.save(vehicule1);
        return vehiculeMapper.mapToDTO(vehicule2);
    }

    @Override
    public void delete(Long id) {
this.vehiculeRepository.deleteById(id);
    }

    @Override
    public List<VehiculeDTO> findALL() {
        List<Vehicule> vehicules= vehiculeRepository.findAll();

        return vehicules.stream().map(vehicule -> vehiculeMapper.mapToDTO(vehicule)).collect(Collectors.toList());
    }

    @Override
    public VehiculeDTO getByregistration(String registration) {
        Vehicule vehicule = vehiculeRepository.findByRegistratioNumber(registration).orElseThrow(()->new RegistrationException("Vehicle whitch this registration not found"))   ;
        return vehiculeMapper.mapToDTO(vehicule);
    }

    @Override
    public VehiculeDTO getByprice(double rentalPrice) {
        Vehicule vehicule=vehiculeRepository.findByRentalPrice(rentalPrice).orElseThrow(()->new RentablePriceException("vehicule whith this rentalPrice not found"));
        return vehiculeMapper.mapToDTO(vehicule);
    }

}