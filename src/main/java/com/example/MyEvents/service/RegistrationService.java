package com.example.MyEvents.service;

import com.example.MyEvents.RegistrationMapper;
import com.example.MyEvents.dto.Registration;
import com.example.MyEvents.exception.RegistrationNotFoundException;
import com.example.MyEvents.model.RegistrationEntity;
import com.example.MyEvents.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
    public List<Registration> getAllRegistrations(){
        return registrationRepository.findAll()
                .stream()
                .map(RegistrationMapper::toDto)
                .collect(Collectors.toList());
    }
    public Registration getRegistrationById(Long id){
        RegistrationEntity entity = registrationRepository.findById(id)
                .orElseThrow(() -> new RegistrationNotFoundException(id));
        return RegistrationMapper.toDto(entity);
    }
    public Registration addRegistration(Registration registration){
        RegistrationEntity entity = RegistrationMapper.toEntity(registration);
        RegistrationEntity saved =  registrationRepository.save(entity);
        return RegistrationMapper.toDto(saved);
    }

    public Registration updateRegistration(Long id, Registration registration){
        RegistrationEntity entity = registrationRepository.findById(id)
                .orElseThrow(() -> new RegistrationNotFoundException(id));
        RegistrationEntity updatedRegistration = RegistrationMapper.toEntity(registration);
        return RegistrationMapper.toDto(registrationRepository.save(updatedRegistration));
    }

    public void deleteRegistration(Long id){
        registrationRepository.deleteById(id);
    }
}
