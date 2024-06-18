package com.maicon.todo_list_api.repositories;

import com.maicon.todo_list_api.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Integer> {
}
