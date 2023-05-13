package com.prprv.controller;

import com.prprv.entity.Complaints;
import com.prprv.service.ComplaintsService;
import com.prprv.service.ComplaintsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Christine
 * @version 1.0
 * @since 2023/5/13
 * @see ComplaintsServiceImpl
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/complaints")
public class ComplaintsController {

    private final ComplaintsService complaintsService;

    /**
     * 创建投诉记录
     * @param complaints 投诉信息
     */
    @PostMapping("/create")
    public Object createComplaints(@RequestBody Complaints complaints) {
        return complaintsService.createComplaints(complaints);
    }

    /**
     * 查询所有投诉记录
     * @return Result
     */
    @GetMapping("/list")
    public Object listComplaints() {
        return complaintsService.getAllComplaints();
    }

    /**
     * 处理投诉记录
     * @param complaints 投诉信息
     * @return Result
     */
    @PostMapping("/handle")
    public Object handleComplaints(@RequestBody Complaints complaints) {
        return complaintsService.updateComplaints(complaints);
    }

    /**
     * 根据ID删除投诉记录
     * @param complaints 投诉编号
     * @return object
     */
    @PostMapping("/delete")
    public Object deleteComplaints(@RequestBody Complaints complaints) {
        return complaintsService.deleteComplaints(complaints.getId());
    }

    /**
     *根据ID查询投诉记录
     */
    @GetMapping("/get")
    public Object getComplaintsById() {
//        Todo : 待完成
        return null;
    }

    /**
     * 分页查询投诉记录
     */
    @GetMapping("/page")
    public Object pageComplaints() {
//        Todo: 待完成
        return null;
    }
}
