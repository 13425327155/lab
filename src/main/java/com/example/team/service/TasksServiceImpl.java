package com.example.team.service;

import com.example.team.dao.TasksDao;
import com.example.team.model.Tasks;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {
    @Resource
    TasksDao tasksDao;

    @Override
    public List<Tasks> findTasks() {
        return tasksDao.findTasks();
    }

    @Override
    public List<Tasks> findCompleted() {
        return tasksDao.findCompleted();
    }

    @Override
    public void save(Tasks tasks) {
        tasksDao.save(tasks);
    }

    @Override
    public List<Tasks> findByTaskName(String task_name) {
        return tasksDao.findByTaskName(task_name);
    }


    @Override
    public List<Tasks> findAllAssign(String task_people_number) {
        List<Tasks> tasks = tasksDao.findAllAssign(task_people_number);
//        for (Tasks t :
//                tasks) {
//            if (t.getAssign_state().equals("0")){
//                t.setAssign_state("未完成");
//            }else {
//                t.setAssign_state("已完成");
//            }
//        }
        return tasks;
    }

    @Override
    public List<Tasks> searchTasks(String inputs, String stu_number) {
        return tasksDao.searchTasks(inputs, stu_number);
    }

    @Override
    public String updateAssignState(int id, String assign_state) {
        //通过状态返回字符串
        if (assign_state.equals("0")) {
            //进行更新操作，之后返回字符串“已完成”
            tasksDao.updateAssignState(id);
            return "已完成";
        }else{
            return "此任务重复完成";
        }
    }
}
