package Manager;

import Model.Epic;
import Model.Subtask;
import Model.Task;

import java.util.List;

public interface TaskManager {
    void addTask(Task task);

    void addEpic(Epic epic);

    public void addSubtask(Subtask subtask, int epicId);

    void updateTask(Task task);

    void updateSubtask(Subtask subtask);

    void updateEpic(Epic epic);

    List<Epic> getAllEpic();

    List<Subtask> getAllSubtask();

    List<Task> getAllTask();

    List<Subtask> getSubtaskByEpic(Epic epic);

    void deleteAllTask();

    void deleteAllEpic();

    void deleteAllSubtask();

    public void deleteTaskById(Integer id);

    public void deleteEpicById(Integer id);

    public void deleteSubtaskById(Integer id);
    Task getTask(Integer id);
    Epic getEpic(Integer id);
    Subtask getSubtask(Integer id);
    List<Task> getHistory();

}
