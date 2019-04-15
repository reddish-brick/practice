package com.example.practice.JsonApi;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleResourceRepository implements ResourceRepositoryV2<Role, Long> {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public Role findOne(Long id, QuerySpec querySpec) {
    return roleRepository.findById(id).orElse(null);
  }

  @Override
  public ResourceList<Role> findAll(QuerySpec querySpec) {
    return querySpec.apply(roleRepository.findAll());
  }

  @Override
  public ResourceList<Role> findAll(Iterable<Long> ids, QuerySpec querySpec) {
//    return querySpec.apply(roleRepository.findAll(ids));
    return null;
  }

  @Override
  public <S extends Role> S save(S entity) {
    return roleRepository.save(entity);
  }

  @Override
  public void delete(Long id) {
//    roleRepository.delete(id);
    roleRepository.deleteById(id);
  }

  @Override
  public Class<Role> getResourceClass() {
    return Role.class;
  }

  @Override
  public <S extends Role> S create(S entity) {
    return save(entity);
  }
}
