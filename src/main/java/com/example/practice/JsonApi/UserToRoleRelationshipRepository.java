package com.example.practice.JsonApi;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.RelationshipRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserToRoleRelationshipRepository implements
    RelationshipRepositoryV2<User, Long, Role, Long> {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public void setRelation(User User, Long roleId, String fieldName) {
  }

  @Override
  public void setRelations(User user, Iterable<Long> roleIds, String fieldName) {
    Set<Role> roles = new HashSet<>();
    roles.addAll(roleRepository.findAll());
    user.setRoles(roles);
    userRepository.save(user);
  }

  @Override
  public void addRelations(User user, Iterable<Long> roleIds, String fieldName) {
    Set<Role> roles = user.getRoles();
    roles.addAll(roleRepository.findAll());
    user.setRoles(roles);
    userRepository.save(user);
  }

  @Override
  public void removeRelations(User user, Iterable<Long> roleIds, String fieldName) {
    Set<Role> roles = user.getRoles();
    roles.removeAll(roleRepository.findAll());
    user.setRoles(roles);
    userRepository.save(user);
  }

  @Override
  public Role findOneTarget(Long sourceId, String fieldName, QuerySpec querySpec) {
    return null;
  }

  @Override
  public ResourceList<Role> findManyTargets(Long sourceId, String fieldName, QuerySpec querySpec) {
    User user = userRepository.findById(sourceId).orElse(null);
    return querySpec.apply(user.getRoles());
  }

  @Override
  public Class<User> getSourceResourceClass() {
    return User.class;
  }

  @Override
  public Class<Role> getTargetResourceClass() {
    return Role.class;
  }

}
