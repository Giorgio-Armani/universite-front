package fr.afang.universite.enseignant.controller;

import org.springframework.ui.Model;

import fr.afang.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {

	
	public String getEnseignant(Model model);

	public String getEnseignantById(Model model, Integer id);
	
	public String ajoutEnseignant(Model model);

	public String ajouterEnseignant(Model model, Enseignant enseignant);

	public String supprimerEnseignant(Model model, Enseignant enseignant);
	
	public String supprimerEnseignantById(Model model, Integer id);
}
