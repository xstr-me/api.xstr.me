package me.xstr.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.xstr.api.models.TvShow;
import me.xstr.api.models.XstrTitle;

@Repository
public interface TvShowRepo extends JpaRepository<TvShow, Integer> {

	TvShow findOneById(int id);
	List<TvShow> findById(int id);
	TvShow findByOriginalTitle(XstrTitle title);

}
