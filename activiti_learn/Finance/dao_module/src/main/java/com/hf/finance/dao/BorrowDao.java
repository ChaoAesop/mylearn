package com.hf.finance.dao;

import com.hf.finance.entity.form.BorrowForm;

/**
 * 借支单dao
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/16 0016 9:31
 */
public interface BorrowDao {
    void executeSave(BorrowForm bform);

    void executeUpdate(BorrowForm bform);
}
