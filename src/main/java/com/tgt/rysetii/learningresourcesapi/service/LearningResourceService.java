package com.tgt.rysetii.learningresourcesapi.service;
import com.tgt.rysetii.learningresourcesapi.Repositories.LearningResourceRepository;
import com.tgt.rysetii.learningresourcesapi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
@Component("LRR")
public class LearningResourceService {
    @Autowired

    LearningResourceRepository a;



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
        List<Double> profitMargins=learningResources.stream()
                .map(lr->((lr.getSellingPrice()-lr.getCostPrice())/lr.getSellingPrice())).collect(toList());
        return profitMargins;
            }


        return profitMargins;

    }
    public List<LearningResource> sortLearningResources()
    {
        List<LearningResource> learningResources=getLearningResources();
        learningResources.sort((lr1,lr2)->{
            Double profitMargin1=(lr1.getSellingPrice()-lr1.getCostPrice())/lr1.getSellingPrice();
            Double profitMargin2=(lr1.getSellingPrice()-lr1.getCostPrice())/lr1.getSellingPrice();
            return profitMargin2.compareTo(profitMargin1);
        });
        return learningResources;
    }
}
