package luis.alfaro.prueba.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import luis.alfaro.prueba.model.Servicio;
import luis.alfaro.prueba.service.ServicioService;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private ServicioService sService;
    
	@RequestMapping("/bienvenido")
	public String irServicioBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irpaginaListadoServicios(Map<String, Object>model) {
        model.put("listaServicios", sService.listar());
    	return "listServicio";
    }
    
	@RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
    	model.addAttribute("servicio", new Servicio());
    	return "servicio";
    }

	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Servicio objServicio, BindingResult binRes, Model model)
	       throws ParseException
	       {
		         if (binRes.hasErrors())
		        	 return "servicio";
		         else {
		        	 boolean flag = sService.insertar(objServicio);
		        	 if (flag)
		        		 return "redirect:/servicio/listar";
		        	 else {
		        		 model.addAttribute("mensaje", "Ocurrio un error");
		        		 return "redirect:/servicio/irRegistrar";
		        	 }
		         }
	       }   
	    
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<Servicio> objServicio = sService.listarId(id);
		if (objServicio == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/servicio/listar";
		}
		else {
			model.addAttribute("servicio", objServicio);
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
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
	model.put("listaServicios", sService.listar());
	return "listServicio";
	}	
}

	


