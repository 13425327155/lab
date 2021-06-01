package com.example.team.dao;

import com.example.team.model.Tasks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TasksDao {
    //未完成的任务
    List<Tasks> findTasks();
    //已完成的任务
    List<Tasks> findCompleted();

    //分配任务
    void save(Tasks tasks);
    //根据任务名称查找已完成任务
    List<Tasks> findByTaskName(@Param("task_name") String task_name);

    List<Tasks> findAllAssign(@Param("task_people_number")String task_people_number);

    List<Tasks> searchTasks(@Param("inputs") String inputs, @Param("task_people_number")String task_people_number);

    void updateAssignState(@Param("id")int id);
}
