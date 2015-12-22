package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {
	
	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String save(Product product){
	productDao.save(product);
	return "redirect:produtos";
	}
	
//	@RequestMapping("/produtos/form")
//	public String form(){
//		return "products/form";
//	}
//	
	
	@RequestMapping("/form")
	public ModelAndView  form(){
ModelAndView modelAndView =
	new ModelAndView("products/form");
	modelAndView.addObject("types", BookType.values());
	return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(){
	ModelAndView modelAndView =
	new ModelAndView("products/list");
	modelAndView.addObject("products", productDao.list());
	return modelAndView;
	}
	

}
