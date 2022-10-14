package Manager;

import Model.Task;

import java.util.List;

public class Managers {
    private TaskManager taskManager = new InMemoryTaskManager();
    private static HistoryManager historyManager = new InMemoryHistoryManager();

    public TaskManager getDefault(){
        return taskManager;
    }
    public static HistoryManager getDefaultHistory(){
        return historyManager;
    }
}
