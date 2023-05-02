package com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.AppUser;
import com.entities.MyTshirt;
import com.utilityClasses.MySorter;

@Component
public class MyTshirtDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void save(MyTshirt t) {
//		int i= (Integer)this.hibernateTemplate.save(t);
		this.hibernateTemplate.saveOrUpdate(t);
	}
	
	public ArrayList<MyTshirt> getRequiredTshirts(String color,String size, String gender, String pref){
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(MyTshirt.class);
		detachedCriteria.add(Restrictions.eq("colour", color));
		detachedCriteria.add(Restrictions.eq("gender", gender));
		detachedCriteria.add(Restrictions.eq("size", size));
		List<MyTshirt> reqTshirts = (List<MyTshirt>) hibernateTemplate.findByCriteria(detachedCriteria);
		System.out.println(reqTshirts.size());
		Collections.sort(reqTshirts,new MySorter(pref));
		return (ArrayList<MyTshirt>) reqTshirts;
	}
	
	
	
}
