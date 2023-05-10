package com.prprv.service;

import com.github.pagehelper.Page;
import com.prprv.entity.Estates;

import java.util.List;
import java.util.Map;

public interface EstatesService {

    public List<Estates> findAll();

    public Page<Estates> search(Map searchMap);

    public Boolean add(Estates estates);

    public Estates findById(Integer id);

    public Boolean update(Estates estates);

    public Boolean updateStatus(String status, Long id);

    public Boolean del(List<Integer> ids);
}
