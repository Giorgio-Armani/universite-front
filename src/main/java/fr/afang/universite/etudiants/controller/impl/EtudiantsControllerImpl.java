package fr.afang.universite.etudiants.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.afang.universite.etudiants.business.IEtudiantsBusiness;
import fr.afang.universite.etudiants.controller.IEtudiantsController;
import fr.afang.universite.etudiants.domain.Etudiants;

@Controller
public class EtudiantsControllerImpl implements IEtudiantsController {
	@Autowired
	private IEtudiantsBusiness etudiantsBusisness;

	@Override
	@GetMapping("/etudiants")
	public String getEtudiants(Model model) {
		List<Etudiants> liste = etudiantsBusisness.getListeEtudiants();
		model.addAttribute("liste", liste);
		return "etudiant/etudiants";
	}

	@Override
	@GetMapping("/etudiant")
	public String getEtudiantById(Model model, @RequestParam Integer id) {

		Etudiants e = etudiantsBusisness.getEtudiantsById(id);

		model.addAttribute("etudiantsBusisness", e);

		return "etudiant/detailsEtudiants";

	}

	@Override
	@RequestMapping("/ajouterEtudiants")
	public String AjouterEtudiants(Model model, Integer id) {

		Etudiants e = new Etudiants();
		model.addAttribute("Etudiants", e);

		return "etudiant/ajoutEtudiants";
	}

	@Override
	@PostMapping("/ajouterEtudiants")
	public String AjouterEtudiant(Model model, @ModelAttribute Etudiants Etudiants) {

		etudiantsBusisness.saveEtudiants(Etudiants);
		return "redirect:/Etudiants";

	}

	@Override
	@GetMapping("/SupprimerEtudiant")
	public String SupprimerEtudiant(Model model, @RequestParam Integer id) {

		etudiantsBusisness.supprimerEtudiant(id);
		;

		return "redirect:/Etudiants";
	}

	@Override
	@GetMapping("/modifierEtudiant")
	public String ModifierEtudiant(Model model, @RequestParam Integer id) {
		Etudiants e = etudiantsBusisness.getEtudiantsById(id);
		model.addAttribute("Etudiants", e);
		return "Etudiants/ModifierEtudiant";
	}

	@Override
	@PostMapping("/ModifierEtudiants")
	public String modifierEtudiants(Model model, @ModelAttribute Etudiants Etudiants) {
		etudiantsBusisness.saveEtudiants(Etudiants);
		return "redirect:/Etudiants";
	}

}