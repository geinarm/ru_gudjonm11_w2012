package models.book.service;

import java.util.List;
import models.book.data.UserDTO;

public class UserServiceStub implements UserService 
{
	private List<UserDTO> users;
	
	public UserServiceStub()
	{
		users.add(new UserDTO(1, "Boris Badenov", "boris", "boris@pottsylvania.gov"));
		users.add(new UserDTO(2, "Natasha Fatale", "natasha", "natasha@pottsylvania.gov"));
		users.add(new UserDTO(3, "Rocky J", "rocky", "rocky@internationalfalls.gov"));
		users.add(new UserDTO(4, "Bullwinkle J. Moose", "bullwinkle", "bullwinkle@internationalfalls.gov"));
	}

	public List<UserDTO> getUsers() 
	{
		return users;
	}

}
