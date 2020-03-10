package com.shifat63.magazine.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shifat63.magazine.Model.ContentCategory;

@Repository
@Transactional
public interface ContentCategoryRepository extends CrudRepository<ContentCategory, Integer> {

}
