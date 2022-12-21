package com.javacourse.springBootDemo.apiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {
		
		@GetMapping("/") // uygulama çalışınca bu gelmelidir
		public String get() {
			return "laptop";
		}
		
		@GetMapping("/products") 
		public String get2() {
			return "laptop 3";
		}
		
		
}
