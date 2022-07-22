package com.tgt.rysetii.learningresourcesapi.Controllers;
import com.tgt.rysetii.learningresourcesapi.Repositories.LearningResourceRepository;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LearningResourceController {

    private final LearningResourceService lrs;
    @Autowired
    LearningResourceRepository a;

    public LearningResourceController(LearningResourceService lrs) {
        this.lrs = lrs;
    }

    @GetMapping("/Resources")
        public List<LearningResource> getResources()
    {
        return lrs.getLearningResources();
    }
    @PostMapping("/Resources")
    public void putResources(@RequestBody List<LearningResource> lr)
    {

            lrs.saveLearningResources(lr);
            
    }
    @DeleteMapping("/Resources/{id}")
    public void deleteResource(@PathVariable int id)
    {
        lrs.deleteLearningResource(id);
    }


}
