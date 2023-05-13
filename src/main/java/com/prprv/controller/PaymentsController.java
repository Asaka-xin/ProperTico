package com.prprv.controller;

import com.prprv.entity.Payments;
import com.prprv.service.PaymentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Christine
 * @version 1.0
 * @since 2023/5/14
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/payments")
public class PaymentsController {

    private final PaymentsService paymentsService;

    /**
     * 创建缴费记录
     */
    @PostMapping("/create")
    public Object createPayments(@RequestBody Payments payments) {
        return paymentsService.createPayments(payments);
    }

    /**
     * 查询所有缴费记录
     */
    @GetMapping("/findAll")
    public Object findAllPayments() {
        return paymentsService.findAllPayments();
    }

    /**
     * 分页查询缴费记录
     */
    @GetMapping("/findPage")
    public Object findPagePayments() {
//        Todo : 待完成
        return null;
    }

    /**
     * 根据缴费人查询缴费记录
     */
    @GetMapping("/findByPayer?user={user}")
    public Object findByPayerPayments(@PathVariable String user) {
//        Todo : 待完成
        return null;
    }

    /**
     * 删除缴费记录
     */
    @PostMapping("/delete")
    public Object deletePayments(@RequestBody Long id) {
//        Todo : 测试未通过
        return paymentsService.deletePaymentsById(id);
    }
}
