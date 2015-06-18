package com.skybow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ����������
 * @author le
 * getCon()��ȡ���ݿ�����,closed()�ر����ݿ�����,doPstm()��ɾ�Ĳ����
 */
public class DB {
	private Connection con;
	private PreparedStatement pstm;
	//----���ݿ����Ӳ�������----
	/**
	 * �û���
	 */
	private String user="root";
	/**
	 * �û�����
	 */
	private String password="3171204";
	/**
	 *��������
	 *	mysql 		com.mysql.jdbc.Driver
	 *	sqlserver 	com.microsoft.sqlserver.jdbc.SQLServerDriver
	 *	oracle		oracle.jdbc.driver.OracleDriver
	 */
	private String className="com.mysql.jdbc.Driver";
	/**
	 * ���ݿ�URL
	 * mysql		jdbc:mysql://127.0.0.1:3306/db_wymedia?useUnicode=true&characterEncoding=UTF-8
	 * sqlserver	jdbc:sqlserver://localhost:1433;DatabaseName=db_wymedia
	 * oracle 		jdbc:oracle:thin:@localhost:1521:orcl
	 */
	private String url="jdbc:mysql://127.0.0.1:3306/db_wymedia?useUnicode=true&characterEncoding=UTF-8";
	
	/**
	 * ������
	 * 	����س�ʼ��
	 */
	public DB(){
		try{
			Class.forName(className);
		}catch(ClassNotFoundException e){
			System.out.println("�������ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	
	/**
	 * �������ݿ�����
	 * 	��ȡ��������
	 * @return Connection
	 */
	public Connection getCon(){
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("�������ݿ�����ʧ�ܣ�");
			con=null;
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * ִ��������ɾ�Ĳ����
	 * @param sql
	 * @param params
	 */
	public void doPstm(String sql,Object[] params){
		if(sql!=null&&!sql.equals("")){
			if(params==null)
				params=new Object[0];
			
			getCon();
			if(con!=null){
				try{		
					System.out.print("---->sql--"+sql);
					pstm=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					for(int i=0;i<params.length;i++){
						System.out.print("--"+params[i]+",");
						pstm.setObject(i+1,params[i]);
					}
					System.out.println();
					pstm.execute();
				}catch(SQLException e){
					System.out.println("doPstm()��������");
					e.printStackTrace();
				}				
			}			
		}
	}
	
	/**
	 * ��ȡ�����
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getRs() throws SQLException{
		return pstm.getResultSet();		
	}
	/**
	 * Retrieves the current result as an update count; 
	 * if the result is a ResultSet object or there are no more results, -1 is returned. This method should be called only once per result.
	 * @return
	 * @throws SQLException
	 */
	public int getCount() throws SQLException{
		return pstm.getUpdateCount();		
	}
	/**
	 * �ر�����
	 */
	public void closed(){
		try{
			if(pstm!=null)
				pstm.close();			
		}catch(SQLException e){
			System.out.println("�ر�pstm����ʧ�ܣ�");
			e.printStackTrace();
		}
		try{
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			System.out.println("�ر�con����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}
