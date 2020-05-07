package com.demo.cis.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cis.dto.CustomerRequestDTO;
import com.demo.cis.dto.CustomerResponseDTO;
import com.demo.cis.dto.ValidationErrorDTO;
import com.demo.cis.model.Customer;
import com.demo.cis.service.CustomerService;

@Validated
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(){
		List<Customer> customerList = customerService.findAll();
		List<CustomerResponseDTO> responseList = customerList.stream().map(customer -> {
			CustomerResponseDTO responseDTO = new CustomerResponseDTO();
			BeanUtils.copyProperties(customer, responseDTO);
			return responseDTO;
		}).collect(Collectors.toList());
		return ResponseEntity.ok(responseList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable Long id){
		Customer customer = customerService.find(id);
		if(customer!=null) {
			CustomerResponseDTO responseDTO = new CustomerResponseDTO();
			BeanUtils.copyProperties(customer, responseDTO);
			return ResponseEntity.ok(responseDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO custCreateDTO){
		Customer customer = new Customer();
		CustomerResponseDTO responseDTO = new CustomerResponseDTO();
		BeanUtils.copyProperties(custCreateDTO, customer);
		customer = customerService.save(customer);
		BeanUtils.copyProperties(customer, responseDTO);
		return new ResponseEntity<CustomerResponseDTO>(responseDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerRequestDTO custUpdateDTO){
		Customer customer = customerService.find(id);
		if(customer!=null) {
			BeanUtils.copyProperties(custUpdateDTO, customer);
			customer = customerService.save(customer);
			CustomerResponseDTO responseDTO = new CustomerResponseDTO();
			BeanUtils.copyProperties(customer, responseDTO);
			return ResponseEntity.ok(responseDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/csvReport")
	public void downloadCSVReport(HttpServletResponse response) {
		List<Customer> customerList = customerService.findAll();
		List<CustomerResponseDTO> responseList = customerList.stream().map(customer -> {
			CustomerResponseDTO responseDTO = new CustomerResponseDTO();
			BeanUtils.copyProperties(customer, responseDTO);
			return responseDTO;
		}).collect(Collectors.toList());
		
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=customers.csv");
		
		try {
			customerService.writeToCsv(response.getWriter(), responseList);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@NotNull @PathVariable Long id){
		Customer customer = customerService.find(id);
		if(customer!=null) {
			customerService.deleteCustomer(id);
			return ResponseEntity.noContent().build();
		} 
		return ResponseEntity.notFound().build();
	}

	
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ResponseEntity<ValidationErrorDTO> validationExceptionHandler(MethodArgumentNotValidException ex) { 
		ValidationErrorDTO errorResponse = new ValidationErrorDTO();
		for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			errorResponse.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	 
}
