package me.xstr.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.xstr.api.models.ImdbMedia;

@Repository
public interface ImdbMediaRepo extends JpaRepository<ImdbMedia, Integer> {
}
