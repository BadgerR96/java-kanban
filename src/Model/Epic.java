package Model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task{
    private List<Subtask> listOfSubtask = new ArrayList<>();
    private int nextId = 1;

    public boolean addSubtaskInList(Subtask subtask){
        subtask.setId(nextId++);
        return listOfSubtask.add(subtask);
    }


    public boolean entrySubtask(Integer id) {
        for (Subtask subtask : listOfSubtask){
            if(id.equals(subtask.getId())){
                return true;
            }
        }
        return false;
    }
    @Override
    public String getStatus(){
        int count = listOfSubtask.size();
        String result = Dictionary.NEW;
        for (int i = 0; i < listOfSubtask.size(); i++){
            Subtask subtask = listOfSubtask.get(i);
            if(Dictionary.NEW.equals(subtask.getStatus()) && !Dictionary.IN_PROGRES.equals(result)){
                result = Dictionary.NEW;
            }
            if(Dictionary.IN_PROGRES.equals(subtask.getStatus())){
                result = Dictionary.IN_PROGRES;
            }
            if(Dictionary.DONE.equals(subtask.getStatus())){
                count--;
                if(count == 0){
                    return Dictionary.DONE;
                }
            }
        }
        return result;
    }

    public List<Subtask> getAllSubtask() {
        return listOfSubtask;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", subtitle='" + super.getDescription() + '\'' +
                ", status='" + super.getStatus() + '\'' +
                "listOfSubtask=" + listOfSubtask +
                '}';
    }
}
