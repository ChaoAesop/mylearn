package com.hf.finance.entity.permission;

import javax.persistence.*;

/**
 * 用户Entity
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 14:24
 */
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Integer uid;

    @Column(name = "username")
    private String userName;

    @Column(name = "tel")
    private String tel;

    @Column(name = "age")
    private Integer age;


    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", tel='" + tel + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
