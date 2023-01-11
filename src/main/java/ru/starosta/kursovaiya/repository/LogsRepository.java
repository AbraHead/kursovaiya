package ru.starosta.kursovaiya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.starosta.kursovaiya.entity.Logs;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Long> {
}
