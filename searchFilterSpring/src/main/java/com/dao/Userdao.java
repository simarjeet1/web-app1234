package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.AppUser;

@Component
public class Userdao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public String save(AppUser u) {
//		int i= (Integer)this.hibernateTemplate.save(t);
		return (String) this.hibernateTemplate.save(u);
	}

	public AppUser getUserDetailsByEmailAndPassword(String username,String password){
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(AppUser.class);
		detachedCriteria.add(Restrictions.eq("username", username));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<AppUser> findByCriteria = (List<AppUser>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;
	}
}
