package com.ag.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ag.pma.dto.ChartData;
import com.ag.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	public List<Project> findAll();

	@Query(nativeQuery = true, value = "SELECT STAGE as label, Count (*) as number FROM PROJECT GROUP BY STAGE")

	public List<ChartData> getProjectStatus();
}
