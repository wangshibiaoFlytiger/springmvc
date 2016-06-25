package com.wangshibiao.spring.model;

import java.util.Date;
import java.util.List;

public class Org extends BaseModel{
    private List<User> userList;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.id
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.name
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.org_code
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private String org_code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.address
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.logo
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private String logo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.contacter
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private String contacter;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.phone
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.email
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.status
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.comment
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.add_time
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private Date add_time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org.update_time
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    private Date update_time;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.id
     *
     * @return the value of org.id
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.id
     *
     * @param id the value for org.id
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.name
     *
     * @return the value of org.name
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.name
     *
     * @param name the value for org.name
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.org_code
     *
     * @return the value of org.org_code
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public String getOrg_code() {
        return org_code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.org_code
     *
     * @param org_code the value for org.org_code
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setOrg_code(String org_code) {
        this.org_code = org_code == null ? null : org_code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.address
     *
     * @return the value of org.address
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.address
     *
     * @param address the value for org.address
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.logo
     *
     * @return the value of org.logo
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public String getLogo() {
        return logo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.logo
     *
     * @param logo the value for org.logo
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.contacter
     *
     * @return the value of org.contacter
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public String getContacter() {
        return contacter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.contacter
     *
     * @param contacter the value for org.contacter
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setContacter(String contacter) {
        this.contacter = contacter == null ? null : contacter.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.phone
     *
     * @return the value of org.phone
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.phone
     *
     * @param phone the value for org.phone
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.email
     *
     * @return the value of org.email
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.email
     *
     * @param email the value for org.email
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.status
     *
     * @return the value of org.status
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.status
     *
     * @param status the value for org.status
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.comment
     *
     * @return the value of org.comment
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.comment
     *
     * @param comment the value for org.comment
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.add_time
     *
     * @return the value of org.add_time
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public Date getAdd_time() {
        return add_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.add_time
     *
     * @param add_time the value for org.add_time
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org.update_time
     *
     * @return the value of org.update_time
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org.update_time
     *
     * @param update_time the value for org.update_time
     *
     * @mbggenerated Fri Jun 24 22:56:37 CST 2016
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}