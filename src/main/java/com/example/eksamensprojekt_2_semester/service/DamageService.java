package com.example.eksamensprojekt_2_semester.service;

import com.example.eksamensprojekt_2_semester.model.Damage;
import com.example.eksamensprojekt_2_semester.repository.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DamageService {

    DamageRepository damageRepository;

    @Autowired
    public DamageService(DamageRepository damageRepository) {
        this.damageRepository = damageRepository;
    }

    public List<Damage> fetchDamageById(int vehicleReport) {
        return damageRepository.fetchDamageById(vehicleReport);
    }

    public void createDamageById(Damage damage) {
        damageRepository.createDamageById(damage);
    }

    public void deleteDamageById(int vehicleReport) {
        damageRepository.deleteDamageById(vehicleReport);
    }

    public void updateAllDamagesById(List<String> name, List<Integer> price, int vehicleReportId) {

        deleteDamageById(vehicleReportId);

        if(name != null && !name.isEmpty()) {
            for (int i = 0; i < name.size(); i++) {

                Damage damage = new Damage();

                damage.setName(name.get(i));
                damage.setPrice(price.get(i));
                damage.setVehicleReportId(vehicleReportId);

                createDamageById(damage);

            }

        }

    }

}
