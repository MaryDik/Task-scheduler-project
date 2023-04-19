package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForTaskByRequest() {
        SimpleTask simpleTask = new SimpleTask(100, "Встреча с друзьями");

        String[] subtasks = {"Написать письмо", "Сделать ДЗ по лекции", "Приготовить ужин"};
        Epic epic = new Epic(30, subtasks);

        Meeting meeting = new Meeting(
                10256,
                "Дымовое тестирование сайта",
                "Найти баги в приложении НетоБанка",
                "В пятницу в восемь утра"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("ужин");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForTaskByRequestFalse() {
        SimpleTask simpleTask = new SimpleTask(100, "Встреча с друзьями");

        String[] subtasks = {"Написать письмо", "Сделать ДЗ по лекции", "Приготовить ужин"};
        Epic epic = new Epic(30, subtasks);

        Meeting meeting = new Meeting(
                10256,
                "Дымовое тестирование сайта",
                "Найти баги в приложении НетоБанка",
                "В пятницу в восемь утра"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Завтрак");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testForGetId() {
        SimpleTask simpleTask = new SimpleTask(100, "Встреча с друзьями");

        String[] subtasks = {"Написать письмо", "Сделать ДЗ по лекции", "Приготовить ужин"};
        Epic epic = new Epic(30, subtasks);

        Meeting meeting = new Meeting(
                10256,
                "Дымовое тестирование сайта",
                "Найти баги в приложении НетоБанка",
                "В пятницу в восемь утра"
        );
        int[] expected = {100, 30, 10256};
        int[] actual = {simpleTask.getId(), epic.getId(), meeting.getId()};

        Assertions.assertArrayEquals(expected, actual);

    }


}
