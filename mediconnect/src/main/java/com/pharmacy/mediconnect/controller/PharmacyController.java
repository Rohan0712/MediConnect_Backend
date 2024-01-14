package com.pharmacy.mediconnect.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.mediconnect.enitity.Doctor;
import com.pharmacy.mediconnect.enitity.Medicine;
import com.pharmacy.mediconnect.enitity.OrderDetailesModel;
import com.pharmacy.mediconnect.enitity.Support;
import com.pharmacy.mediconnect.enitity.SupportModel;
import com.pharmacy.mediconnect.enitity.User;
import com.pharmacy.mediconnect.service.DoctorService;
import com.pharmacy.mediconnect.service.MedicineService;
import com.pharmacy.mediconnect.service.OrderService;
import com.pharmacy.mediconnect.service.SupportService;
import com.pharmacy.mediconnect.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "http://localhost:4200")
public class PharmacyController {

	private static final Logger log = LoggerFactory.getLogger(PharmacyController.class);
	
	@Autowired
	MedicineService medicineService;
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SupportService supportService;
	
	@Autowired
	EmailController emailController;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(value = "/api/medicinesList")
	public @ResponseBody ResponseEntity<List<Medicine>> fetchListOfMedicine() throws Exception {
		List<Medicine> mediList = new ArrayList<Medicine>();
		log.info("Fetched Medicine Details called");
		try {
			mediList = medicineService.fetchMedicineList();
		} catch (Exception exception) {
			log.error("Error while fetching Medicine Details..{}", exception.getStackTrace());
			return new ResponseEntity<>(mediList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("Fetched Medicine Details Ended");
		return new ResponseEntity<>(mediList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/medicine/{medicineId}")
	public @ResponseBody ResponseEntity<Medicine> fetchMedicineById(@PathVariable("medicineId") Integer medicineId) throws Exception {
		Medicine medicine = new Medicine();
		log.info("fetchMedicineById called");
		try {
			medicine = medicineService.fetchMedicineById(medicineId);
		} catch (Exception exception) {
			log.error("Error in fetchMedicineById", exception.getStackTrace());
			return new ResponseEntity<>(medicine, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("fetchMedicineById Ended");
		return new ResponseEntity<>(medicine, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/api/doctorList")
	public @ResponseBody ResponseEntity<List<Doctor>> fetchListOfDoctor() throws Exception {
		List<Doctor> doctorListList = new ArrayList<Doctor>();
		log.info("Fetched Doctor Details called");
		try {
			doctorListList = doctorService.fetchDoctorList();
		} catch (Exception exception) {
			log.error("Error while fetching Doctor Details..{}", exception.getStackTrace());
			return new ResponseEntity<>(doctorListList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("Fetched Doctor Details Ended");
		return new ResponseEntity<>(doctorListList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/doctor/{name}")
	public @ResponseBody ResponseEntity<Doctor> fetchDoctorByName(@PathVariable("name") String name) throws Exception {
		Doctor doctor = new Doctor();
		log.info("fetchDoctorByName called");
		try {
			doctor = doctorService.fetchDoctorByName(name);
		} catch (Exception exception) {
			log.error("Error in fetchDoctorByName", exception.getStackTrace());
			return new ResponseEntity<>(doctor, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("fetchDoctorByName Ended");
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/userList")
	public @ResponseBody ResponseEntity<List<User>> fetchListOfUser() throws Exception {
		List<User> userList = new ArrayList<User>();
		log.info("Fetched User Details called");
		try {
			userList = userService.fetchUserList();
		} catch (Exception exception) {
			log.error("Error while fetching User Details..{}", exception.getStackTrace());
			return new ResponseEntity<>(userList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("Fetched User Details Ended");
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/user/{email}")
	public @ResponseBody ResponseEntity<User> fetchUserByEmail(@PathVariable("email") String email) throws Exception {
		User user = new User();
		log.info("fetchUserByEmail called");
		try {
			user = userService.fetchUserByEmail(email);
			if(!user.getEmail().isBlank()) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
		} catch (Exception exception) {
			log.error("Error in fetchUserByEmail", exception.getStackTrace());
			return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("fetchUserByEmail Ended");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/userId/{userId}")
	public @ResponseBody ResponseEntity<String> fetchUserByName(@PathVariable("userId") String userId) throws Exception {
		Boolean response = false;
		log.info("fetchUserByEmail called");
		try {
			response = userService.updateUserDetails(userId);
			if(response) {
				return new ResponseEntity<>("User Verified", HttpStatus.OK);
			}
		} catch (Exception exception) {
			log.error("Error in fetchUserByEmail", exception.getStackTrace());
			return new ResponseEntity<>("User verification Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("fetchUserByEmail Ended");
		return new ResponseEntity<>("User not found", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping(value = "/api/support", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> userSupport(@RequestBody SupportModel support) throws Exception {
		String response = "";
		log.info("userSupport called");
		try {
			response = supportService.saveSupportData(support);
			if(response.equals("Success")) {
				log.info("userSupport Ended");
				return new ResponseEntity<>("Message Shared Successfully", HttpStatus.OK);
			}
		} catch (Exception exception) {
			log.error("Error in userSupport", exception.getStackTrace());
			return new ResponseEntity<>("Error Occured, Try Again!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("userSupport Ended");
		return new ResponseEntity<>("Error Occured, Try Again!!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/api/registration", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> userRegistration(@RequestBody User user) throws Exception {
		String response = "";
		log.info("userRegistration called");
		try {
			response = userService.registerUser(user);
			if(response.equals("Success")) {
				emailController.sendVerificationEmail(user.getEmail());
				log.info("userRegistration Ended");
				return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
			}else if(response.equals("Username Already Exist")) {
				log.info("userRegistration Ended");
				return new ResponseEntity<>("Username Already Exist", HttpStatus.NOT_ACCEPTABLE);
			}else if(response.equals("Email Already Exist")) {
				log.info("userRegistration Ended");
				return new ResponseEntity<>("Email Already Exist", HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception exception) {
			log.error("Error in userRegistration", exception.getStackTrace());
			return new ResponseEntity<>("Error Occured, Try Again!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("userRegistration Ended");
		return new ResponseEntity<>("Error Occured, Try Again!!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/api/saveOrderDetails", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> saveOrderDetails(@RequestBody OrderDetailesModel orderDetailesModel) throws Exception {
		String response = "";
		log.info("saveOrderDetails called");
		try {
			response = orderService.saveOrderDetails(orderDetailesModel);
			if(response.equals("Success")) {
				log.info("saveOrderDetails Ended");
				return new ResponseEntity<>("Order Details Saved Successfully", HttpStatus.OK);
			}else {
				log.info("userRegistration Ended");
				return new ResponseEntity<>("Details not Saved, Place another Order", HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception exception) {
			log.error("Error in saveOrderDetails", exception.getStackTrace());
			return new ResponseEntity<>("Error Occured, Try Again!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
