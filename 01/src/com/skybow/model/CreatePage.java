package com.skybow.model;

/**
 * ��ҳ���Model��
 * @author le
 * 2015��6��18�� ����12:23:15
 * 
 */
public class CreatePage {
	private int CurrentP; // ��ǰҳ��
	private int AllP; // ��ҳ��
	private int AllR; // �ܼ�¼��
	private int PerR; // ÿҳ��ʾ��¼��
	private String PageLink; // ��ҳ��������Ϣ
	private String PageInfo; // ��ҳ״̬��ʾ��Ϣ

	public CreatePage() {
		CurrentP = 1;
		AllP = 1;
		AllR = 0;
		PerR = 3;
		PageLink = "";
		PageInfo = "";
	}
	/**
	 * ����ÿҳ��ʾ��¼��
	 * @param PerR
	 */
	public void setPerR(int PerR) {
		this.PerR = PerR;
	}
	/**
	 * �����ܼ�¼��
	 * @param AllR
	 */
	public void setAllR(int AllR) {
		this.AllR = AllR;
	}
	/**
	 * ������ҳ�� 
	 */
	public void setAllP() {
		AllP = (AllR % PerR == 0) ? (AllR / PerR) : (AllR / PerR + 1);
	}
	/**
	 * ���õ�ǰҳ��
	 * @param currentP
	 */
	public void setCurrentP(String currentP) {
		if (currentP == null || currentP.equals(""))
			currentP = "1";
		try {
			CurrentP = Integer.parseInt(currentP);
		} catch (NumberFormatException e) {
			CurrentP = 1;
			e.printStackTrace();
		}
		if (CurrentP < 1)
			CurrentP = 1;
		if (CurrentP > AllP)
			CurrentP = AllP;
	}
	/**
	 * ���÷�ҳ״̬��ʾ��Ϣ
	 */
	public void setPageInfo() {
		if (AllP > 1) {
			PageInfo = "<table border='0' cellpadding='3'><tr><td>";
			PageInfo += "ÿҳ��ʾ��" + PerR + "/" + AllR + " ����¼��";
			PageInfo += "��ǰҳ��" + CurrentP + "/" + AllP + " ҳ��";
			PageInfo += "</td></tr></table>";
		}
	}
	/**
	 * ���÷�ҳ��������Ϣ
	 * @param gowhich
	 */
	public void setPageLink(String gowhich) {
		if (gowhich == null)
			gowhich = "";
		if (gowhich.indexOf("?") >= 0)
			gowhich += "&";
		else
			gowhich += "?";
		if (AllP > 1) {
			PageLink = "<table border='0' cellpadding='3'><tr><td>";
			if (CurrentP > 1) {
				PageLink += "<a href='" + gowhich + "showpage=1'>��ҳ</a>&nbsp;";
				PageLink += "<a href='" + gowhich + "showpage="
						+ (CurrentP - 1) + "'>��һҳ</a>&nbsp;";
			}
			if (CurrentP < AllP) {
				PageLink += "<a href='" + gowhich + "showpage="
						+ (CurrentP + 1) + "'>��һҳ</a>&nbsp;";
				PageLink += "<a href='" + gowhich + "showpage=" + AllP
						+ "'>βҳ</a>";
			}
			PageLink += "</td></tr></table>";
		}
	}
	/**
	 * ����ÿҳ��¼��
	 * @return
	 */
	public int getPerR() {
		return PerR;
	}
	/**
	 * �����ܼ�¼��
	 * @return
	 */
	public int getAllR() {
		return AllR;
	}
	/**
	 * ������ҳ��
	 * @return
	 */
	public int getAllP() {
		return AllP;
	}
	/**
	 * ���ص�ǰҳ��
	 * @return
	 */
	public int getCurrentP() {
		return CurrentP;
	}
	/**
	 * ���ط�ҳ״̬��ʾ��Ϣ 
	 * @return
	 */
	public String getPageInfo() {
		return PageInfo;
	}
	/**���ط�ҳ��������Ϣ
	 * @return
	 */
	public String getPageLink() {
		return PageLink;
	}
}
