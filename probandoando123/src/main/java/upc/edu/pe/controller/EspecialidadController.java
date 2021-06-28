package upc.edu.pe.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import upc.edu.pe.model.Especialidad;
import upc.edu.pe.service.EspecialidadService;


@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

	@Autowired
	private EspecialidadService eService;
	
	
	@RequestMapping("/bienvenido")
	public String irEspecialidadBienvenido() {
		return "bienvenido";
	}

	@RequestMapping({"/", "listarEspecialidad"})
	public String irpaginaListadoEspecialidades(Map<String, Object>model) {
        model.put("listaEspecialidades", eService.listar());
    	return "listEspecialidad";
    }
    
	@RequestMapping("/irRegistrar")
    public String irPaginaRegistroEspecialidad(Model model) {
	
    	model.addAttribute("especialidad", new Especialidad());    	
    	return "especialidad";
    }

	

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Especialidad objE, BindingResult binRes, Model model)
	       throws ParseException
	       {
		         if (binRes.hasErrors())
		        	 return "especialidad";
		         else {
		        	 boolean flag = eService.insertar(objE);
		        	 if (flag)
		        		 return "redirect:/especialidad/listarEspecialidad";
		        	 else {
		        		 model.addAttribute("mensaje", "Ocurrio un error");
		        		 return "redirect:/especialidad/irRegistrar";
		        	 }
		         }
	       }   
	    

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Especialidad> objE = eService.listarId(id);
		if (objE == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/especialidad/listarEspecialidad";
		} else {
			model.addAttribute("especialidad", objE);
			return "especialidad";
		}
	}
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
         try {
        	 
        	 if (id!=null && id>0) {
        		 eService.eliminar(id);
        		 model.put("listaEspecialidad", eService.listar());
        	 }
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "ocurrio un error");
			model.put("listaEspecialidades", eService.listar());
		}
		return "listEspecialidad";

	}
	
	@RequestMapping("/irBuscar")
	public String buscar(Model model) {
		model.addAttribute("especialidad", new Especialidad());
		return "buscaresp";
	}
	
	@RequestMapping("/buscar")
	public String findbyCategory(@RequestParam(value = "txtnamesearch") String txtnamesearch,
			Model model) {
		
		List<Especialidad> listaEspecialidades;
		if (StringUtils.isEmpty(txtnamesearch)) {
			model.addAttribute("mensaje", "No hay resultados");
			listaEspecialidades = eService.listar();
		} else {
			listaEspecialidades = eService.buscarEspecialidad(txtnamesearch);
		}
		
		if (listaEspecialidades.isEmpty()) {
			model.addAttribute("mensaje", "No existen resultados");
		}
		model.addAttribute("listaEspecialidades", listaEspecialidades);				
		return "buscaresp";
		
	}

}
