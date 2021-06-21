package br.com.alura.spring.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.spring.mvc.dto.RequisicaoNovoPedido;
import br.com.alura.spring.mvc.model.Pedido;
import br.com.alura.spring.mvc.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result, RedirectAttributes attributes) {
		if(result.hasFieldErrors("nomeProduto")) {
			System.out.println("---------------------------------FUNCIONO O NOTBLANK!!!!!! --------------------------------------");
			return "pedido/formulario";
		}
		System.out.println(result.hasErrors());
		System.out.println("---------------------------------NAO FUNCIONO O NOTBLANK!!!!!! --------------------------------------");
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		
		return "pedido/formulario";
	}

}
