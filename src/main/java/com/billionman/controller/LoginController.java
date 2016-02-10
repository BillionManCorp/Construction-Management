/**
 * 
 */
package com.billionman.controller;

/**
 * @author CTM
 *
 */
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import com.billionman.filter.SessionBean;
import com.billionman.model.User;
import com.billionman.model.UserRoles;
import com.billionman.service.CreateUserService;
import com.billionman.service.LoginService;
import com.billionman.util.Constants;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	private String role;
	private Boolean admin;
	private User addNewUser;
	private UserRoles addRoles;

	@ManagedProperty(value = "#{loginModel}")
	private LoginModel login;

	@ManagedProperty(value = "#{createUserService}")
	private CreateUserService createUserService;

	@ManagedProperty(value = "#{loginService}",name="loginService")
	LoginService loginService;

	public String userLogin() throws IOException {
		String role = loginService.validateLogin(getLogin().getUserName(), getLogin().getPassword());
		if (role != null) {
			HttpSession session = SessionBean.getSession();
			switch (role) {
			case Constants.ADMIN:
				login.setRole(Constants.ADMIN);
				getLogin().setAdmin(true);
				break;
			default:
				login.setRole(Constants.USER);
				getLogin().setAdmin(false);
				break;
			}
			session.setAttribute("username", login.getUserName());
			return "home";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	public String logout() throws IOException {
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "loggedout";
	}

	public String createProject() throws IOException {
		return "new";
	}

	public String redirectToMaterials() {
		return "materials";
	}

	public String redirectToReport() {
		return "report";
	}

	public String addUser() {
		clearUser();
		setAddNewUser(new User());
		setAddRoles(new UserRoles());
		return "user";
	}

	private void sendViaGmail(User newUserData) {
		final String username = "ctiitb0505@gmail.com";
		final String password = "beetel1991";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress());
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(newUserData.getEmail()));
			message.setSubject("Congratulations! Account created");
			message.setText("Dear "
					+ newUserData.getFullName()
					+ ","
					+ "\n\n Welcome to BillionMan Corporation.Your account created with \n\n"
					+ "userId:" + newUserData.getUserName() + "\n\n"
					+ "password:" + newUserData.getPassword() + "\n\n"
					+ "Regards, \n\n" + "BillionMan Team");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private void clearUser() {
		setAddNewUser(null);
		setAddRoles(null);
	}

	public String saveNewUser() {
		boolean successfullyAdded;
		User tempNewUser = getAddNewUser();
		UserRoles tempUserRoles = getAddRoles();
		tempUserRoles.setUsername(getAddNewUser().getUserName());
		tempNewUser.setEnabled(1);
		tempNewUser.setPassword(tempNewUser.getUserName() + "@"
				+ tempNewUser.getMobileNumber());
		successfullyAdded = Constants.SUCCESS.equals(createUserService
				.saveNewUser(tempNewUser, getAddRoles()));
		if (successfullyAdded) {
			sendViaGmail(tempNewUser);
			return Constants.SUCCESS;
		}
		return Constants.FAILURE;
	}

	public String cancel() {
		return "cancel";
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the addNewUser
	 */
	public User getAddNewUser() {
		return addNewUser;
	}

	/**
	 * @param addNewUser
	 *            the addNewUser to set
	 */
	public void setAddNewUser(User addNewUser) {
		this.addNewUser = addNewUser;
	}

	/**
	 * @return the addRoles
	 */
	public UserRoles getAddRoles() {
		return addRoles;
	}

	/**
	 * @param addRoles
	 *            the addRoles to set
	 */
	public void setAddRoles(UserRoles addRoles) {
		this.addRoles = addRoles;
	}

	/**
	 * @return the login
	 */
	public LoginModel getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(LoginModel login) {
		this.login = login;
	}

	/**
	 * @return the createUserService
	 */
	public CreateUserService getCreateUserService() {
		return createUserService;
	}

	/**
	 * @param createUserService the createUserService to set
	 */
	public void setCreateUserService(CreateUserService createUserService) {
		this.createUserService = createUserService;
	}

	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
