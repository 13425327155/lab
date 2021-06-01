package com.example.team;

import com.example.team.model.Achievement;
import com.example.team.service.AchievementService;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    AchievementService achievementService;

}
