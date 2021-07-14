package com.itwillbs.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// DB연결
	SimpleJdbcTemplate template;
	public void setDataSource(DataSource dataSource) {
		template = new SimpleJdbcTemplate(dataSource);
	}
	
	String insertMember = "insert into member(id,pass,name,date) values(?,?,?,?)";
	@Override
	public void insertMember(MemberBean mb) {
		System.out.println("MemberDAOImpl - insertMember()");
		
		// DB작업
		template.update(insertMember, mb.getId(), mb.getPass(), mb.getName(), mb.getDate()); // sql구문
	
	}
	
	String userCheck = "select * from member where id=? and pass=?";
	@Override
	public MemberBean userCheck(MemberBean mb) {
		System.out.println("MemberDAOImpl - userCheck()");
		// DB작업
//		MemberBean mb2 = new MemberBean();
//		mb2.setId(rs.getString("id"));
//		mb2.setPass(rs.getString("pass"));
//		mb2.setName(rs.getString("name"));
//		mb2.setDate(rs.getTimestamp("date"));
		
		RowMapper<MemberBean> mapper = new BeanPropertyRowMapper<MemberBean>(MemberBean.class);
		
		return template.queryForObject(userCheck, mapper, mb.getId(), mb.getPass());
	}
	
	String getMember = "select * from member where id=?";
	@Override
	public MemberBean getMember(String id) {
		System.out.println("MemberDAOImpl - getMember()");
		
		RowMapper<MemberBean> mapper = new BeanPropertyRowMapper<MemberBean>(MemberBean.class);

		return template.queryForObject(getMember, mapper, id);
	}
	
	String updateMember = "update member set name=? where id=?";
	@Override
	public void updateMember(MemberBean mb) {
		template.update(updateMember, mb.getName(), mb.getId());
	}

	String deleteMember = "delete from member where id=?";
	@Override
	public void deleteMember(MemberBean mb) {
		template.update(deleteMember, mb.getId());
	}

}
