package com.fnb.cis.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnb.cis.dto.CustomerResponseDTO;
import com.fnb.cis.model.Customer;
import com.fnb.cis.repository.CustomerRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	public Customer save(Customer customer){
		return customerRepository.save(customer);
	}
	
	public Customer find(Long id){
		return customerRepository.findById(id).orElse(null);
	}
	
	public void writeToCsv(PrintWriter writer, List<CustomerResponseDTO> customerList) throws Exception {
		StatefulBeanToCsv<CustomerResponseDTO> beanToCsv = 
				new StatefulBeanToCsvBuilder<CustomerResponseDTO>(writer)
				.withSeparator(CSVWriter.DEFAULT_SEPARATOR)
				.withQuotechar(CSVWriter.DEFAULT_QUOTE_CHARACTER)
				.withLineEnd(CSVWriter.DEFAULT_LINE_END)
				.withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
				.build();
		beanToCsv.write(customerList);
	}
	
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
}
