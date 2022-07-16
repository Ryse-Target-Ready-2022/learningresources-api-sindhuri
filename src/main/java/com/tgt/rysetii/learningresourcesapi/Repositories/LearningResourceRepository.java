package com.tgt.rysetii.learningresourcesapi.Repositories;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LearningResourceRepository extends JpaRepository<LearningResource,Integer> {
}
