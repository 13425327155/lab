package com.example.team.service;

import com.example.team.model.Tasks;

import java.util.List;

public interface TasksService {
    //未完成的任务
    List<Tasks> findTasks();
    //已完成的任务
    List<Tasks> findCompleted();

    //分配任务
    void save(Tasks tasks);
    //根据任务名称查找已完成任务
    List<Tasks> findByTaskName(String task_name);


    List<Tasks> findAllAssign(String task_people_number);

    List<Tasks> searchTasks(String inputs, String stu_number);

    String updateAssignState(int id, String assign_state);
}
