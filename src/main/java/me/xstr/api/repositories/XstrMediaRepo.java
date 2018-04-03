package me.xstr.api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.xstr.api.models.XstrMedia;

@Repository
public interface XstrMediaRepo extends JpaRepository<XstrMedia, Integer> {

	XstrMedia findOneById(int id);
	List<XstrMedia> findById(int id);
	XstrMedia findByOriginalTitleUuid(UUID title);

}
