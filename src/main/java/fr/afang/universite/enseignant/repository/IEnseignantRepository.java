package fr.afang.universite.enseignant.repository;

import java.util.List;

import fr.afang.universite.enseignant.domain.Enseignant;

public interface IEnseignantRepository {

	List<Enseignant> findAll();

	Enseignant getOne(Integer id);

	Enseignant save(Enseignant enseignant);

	void deleteById(Integer id);

	Enseignant deleteById(Enseignant enseignant);

}
