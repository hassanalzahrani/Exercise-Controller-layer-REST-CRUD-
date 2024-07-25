package com.example.demo.bank;

import com.example.demo.model.Customer;
import com.example.demo.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/system")
public class BankController {

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getSystem() {
        return customers;
    }

    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new ApiResponse("customer added successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateSystem(@PathVariable int index, @RequestBody Customer customer) {
        customers.set(index, customer);
        return new ApiResponse("customer updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteSystem(@PathVariable int index) {
        customers.remove(index);
        return new ApiResponse("customer deleted successfully");
    }

    @PatchMapping("/deposit/{index}")
    public ApiResponse updateDeposit(@PathVariable int index, @RequestBody double deposit) {
        Customer customer = customers.get(index);
        customer.setDeposit(deposit);
        customers.set(index, customer);
        return new ApiResponse("customer deposit updated successfully");
    }
    @PatchMapping("/withdraw/{index}")
    public ApiResponse withdrawMoney(@PathVariable int index, @RequestBody double amount) {
        Customer customer = customers.get(index);
        if (customer.getDeposit() >= amount) {
            customer.setDeposit(customer.getDeposit() - amount);
            customers.set(index, customer);
            return new ApiResponse("customer withdrawal successful");
        } else {
            return new ApiResponse("Insufficient funds");
        }
    }
}
