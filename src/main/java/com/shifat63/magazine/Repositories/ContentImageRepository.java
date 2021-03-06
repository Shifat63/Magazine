package com.shifat63.magazine.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shifat63.magazine.Model.ContentImage;

@Repository
@Transactional
public interface ContentImageRepository extends CrudRepository<ContentImage, Integer> {

}
