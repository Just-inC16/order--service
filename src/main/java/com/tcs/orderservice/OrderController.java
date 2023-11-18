package com.tcs.orderservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderRepository repository;

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}

	@GetMapping
	public List<Order> getOrders() {
		return repository.findAll();
	}

	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		return repository.save(order);
	}
}