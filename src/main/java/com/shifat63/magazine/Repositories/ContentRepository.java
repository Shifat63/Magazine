package com.shifat63.magazine.Repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shifat63.magazine.Model.Content;

@Repository
@Transactional
public interface ContentRepository extends CrudRepository<Content, Integer> {
	Set<Content> findByIsSlider(Boolean isSlider);
	Set<Content> findByIsFront(Boolean isFront);
	Set<Content> findAllByKeywordContaining(String keyword);
}
