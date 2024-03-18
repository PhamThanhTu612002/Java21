package vn.techmaster.bookinghotel.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.Province;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class HotelRepoimpl implements HotelRepository{
    @Override
    public Hotel findByIdAndSlug(Integer id, String slug) {
        return null;
    }

    @Override
    public List<Hotel> findAllByProvince(Province province) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Hotel> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Hotel> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Hotel> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Hotel getOne(Integer integer) {
        return null;
    }

    @Override
    public Hotel getById(Integer integer) {
        return null;
    }

    @Override
    public Hotel getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Hotel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Hotel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Hotel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Hotel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Hotel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Hotel> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Hotel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Hotel> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Hotel> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Hotel> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Hotel> findAll() {
        return null;
    }

    @Override
    public List<Hotel> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Hotel entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Hotel> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Hotel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        return null;
    }


}
