package models.book.data;

public class UserDTO 
{
	private int id;
	private String username;
	private String name;
	private String email;
	
	public UserDTO(int id, String name, String username, String email)
	{
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
	}
	
	//ID
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}
	
	//Username
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}
	
	//Name
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	
	//Email
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}
}
