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

import luis.alfaro.prueba.model.Reserva;
import luis.alfaro.prueba.service.iReservaService;
import luis.alfaro.prueba.model.Psicologo;
import luis.alfaro.prueba.service.iPsicologoService;

import luis.alfaro.prueba.model.Paciente;
import luis.alfaro.prueba.service.iPacienteService;


@Controller
@RequestMapping("/reserva")
public class ReservaController {
	
	
	@Autowired
	private iReservaService rService;
	@Autowired
	private iPacienteService pacService;	
	@Autowired
	private iPsicologoService pService;
	

	
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenidoPsicologo";
	}
	
	@RequestMapping({"/", "listarReserva"})
	public String irReserva(Map<String, Object> model) {
		model.put("listaReservas", rService.listar());
		return "listReserva";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("paciente", new Paciente());
		model.addAttribute("psicologo", new Psicologo());
		
		model.addAttribute("listaPacientes", pacService.listar());
		model.addAttribute("listaPsicologos", pService.listar());
		
		model.addAttribute("reserva", new Reserva());
		
		return "reserva";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Reserva objP, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
		{
			model.addAttribute("listaPacientes", pacService.listar());
			model.addAttribute("listaPsicologos", pService.listar());			
			return "reserva";
		}
		else {
			boolean flag = rService.insertar(objP);
			if (flag)
				return "redirect:/reserva/listarReserva";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/reserva/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Reserva> objP = rService.listarId(id);
		if (objP == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/reserva/listarReserva";
		} else {
			model.addAttribute("reserva", objP);
			return "reserva";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				rService.eliminar(id);
				model.put("listaReservas", rService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaReservas", rService.listar());
		}
		return "listReserva";
	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaReservas", rService.listar());
		return "listReserva";
	}
	
	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Reserva reserva) 
	throws ParseException
	{
		rService.listarId(reserva.getIdReserva());
		return "listReserva";
	}	
	
}
