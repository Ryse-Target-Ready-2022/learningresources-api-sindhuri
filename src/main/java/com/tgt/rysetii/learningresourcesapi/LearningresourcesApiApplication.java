package com.tgt.rysetii.learningresourcesapi;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.boot.SpringApplication;
import com.tgt.rysetii.learningresourcesapi.Repositories.LearningResourceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.time.LocalDate;
import java.util.ListIterator;

@SpringBootApplication
public class LearningresourcesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningresourcesApiApplication.class, args);

	}

}
