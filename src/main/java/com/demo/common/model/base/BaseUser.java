package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setUserName(java.lang.String userName) {
		set("userName", userName);
		return (M)this;
	}
	
	public java.lang.String getUserName() {
		return getStr("userName");
	}

	public M setPhoneNumber(java.lang.Integer phoneNumber) {
		set("phoneNumber", phoneNumber);
		return (M)this;
	}
	
	public java.lang.Integer getPhoneNumber() {
		return getInt("phoneNumber");
	}

	public M setPassword(java.lang.Integer password) {
		set("password", password);
		return (M)this;
	}
	
	public java.lang.Integer getPassword() {
		return getInt("password");
	}

	public M setWeixinId(java.lang.String weixinId) {
		set("weixinId", weixinId);
		return (M)this;
	}
	
	public java.lang.String getWeixinId() {
		return getStr("weixinId");
	}

	public M setEmail(java.lang.String email) {
		set("email", email);
		return (M)this;
	}
	
	public java.lang.String getEmail() {
		return getStr("email");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
		return (M)this;
	}
	
	public java.util.Date getCreateTime() {
		return get("createTime");
	}

	public M setInvitationCode(java.lang.String invitationCode) {
		set("invitationCode", invitationCode);
		return (M)this;
	}
	
	public java.lang.String getInvitationCode() {
		return getStr("invitationCode");
	}

}
