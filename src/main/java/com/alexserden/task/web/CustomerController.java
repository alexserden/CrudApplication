package com.alexserden.task.web;

import java.util.List;
import java.util.Optional;

import com.alexserden.task.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alexserden.task.repository.CustomerRepository;

@Controller
public class CustomerController {
	@Autowired
    private CustomerRepository repository;


	
	@RequestMapping("/login")
	public String login() {
    	return "login";
    }
	
	@RequestMapping("/customers")
	public String index(Model model) {
		List<Customer> customers = (List<Customer>) repository.findAll();
		model.addAttribute("customers", customers);
    	return "customers";
    }

    @RequestMapping(value = "add")
    public String addStudent(Model model){
    	model.addAttribute("customer", new Customer());
        return "addCustomer";
    }	

    @RequestMapping(value = "/edit/{id}")
    public String editStudent(@PathVariable("id") Long studentId, Model model){
    	model.addAttribute("customer", repository.findById(studentId));
        return "editCustomer";
    }	    
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Customer customer){
        repository.save(customer);
    	return "redirect:/customers";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long studentId, Model model) {
    	repository.deleteById(studentId);
        return "redirect:/customers";
    }    
    



    @RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	public String customersAdd(@RequestParam(value="action", required=true) String action, @PathVariable Long id, Model model) {
		Optional<Customer> student = repository.findById(id);

			repository.save(student.get());
			model.addAttribute("customer", repository.findById(id));
			return "redirect:/customers";

	}
    
    @RequestMapping(value = "getcustomers", method = RequestMethod.GET)
    public @ResponseBody List<Customer> getStudents() {
            return (List<Customer>)repository.findAll();
    }      
}
