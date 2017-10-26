package com.example.demo.model;
import java.sql.Date;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
@Entity
@Table(name = "emp")
@SqlResultSetMapping(name="updateResult", columns = { @ColumnResult(name = "count")})
@NamedNativeQueries({
    @NamedNativeQuery(
            name    =   "updateEmp",
            query   =   "UPDATE emp SET fromdate = ?, todate = ? WHERE name = ?"
            ,resultSetMapping = "updateResult"
    )
})
public class emp {

	@Id
	String name;
	String pwd;
	Date fromdate;
	Date todate;
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	
	
	
}
