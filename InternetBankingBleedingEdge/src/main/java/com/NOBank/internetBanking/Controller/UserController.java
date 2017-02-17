package com.NOBank.internetBanking.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.NOBank.internetBanking.Model.UserAccount;
import com.NOBank.internetBanking.Service.UserAccountService;
import org.springframework.http.HttpStatus;

import com.NOBank.internetBanking.DAO.UserAccountDAO;

@Controller
public class UserController {
	public static final String SERVER_URI = "http://localhost:8080/InternetBanking";


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

  //  @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
 //   public String login(Model model) {

 //       return "login";
 //   }
 //   @RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
 //   public String registration(Model model) {
 //
  //      return "registration";
  //  }


    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UserAccountDAO userAccountDAO;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserAccount());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserAccount userForm, BindingResult bindingResult, Model model) {

        userAccountService.save(userForm);

        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }



	@RequestMapping(value="/accounts", method=RequestMethod.GET)
	public @ResponseBody List<UserAccount> findAllUsers() {

	    List<UserAccount> users = new ArrayList<UserAccount>();
	    return users;
	}

    @RequestMapping(value="/useraccounts", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<UserAccount> list(Model model) {

        return userAccountDAO.retreiveAllAccounts();
    }

    @RequestMapping(value = "/successful_login", method = RequestMethod.GET)
    public String successful_login() {

        return "successful_login";
    }

    
	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public @ResponseBody UserAccount authentication(@RequestBody UserAccount userAccount1) {
		UserAccount userAccount = userAccountDAO.getAccountData(userAccount1);
	//	System.out.println(userAccount.getEmail());
	//	System.out.println(userAccount.getPassword());
	//	System.out.println(userAccount.getFirstname());
	//	System.out.println(userAccount.getPhone());
	//	System.out.println(userAccount.getDOB());
	
		return userAccount;
	}
}
