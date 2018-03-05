package me.xstr.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.xstr.api.models.AnidbTitles;

@Repository
public interface AnidbTitlesRepo extends JpaRepository<AnidbTitles, Integer> {
}
