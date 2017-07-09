package Developer.Controller;

import Developer.DAO.DeveloperDAO;
import Developer.Model.Developer;
import java.util.List;


public class DeveloperController {
    private DeveloperDAO dao= new DeveloperDAO();
    private Developer developer;

    public void getById(int id){
        developer=dao.getById(id);
        if ((developer.getId())==0){
            System.out.println("Developer is not found.");
        }
        else {
            System.out.println(developer);
        }
    }

    public void saveDeveloper(Developer developer){
        dao.save(developer);
    }

    public void upDataDeveloper( Developer developer){
       dao.update(developer);}

    public List readDeveloper(){
        return dao.getAllDevelopers();
    }

    public void deleteDeveloper(int id){
        developer=dao.getById(id);
        if ((developer.getId())==0){
            System.out.println("Developer is not found.");
        }
        else {
        dao.delete(id);}

    }
}


