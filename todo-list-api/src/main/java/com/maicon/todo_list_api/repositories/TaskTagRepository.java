package com.maicon.todo_list_api.repositories;

import com.maicon.todo_list_api.models.TaskTagModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTagRepository extends JpaRepository<TaskTagModel, Integer> {
}
