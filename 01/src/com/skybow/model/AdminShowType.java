package com.skybow.model;

/**
 * ��̨����չʾModel
 * @author le
 * 2015��6��18�� ����12:38:46
 * 
 */
public class AdminShowType {
	private String stateType;//���״̬:0δ���,1���
	private String payforType;//����״̬:0δ����,1���� 
	private int infoType;//��Ϣ����

	public String getPayforType() {
		return payforType;
	}
	public void setPayforType(String payforType) {
		this.payforType = payforType;
	}
	public String getStateType() {
		return stateType;
	}
	public void setStateType(String stateType) {
		this.stateType = stateType;
	}
	public int getInfoType() {
		return infoType;
	}
	public void setInfoType(int infoType) {
		this.infoType = infoType;
	}	
}
