package com.cokepepsi.easyexceldemo.repository;

import com.cokepepsi.easyexceldemo.domain.DemoData;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author CokePepsi
 * @date 2023/10/16 17:07
 */
@Repository
public class DemoDataRepository implements JpaRepositoryImplementation<DemoData, Long> {
    @Override
    public void setRepositoryMethodMetadata(CrudMethodMetadata crudMethodMetadata) {

    }

    @Override
    public List<DemoData> findAll() {
        return null;
    }

    @Override
    public List<DemoData> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DemoData> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<DemoData> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(DemoData entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends DemoData> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends DemoData> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DemoData> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DemoData> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends DemoData> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<DemoData> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DemoData getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends DemoData> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DemoData> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DemoData> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DemoData> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DemoData> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DemoData> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Optional<DemoData> findOne(Specification<DemoData> spec) {
        return Optional.empty();
    }

    @Override
    public List<DemoData> findAll(Specification<DemoData> spec) {
        return null;
    }

    @Override
    public Page<DemoData> findAll(Specification<DemoData> spec, Pageable pageable) {
        return null;
    }

    @Override
    public List<DemoData> findAll(Specification<DemoData> spec, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification<DemoData> spec) {
        return 0;
    }
}
