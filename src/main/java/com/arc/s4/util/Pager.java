package com.arc.s4.util;

public class Pager {

	private Integer curPage; //현재 페이지 번호. client에게서 받아와야 함(parameter)
	private Integer perPage; //불러올 페이지 개수. client에게서 받아와야 함(parameter)
	// 두 개의 값이 안넘어올 경우가 있음
	private String kind;
	private String search;
	
	//DB
	private Integer startRow; //시작 rownum
	private Integer lastRow; //마지막 rownum
	
	//View(jsp)
	private Integer startNum; //시작 번호
	private Integer lastNum; //마지막 번호
	private Integer curBlock; //현재 블럭 번호
	private Integer totalBlock; //전체 블럭 개수
	//외부로 나갈 것들만 멤버변수로 선언. 그 외는 필요할 때 지역변수로 선언
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}
	public void setSearch(String search) {
		//search = "%"+search+"%";
		this.search = search;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}
	public Integer getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getCurPage() {
		if(curPage == null || curPage == 0) {
			curPage = 1;
		}
		return curPage;
	}
	public Integer getPerPage() {
		if(perPage == null || perPage == 0) {
			perPage = 10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getLastRow() {
		return lastRow;
	}
	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}
	
	//makeRow
	public void makeRow() { //getter를 호출해야 그 안에 있는 if문이 실행되니까!! null이 들어오면 안돼ㅜㅠ
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	//makePage
	public void makePage(int totalCount) {
		//1. 전체 글의 개수를 DB에서 매개변수로 받아옴
		//2. totalPage
		int totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}

		//3. totalBlock
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}

		//4. curPage로 curBlock 구하기
		curBlock = this.getCurPage()/perBlock;
		if(this.getCurPage()%perBlock !=0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum
		startNum = (curBlock-1)*perBlock +1;
		lastNum = curBlock*perBlock;
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
	}
}
