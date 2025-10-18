package com.repository;

import com.entity.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * 财务记录实体数据访问接口
 */
@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    /**
     * 根据用户ID和日期范围查询财务记录
     * @param userId 用户ID
     * @param startDate 开始日期（包含）
     * @param endDate 结束日期（包含）
     * @return 匹配的财务记录列表
     */
    List<FinancialRecord> findByUserIdAndRecordDateBetween(
            Long userId,
            LocalDate startDate,
            LocalDate endDate
    );
}