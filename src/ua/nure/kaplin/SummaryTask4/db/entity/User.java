package ua.nure.kaplin.SummaryTask4.db.entity;

/**
 * User entity.
 * 
 * @author D.Kolesnikov
 * 
 */
public class User {

	private static final long serialVersionUID = -6889036256149495388L;
	
	private long id;

	private String login;

	private String email;

	private String password;

	private String firstName;

	private String lastName;

	private int roleId;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", firstName=" + firstName + ", lastName=" + lastName + ", roleId=" + roleId
				+ "]";
	}

}
