package com.org.franklin.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.org.franklin.dao.HiveDAO;
import com.org.franklin.dao.JdbcDAO;
import com.org.franklin.entity.HiveTable;
import com.org.franklin.request.model.FilterCriteria;;
/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      May 27, 2019
 ******************************************************************************/
@Service
public class HiveService {
	private final static Logger log = Logger.getLogger(HiveService.class);
	@Autowired
	private HiveDAO hiveDao;
	@Autowired
	private JdbcDAO jdbcDao;

	public Page<HiveTable> findJsonDataByCondition(FilterCriteria filter,int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		String quote = filter.getTableName().toString().trim();
		log.debug("hive DAO :"+ hiveDao + " Quote :"+quote);
		Page<HiveTable> data = hiveDao.findQuote(quote,pageable);
		//Page<HiveTable> data = hiveDao.findAll(pageable);
		log.debug("Number of records are :"+ data.getNumberOfElements());
		return data;
	}
	
	public List<Map<String, Object>> findXMLDataByCondition() {		
		List<Map<String, Object>> data = jdbcDao.fetchData();
		return data;
	}
}