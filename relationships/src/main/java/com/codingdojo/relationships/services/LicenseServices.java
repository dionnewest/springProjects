package com.codingdojo.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

@Service
public class LicenseServices{
	public long num = 000000;
	private LicenseRepository licenseRep;
	public LicenseServices(LicenseRepository licenseRep) {
		this.licenseRep = licenseRep;
	}
	public List<License> allLicenses(){
		return licenseRep.findAll();
	}
	public License lookupLicense(License license) {
		Long id = license.getId();
		return licenseRep.findOne(id);
	}
	public void createLicense(License license) {
		num += 000001;
		String number = Long.toString(num);
		license.setNumber(number);
		licenseRep.save(license);
	}
	public void deleteAllLicenses() {
		List<License> allLicenses = licenseRep.findAll();
		licenseRep.delete(allLicenses);
	}
		
}