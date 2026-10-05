package com.jasoncode;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public void addNewSoftwareEngineer(@Validated @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("{id}")
    public void deleteEngineer(@PathVariable Integer id) {
        softwareEngineerService.removeSoftwareEngineerById(id);
    }

    @PutMapping("{id}")
    public void updateEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.updateSoftwareEngineerById(id, softwareEngineer);
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(@RequestParam(required = false) String techStack) {
        if (techStack != null) {
            return softwareEngineerService.getEngineersByTechStack(techStack);
        }
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @PatchMapping("{id}/tech-stack")
    public void updateEngineerTechStack(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer){
        softwareEngineerService.updateSoftwareEngineerTechStack(id, softwareEngineer.getTechStack());
    }
}
