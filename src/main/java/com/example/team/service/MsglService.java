package com.example.team.service;


import com.example.team.model.Msgl;

import java.util.List;

public interface MsglService {

    public List<Msgl> getMsglList();

    public Msgl findMsglById(long id);
    public List<Msgl> findMsglByIdentifier(String identifier);

    public void save(Msgl msgl);

    public void edit(Msgl msgl);

    public void delete(long id);


}
