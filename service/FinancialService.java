package com.service;

import com.entity.FinancialRecord;
import java.util.List;

/**
 * 财务记录服务接口
 */
public interface FinancialService {
    // 添加财务记录
    FinancialRecord addRecord(FinancialRecord record);
    
    // 根据用户ID和月份查询记录（格式：yyyy-MM）
    List<FinancialRecord> getRecordsByMonth(Long userId, String month);
}