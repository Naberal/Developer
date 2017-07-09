package Developer.DAO;

import Developer.Model.Developer;
import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


public class DeveloperDAO {
    File file=new File("D:\\khmeliar volodymyr\\Developer\\src\\Developer\\Developer.txt");
    public Developer getById(long id){
        Developer developer=new Developer();
        try{FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String  buffer;
            while ((buffer=bufferedReader.readLine())!=null){
                if (buffer.isEmpty()){continue;}
                String[]arrayOfSplitDeveloper=buffer.split(",");
                if (Integer.parseInt(arrayOfSplitDeveloper[0])==id){
                developer.setId(Long.parseLong(arrayOfSplitDeveloper[0]));
                developer.setFirstName(arrayOfSplitDeveloper[1]);
                developer.setLastName(arrayOfSplitDeveloper[2]);
                developer.setSpecialty(arrayOfSplitDeveloper[3]);
                developer.setExperience(Integer.parseInt(arrayOfSplitDeveloper[4]));
                developer.setSalary(new BigDecimal(arrayOfSplitDeveloper[5]));
                return developer;}
            }bufferedReader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return developer;
    }
    public List<Developer>getAllDevelopers() {
        List<Developer> developers = new LinkedList<>();
        Developer tempDeveloper;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String buffer;
            while ((buffer = bufferedReader.readLine()) != null) {
                if (buffer.isEmpty()) {
                    continue;
                }
                tempDeveloper = new Developer();
                String[] arrayOfSplitDeveloper = buffer.split(",");
                tempDeveloper.setId(Long.parseLong(arrayOfSplitDeveloper[0]));
                tempDeveloper.setFirstName(arrayOfSplitDeveloper[1]);
                tempDeveloper.setLastName(arrayOfSplitDeveloper[2]);
                tempDeveloper.setSpecialty(arrayOfSplitDeveloper[3]);
                tempDeveloper.setExperience(Integer.parseInt(arrayOfSplitDeveloper[4]));
                tempDeveloper.setSalary(new BigDecimal(arrayOfSplitDeveloper[5]));
                developers.add(tempDeveloper);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developers;
    }
    public void save(Developer developer){
        String developerToString="";
        developerToString+=developer.getId()+",";
        developerToString+=developer.getFirstName()+",";
        developerToString+=developer.getLastName()+",";
        developerToString+=developer.getSpecialty()+",";
        developerToString+=developer.getExperience()+",";
        developerToString+=developer.getSalary()+"\n";
        try (FileOutputStream fileOutputStream=new FileOutputStream(file,true)){
            fileOutputStream.write(developerToString.getBytes());
            System.out.println("Developer: "+developer+" successfully save.");
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(Developer developer){
        if (developer.equals(null)){
            System.out.println("Developer is not found.");
        }
        else {
            delete(developer.getId());
            save(developer);
            System.out.println("Developer with id "+developer.getId()+" is successfully updata");}
    }
    public void delete(long id){
            String buffer=null;
            StringBuffer stringBuffer = new StringBuffer();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while ((buffer = reader.readLine()) != null) {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    int idToDelete=buffer.charAt(0)-'0';
                    if (!(idToDelete==id)){
                    stringBuffer.append(buffer).append("\n");}
                }
                buffer = stringBuffer.toString();
                System.out.println("Developer with id "+id+" successfully delete");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try (FileOutputStream fileOutputStream=new FileOutputStream(file)) {
                fileOutputStream.write(buffer.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

