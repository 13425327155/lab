package com.example.team.service;


import com.example.team.model.Sbgl;

import java.util.List;

public interface SbglService {

    public List<Sbgl> getSbglList();

    public Sbgl findSbglById(long id);
    public List<Sbgl> findSbglByname(String name);

    public void save(Sbgl sbgl);

    public void edit(Sbgl sbgl);

    public void delete(long id);


}
