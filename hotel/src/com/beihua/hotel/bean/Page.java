package com.beihua.hotel.bean;

public class Page {
	//��ǰҳ�棬��ʼֵ����Ϊ1
	private int  nowPage = 1;
	//ÿ�β�ѯ�Ŀ�ʼλ��
	private int position;
	//ÿҳ��ʾ��¼��,�Զ���Ϊ10
	private int size = 8;
	//ÿһ������ܼ�¼��
	private int total;
	
	private String dTime;
	
	//��ҳ��
	private int totalPage;
	private String startDate;
	private String endDate;
	
	/*
	 * totalPage = total%size== 0 ? total/size:(total/size+1)
	 * */
	
	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	//����ÿ����ʼλ��
	public void calculatePosition(){
		 
			setPosition((getNowPage()-1) * getSize());
		  
	}


	
	public int getNowPage() {
		return nowPage;
	}


	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
    

	

	public String getdTime() {
		return dTime;
	}


	public void setdTime(String dTime) {
		this.dTime = dTime;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	//��һҳ
	public void pageUp(int n){
		
		/*nowPage = n <=1 ? 1 : n - 1;
		page.setNowPage(nowPage);*/
		System.out.println("��һҳ"+n);
		n = n <=1 ? 1 : n - 1;
		setNowPage(n);
		
		
	}
	//��һҳ
	public void pageDown(int n){
		n = n + 1;
		
		setNowPage(n);
		System.out.println("��һҳ----------"+getNowPage());
	}
	//��ҳ��
	public void pageAll(int n){
		totalPage=total%size+1;
		setTotalPage(totalPage);
	}
}
