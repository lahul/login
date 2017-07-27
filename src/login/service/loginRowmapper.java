package login.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import login.memberdetails.Member;

public class loginRowmapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int arg1) throws SQLException {
		Member mem=new Member();
		mem.setEmail(rs.getString("email"));
		mem.setPassword(rs.getString("password"));
		mem.setUsername(rs.getString("username"));
		mem.setDob(rs.getString("dob"));
		mem.setGender(rs.getString("gender"));
		mem.setQualification(rs.getString("qualification"));
		return mem;
	}
	

}
