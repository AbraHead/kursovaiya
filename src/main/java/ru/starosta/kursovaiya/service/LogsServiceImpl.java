package ru.starosta.kursovaiya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Service;
import ru.starosta.kursovaiya.entity.Logs;
import ru.starosta.kursovaiya.repository.LogsRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class LogsServiceImpl implements LogsService{

    private final LogsRepository logsRepository;
    @Autowired
    public LogsServiceImpl(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    @Override
    public void saveLog(String describe) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Logs logs = new Logs();
        logs.setDescription(describe);
        logs.setDate_actions(sdf.format(date));
        logsRepository.save(logs);
    }
}
