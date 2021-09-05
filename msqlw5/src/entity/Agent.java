package entity;

public class Agent {
	private int agentID;
	private String name;
	private String email;
	
	
	public Agent(int agentID, String name, String email) {
		this.setAgentId(agentID);
		this.setName(name);
		this.setEmail(email);
	}

	public int getAgentID() {
		return agentID;
	}
	
	public void setAgentId(int agentID) {
		this.agentID = agentID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
