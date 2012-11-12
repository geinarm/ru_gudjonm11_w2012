package models.book.service; 

import models.book.data.UserDTO;
import java.util.List;

public interface UserService
{
	public List<UserDTO> getUsers(); 
}