package Model;

public class Subtask extends Task {
    private int epicId;

    public Subtask(String title, String description, String status, int epicId) {
        super(title, description, status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" + "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", subtitle='" + super.getDescription() + '\'' +
                ", status='" + super.getStatus() + '\'' +
                "epicId=" + epicId +
                '}';
    }
}
