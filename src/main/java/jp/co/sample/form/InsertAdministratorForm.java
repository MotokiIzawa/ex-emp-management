package jp.co.sample.form;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author izawamotoki
 *
 */
public class InsertAdministratorForm {
	/** 名前 */
	private String name;
	/** メールアドレス */
	private String mailAddress;
	/** パスワード */
	private String password;

	public InsertAdministratorForm() {
	}

	public InsertAdministratorForm(String name, String mailAddress, String password) {
		super();
		this.name = name;
		this.mailAddress = mailAddress;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password + "]";
	}

}
