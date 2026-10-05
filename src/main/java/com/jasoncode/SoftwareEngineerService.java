package com.jasoncode;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return  softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public void removeSoftwareEngineerById(Integer id){
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineerById(Integer id, SoftwareEngineer engineer){
        SoftwareEngineer existingEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));

        existingEngineer.setName(engineer.getName());
        existingEngineer.setTechStack(engineer.getTechStack());

        softwareEngineerRepository.save(existingEngineer);
    }

    public List<SoftwareEngineer> getEngineersByTechStack(String techStack){
        return softwareEngineerRepository.findByTechStack(techStack);
    }

    public void updateSoftwareEngineerTechStack(Integer id, String techStack) {
        SoftwareEngineer existingEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));

        existingEngineer.setTechStack(techStack);

        softwareEngineerRepository.save(existingEngineer);
    }
}
