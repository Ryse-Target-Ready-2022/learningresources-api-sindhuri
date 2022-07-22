package com.tgt.rysetii.learningresourcesapi.service;
import com.tgt.rysetii.learningresourcesapi.entity.*;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
@Service
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


        } catch (Exception e) {
            System.out.println(e);

        }
        return li;
    }
    public List<LearningResource> getLearningResources()
    {
        File filename=new File("LearningResources.csv");
        List<LearningResource> learningResources=getLearningResourcesFromFile(filename);
        return learningResources;
    }
    private void loadLearningResourcesIntoFile(List<LearningResource> li)
    {
        try
        {
            String csvD=",";
            File filename=new File("LearningResources.csv");
            BufferedWriter bw=new BufferedWriter(new FileWriter(filename,true));
            for(LearningResource li1:li)
            {
                bw.newLine();
                StringBuffer line=new StringBuffer();
                line.append(li1.getResourceId());
                line.append(",");
                line.append(li1.getResourceName());
                line.append(",");
                line.append(li1.getCostPrice());
                line.append(",");
                line.append(li1.getSellingPrice());
                line.append(",");
                line.append(li1.getResourceStatus());
                line.append(",");
                line.append(li1.getCreatedDate());
                line.append(",");
                line.append(li1.getPublishedDate());
                line.append(",");
                line.append(li1.getRetiredDate());
                line.append(",");
                bw.write(line.toString());
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void loadLearningResources(List<LearningResource> li)
    {

        loadLearningResourcesIntoFile(li);
    }
    public List<Double> getProfitMargin(LearningResource li)
    {

           List<LearningResource> learningResources=getLearningResources();
        List<Double> profitMargins=new ArrayList<>();
        for(LearningResource lr1:learningResources)
        {Double profit=(lr1.getSellingPrice()-lr1.getCostPrice())/lr1.getSellingPrice();
            profitMargins.add(profit);}
        return profitMargins;
    }
    public List<LearningResource> sortLearningResources()
    {
        List<LearningResource> learningResources=getLearningResources();
        learningResources.sort(new LearningResourceSorter());
        return learningResources;
    }
}
