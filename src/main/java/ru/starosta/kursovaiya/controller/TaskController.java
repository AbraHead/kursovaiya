package ru.starosta.kursovaiya.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.starosta.kursovaiya.dto.UserDto;
import ru.starosta.kursovaiya.entity.Logs;
import ru.starosta.kursovaiya.entity.Task;
import ru.starosta.kursovaiya.repository.LogsRepository;
import ru.starosta.kursovaiya.repository.TaskRepository;
import ru.starosta.kursovaiya.service.LogsService;

import java.util.Optional;

//import static org.hibernate.id.enhanced.StandardOptimizerDescriptor.log;

@Slf4j
@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private LogsService logsService;
//    @Autowired
//    private LogsRepository logsRepository;
    @GetMapping("/list")
    public ModelAndView getAllTasks(UserDto userDto) {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-tasks");
        mav.addObject("tasks", taskRepository.findAll());
        logsService.saveLog("get list of tasks");
//        Logs logs = new Logs();
//        logs.setDescribe("get all students");
//        logs.setUser_id(userDto.getId());
//        logsRepository.save(logs);
        return mav;
    }

    @GetMapping("/addTaskForm")
    public ModelAndView addTaskForm(){
        ModelAndView mav = new ModelAndView("add-task-form");
        Task task = new Task();
        mav.addObject("task", task);
        logsService.saveLog("add task");
//        UserDto user = new UserDto();
//        Logs logs = new Logs();
//        logs.setDescribe("add object student form");
//        logs.setUser_id(user.getId());
//        logsRepository.save(logs);
        return mav;
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute Task task){
        taskRepository.save(task);
        logsService.saveLog("save task in database");
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long taskId) {
        // Отрисовка модели add-task-form.html
        ModelAndView mav = new ModelAndView("add-task-form");
        // Поиск задачи по id
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        Task task = new Task();
        //
        if (optionalTask.isPresent()){
            task = optionalTask.get();
        }
        mav.addObject("task", task);
        logsService.saveLog("show update form 'add-task-form'");
        return mav;
    }

    @GetMapping("/deleteTask")
    public String deleteTask(@RequestParam Long taskId){
        taskRepository.deleteById(taskId);
        logsService.saveLog("delete task from database");
        return "redirect:/list";
    }
}
