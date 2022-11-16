package Manager;

import Model.Node;
import Model.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private List<Task> history = new LinkedList<>();
    private CustomLinkedList customLinkedList = new CustomLinkedList();

    private class CustomLinkedList {
        Map<Integer, Node> map = new HashMap<>();

        private Node first;
        private Node last;
        private int size;

        public void linkLast(Task element) {
            Node newNode = new Node(element);
            if (size == 0) {
                first = newNode;

            } else {
                first.next = newNode;
                newNode.prev = last;

            }
            last = newNode;
            size++;
            map.put(element.getId(), newNode);
        }

        public int size() {
            return size;
        }

        public void removeFirst() {
            if (size == 1) {
                first = null;
                last = null;
                size = 0;
                map.clear();
            }
            if (size > 1) {
                Node node = first.next;
                node.prev = null;
                first = node;
                size--;
            }
        }

        public List<Task> getTasks() {
            List<Node> list = new ArrayList<>(map.values());
            List<Task> tasksList = new ArrayList<>();
           ///Node node = first;
            for (Node node : list){
                if(list.contains(node))
                    removeNode(node);
                linkLast(node.value);
                tasksList.add(node.value);

            }
          /* for (Node node : list){

                /*if(tasksList.contains(node.value)){

                    tasksList.remove(node.value);

                }
               tasksList.add(node.value);

            }*/

            return tasksList;
// из нодов сделать таски
        }

        public void remove(int id) {
            Node node = map.get(id);
            Node nodeNext = node.next;
            Node nodePrev = node.prev;
            if (nodeNext != null) {
                nodeNext.prev = nodePrev;
            }
            if (nodePrev != null) {
                nodePrev.next = nodeNext;
            }
            map.remove(id);
        }

        public void removeNode(Node node) {
            Node nodeNext = node.next;
            Node nodePrev = node.prev;
            if(nodeNext != null) {
                nodeNext.prev = nodePrev;
            }
            if(nodePrev != null) {
                nodePrev.next = nodeNext;
            }
            map.remove(node.value.getId());
        }

        public void addTask(Task task) {

            if (map.containsKey(task.getId())) {
               removeNode(map.get(task.getId()));
            }
            if (customLinkedList.size() >= 10) {
                customLinkedList.removeFirst();

            }
            linkLast(task);
        }

    }

    @Override
    public void add(Task task) {
        /*if (customLinkedList.size() >= 10) {
            customLinkedList.removeFirst();

        }*/
        customLinkedList.addTask(task);

    }

    @Override
    public List<Task> getHistory() {

        return customLinkedList.getTasks();
    }

    @Override
    public void remove(int id) {
        customLinkedList.remove(id);
    }
}
// сделать проверку при добавлении, на дубликаты, при совпадении добавлять в конец.