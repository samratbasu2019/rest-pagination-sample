package com.org.franklin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.franklin.model.HiveTable;

@Repository
public class JdbcDAO {
	@Autowired  
    private JdbcTemplate jdbc;
	private static final String SQL = "select * from test";
	public List<Map<String, Object>> fetchData(){	
		return jdbc.queryForList(SQL);
	}
}
