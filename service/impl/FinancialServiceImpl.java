package com.service.impl;

import com.entity.FinancialRecord;
import com.repository.FinancialRecordRepository;
import com.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

/**
 * 财务记录服务实现类
 */
@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private FinancialRecordRepository financialRecordRepository;

    @Override
    public FinancialRecord addRecord(FinancialRecord record) {
        // 验证金额（不能为0）
        if (record.getAmount() == 0) {
            throw new RuntimeException("Amount cannot be zero");
        }
        return financialRecordRepository.save(record);
    }

    @Override
    public List<FinancialRecord> getRecordsByMonth(Long userId, String month) {
        try {
            // 解析月份获取日期范围（当月第一天和最后一天）
            LocalDate firstDayOfMonth = LocalDate.parse(month + "-01");
            LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());
            
            return financialRecordRepository.findByUserIdAndRecordDateBetween(
                    userId,
                    firstDayOfMonth,
                    lastDayOfMonth
            );
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid month format. Please use yyyy-MM");
        }
    }
}