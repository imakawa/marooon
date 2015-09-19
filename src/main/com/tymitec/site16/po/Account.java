/**
 * 
 */
package site16.po;

/**
 * @author bret@tymitec.com
 * @version beta
 * @since 2015/09/20
 *
 */
public class Account {

	private String id;

	private String username;

	private String password;

	private String address;

	private String groupeCode;

	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGroupeCode() {
		return groupeCode;
	}

	public void setGroupeCode(String groupeCode) {
		this.groupeCode = groupeCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}