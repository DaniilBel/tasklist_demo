package org.project.tasklist_demo.web.mappers;

import java.util.List;

public interface Mappable<E, D> {
    D toDto(E entity);

    List<D> toDto(List<E> entities);

    E toEntity(D dto);

    List<E> toEntity(List<D> dtos);
}
