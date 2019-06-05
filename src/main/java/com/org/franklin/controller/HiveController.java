package com.org.franklin.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.org.franklin.entity.HiveTable;
import com.org.franklin.exception.PaginationErrorResponse;
import com.org.franklin.exception.PaginationException;
import com.org.franklin.request.model.FilterCriteria;
import com.org.franklin.service.HiveService;
/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      May 27, 2019
 ******************************************************************************/

@RestController
@RequestMapping(value = "/hive")
public class HiveController {
	private final static Logger log = Logger.getLogger(HiveController.class);

	@Autowired
	private HiveService hiveService;

	@RequestMapping(value = "/rest/getDataSet",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	//@RequestMapping(value = "/rest/getDataSet",method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	public Page<HiveTable> findHiveDataSet(@RequestBody final FilterCriteria filters) {
		log.debug("Request Body is : "+ filters.getPageNumber() +" Size :"+filters.getPageSize());
		
		long starttime = System.currentTimeMillis();
		Page<HiveTable> list = hiveService.findJsonDataByCondition(filters,Integer.parseInt(filters.getPageNumber()), Integer.parseInt(filters.getPageSize()));
		long endtime = System.currentTimeMillis();
		log.debug("Total processing time "+ (endtime -starttime)+ " ms.");
		
		return list;
	}
	
	@RequestMapping(value = "/rest/getDataSetXML",method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	//@RequestMapping(value = "/rest/getDataSet",method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	public List<Map<String, Object>> findHiveDataSetXML(@RequestBody final FilterCriteria filters) {
		log.debug("Request Body is : "+ filters.getPageNumber() +" Size :"+filters.getPageSize());
		return hiveService.findXMLDataByCondition();
	}

	@ExceptionHandler(PaginationException.class)
	public ResponseEntity<PaginationErrorResponse> exceptionHandler(Exception ex) {
		PaginationErrorResponse paginationErrorResponse = new PaginationErrorResponse();
		paginationErrorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		paginationErrorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<PaginationErrorResponse>(paginationErrorResponse, HttpStatus.OK);
	}
}