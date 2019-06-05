package com.org.franklin.request.model;
public class FilterCriteria {
	private String startDateTime;
	private String endDateTime;
	private String tableName;
	private String fileName;
	private String failoverRequest;
	private String pageSize;
	private String pageNumber;

	/*******************************************************************************
	 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
	 * 
	 *  Contributors:
	 *      Samrat Basu.
	 *      May 27, 2019
	 ******************************************************************************/
	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFailoverRequest() {
		return failoverRequest;
	}

	public void setFailoverRequest(String failoverRequest) {
		this.failoverRequest = failoverRequest;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

}