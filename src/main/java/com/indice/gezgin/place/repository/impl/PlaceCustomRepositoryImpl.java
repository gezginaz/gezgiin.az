package com.indice.gezgin.place.repository.impl;

import com.indice.gezgin.place.dto.request.DynamicSearchRequest;
import com.indice.gezgin.place.model.Place;
import com.indice.gezgin.place.repository.PlaceCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;


public class PlaceCustomRepositoryImpl implements PlaceCustomRepository {


    @PersistenceContext
    private final EntityManager em;
    public PlaceCustomRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Place> dynamicSearch(DynamicSearchRequest payload, int limit, int offset) {
        String query = "SELECT u FROM Place u WHERE u.isActive = true";

        if(payload.getType() != null && !payload.getType().equals("")){
            query = query + " AND u.type = \"" + payload.getType() + "\"";
        }
        if(payload.getAura() != null && !payload.getAura().equals("")){
            query = query + " AND u.aura = \"" + payload.getAura() + "\"";
        }
        if(payload.getTheme() != null && !payload.getTheme().equals("")){
            query = query + " AND u.theme = \"" + payload.getTheme() + "\"";
        }
        if(payload.getArchitecture() != null && !payload.getArchitecture().equals("")){
            query = query + " AND u.architecture = \"" + payload.getArchitecture() + "\"";
        }
        if(payload.getRegion() != null && !payload.getRegion().equals("")){
            query = query + " AND u.region = \"" + payload.getRegion() + "\"";
        }

        query = query + " ORDER BY id DESC  limit " + limit + " offset " + offset;

        System.out.println(" dynamicSearchMethod ------------------------------------------------------------");
        System.out.println(query);
        System.out.println(" dynamicSearchMethod ------------------------------------------------------------");

        Query q = em.createQuery(query);

        return q.getResultList();
    }
}
