package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void findingTaskForSearchQueryTrue() {
        SimpleTask simpleTask = new SimpleTask(6, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void findingTaskForSearchQueryFalse() {
        SimpleTask simpleTask = new SimpleTask(6, "Встреча с друзьями");

        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchQueryForEpicFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic pic = new Epic(1, subtasks);

        boolean expected = false;
        boolean actual = pic.matches("Батон");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchQueryForEpicTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic pic = new Epic(1, subtasks);

        boolean expected = true;
        boolean actual = pic.matches("Яйца");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchQueryForMeetingTrueTopic() {
        Meeting meet = new Meeting(
                100,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean expected = true;
        boolean actual = meet.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchQueryForMeetingTrueProject() {
        Meeting meet = new Meeting(
                100,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean expected = true;
        boolean actual = meet.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchQueryForMeetingFalse() {
        Meeting meet = new Meeting(
                100,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean expected = false;
        boolean actual = meet.matches("Нетология}");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testForGetTopic() {
        Meeting meet = new Meeting(
                100,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        String expected = "Выкатка 3й версии приложения";
        String actual = meet.getTopic();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testForGetProject() {
        Meeting meet = new Meeting(
                100,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        String expected = "Приложение НетоБанка";
        String actual = meet.getProject();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testForGetStart() {
        Meeting meet = new Meeting(
                100,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        String expected = "Во вторник после обеда";
        String actual = meet.getStart();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testForGetterTitle() {
        SimpleTask simpleTask = new SimpleTask(6, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testForGetterSubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic pic = new Epic(1, subtasks);

        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = pic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

}

