package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	private List<User> users;
	
	public UserService(String filename) {
		users = new ArrayList<>();
		readUserDataFromfile(filename);
	}
	
	private void readUserDataFromfile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(",");
				String username = userInfo[0].trim();
				String password = userInfo[1].trim();
				String name = userInfo[2].trim();
				
				users.add(new User(username, password, name));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public User validateCredentials(String enteredUsername, String enteredPassword) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(enteredUsername) &&
				user.getPassword().equals(enteredPassword)) {
					return user;
				}
		}
		return null;
	}

}
