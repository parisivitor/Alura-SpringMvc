package br.com.alura.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.spring.mvc.model.Pedido;
import br.com.alura.spring.mvc.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository repositoryPedido;

	@GetMapping("/home")
	public String home(Model model) {
		List<Pedido> pedidos = repositoryPedido.findAll();
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
}
