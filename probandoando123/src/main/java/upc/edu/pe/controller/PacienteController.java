package upc.edu.pe.controller;

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

import upc.edu.pe.model.Paciente;
import upc.edu.pe.service.iPacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private iPacienteService pService;
    
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping({"/", "listarPaciente"})
	public String irpaginaListadoPacientes(Map<String, Object>model) {
        model.put("listaPacientes", pService.listar());
    	return "listPaciente";
    }
    
	@RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
    	model.addAttribute("paciente", new Paciente());
    	return "paciente";
    }

	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Paciente objPaciente, BindingResult binRes, Model model)
	       throws ParseException
	       {
		         if (binRes.hasErrors())
		        	 return "paciente";
		         else {
		        	 boolean flag = pService.insertar(objPaciente);
		        	 if (flag)
		        		 return "redirect:/paciente/listarPaciente";
		        	 else {
		        		 model.addAttribute("mensaje", "Ocurrio un error");
		        		 return "redirect:/paciente/irRegistrar";
		        	 }
		         }
	       }   

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Paciente> objP = pService.listarId(id);
		if (objP == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/paciente/listarPaciente";
		} else {
			model.addAttribute("paciente", objP);
			return "paciente";
		}
	}
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
         try {
        	 
        	 if (id!=null && id>0) {
        		 pService.eliminar(id);
        		 model.put("listaPacientes", pService.listar());
        	 }
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "ocurrio un error");
			model.put("listaPacientes", pService.listar());
		}
		return "listPaciente";

	}
	
}

	


