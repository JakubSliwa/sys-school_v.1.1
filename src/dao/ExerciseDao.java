package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbUtil;
import model.Exercise;

public class ExerciseDao {

	public static List<Exercise> loadAll() {
		List<Exercise> allExercises = null;

		try (Connection conn = DbUtil.getConn()) {
			String sql = "SELECT * FROM exercise";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			allExercises = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("tittle");
				String description = rs.getString("description");

				allExercises.add(new Exercise(id, title, description));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allExercises;
	}

	public static Exercise loadById(int id) {
		Exercise exercise = null;
		try (Connection conn = DbUtil.getConn()) {

			String sql = "SELECT * FROM exercise WHERE id=?;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String tittle = rs.getString("tittle");
				String description = rs.getString("description");
				exercise = new Exercise(id, tittle, description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exercise;
	}

	public static boolean saveToDB(Exercise exercise) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "INSERT INTO exercise(tittle,description) VALUES (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, exercise.getTitle());
			preparedStatement.setString(2, exercise.getDescription());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateAllExerciseParameters(int id, String title, String description) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE exercise SET	tittle=?, description=? where id	= ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, description);

			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateTitle(int id, String title) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE exercise SET	tittle=? where id	= ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, title);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateDescription(int id, String description) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE exercise SET	description=? where id	= ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, description);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void delete(int id) {
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE	FROM exercise WHERE	id=	?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
