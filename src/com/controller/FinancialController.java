package com.controller;

import com.entity.FinancialRecord;
import com.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 财务记录相关接口控制器
 */
@RestController
@RequestMapping("/api/financial")
public class FinancialController {

    @Autowired
    private FinancialService financialService;

    /**
     * 添加财务记录接口
     */
    @PostMapping("/records")
    public ApiResponse<FinancialRecord> addRecord(@RequestBody FinancialRecord record) {
        try {
            return ApiResponse.success(financialService.addRecord(record));
        } catch (RuntimeException e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 获取月度财务记录接口
     */
    @GetMapping("/records")
    public ApiResponse<List<FinancialRecord>> getMonthlyRecords(
            @RequestParam Long userId,
            @RequestParam String month // 格式：yyyy-MM
    ) {
        try {
            return ApiResponse.success(financialService.getRecordsByMonth(userId, month));
        } catch (RuntimeException e) {
            return ApiResponse.error(e.getMessage());
        }
    }
}