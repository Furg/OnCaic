package cat.udl.eps.softarch.hello.repository;

import cat.udl.eps.softarch.hello.model.Hosting;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface HostingRepository extends PagingAndSortingRepository<Hosting, String> {

    // PagingAndSortingRepository provides:
    // exists(ID id), delete(T entity), findAll(Pageable), findAll(Sort), findOne(ID id), save(T entity),...
    // http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html
}
