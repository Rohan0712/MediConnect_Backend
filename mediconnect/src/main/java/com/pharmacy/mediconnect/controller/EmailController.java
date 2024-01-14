package com.pharmacy.mediconnect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.mediconnect.email.EmailAuthClass;
import com.pharmacy.mediconnect.enitity.User;
import com.pharmacy.mediconnect.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/email")
public class EmailController {

	private static final Logger log = LoggerFactory.getLogger(EmailController.class);

//	@Autowired
//	EmailService emailService;

	@Autowired
	EmailAuthClass emailAuthClass;

	@Autowired
	UserService userService;

	// Send Email with user-email
	@GetMapping(value = "/sendMail/{user-email}")
	public @ResponseBody ResponseEntity<String> sendVerificationEmail(@PathVariable("user-email") String email)
			throws Exception {
		User user = new User();
		String verificationLink = "";
		log.info("sendVerificationEmail Method Called");
		try {
			user = userService.fetchUserByEmail(email);
			verificationLink = "localhost:8080/api/userId/" + user.getUserID();
			//String verifyLink = "<a href='" + verificationLink + "'>" + "Click on verification link" + "</a>";
			emailAuthClass.sendMail("Account Verification Link",
					"Dear " + user.getFirstName() + " " + user.getLastName() + "," + "\n\n"
							+ "Please copy the verification link below and run it in new window of the browser," + "\n" + verificationLink + "\n"
							+ "\n" + "\n" + "\n" + "Regards," + "\n" + "Medi-Connect Team",
					email);
			
//			emailAuthClass.sendMail("Account Verification Link",
//					"Dear User," + "\n" + "Please click on the link in the mail below," + "\n" + verificationLink + "\n"
//							+ "\n" + "\n" + "\n" + "\n" + "Regards," + "\n" + "Medi-Connect Team",
//					email);
		} catch (MailException mailException) {
			log.error("Error while sending out email..{}", mailException.getStackTrace());
			return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("sendVerificationEmail Method Ended");
		return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
	}

}
