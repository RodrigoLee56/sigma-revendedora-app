package com.rede.sigma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rede.sigma.service.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
    private VendedorService vendedorService;
	
}
