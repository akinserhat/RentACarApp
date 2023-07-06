package akinserhat.projects.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import akinserhat.projects.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	
}
