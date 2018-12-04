package fr.afang.universite.enseignant.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.afang.universite.enseignant.business.IEnseignantBusiness;
import fr.afang.universite.enseignant.controller.IEnseignantController;
import fr.afang.universite.enseignant.domain.Enseignant;

@Controller
public class EnseignantControllerImpl implements IEnseignantController {

	public static final String ENSEIGNANT = "enseignant";
	@Autowired
	private IEnseignantBusiness enseignantBusiness;

	@Override
	@RequestMapping("/enseignants")
	public String getEnseignant(Model model) {
		List<Enseignant> listeEn = enseignantBusiness.getListeEnseignants();
		model.addAttribute("liste", listeEn);
		return "enseignants/enseignant";

	}

	@Override
	@RequestMapping("/enseignant")
	public String getEnseignantById(Model model, @RequestParam Integer id) {
		Enseignant listeEn = enseignantBusiness.getEnseignantById(id);
		model.addAttribute(ENSEIGNANT, listeEn);

		return "enseignants/enseignantDetail";
	}

	@Override
	@RequestMapping("/ajout-enseignant")
	public String ajoutEnseignant(Model model) {
		Enseignant e = new Enseignant();
		model.addAttribute(ENSEIGNANT, e);
		return "enseignants/ajoutEnseignant";

	}

	@Override
	@PostMapping("/ajouter-enseignant")
	public String ajouterEnseignant(Model model, @ModelAttribute Enseignant enseignant) {
		enseignantBusiness.saveEnseignant(enseignant);
		return "redirect:/enseignants";
	}

	@Override
	@RequestMapping("/supprimerenseignant")
	public String supprimerEnseignantById(Model model, @RequestParam Integer id) {
		enseignantBusiness.supprimerEnseignant(id);
		return "redirect:/enseignants";

	}

	@Override
	public String supprimerEnseignant(Model model, Enseignant enseignant) {
		// TODO Auto-generated method stub
		return null;
	}

}