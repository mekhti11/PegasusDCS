package com.hititcs.pegasusdcs.domain.mapper;

public interface Mapper<E, D> {

  D mapFromEntity(E e);

  E mapToEntity(D d);
}