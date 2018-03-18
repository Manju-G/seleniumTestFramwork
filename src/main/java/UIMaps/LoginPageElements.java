package UIMaps;

public interface LoginPageElements {

	String email = "input.form-control[type=email]"; // CssSelector
	String password = "input.form-control[type=password]"; // CssSelector
	String remember = "input[type=checkbox]"; // CssSelector
	String login = "input#login"; // CssSelector
	String forgetpassword = "a.btn.btn-default"; // CssSelector
	String register = "Register"; // LinkTest
	String storeMenuOption = "li#Primary_Navbar-Store"; // CssSelector
	String storeMenusubOption = "li#Primary_Navbar-Store-Installation"; // CssSelector
	String result = "div.alert.alert-danger.text-center"; // CssSelector
}