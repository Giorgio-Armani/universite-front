package fr.afang.universite.etudiants.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afang.universite.etudiants.business.IEtudiantsBusiness;
import fr.afang.universite.etudiants.domain.Etudiants;
import fr.afang.universite.etudiants.repository.IEtudiantsRepository;

@Service
public class EtudiantsBusinessImpl implements IEtudiantsBusiness {

	@Autowired
	private IEtudiantsRepository etudiantsRepository;

	@Override
	public List<Etudiants> getListeEtudiants() {
		List<Etudiants> liste = etudiantsRepository.findAll();
		return liste;
	}

	@Override
	public Etudiants getEtudiantsById(Integer id) {
		Etudiants etu = etudiantsRepository.getOne(id);
		return etu;
	}

	@Override
	public void saveEtudiants(Etudiants etudiant) {
		etudiantsRepository.save(etudiant);

	}

	@Override
	public void supprimerEtudiant(Integer id) {
		etudiantsRepository.deleteById(id);

	}

}
