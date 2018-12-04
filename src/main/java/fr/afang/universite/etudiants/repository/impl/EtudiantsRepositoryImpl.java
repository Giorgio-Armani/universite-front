package fr.afang.universite.etudiants.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.afang.universite.etudiants.domain.Etudiants;
import fr.afang.universite.etudiants.repository.IEtudiantsRepository;

@Repository
public class EtudiantsRepositoryImpl implements IEtudiantsRepository {

	private static final String URL = "http://localhost:8080/etudiants/";

	@Override
	public List<Etudiants> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		List<Etudiants> liste = restTemplate
				.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Etudiants>>() {
				}).getBody();
		return liste;
	}

	@Override
	public Etudiants getOne(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		Etudiants e = restTemplate.getForObject(URL + id, Etudiants.class);
		return e;
	}

	@Override
	public Etudiants save(Etudiants etudiants) {
		RestTemplate restTemplate = new RestTemplate();

		Etudiants e = restTemplate.postForObject(URL, etudiants, Etudiants.class);
		return e;
	}

	@Override
	public void deleteById(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URL + id);

	}

}
