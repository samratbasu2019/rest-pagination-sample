package com.org.franklin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.franklin.entity.HiveTable;
/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      May 27, 2019
 ******************************************************************************/

@Repository
public interface HiveDAO extends PagingAndSortingRepository<HiveTable, Integer> {
	
	Page<HiveTable> findQuote(@Param("quote") String quote,Pageable pageable);
	
	Page<HiveTable> findAll(Pageable pageable);
}