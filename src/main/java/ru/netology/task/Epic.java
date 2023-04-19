package ru.netology.task;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора  (число)
        this.subtasks = subtasks; // заполнение своих полей массив из подзадач,
        // каждая из которых является простым текстом (String);
    }

    public String[] getSubtasks() {

        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (int i = 0; i < subtasks.length; i++) {
            if (subtasks[i].contains(query)) {
                return true;
            }
        }
        return false;
    }
}