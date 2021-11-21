package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService  {
	
	@Autowired
	private CandidatRepository candidatRepository;
	
	public Candidat addCandidat(Candidat candidat)
	{	
		return candidatRepository.save(candidat);
	}
	
	public Candidat updateCandidat(int id, Candidat newCandidat)
	{
		if (candidatRepository.findById(id).isPresent())
		{
			Candidat existingCandidat = candidatRepository.findById(id).get();
			existingCandidat.setNom(newCandidat.getNom());
			existingCandidat.setPrenom(existingCandidat.getPrenom());
			existingCandidat.setEmail(existingCandidat.getEmail());
			
			return candidatRepository.save(existingCandidat);
		}
		else 
			return null;
	}
	
	public String deleteCandidat(int id)
	{
		if(candidatRepository.findById(id).isPresent())
		{
			candidatRepository.deleteById(id);
			return "candidat supprime";
		}
		else 
			return "candidat non supprimé";
	}
	
}
