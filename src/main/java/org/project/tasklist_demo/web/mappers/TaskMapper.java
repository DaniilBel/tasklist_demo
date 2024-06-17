package org.project.tasklist_demo.web.mappers;

import org.mapstruct.Mapper;
import org.project.tasklist_demo.domain.task.Task;
import org.project.tasklist_demo.web.dto.task.TaskDto;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDto> {
}
