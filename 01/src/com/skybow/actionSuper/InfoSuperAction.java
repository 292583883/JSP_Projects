package com.skybow.actionSuper;

import com.skybow.model.InfoSingle;
import com.skybow.model.SearchInfo;

/**
 * ��Ϣ�������
 * @author le
 * 2015��6��18�� ����12:37:06
 * 
 */
public class InfoSuperAction extends MySuperAction {
	protected InfoSingle infoSingle;//����������Ϣ
	protected SearchInfo searchInfo;//�����Ľ����Ϣ

	public InfoSingle getInfoSingle() {
		return infoSingle;
	}

	public void setInfoSingle(InfoSingle infoSingle) {
		this.infoSingle = infoSingle;
	}

	public SearchInfo getSearchInfo() {
		return searchInfo;
	}

	public void setSearchInfo(SearchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}
}
