package org.project.tasklist_demo.service;

import org.project.tasklist_demo.domain.task.TaskImage;

import java.io.IOException;

public interface ImageService {
    String upload(TaskImage image);
}
