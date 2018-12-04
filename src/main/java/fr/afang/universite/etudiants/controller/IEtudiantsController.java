package fr.afang.universite.etudiants.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.afang.universite.etudiants.domain.Etudiants;

public interface IEtudiantsController {

	public String getEtudiants(Model model);

	public String getEtudiantById(Model model, Integer id);

	public String AjouterEtudiants(Model model, Integer id);

	public String AjouterEtudiant(Model model, @ModelAttribute Etudiants Etudiants);

	public String SupprimerEtudiant(Model model, Integer id);

	public String ModifierEtudiant(Model model, Integer id);

	public String modifierEtudiants(Model model, Etudiants etudiant);

}