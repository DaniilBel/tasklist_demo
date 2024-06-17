package org.project.tasklist_demo.web.mappers;

import org.mapstruct.Mapper;
import org.project.tasklist_demo.domain.task.TaskImage;
import org.project.tasklist_demo.web.dto.task.TaskImageDto;

@Mapper(componentModel = "spring")
public interface TaskImageMapper extends Mappable<TaskImage, TaskImageDto> {
}
