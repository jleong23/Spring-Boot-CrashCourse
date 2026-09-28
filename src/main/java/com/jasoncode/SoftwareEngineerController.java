package com.jasoncode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return List.of(
                new SoftwareEngineer(
                1,
                "Jason",
                "react, node, tailwind, postgresql"
        ),
                new SoftwareEngineer(
                        2,
                        "James",
                        "python, pytorch, tailwind"
                ),
                new SoftwareEngineer(
                        3,
                        "Mila",
                        "Java, Springboot, AWS"
                ));
    }
}
