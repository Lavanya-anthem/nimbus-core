package com.anthem.oss.nimbus.core.entity.queue;

import java.util.HashSet;
import java.util.Set;

import com.anthem.oss.nimbus.core.domain.definition.AssociatedEntity;
import com.anthem.oss.nimbus.core.domain.definition.ConfigNature.Ignore;
import com.anthem.oss.nimbus.core.domain.definition.Domain;
import com.anthem.oss.nimbus.core.domain.definition.Domain.ListenerType;
import com.anthem.oss.nimbus.core.domain.definition.Repo.Cache;
import com.anthem.oss.nimbus.core.domain.definition.Repo.Database;
import com.anthem.oss.nimbus.core.domain.definition.Repo;
import com.anthem.oss.nimbus.core.entity.AbstractEntity.IdString;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jayant Chaudhuri
 *
 */
@Domain(value="queue", includeListeners={ListenerType.persistence})
@Repo(value=Database.rep_mongodb, cache=Cache.rep_device)
@Getter @Setter @EqualsAndHashCode(of={"code"},callSuper=false)
public class Queue extends IdString {

	@Ignore
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String code;
	
	private String name;
	
	@AssociatedEntity(clazz=MUser.class)
	private Set<String> users;
	
	private Set<String> userGroups;
	
	public void addUsers(MUser usr) {
		if(getUsers() == null) {
			setUsers(new HashSet<>());
		}
		getUsers().add(usr.getName());
	}
	
	public void addUserGroups(MUserGroup userGroup) {
		if(getUserGroups() == null) {
			setUserGroups(new HashSet<>());
		}
		getUserGroups().add(userGroup.getName());
	}
}
