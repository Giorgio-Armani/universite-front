package fr.afang.universite.enseignant.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afang.universite.enseignant.business.IEnseignantBusiness;
import fr.afang.universite.enseignant.domain.Enseignant;
import fr.afang.universite.enseignant.repository.IEnseignantRepository;

@Service
public class EnseignantBusinessImpl implements IEnseignantBusiness {
	@Autowired
	private IEnseignantRepository enseignantRepository;
	private static Logger logger = LoggerFactory.getLogger(EnseignantBusinessImpl.class);

	@Override
	public List<Enseignant> getListeEnseignants() {
		List<Enseignant> liste = enseignantRepository.findAll();
		return liste;
	}

	@Override
	public Enseignant getEnseignantById(Integer id) {
		Enseignant e1 = enseignantRepository.getOne(id);
		return e1;
	}

	@Override
	public void saveEnseignant(Enseignant enseignant) {
		enseignantRepository.save(enseignant);

	}

	@Override
	public void supprimerEnseignant(Integer id) {
		enseignantRepository.deleteById(id);

		logger.info("L'Enseignant est deleted !!!");
	}

}
