package org.project.tasklist_demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.project.tasklist_demo.domain.exception.ResourceNotFoundException;
import org.project.tasklist_demo.domain.task.Status;
import org.project.tasklist_demo.domain.task.Task;
import org.project.tasklist_demo.domain.task.TaskImage;
import org.project.tasklist_demo.domain.user.User;
import org.project.tasklist_demo.repository.TaskRepository;
import org.project.tasklist_demo.service.ImageService;
import org.project.tasklist_demo.service.TaskService;
import org.project.tasklist_demo.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final ImageService imageService;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(
            value = "TaskService::getById",
            key = "#id"
    )
    public Task getById(final Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllByUserId(
            final Long id
    ) {
        return taskRepository.findAllByUserId(id);
    }

    @Override
    @Transactional
    @CachePut(
            value = "TaskService::getByID",
            key = "#task.id"
    )
    public Task update(final Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        taskRepository.save(task);
        return task;
    }

    @Override
    @Transactional
    @Cacheable(
            value = "TaskService::getById",
            key = "#task.id"
    )
    public Task create(
            final Task task,
            final Long userId
    ) {
        User user = userService.getById(userId);
        task.setStatus(Status.TODO);
        user.getTasks().add(task);
        userService.update(user);
        return task;
    }

    @Override
    @Transactional
    @CacheEvict(
            value = "TaskService::getByID",
            key = "#id"
    )
    public void delete(
            final Long id
    ) {
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(
            value = "TaskService::getByID",
            key = "#id"
    )
    public void uploadImage(
            final Long id,
            final TaskImage image
    ) {
        Task task = getById(id);
        String filename = imageService.upload(image);
        task.getImages().add(filename);
        taskRepository.save(task);
    }
}
