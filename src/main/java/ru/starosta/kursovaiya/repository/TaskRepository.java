package ru.starosta.kursovaiya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.starosta.kursovaiya.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
