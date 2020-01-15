package com.collection.dao;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.collection.model.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

@Repository
public class SimpleDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void initService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    public void addList(String name) {
        String sql = "INSERT INTO lists VALUES (NULL,'" + name + "')";
        jdbcTemplate.update(sql);
    }
    
    public void addItem(String name, int listId) {
        String sql = "INSERT INTO items VALUES (NULL,'" + name + "'," + listId + ",0,NULL)";
        jdbcTemplate.update(sql);
    }

    public List<SimpleList> getAllLists() {
        String sql = "SELECT * FROM lists";
        List<SimpleList> simpleLists = jdbcTemplate.query(sql, new BeanPropertyRowMapper(SimpleList.class));
        return simpleLists;
    }
    public List<SimpleItem> getListItems(int listId) {
        String sql = "SELECT * FROM items WHERE listid = " + listId;
        List<SimpleItem> listItems = jdbcTemplate.query(sql, new BeanPropertyRowMapper(SimpleItem.class));
        return listItems;
    }
    
    public SimpleList getListById(int listId) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM lists WHERE listid = " + listId;
        return (SimpleList) jdbcTemplate.query(sql, new BeanPropertyRowMapper(SimpleList.class)).get(0);
    }
    
    public SimpleItem getItemById(int itemId) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM items WHERE itemid = " + itemId;
        return (SimpleItem) jdbcTemplate.query(sql, new BeanPropertyRowMapper(SimpleItem.class)).get(0);
    }
    
}
