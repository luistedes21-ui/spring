package upc.edu.pe.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.sun.el.parser.ParseException;

import upc.edu.pe.model.Especialidad;
import upc.edu.pe.model.Servicio;
import upc.edu.pe.service.EspecialidadService;
import upc.edu.pe.service.ServicioService;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private EspecialidadService eService;
	
	@Autowired
	private ServicioService sService;
    
	@RequestMapping("/bienvenido")
	public String irServicioBienvenida() {
		return "bienvenido";
	}

	@RequestMapping({"/", "listarServicio"})
	public String irpaginaListadoServicios(Map<String, Object>model) {
        model.put("listaServicios", sService.listar());
    	return "listServicio";
    }
    
	@RequestMapping("/irRegistrar")
    public String irPaginaRegistroServicio(Model model) {
		
		model.addAttribute("listaEspecialidades", eService.listar());
		model.addAttribute("listaServicios", sService.listar());
		
    	model.addAttribute("especialidad", new Especialidad());
    	model.addAttribute("servicio", new Servicio());
    	
    	return "servicio";
    }

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Servicio objServicio , BindingResult binRes, Model model)
	       throws ParseException
	       {
		        if(binRes.hasErrors())
		        {
		        	model.addAttribute("listaEspecialidades", eService.listar());
		        	return "servicio";
		        }
		        else
		        {
		        	boolean flag = sService.insertar(objServicio);
		        	if(flag)
		        		return "redirect:/servicio/listarServicio";
		        	else
		        	{
		        		model.addAttribute("mensaje", "Ocurrio un error");
		        		return "redirect:/servicio/irRegistrar";
		        	}
		        }
		        	
	       }   
    
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
			
	{
		System.out.println(id);
		Optional<Servicio> objServicio = sService.listarId(id);
		if (objServicio == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/servicio/listar";
		}
		else {
			model.addAttribute("listaServicios", sService.listar());
			
			model.addAttribute("listaEspecialidades", eService.listar());
			
		if(objServicio.isPresent())
			objServicio.ifPresent(o->model.addAttribute("servicio",o));
			return "servicio";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
         try {
        	 
        	 if (id!=null && id>0) {
        		 sService.eliminar(id);
        		 model.put("listaServicios", sService.listar());
        	 }
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "ocurrio un error");
			model.put("listaServicios", sService.listar());
		}
		return "listServicio";

	}
	

	@RequestMapping("/listarID")
	public String listarId(Map<String, Object> model, @ModelAttribute Servicio servicio)
			throws ParseException 
			{
		          sService.listarId(servicio.getIdServicio());
		          return "listServicio";
			}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model){
		model.addAttribute("servicio", new Servicio());
		return "buscarservi";
		
	}
	@RequestMapping("/buscar")
	public String findbyCategory(@RequestParam(value = "txtnamesearch") String txtnamesearch,
			Model model) {
		
		List<Servicio> listaServicios;
		if (StringUtils.isEmpty(txtnamesearch)) {
			model.addAttribute("mensaje", "No hay resultados");
			listaServicios = sService.listar();
		} else {
			listaServicios = sService.buscarServicio(txtnamesearch);
		}
		
		if (listaServicios.isEmpty()) {
			model.addAttribute("mensaje", "No existen resultados");
		}
		model.addAttribute("listaServicios", listaServicios);				
		return "buscarservi";
		
	}
	
	
	
}

	


