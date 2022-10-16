package Manager;

import Model.*;

import java.util.*;

public class InMemoryTaskManager implements TaskManager {
    private int nexId = 1;


    private Map<Integer, Task> mapOfTask = new HashMap<>();
    private Map<Integer, Epic> mapOfEpic = new HashMap<>();
    private Map<Integer, Subtask> mapOfSubtask = new HashMap<>();
    private final HistoryManager historyManager = Managers.getDefaultHistory();


    @Override
    public void addTask(Task task) {
        task.setId(nexId++);
        mapOfTask.put(task.getId(), task);
    }

    @Override
    public void addEpic(Epic epic) {
        epic.setId(nexId++);
        updateEpicStatus(epic);
        mapOfEpic.put(epic.getId(), epic);

    }

    @Override
    public void addSubtask(Subtask subtask, int epicId) {
        subtask.setId(nexId++);
        mapOfSubtask.put(subtask.getId(), subtask);
        Epic epic = mapOfEpic.get(epicId);
        epic.addSubId(subtask.getId());
        updateEpicStatus(epic);
        mapOfEpic.put(epic.getId(), epic);
    }

    @Override
    public void updateTask(Task task) {
        mapOfTask.put(task.getId(), task);
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        updateEpicStatus(mapOfEpic.get(subtask.getEpicId()));
        mapOfSubtask.put(subtask.getId(), subtask);
    }

    @Override
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

    @Override
    public Task getTask(Integer id) {
        Task task = mapOfTask.get(id);
        historyManager.add(task);
        return task;
    }

    @Override
    public Epic getEpic(Integer id) {
        Epic epic = mapOfEpic.get(id);
        historyManager.add(epic);
        return epic;
    }

    @Override
    public Subtask getSubtask(Integer id) {
        Subtask subtask = mapOfSubtask.get(id);
        historyManager.add(subtask);
        return subtask;
    }

    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

    @Override
    public List<Epic> getAllEpic() {
        return new ArrayList<>(mapOfEpic.values());
    }

    @Override
    public List<Subtask> getAllSubtask() {
        return new ArrayList<>(mapOfSubtask.values());
    }

    @Override
    public List<Task> getAllTask() {
        return new ArrayList<>(mapOfTask.values());
    }

    @Override
    public List<Subtask> getSubtaskByEpic(Epic epic) {
        List<Subtask> listSubtask = new ArrayList<>();
        for (int subtaskId : epic.getSubtaskIds()) {
            Subtask subtask = mapOfSubtask.get(subtaskId);
            listSubtask.add(subtask);
        }
        return listSubtask;
    }

    @Override
    public void deleteAllTask() {
        mapOfTask.clear();
    }

    @Override
    public void deleteAllEpic() {
        mapOfEpic.clear();
        mapOfSubtask.clear();
    }

    @Override
    public void deleteAllSubtask() {
        mapOfSubtask.clear();
        for (Epic e : mapOfEpic.values()) {
            e.getSubtaskIds().clear();
            updateEpicStatus(e);
            mapOfEpic.put(e.getId(), e);
        }
    }

    @Override
    public void deleteTaskById(Integer id) {
        mapOfTask.remove(id);
    }

    @Override
    public void deleteEpicById(Integer id) {
        mapOfEpic.remove(id);
    }

    @Override
    public void deleteSubtaskById(Integer id) {
        mapOfSubtask.remove(id);
    }

}

