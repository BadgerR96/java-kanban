package Repository;

import Model.Epic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EpicRepo {
    private int nextId = 1;
    private Map<Integer, Epic> mapOfEpic = new HashMap<>();

    public Epic addNewEpic(Epic epic){
        epic.setId(nextId++);
        return mapOfEpic.put(epic.getId(), epic);
    }
    public Epic updateEpic(Epic epic){
        epic.setStatus(epic.getStatus());
        return mapOfEpic.put(epic.getId(), epic);
    }
    public Epic getEpicById(Integer id){
        return mapOfEpic.get(id);
    }
    public List<Epic> getAllEpic(){
        return mapOfEpic.values().stream().collect(Collectors.toList());
    }
    public Epic deleteEpicById(Integer id){
        return mapOfEpic.remove(id);
    }
    public void deleteAllEpic(){
        mapOfEpic.clear();
    }
    public Epic getBySubtaskId(Integer id){
        Epic epic = null;
        for(Map.Entry<Integer, Epic> entry : mapOfEpic.entrySet()){
            if(entry.getValue().entrySubtask(id)){
                return entry.getValue();
            }
        }
        return null;
    }
}
