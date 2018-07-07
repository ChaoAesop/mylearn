package com.hf.finance.entity.form;

import com.hf.finance.core.utils.state.YNStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * 借支单
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 15:07
 */
@Entity
@Table(name="borrow_form")
public class BorrowForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    private Integer bid;

    /**
     * 工作部门
     */
    @Column(name = "dept",length = 25)
    private String dept;

    /**
     * 借款人
     */
    @Column(name = "borrower",length = 25)
    private String borrower;

    /**
     * 职别
     */
    @Column(name = "job",length = 25)
    private String job;

    /**
     * 借支金额
     */
    @Column(name = "price")
    private Double price;

    /**
     * 借款原因
     */
    @Column(name = "reason",length = 255)
    private String reason;

    /**
     * 还款日期
     */
    @Column(name = "back_date")
    private Date backDate;

    /**
     * 工资是否扣除
     */
    @Column(name = "salary_is_take",length = 1)
    @Enumerated(EnumType.STRING)
    private YNStatus salaryIsTake;

    /**
     * 出纳人
     */
    @Column(name = "cashier",length = 25)
    private String cashier;

    /**
     * 申请人
     */
    @Column(name = "applicant")
    private Integer applicant;

    /**
     * 领款人
     */
    @Column(name = "payee",length = 25)
    private String payee;

    /**
     * 流程实例id
     */
    @Column(name = "ins_id",length = 25)
    private String insId;

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public YNStatus getSalaryIsTake() {
        return salaryIsTake;
    }

    public void setSalaryIsTake(YNStatus salaryIsTake) {
        this.salaryIsTake = salaryIsTake;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public Integer getApplicant() {
        return applicant;
    }

    public void setApplicant(Integer applicant) {
        this.applicant = applicant;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}
