package com.apap.tutorial5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.repository.PilotDB;

@Service("pilotService")
@Transactional
public class PilotServiceImpl implements PilotService{
	@Autowired 
	private PilotDB pilotDB;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDB.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDB.save(pilot);
	}
	
	public void deletePilot(PilotModel pilot) {
		pilotDB.delete(pilot);
	}
	
	public void updatePilot(String licenseNumber, String nama, int flyHour) {
		System.out.println(nama + " " + flyHour + " license : " + licenseNumber);
		pilotDB.findByLicenseNumber(licenseNumber).setName(nama);
		pilotDB.findByLicenseNumber(licenseNumber).setFlyHour(flyHour);
	}
	

}