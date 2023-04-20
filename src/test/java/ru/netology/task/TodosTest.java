package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void thereAreSeveralTasksOnRequest() {
        SimpleTask simpleTask = new SimpleTask(1, "Встреча с друзьями");

        String[] subtasks = {"Купить вино", "Сделать ДЗ по лекции", "Отправить ДЗ на проверку"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "План на пятницу",
                "Выпить вино, если поставят зачет!",
                "В эту пятницу, в восемь вечера"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic,meeting};
        Task[] actual = todos.search("вино");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findOneTaskWhenRequested() {
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
    public void searchEngineFindsZeroTasks() {
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

    @Test
    public void querySearchDoesNotFindAnyTask() {
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

        boolean[] expected = {false, false, false};
        boolean[] actual = new boolean[3];
        Task[] arrayTask = todos.findAll();
        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Купить вино");
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void querySearchAnyTask() {
        SimpleTask simpleTask = new SimpleTask(100, "Встреча с друзьями");

        String[] subtasks = {"Написать письмо", "Тестирование сайта", "Приготовить ужин"};
        Epic epic = new Epic(30, subtasks);

        Meeting meeting = new Meeting(
                10256,
                "Написать баг репорт",
                "Найти баги в приложении НетоБанка",
                "В пятницу в восемь утра"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, true, true};
        boolean[] actual = new boolean[3];
        Task[] arrayTask = todos.findAll();
        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Написать");
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void querySearchOneTask() {
        SimpleTask simpleTask = new SimpleTask(100, "Встреча с друзьями");

        String[] subtasks = {"Написать письмо", "Тестирование сайта", "Приготовить ужин"};
        Epic epic = new Epic(30, subtasks);

        Meeting meeting = new Meeting(
                10256,
                "Позвонить на работу",
                "Найти баги в приложении НетоБанка",
                "В пятницу в восемь утра"
        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, true, false};
        boolean[] actual = new boolean[3];
        Task[] arrayTask = todos.findAll();
        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Написать");
        }
        Assertions.assertArrayEquals(expected, actual);

    }

}
