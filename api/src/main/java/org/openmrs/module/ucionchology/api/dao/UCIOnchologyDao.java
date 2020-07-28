/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ucionchology.api.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.APIException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.module.ucionchology.models.StageDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ucionchology.UCIOnchologyDao")
public class UCIOnchologyDao {
	
	@Autowired
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public Protocol saveOrUpdateProtocal(Protocol protocal) throws APIException {
		getSession().saveOrUpdate(protocal);
		return protocal;
	}
	
	
	public Protocol getProtocalById(int protocalId) throws APIException {
		return (Protocol) getSession().get(Protocol.class,protocalId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Protocol> getAllProtocals() throws APIException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Protocol.class);
		criteria.add(Restrictions.eq("voided", false));
		return criteria.list();
	}
	
	public void deleteProtocal(Protocol protocal) throws APIException {
		getSession().delete(protocal);		
	}
	
	public Protocol voidProtocal(Protocol protocal) throws APIException {
		protocal.setVoided(true);
		getSession().saveOrUpdate(protocal);
		return protocal;
	}
	
	public Phase saveOrUpdatePhase(Phase phase) throws APIException {
		getSession().saveOrUpdate(phase);
		return phase;
	}
	
	public Phase getPhaseById(int phaseId) throws APIException {
		return (Phase)getSession().get(Phase.class , phaseId);
	}

	@SuppressWarnings("unchecked")
	public List<Phase> getAllphases() throws APIException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Phase.class);
		criteria.add(Restrictions.eq("voided", false));
		return criteria.list();
	}
	
	public void deletePhase(Phase phase) throws APIException {
		getSession().delete(phase);		
	}
	
	public Phase voidPhase(Phase phase) throws APIException {
		phase.setVoided(true);
		getSession().saveOrUpdate(phase);
		return phase;
	}

	public StageDay saveOrUpdateStageDay(StageDay stageDay) throws APIException {
		 getSession().saveOrUpdate(stageDay);		 
		 return stageDay ;
	}
	
	
}
