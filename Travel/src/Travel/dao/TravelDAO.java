package Travel.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Travel.vo.TravelVO;

public class TravelDAO extends DAO {

	public List<TravelVO> selectList() {
		String sql = "select * from tbl_travel order by no";
		List<TravelVO> list = new ArrayList<>();

		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TravelVO svo = new TravelVO();
				svo.setCustNo(rs.getString("no"));
				svo.setCustName(rs.getString("name"));
				svo.setCustSex(rs.getString("sex"));
				svo.setCustPhone(rs.getString("phone"));
				svo.setCustMoney(rs.getString("money"));
				svo.setCreationDate(rs.getDate("creation_date"));

				list.add(svo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}// end of selectList

	public List<TravelVO> viewList(String view) {
		String sql = "select * from tbl_cinfo ";
		sql += "         where name =  ? ";
		List<TravelVO> list = new ArrayList<>();

		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, view);
			rs = psmt.executeQuery();
			while (rs.next()) {
				TravelVO svo = new TravelVO();
				svo.setcName(rs.getString("name"));
				svo.setcCurrency(rs.getString("currency"));
				svo.setcMonth(rs.getString("month"));
				svo.setcVisa(rs.getString("visa"));
				svo.setcContents(rs.getString("contents"));

				list.add(svo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}// end of selectList

	public int loginCheck(String id, String pwd) {
		String sql = "SELECT count(1) from tbl_user";
		sql += "      where id = ?  ";
		sql += "        and pwd = ? ";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	} // end of selectExit

	public int viewCheck(String view) {
		String sql = "SELECT count(1) from tbl_cinfo";
		sql += "      where name = ?  ";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, view);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	} // end of selectExit
	
	// 선택기능.
	public int selectExit(String cust) {
		String sql = "SELECT count(1) from tbl_travel";
		sql += "      where no = ?";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "T-" + cust);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	} // end of selectExit

	// 삭제기능
	public int removeCust(String cNo) {
		conn = getConn();
		String sql = "DELETE tbl_travel";
		sql += " where no = '" + cNo + "'";

		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수를 반환해주는 메소드
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}// end of removeCust

	// 등록기능.
	public boolean insertCust(TravelVO cust) {
		String sql = "insert into tbl_travel (no, name, sex, phone, money) ";
		sql += "values(?, ?, ?, ?, ?) ";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "T-" + cust.getCustNo());
			psmt.setString(2, cust.getCustName());
			psmt.setString(3, cust.getCustSex());
			psmt.setString(4, cust.getCustPhone());
			psmt.setString(5, cust.getCustMoney());

			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r == 1) {
				return true; // 정상처리.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리.
	}// end of insertCust

	// 수정 기능.
	public boolean updateCust(TravelVO no) {
		String sql = "UPDATE tbl_travel";
		sql += "   set    name = ?";
		sql += "          ,sex = ?";
		sql += "          ,phone = ?";
		sql += "   where  no = ?";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no.getCustName());
			psmt.setString(2, no.getCustSex());
			psmt.setString(3, no.getCustPhone());
			psmt.setString(4, "T-" + no.getCustNo());

			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r == 1) {
				return true; // 정상처리.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리.
	}// end of updateCust

}// end of class
