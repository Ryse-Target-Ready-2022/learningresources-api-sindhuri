package com.tgt.rysetii.learningresourcesapi.service;
import com.tgt.rysetii.learningresourcesapi.Repositories.LearningResourceRepository;
import com.tgt.rysetii.learningresourcesapi.entity.*;

import java.util.*;

public class LearningResourceService {

    private final LearningResourceRepository a;

    public LearningResourceService(LearningResourceRepository a) {
        this.a = a;
    }

    public void saveLearningResources(List<LearningResource> a1)
   {
       for(LearningResource l:a1)
           a.save(l);
   }
   public List<LearningResource> getLearningResources()
   {
      return a.findAll();
   }

    public List<Double> getProfitMargin(LearningResource li)
    {

            List<LearningResource> learningResources=getLearningResources();
            List<Double> profitMargins;
        profitMargins = new ArrayList<>();
        for(LearningResource lr:learningResources)
            {
                double r=(lr.getSellingPrice() - lr.getCostPrice())/lr.getSellingPrice();
                profitMargins.add(r);
            }


        return profitMargins;

    }
    public List<LearningResource> sortLearningResources(List<LearningResource> learningResources)
    {
        List<LearningResource> lr=getLearningResources();
        Collections.sort(lr,new LearningResourceSorter());
        return lr;
    }
}
