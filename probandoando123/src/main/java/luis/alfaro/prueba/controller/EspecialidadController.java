package luis.alfaro.prueba.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import luis.alfaro.prueba.model.Especialidad;
import luis.alfaro.prueba.model.Servicio;
import luis.alfaro.prueba.service.EspecialidadService;
import luis.alfaro.prueba.service.ServicioService;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

	@Autowired
	private EspecialidadService eService;
	@Autowired
	private ServicioService sService;
	
	@RequestMapping("/bienvenido")
	public String irEspecialidadBienvenido() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irpaginaListadoEspecialidades(Map<String, Object>model) {
        model.put("listaEspecialidades", eService.listar());
    	return "listEspecialidad";
    }
    
	@RequestMapping("/irRegistrar")
    public String irPaginaRegistroEspecialidad(Model model) {
		
		model.addAttribute("listaEspecialidades", eService.listar());
		model.addAttribute("listaServicios", sService.listar());
    	model.addAttribute("especialidad", new Especialidad());
    	model.addAttribute("servicio", new Servicio());
    	return "especialidad";
    }

	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Especialidad objEspecialidad , BindingResult binRes, Model model)
	       throws ParseException
	       {
		        if(binRes.hasErrors())
		        {
		        	model.addAttribute("listaServicios", sService.listar());
		        	return "especialidad";
		        }
		        else
		        {
		        	boolean flag = eService.insertar(objEspecialidad);
		        	if(flag)
		        		return "redirect:/especialidad/listar";
		        	else
		        	{
		        		model.addAttribute("mensaje", "Ocurrio un error");
		        		return "redirect:/especialidad/irRegistrar";
		        	}
		        }
		        	
	       }   
	    
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
			
	{
		System.out.println(id);
		Optional<Especialidad> objEspecialidad = eService.listarId(id);
		if (objEspecialidad == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/especialidad/listar";
		}
		else {
			model.addAttribute("listaServicios", sService.listar());
			
			model.addAttribute("listaEspecialidades", eService.listar());
			
			if(objEspecialidad.isPresent())
				objEspecialidad.ifPresent(o->model.addAttribute("especialidad",o));
			return "especialidad";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
         try {
        	 
        	 if (id!=null && id>0) {
        		 eService.eliminar(id);
        		 model.put("listaEspecialidades", eService.listar());
        	 }
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "ocurrio un error");
			model.put("listaEspecialidades", eService.listar());
		}
		return "listEspecialidad";

	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
	model.put("listaEspecialidades", eService.listar());
	return "listEspecialidad";
	}	
	
	@RequestMapping("/listarID")
	public String listarId(Map<String, Object> model, @ModelAttribute Especialidad especialidad)
			throws ParseException 
			{
		          eService.listarId(especialidad.getIdEspecialidad());
		          return "listEspecialidad";
			}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model)
	{
		model.addAttribute("especialidad", new Especialidad());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Especialidad especialidad)
	throws ParseException 
	{
		List<Especialidad> listaEspecialidades;
		especialidad.setNombreEspecialidad(especialidad.getNombreEspecialidad());
		listaEspecialidades = eService.buscarnombre(especialidad.getNombreEspecialidad());
		
		if(listaEspecialidades.isEmpty())
		{
			model.put("mensaje", "No existe coincidencias");
		}
		
			model.put("listaEspecialidades", listaEspecialidades);
		return "buscar";
	}
	
}
