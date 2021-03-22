/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.ResourceBundle;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlMessages;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Komp
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    public LoginBean() {
    }

    public String login() {
        if(username.equals("scott")&&password.equals("tiger"))
        {
            ResourceBundle bundle = ResourceBundle.getBundle("ApplicationMessages");
            messages.setRendered(true);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,bundle.getString("oracle"),"");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", message);
            context.renderResponse(); 
            return null;
        }
        else if (username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }

    public void activateButton(ValueChangeEvent e) {
        if (acceptCheckbox.isSelected()) {
            loginButton.setDisabled(false);
        } else {
            loginButton.setDisabled(true);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse(); 
    }

    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;
    private HtmlMessages messages;
    private String username;
    private String password;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the acceptCheckbox
     */
    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    /**
     * @param acceptCheckbox the acceptCheckbox to set
     */
    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    /**
     * @return the loginButton
     */
    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }

    /**
     * @return the messages
     */
    public HtmlMessages getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(HtmlMessages messages) {
        this.messages = messages;
    }
}
