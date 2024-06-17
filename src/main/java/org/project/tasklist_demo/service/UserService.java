package org.project.tasklist_demo.service;

import org.project.tasklist_demo.domain.task.Task;
import org.project.tasklist_demo.domain.user.User;

import java.util.List;

public interface UserService {

    User getById(
            Long id
    );

    User getByUsername(
            String username
    );

    User update(
            User user
    );

    User create(
            User user
    );

    boolean isTaskOwner(
            Long userId,
            Long taskId
    );

    void delete(
            Long id
    );

}
