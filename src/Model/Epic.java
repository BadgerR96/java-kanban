package Model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Integer> subtaskIds;

    public Epic(String title, String description, Status status) {
        super(title, description, status);
        subtaskIds = new ArrayList<>();
    }

    public void addSubId(int subtaskId){
        subtaskIds.add(subtaskId);
    }

    public List<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    public void setSubtaskIds(List<Integer> subtaskIds) {
        this.subtaskIds = subtaskIds;
    }

    @Override
    public String toString() {
        return "Epic{" + "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", subtitle='" + super.getDescription() + '\'' +
                ", status='" + super.getStatus() + '\'' +
                "subtaskIds=" + subtaskIds.size() +
                '}';
    }
}
