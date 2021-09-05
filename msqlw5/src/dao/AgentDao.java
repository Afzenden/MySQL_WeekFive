package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Agent;

public class AgentDao {

	private Connection MyConn;
	private final String SHOW_AGENTS_QUERY = "select * from agents";
	private final String CREATE_AGENT_QUERY = "insert into agents(agentID, name, email) values(?,?,?)";
	private final String GET_MAX_ID_QUERY = "select max(agentID) as lastID from agents";
	private final String UPDATE_AGENT_QUERY = "update agents set name = ?, email = ? where agentID = ?";
	private final String DELETE_AGENT_QUERY = "delete from agents where agentID = ?";

	public AgentDao() {
		MyConn = DBConnection.getConnection();
	}

	public List<Agent> showAgents() throws SQLException {
		ResultSet rs = MyConn.prepareStatement(SHOW_AGENTS_QUERY).executeQuery();
		List<Agent> agents = new ArrayList<Agent>();

		while (rs.next()) {
			agents.add(new Agent(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return agents;
	}

	public void addAgent(int agentID, String name, String email) throws SQLException {
		PreparedStatement ps = MyConn.prepareStatement(CREATE_AGENT_QUERY);
		ps.setInt(1, agentID);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.executeUpdate();
	}

	public Integer getLastID() throws SQLException {
		ResultSet rs = MyConn.prepareStatement(GET_MAX_ID_QUERY).executeQuery();
		rs.next();
		int nextID = rs.getInt(1) + 1;
		return nextID;
	}

	public void updateAgent(String name, String email, int agentId) throws SQLException {
		PreparedStatement ps = MyConn.prepareStatement(UPDATE_AGENT_QUERY);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, agentId);
		ps.executeUpdate();
	}

	public void deleteAgent(int agentId) throws SQLException {
		PreparedStatement ps = MyConn.prepareStatement(DELETE_AGENT_QUERY);
		ps.setInt(1, agentId);
		ps.executeUpdate();
	}

}
