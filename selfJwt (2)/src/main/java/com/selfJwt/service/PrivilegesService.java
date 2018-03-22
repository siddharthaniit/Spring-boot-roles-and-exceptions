package com.selfJwt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.selfJwt.model.Privilege;
import com.selfJwt.repo.PrivilegeRepo;

@Service
public class PrivilegesService {

	@Autowired
	private PrivilegeRepo repo;

	@Cacheable(value = "privilegeCache", key = "#result==null?#p0:result.user_id", unless = "#result==null")
	public Privilege create(Privilege privilege) {
		Privilege save = repo.save(privilege);
		return save;
	}
	
	@Cacheable(value = "userCache", key = "#p0.user_id")
	public Set<Privilege> getAll() {
		Iterable<Privilege> findAll = repo.findAll();
		Set<Privilege> arrayList = new HashSet<Privilege>();
		findAll.forEach(arrayList::add);
		return arrayList;
	}

	public Privilege getById(long id) {
		Privilege findOne = repo.findOne(id);
		System.out.println("executed");
		return findOne;
	}

	public void delete(long id) {
		repo.delete(id);
	}

	public Privilege getByName(String name) {
		Privilege byName = repo.findByName(name);
		return byName;
	}
}
