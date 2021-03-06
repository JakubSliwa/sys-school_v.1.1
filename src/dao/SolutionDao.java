package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.DbUtil;
import model.Exercise;
import model.Solution;
import model.User;

public class SolutionDao {

	public static boolean saveToDB(Solution solution) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "INSERT INTO solutions(description,exercise_id, users_id) VALUES (?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, solution.getDescription());
			preparedStatement.setInt(2, solution.getExercise().getId());
			preparedStatement.setInt(3, solution.getUserId());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateAllSolutionParameters(int id, String description, int exerciseId, int userId) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE solutions SET description=?, exercise_id=?, users_id=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, description);
			preparedStatement.setInt(2, exerciseId);
			preparedStatement.setInt(3, userId);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateSolutionDescription(int id, String description) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE solutions SET description=? where id = ?";
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

	public static boolean updateSolutionUserId(int id, int userId) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE solutions SET users_id=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateSolutionExerciseId(int id, int exerciseId) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE solutions SET exercise_id=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, exerciseId);
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
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE	FROM solutions WHERE	id=	?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Solution> loadAll() {
		List<Solution> result = new ArrayList<>();
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM solutions");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(new Solution(rs.getInt("id"), rs.getDate("created"), rs.getDate("updated"),
						rs.getString("description"), rs.getInt("exercise_id"), rs.getInt("users_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<Solution> loadAll(Integer limit) {
		List<Solution> result = new ArrayList<>();
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement stmt = conn
					.prepareStatement("select id, created, updated, description, exercise_id, users_id "
							+ "from solutions order by created desc limit ?");
			stmt.setInt(1, limit);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(new Solution(rs.getInt("id"), rs.getDate("created"), rs.getDate("updated"),
						rs.getString("description"), rs.getInt("exercise_id"), rs.getInt("users_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<Solution> loadSolutionByUserId(int userId) {
		List<Solution> user_solutions = null;
		try (Connection conn = DbUtil.getConn()) {

			String sql = "SELECT * FROM solutions JOIN users ON solutions.users_id=users.id where	users.id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			user_solutions = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Date created = rs.getTimestamp("created");
				Date updated = rs.getTimestamp("updated");
				String description = rs.getString("description");
				int id = rs.getInt("users_id");
				int exercise_id = rs.getInt("exercise_id");
				User user = UsersDao.loadById(userId);
				Exercise exercise = ExerciseDao.loadById(exercise_id);

				user_solutions
						.add(new Solution(id, created, updated, description, exercise_id, userId, user, exercise));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user_solutions;
	}

	public static Solution loadById(int solutionId) {
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement stmt = conn.prepareStatement(
					"select id, created, updated, description, exercise_id, users_id from solutions where id =?");
			stmt.setInt(1, solutionId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return new Solution(rs.getInt("id"), rs.getDate("created"), rs.getDate("updated"),
						rs.getString("description"), rs.getInt("exercise_id"), rs.getInt("users_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}