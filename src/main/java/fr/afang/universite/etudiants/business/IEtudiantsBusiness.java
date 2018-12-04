package fr.afang.universite.etudiants.business;

import java.util.List;

import fr.afang.universite.enseignant.domain.Enseignant;
import fr.afang.universite.etudiants.domain.Etudiants;

public interface IEtudiantsBusiness {

	List<Etudiants> getListeEtudiants();

	public Etudiants getEtudiantsById(Integer id);

	public void saveEtudiants(Etudiants etudiant);

	public void supprimerEtudiant(Integer id);
	

}
