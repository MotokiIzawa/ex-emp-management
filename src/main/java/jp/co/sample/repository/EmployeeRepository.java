package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

/**
 * administratorsテーブルを操作するリポジトリ.
 * 
 * @author izawamotoki
 *
 */
@Repository
public class EmployeeRepository {

	private final static RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getDate("hire_date"));
		employee.setMailAddress(rs.getString("mail_address"));
		employee.setZipCode(rs.getString("zip_code"));
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentdCount(rs.getInt("department_count"));
		return employee;

	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 全件検索を行う.
	 * 
	 * @return 全従業員一覧
	 */
	public List<Employee> findAll() {
		String findAllSql = "SELECT id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,department_count FROM employees ORDER BY hire_date DESC;";
		List<Employee> employeeList = template.query(findAllSql, EMPLOYEE_ROW_MAPPER);
		return employeeList;
	}

	/**
	 * 主キーから従業員情報を取得する.
	 * 
	 * @param id ID
	 * @return 取得された従業員情報
	 */
	public Employee load(Integer id) {
		String sql = "SELECT id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,department_count FROM employees WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		return employee;
	}

	/**
	 * 従業員情報を更新する
	 * 
	 * @param employee 更新したい従業員情報
	 */
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		String updateSql = "UPDATE employees SET name=:name,image=:image,gender=:gender"
				+ ",hire_date=:hireDate,mail_address=:mailAddress,zip_code=:zipCode"
				+ ",address=:address,telephone=:telephone,salary=:saraly"
				+ ",characteristics=:characteristics,dependentdCount=:dependentdCount WHERE id=:id;";
		template.update(updateSql, param);
	}

}
