package Manager;

import Model.*;

import java.util.*;

public class TaskManager {
    private int nexId = 1;

    private Map<Integer, Task> mapOfTask = new HashMap<>();
    private Map<Integer, Epic> mapOfEpic = new HashMap<>();
    private Map<Integer, Subtask> mapOfSubtask = new HashMap<>();

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
        Set<Status> setOfStatus = new HashSet<>();
        for (int subtaskId : epic.getSubtaskIds()) {
            Subtask subtask = mapOfSubtask.get(subtaskId);
            Status status = subtask.getStatus();
            setOfStatus.add(status);
        }
        if (setOfStatus.isEmpty()) {
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
        return new ArrayList<>(mapOfEpic.values());
    }

    public List<Subtask> getAllSubtask() {
        return new ArrayList<>(mapOfSubtask.values());
    }
    public List<Task> getAllTask() {
        return new ArrayList<>(mapOfTask.values());
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
        mapOfSubtask.clear();
    }

    public void deleteAllSubtask() {
        mapOfSubtask.clear();
        List<Epic> epics = new ArrayList<>();
        for (int epicId : mapOfEpic.keySet()){
            Epic epic = mapOfEpic.get(epicId);
            epic.getSubtaskIds().clear();
            updateEpicStatus(epic);
            mapOfEpic.put(epicId, epic);
        }
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

