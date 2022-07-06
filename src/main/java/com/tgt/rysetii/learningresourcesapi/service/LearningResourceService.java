package com.tgt.rysetii.learningresourcesapi.service;
import com.tgt.rysetii.learningresourcesapi.entity.*;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
public class LearningResourceService {
    private List<LearningResource> getLearningResourcesFromFile(File filename)
    {
        List<LearningResource> li=new ArrayList<>();
        try
        {
            FileReader fi;
            fi = new FileReader(filename);
            BufferedReader br=new BufferedReader(fi);
            String line=null;
            line=br.readLine();
            while(line!=null)
            {
                String attributes[]=line.split(",");
                LearningResource li1=new LearningResource(Integer.parseInt(attributes[0].replaceAll("\\D+","")),attributes[1],Double.parseDouble(attributes[2]),Double.parseDouble(attributes[3]),LearningResourceStatus.valueOf(attributes[4]),LocalDate.parse(attributes[5],DateTimeFormatter.ofPattern("dd-MM-yyyy")),LocalDate.parse(attributes[6],DateTimeFormatter.ofPattern("dd-MM-yyyy")),LocalDate.parse(attributes[7],DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                li.add(li1);
                line=br.readLine();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return li;
    }
    public List<LearningResource> getLearningResources()
    {
        File filename=new File("LearningResources.csv");
        List<LearningResource> learningResources=getLearningResourcesFromFile(filename);
        return learningResources;
    }

}
