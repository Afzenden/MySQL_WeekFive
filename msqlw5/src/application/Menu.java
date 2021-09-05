package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.AgentDao;
import entity.Agent;

public class Menu {

	private AgentDao agentDao = new AgentDao();
	private List<String> options = Arrays.asList("Show Agents", "Add Agent", "Update Agent", "Delete Agent", "Exit");
	private Scanner scan = new Scanner(System.in);

	public void start() throws SQLException {

		String s = "";

		do {
			printMenu();
			s = scan.nextLine();

			if (s.equals("1")) {
				showAgents();
			} else if (s.equals("2")) {
				addAgent();
			} else if (s.equals("3")) {
				updateAgent();
			} else if (s.equals("4")) {
				deleteAgent();
			} else if (s.equals("5")) {
				// Quit();
			}

			if (s.equals("5")) {
				System.out.println("End");
				s = "5";
			} else {
				System.out.println("\nPress Enter To Continue . . .");
				scan.nextLine();
			}

		} while (!s.equals("5"));

	}

	private void showAgents() throws SQLException {
		List<Agent> agents = agentDao.showAgents();
		for (Agent agent : agents) {
			System.out.println(agent.getAgentID() + " ] " + agent.getName() + " " + agent.getEmail());
		}
	}

	private void addAgent() throws SQLException {
		System.out.print("Enter Agent Name:");
		String name = scan.nextLine();
		System.out.print("Enter Agent Email:");
		String email = scan.nextLine();
		int agentID = agentDao.getLastID();
		agentDao.addAgent(agentID, name, email);
	}

	private void updateAgent() throws SQLException {
		System.out.print("Enter Agent ID:");
		int agentID = Integer.parseInt(scan.nextLine());
		System.out.print("Edit Agent Name:");
		String name = scan.nextLine();
		System.out.print("Enter Agent Email:");
		String email = scan.nextLine();
		agentDao.updateAgent(name, email, agentID);
	}

	private void deleteAgent() throws SQLException {
		System.out.print("Enter Agent ID:");
		int agentID = Integer.parseInt(scan.nextLine());
		agentDao.deleteAgent(agentID);

	}

	private void printMenu() {
		System.out.println("Select An Option:");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + " ] " + options.get(i));
		}
	}

}
