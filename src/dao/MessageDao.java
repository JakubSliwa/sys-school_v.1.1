package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.DbUtil;
import model.Message;

public class MessageDao {

	public static boolean saveToDb(Message message) {

		try (Connection conn = DbUtil.getConn()) {

			String sql = "insert into message(users_id, message,  addedBy) values(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, message.getTargetUserId());
			ps.setString(2, message.getText());
			ps.setString(3, message.getAddedBy());
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			return false;
		}
	}
	
	
	

	public static List<Message> loadById(int id) {
		List<Message> messages = new ArrayList<>();

		try (Connection conn = DbUtil.getConn()) {

			String sql = "select * from message where users_id=? order by date desc;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer message_id = rs.getInt("id");
				Integer targetUserId = rs.getInt("users_id");
				Timestamp date = rs.getTimestamp("date");
				String addedBy = rs.getString("addedBy");
				String text = rs.getString("message");
				boolean isReaded = rs.getBoolean("isReaded");
			
				messages.add(new Message(date, message_id, targetUserId, addedBy, text,isReaded));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return messages;
	}
	
	public static List<Message> loadBySender(int senderName) {
		List<Message> messages = new ArrayList<>();

		try (Connection conn = DbUtil.getConn()) {

			String sql = "select * from message where addedBy=? order by date desc;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, senderName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer message_id = rs.getInt("id");
				Integer targetUserId = rs.getInt("users_id");
				Timestamp date = rs.getTimestamp("date");
				String addedBy = rs.getString("addedBy");
				String text = rs.getString("message");
				boolean isReaded = rs.getBoolean("isReaded");
				
				messages.add(new Message(date, message_id, targetUserId, addedBy, text,isReaded));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return messages;
	}

	public static boolean delete(int id) {

		try (Connection conn = DbUtil.getConn()) {

			String sql = "delete from message where id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			return false;
		}
	}
}