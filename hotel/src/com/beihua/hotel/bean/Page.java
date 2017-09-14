package com.beihua.hotel.bean;

public class Page {
	//当前页面，起始值设置为1
	private int  nowPage = 1;
	//每次查询的开始位置
	private int position;
	//每页显示记录数,自定义为10
	private int size = 8;
	//每一个表的总记录数
	private int total;
	
	private String dTime;
	
	//总页数
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


	//计算每次起始位置
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


	//上一页
	public void pageUp(int n){
		
		/*nowPage = n <=1 ? 1 : n - 1;
		page.setNowPage(nowPage);*/
		System.out.println("上一页"+n);
		n = n <=1 ? 1 : n - 1;
		setNowPage(n);
		
		
	}
	//下一页
	public void pageDown(int n){
		n = n + 1;
		
		setNowPage(n);
		System.out.println("下一页----------"+getNowPage());
	}
	//总页数
	public void pageAll(int n){
		totalPage=total%size+1;
		setTotalPage(totalPage);
	}
}
