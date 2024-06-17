package org.project.tasklist_demo.service;

import org.project.tasklist_demo.domain.task.Task;
import org.project.tasklist_demo.domain.task.TaskImage;

import java.util.List;

public interface TaskService {

    Task getById(
            Long id
    );

    List<Task> getAllByUserId(
            Long id
    );

    Task update(
            Task task
    );

    Task create(
            Task task,
            Long userId
    );

    void delete(
            Long id
    );

    void uploadImage(
            Long id,
            TaskImage image
    );

}
