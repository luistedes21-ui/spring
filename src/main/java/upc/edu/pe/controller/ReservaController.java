package upc.edu.pe.controller;

import java.util.Map;

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
import upc.edu.pe.model.Psicologo;
import upc.edu.pe.model.Reserva;
import upc.edu.pe.model.Servicio;
import upc.edu.pe.service.ServicioService;
import upc.edu.pe.service.iPacienteService;
import upc.edu.pe.service.iPsicologoService;
import upc.edu.pe.service.iReservaService;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private iReservaService rService;
	@Autowired
	private iPacienteService pacService;
	@Autowired
	private iPsicologoService pService;
	@Autowired
	private ServicioService sService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenidoPsicologo";
	}

	@RequestMapping(value = { "", "/", "listarReserva" })
	public String irReserva(Map<String, Object> model) {
		model.put("listaReservas", rService.listar());
		return "listReserva";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {

		model.addAttribute("listaPacientes", pacService.listar());
		model.addAttribute("listaPsicologos", pService.listar());
		model.addAttribute("listaReservas", rService.listar());
		model.addAttribute("listaServicios", sService.listar());

		model.addAttribute("paciente", new Paciente());
		model.addAttribute("sevicio", new Servicio());
		model.addAttribute("psicologo", new Psicologo());
		model.addAttribute("reserva", new Reserva());

		return "reserva";
	}

	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Reserva objP, BindingResult binRes, Model model) throws ParseException {

		if (binRes.hasErrors()) {
			model.addAttribute("listaPacientes", pacService.listar());
			model.addAttribute("listaServicios", sService.listar());
			model.addAttribute("listaPsicologos", pService.listar());
			return "reserva";
		} else {
			boolean flag = rService.insertar(objP);
			if (flag) {
				return "redirect:/reserva/";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/reserva/irRegistrar";
			}
		}

	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		System.out.println(id);
		Reserva objP = rService.listarId(id).get();
		if (objP == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/reserva/listarReserva";
		} else {
			model.addAttribute("listaPacientes", pacService.listar());
			model.addAttribute("listaServicios", sService.listar());
			model.addAttribute("listaPsicologos", pService.listar());

			model.addAttribute("reserva", objP);
			return "reserva";
		}
	}
	
	@RequestMapping("/verComprobante/{id}")
	public String verComprobante(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		System.out.println(id);
		Reserva objP = rService.listarId(id).get();
		if (objP == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/reserva/listarReserva";
		} else {
			model.addAttribute("listaPacientes", pacService.listar());
			model.addAttribute("listaServicios", sService.listar());
			model.addAttribute("listaPsicologos", pService.listar());

			model.addAttribute("reserva", objP);
			return "comprobante";
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
	public String listar(Map<String, Object> model, @ModelAttribute Reserva reserva) throws ParseException {
		rService.listarId(reserva.getIdReserva());
		return "listReserva";
	}

}
