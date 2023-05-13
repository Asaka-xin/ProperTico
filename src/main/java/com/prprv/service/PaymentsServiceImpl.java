package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prprv.common.result.Result;
import com.prprv.common.result.ResultEnum;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Payments;
import com.prprv.mapper.PaymentsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author phj233
 * @since 2023/5/13 14:17
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentsServiceImpl implements PaymentsService{
    final private PaymentsMapper paymentsMapper;
    /**
     * 创建缴费记录
     *
     * @param payments 缴费信息
     * @return Result
     */
    @Override
    public Result<Object> createPayments(Payments payments) {
        try{
            QueryWrapper<Payments> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",payments.getId());
            Payments selectedPayment = paymentsMapper.selectOne(queryWrapper);
            queryWrapper.clear();
            if(selectedPayment != null){
                return ResultUtil.error(ResultEnum.PAYMENT_DUPLICATE);
            }
            payments.setId(null);
            paymentsMapper.insert(payments);
            return ResultUtil.success();
        }catch (Exception e) {
            log.error("新增缴费记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 查询所有缴费记录
     *
     * @return Result
     */
    @Override
    public Result<Object> findAllPayments() {
        try {
            return ResultUtil.success(paymentsMapper.selectList(null));
        } catch (Exception e) {
            log.error("查询所有缴费记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 分页查询缴费记录
     *
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    @Override
    public Result<Object> findAllPaymentsByPage(Integer page, Integer size) {
        try {
            Page<Payments> paymentsPage = new Page<>(page, size);
            return ResultUtil.success(paymentsMapper.selectPage(paymentsPage, null));
        }catch (Exception e) {
            log.error("分页查询缴费记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }


    /**
     * 根据缴费人查询缴费记录
     *
     * @param user 缴费户号
     * @return Result
     */
    @Override
    public Result<Object> findPaymentsByUser(String user) {
        try {
            QueryWrapper<Payments> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user",user);
            return ResultUtil.success(paymentsMapper.selectList(queryWrapper));
        }catch (Exception e) {
            log.error("根据缴费人查询缴费记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 删除缴费记录
     *
     * @param id 缴费编号
     */
    @Override
    public Result<Object> deletePaymentsById(Long id) {
        try {
            paymentsMapper.deleteById(id);
            return ResultUtil.success();
        }catch (Exception e) {
            log.error("删除缴费记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
