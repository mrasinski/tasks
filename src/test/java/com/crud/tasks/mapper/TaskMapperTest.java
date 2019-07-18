package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.dto.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "First", "Desc");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(new Long(1L), task.getId());
        assertEquals("First", task.getTitle());
        assertEquals("Desc", task.getContent());
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "First", "Desc");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(new Long(1L), taskDto.getId());
        assertEquals("First", taskDto.getTitle());
        assertEquals("Desc", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "First", "Desc");
        Task task2 = new Task(2L, "Second", "Desc");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(2, taskDtos.size());
    }
}