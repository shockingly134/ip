import Thopz.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Task test with junit test cases
 * Test whether todo task can be saved
 * Test deadline class with date time format
 * check whether delete works
 */

class TaskTest {

    @Test
    void testTODOtask() {
        Task task = new Todo("Test_todo");
        task.markTask();
        assertEquals("Test_todo",task.getTasks());
        assertTrue(task.getTaskStatus());
    }

    @Test
    void testDeadlineTask() {
        Task task = new Deadline("test_time", "04/09/2025 21:56");
        assertEquals("[D][] test_time (due by Sep 04 2025, 21:56)", task.toString());
        assertFalse(task.getTaskStatus());
    }

    @Test
    void addTest() {
        TaskList ls = new TaskList();
        Task task1 = new Todo ("test1");
        Task task2 = new Deadline("test2","12/12/2025 19:20");
        Task task3 =new Events("test3", "12/12/2024 19:20", "12-12-2025 19:25");
        ls.addTask(task1);
        ls.addTask(task2);
        assertEquals(2,ls.size());
        ls.addTask(task3);
        assertEquals(3.,ls.size());
    }

    @Test
    void deleteTest() {
        TaskList ls = new TaskList();
        Task task1 = new Todo ("test1");
        Task task2 = new Deadline("test2","12/12/2025 19:20");
        Task task3 = new Events("test3", "12/12/2024 19:20", "12-12-2025 19:25");
        ls.addTask(task1);
        ls.addTask(task2);
        ls.addTask(task3);
        assertEquals(3,ls.size());
        ls.removeTask(2);
        assertEquals(2,ls.size());
        assertEquals("test1",ls.getTask(1).getTasks());
        assertEquals("test3",ls.getTask(2).getTasks());
    }
}