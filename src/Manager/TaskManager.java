package Manager;

import Model.Epic;
import Model.Status;
import Model.Subtask;
import Model.Task;

import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private int nexId = 1;

    Map<Integer, Task> mapOfTask = new HashMap<>();
    Map<Integer, Epic> mapOfEpic = new HashMap<>();
    Map<Integer, Subtask> mapOfSubtask = new HashMap<>();


    public Subtask generateSubtask(String title, String description, String status, int epicId) {
        Subtask subtask = new Subtask(title, description, status, epicId);
        subtask.setId(nexId++);
        return subtask;
    }
    public Epic generateEpic(String title, String description, String status) {
        Epic epic = new Epic(title, description, status);
        epic.setId(nexId++);
        return epic;
    }
    public Task generateTask(String title, String description, String status) {
        Task task = new Task(title, description, status);
        task.setId(nexId++);
        return task;
    }
    public void addTask(Task task) {
        task.setId(nexId++);
        mapOfTask.put(task.getId(), task);
    }

    public void addEpic(Epic epic) {
        epic.setId(nexId++);
        updateEpicStatus(epic);
        mapOfEpic.put(epic.getId(), epic);

    }

    public void addSubtask(Subtask subtask, int epicId) {
        subtask.setId(nexId++);
        mapOfSubtask.put(subtask.getId(), subtask);
        Epic epic = mapOfEpic.get(epicId);
        epic.addSubId(subtask.getId());
        updateEpicStatus(epic);
        mapOfEpic.put(epic.getId(), epic);
    }

    public void updateTask(Task task) {
        mapOfTask.put(task.getId(), task);
    }

    public void updateSubtask(Subtask subtask) {
        updateEpicStatus(mapOfEpic.get(subtask.getEpicId()));
        mapOfSubtask.put(subtask.getId(), subtask);
    }

    public void updateEpic(Epic epic) {
        updateEpicStatus(epic);
        mapOfEpic.put(epic.getId(), epic);
    }


    public void updateEpicStatus(Epic epic) {
        Set<String> setOfStatus = new HashSet<>();
        for (int subtaskId : epic.getSubtaskIds()) {
            Subtask subtask = mapOfSubtask.get(subtaskId);
            String status = subtask.getStatus();
            setOfStatus.add(status);
        }
        if(setOfStatus.isEmpty()){
            epic.setStatus(Status.NEW);
            return;
        }
        if (setOfStatus.contains(Status.NEW) && setOfStatus.size() <= 1) {
            epic.setStatus(Status.NEW);
            return;
        }
        if (setOfStatus.contains(Status.DONE) && setOfStatus.size() <= 1) {
            epic.setStatus(Status.DONE);
            return;
        }
        epic.setStatus(Status.IN_PROGRES);
    }

    public List<Epic> getAllEpic() {
        return mapOfEpic.values().stream().collect(Collectors.toList());
    }

    public List<Subtask> getAllSubtask() {
        return mapOfSubtask.values().stream().collect(Collectors.toList());
    }

    public List<Subtask> getSubtaskByEpic(Epic epic) {
        List<Subtask> listSubtask = new ArrayList<>();
        for (int subtaskId : epic.getSubtaskIds()) {
            Subtask subtask = mapOfSubtask.get(subtaskId);
            listSubtask.add(subtask);
        }
        return listSubtask;
    }

    public void deleteAllTask() {
        mapOfTask.clear();
    }

    public void deleteAllEpic() {
        mapOfEpic.clear();
    }

    public void deleteAllSubtask() {
        mapOfSubtask.clear();
    }

    public void deleteTaskById(Integer id) {
        mapOfTask.remove(id);
    }

    public void deleteEpicById(Integer id) {
        mapOfEpic.remove(id);
    }

    public void deleteSubtaskById(Integer id) {
        mapOfSubtask.remove(id);
    }
}

