package Service;

import Model.Epic;
import Model.Subtask;
import Repository.EpicRepo;

import java.util.List;

public class EpicService {
    EpicRepo epicRepo = new EpicRepo();


    public Epic addNewEpic(Epic epic){
        return epicRepo.addNewEpic(epic);
    }
    public Epic updateEpic(Epic epic){
        return epicRepo.updateEpic(epic);
    }
    public Epic getEpicById(Integer id){
        return epicRepo.getEpicById(id);
    }
    public List<Epic> getAllEpic(){
        return epicRepo.getAllEpic();
    }
    public Epic deleteEpicById(Integer id){
        return epicRepo.deleteEpicById(id);
    }
    public void deleteAllEpic(){
        epicRepo.deleteAllEpic();
    }
    public List<Subtask> getAllSubtask(Integer id){
        Epic epic = epicRepo.getEpicById(id);
        List<Subtask> listSubtask = epic.getAllSubtask();
        return listSubtask;
    }
}
