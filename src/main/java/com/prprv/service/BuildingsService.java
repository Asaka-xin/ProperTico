package com.prprv.service;


import com.github.pagehelper.Page;
import com.prprv.entity.Buildings;

import java.util.List;
import java.util.Map;

public interface BuildingsService {

    public List<Buildings> findAll();

    public Page<Buildings> search(Map searchMap);

    public Boolean add(Buildings buildings);

    public Buildings findById(Integer id);

    public Boolean update(Buildings buildings);

    public Boolean del(List<Integer> ids);
}
