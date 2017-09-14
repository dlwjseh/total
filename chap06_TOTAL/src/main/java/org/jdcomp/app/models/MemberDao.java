package org.jdcomp.app.models;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	SqlSessionTemplate sql;
	
	public int checkId(Map map) {
		return sql.selectOne("member.checkId", map);
	}
	public int checkEmail(Map map) {
		return sql.selectOne("member.checkEmail", map);
	}
	public boolean Join(Map map) {
		sql.insert("member.addMember", map);
		sql.insert("member.addDetail", map);
		return true;
	}
	public int checklogin(Map map) {
		return sql.selectOne("member.checkLogin", map);
	}
	public Map getInfo(Map map) {
		return sql.selectOne("member.getInfo", map);
	}
	
}
