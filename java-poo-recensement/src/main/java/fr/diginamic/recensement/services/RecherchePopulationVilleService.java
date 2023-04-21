package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exception.CodeException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de la population d'une ville
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws CodeException {

		System.out.println("Quel est le nom de la ville recherchée ? ");
		String choix = scanner.nextLine();
		
		Ville villeSearch = new Ville(choix);
		if(choix != villeSearch.getNom()) {
			throw new CodeException("Ville Inconnue ");
		}
		
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getNom().equalsIgnoreCase(choix)
					|| ville.getNom().toLowerCase().startsWith(choix.toLowerCase())) {
				System.out.println(ville);
			}
		}
	}

}
