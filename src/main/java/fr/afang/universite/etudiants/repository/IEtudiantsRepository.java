package fr.afang.universite.etudiants.repository;

import java.util.List;

import fr.afang.universite.etudiants.domain.Etudiants;

public interface IEtudiantsRepository {

	List<Etudiants> findAll();

	Etudiants getOne(Integer id);

	Etudiants save(Etudiants etudiant);

	public void deleteById(Integer id);

}
