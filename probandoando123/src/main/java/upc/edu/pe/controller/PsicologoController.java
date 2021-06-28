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

import upc.edu.pe.model.Psicologo;
import upc.edu.pe.service.iPsicologoService;

@Controller
@RequestMapping("/psicologo")
public class PsicologoController {
	
	@Autowired
	private iPsicologoService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "inicio";
	}
	
	@RequestMapping({"/", "listarPsicologo"})
	public String irPaginaListadPsicologos(Map<String, Object> model) {
		model.put("listaPsicologos", pService.listar());
		return "listPsicologo";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("psicologo", new Psicologo());
		return "psicologo";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Psicologo objP, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "psicologo";
		else {
			boolean flag = pService.insertar(objP);
			if (flag)
				return "redirect:/psicologo/listarPsicologo";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/psicologo/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Psicologo> objP = pService.listarId(id);
		if (objP == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/psicologo/listar";
		} else {
			model.addAttribute("psicologo", objP);
			return "psicologo";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.eliminar(id);
				model.put("listaPsicologos", pService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaPsicologos", pService.listar());
		}
		return "listPsicologo";
	}

	
}
